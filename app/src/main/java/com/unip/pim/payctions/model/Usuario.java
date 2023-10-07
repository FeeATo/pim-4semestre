package com.unip.pim.payctions.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    public static final String LOGIN = "login";
    public static final String CD_USUARIO = "cdUsuario";
    public static final String SENHA = "senha";
    public static final String PERFIL = "perfil";
    public static final String CD_FUNCIONARIO = "cdFuncionario";

    private Integer cdUsuario;
    private String login;
    private String senha;
    private Character perfil;
    private Integer cdFuncionario;

    private Funcionario funcionario;
    public static List<Usuario> usuarioList;

    static {
        usuarioList = new ArrayList<>();
        usuarioList.add(new Usuario(1, "miMaster", "1234", 'M', 1));
        usuarioList.add(new Usuario(2, "miOpe", "1234", 'O', 1));
        usuarioList.add(new Usuario(3, "jessiOpe", "1234", 'O', 2));
    }


    public Usuario() {
    }

    public Usuario(Integer cdUsuario, String login, String senha, Character perfil, Integer cdFuncionario) {
        this.cdUsuario = cdUsuario;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
        this.cdFuncionario = cdFuncionario;
    }

    public static Usuario validaSenha(String login, String senha) {
        Usuario result = null;
        for (Usuario usuario : usuarioList) {
            if (usuario.login.equals(login) && usuario.senha.equals(senha)) {
                result = usuario;
                result.senha = null;
                break;
            }
        }

        return result;
    }

    public Integer getCdUsuario() {
        return cdUsuario;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Character getPerfil() {
        return perfil;
    }

    public Integer getCdFuncionario() {
        return cdFuncionario;
    }

    public Funcionario getFuncionario() {
        if (this.funcionario == null) {
            funcionario = Funcionario.getFuncionarioByCdFuncionario(this.getCdFuncionario());
        }
        return this.funcionario;
    }
}
