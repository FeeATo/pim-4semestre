package com.unip.pim.payctions.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.unip.pim.payctions.utils.Utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario extends Pessoa {

    public static final String CD_FUNCIONARIO = "cdFuncionario";
    public static final String EMAIL = "email";
    public static final String REGISTRO_PROF = "registroProf";
    public static final String CNH = "cnh";
    public static final String CD_SETOR = "cdSetor";
    public static final String CD_CARGO = "cdCargo";
    public static final String IMG_PATH = "imgPath";
    public static final String DT_CONTRATACAO = "dtContratacao";
    public static final String CARGO = "cargo";

    private Integer cdFuncionario;
    private String email;
    private Long telefone;
    private String registroProf;
    private String cnh;
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

        funcionarioList.add(new Funcionario(2,
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

        funcionarioList.add(new Funcionario(3,
                "Fernando",
                "Joaquiles",
                "21022547936",
                "joaquiles@email.com",
                987458587L,
                Utils.toDate("1995-05-08", "yyyy-MM-dd"),
                "4521",
                null,
                Utils.toDate("2022-12-05", "yyyy-MM-dd"),
                "imgPath/Fernando",
                3,
                2,
                2));
    }

    public Funcionario() {
    }

    public Funcionario(Parcel parcel) {

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

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Date getDtContratacao() {
        return dtContratacao;
    }

    public void setDtContratacao(Date dtContratacao) {
        this.dtContratacao = dtContratacao;
    }

    public Cargo getCargo() {
        if (cargo==null) {
            cargo = Cargo.getCargoByCdCargo(cdCargo);
        }
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
