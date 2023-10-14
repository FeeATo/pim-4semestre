package com.unip.pim.payctions.model;

import android.os.Parcel;

import com.unip.pim.payctions.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Pessoa {

    public static final String NOME = "nome";
    public static final String SOBRENOME = "sobrenome";
    public static final String CPF = "cpf";
    public static final String DT_NASCIMENTO = "dtNascimento";
    public static final String CD_ENDERECO = "cdEndereco";
    protected String nome;
    protected String sobrenome;
    protected String cpf;
    protected Date dtNascimento;
    protected Integer cdEndereco;


    public Pessoa() {
    }

    public Pessoa(String nome,
                       String sobrenome,
                       String cpf,
                       Date dtNascimento,
                       Integer cdEndereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.cdEndereco = cdEndereco;
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
    public Date getDtNascimento() {
        return dtNascimento;
    }
    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
    public Integer getCdEndereco() {
        return cdEndereco;
    }
    public void setCdEndereco(Integer cdEndereco) {
        this.cdEndereco = cdEndereco;
    }
}
