package com.unip.pim.payctions.model;

import com.unip.pim.payctions.utils.Utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario {

    private Integer cdFuncionario;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private Long telefone;
    private Date dtNascimento;
    private String registroProf;
    private String cnh;
    private Integer cdEndereco;
    private Integer cdSetor;
    private Integer cdCargo;
    private String imgPath;
    private Date dtContratacao;

    private Cargo cargo;
    public static List<Funcionario> funcionarioList;

    static {
        funcionarioList = new ArrayList<>();
        funcionarioList.add(new Funcionario(1,
                "Miguel",
                "Teles",
                "12354678906",
                "miguel@email.com",
                145236988L,
                Utils.toDate("2002-09-13", "yyyy-MM-dd"),
                "1234",
                null,
                Utils.toDate("2022-10-10", "yyyy-MM-dd"),
                "imgPath/Miguel",
                1,
                1,
                1));

        funcionarioList.add(new Funcionario(1,
                "Jessica",
                "Reis",
                "54785633398",
                "jessica@email.com",
                985474522L,
                Utils.toDate("2004-02-03", "yyyy-MM-dd"),
                "4521",
                null,
                Utils.toDate("2022-12-05", "yyyy-MM-dd"),
                "imgPath/Jessica",
                2,
                2,
                2));
    }

    public Funcionario() {
    }

    public Funcionario(Integer cdFuncionario,
                       String nome,
                       String sobrenome,
                       String cpf,
                       String email,
                       Long telefone,
                       Date dtNascimento,
                       String registroProf,
                       String cnh,
                       Date dtContratacao,
                       String imgPath,
                       Integer cdEndereco,
                       Integer cdSetor,
                       Integer cdCargo) {
        this.cdFuncionario = cdFuncionario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.dtNascimento = dtNascimento;
        this.registroProf = registroProf;
        this.cnh = cnh;
        this.cdEndereco = cdEndereco;
        this.cdSetor = cdSetor;
        this.cdCargo = cdCargo;
        this.dtContratacao = dtContratacao;
        this.imgPath = imgPath;
    }

    public static Funcionario getFuncionarioByCdFuncionario(Integer cdFuncionario) {
        Funcionario result = null;
        for (Funcionario funcionario : funcionarioList) {
            if (funcionario.cdFuncionario.equals(cdFuncionario)) {
                result = funcionario;
                break;
            }
        }
        return result;
    }

    public Integer getCdFuncionario() {
        return cdFuncionario;
    }

    public void setCdFuncionario(Integer cdFuncionario) {
        this.cdFuncionario = cdFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getRegistroProf() {
        return registroProf;
    }

    public void setRegistroProf(String registroProf) {
        this.registroProf = registroProf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Integer getCdEndereco() {
        return cdEndereco;
    }

    public void setCdEndereco(Integer cdEndereco) {
        this.cdEndereco = cdEndereco;
    }

    public Integer getCdSetor() {
        return cdSetor;
    }

    public void setCdSetor(Integer cdSetor) {
        this.cdSetor = cdSetor;
    }

    public Integer getCdCargo() {
        return cdCargo;
    }

    public void setCdCargo(Integer cdCargo) {
        this.cdCargo = cdCargo;
    }

    public String getImgPath() {
        return imgPath;
    }

    public Date getDtContratacao() {
        return dtContratacao;
    }

    public static List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public Cargo getCargo() {
        if (this.cargo == null) {
            this.cargo = Cargo.getCargoByCdCargo(this.cdCargo);
        }
        return this.cargo;
    }

}
