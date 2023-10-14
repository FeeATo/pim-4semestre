package com.unip.pim.payctions.model;

import com.unip.pim.payctions.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Solicitacao {

    private Integer cdSolicitacao;
    private Date dtSolicitacao;
    private String descricao;
    private Integer cdFuncionario;
    private Integer cdResponsavel;

    static List<Solicitacao> solicitacaoList;

    static {
        solicitacaoList = new ArrayList<>();
        solicitacaoList.add(new Solicitacao(1,
                Utils.addDias(new Date(), -2),
                "Solicitação teste 1",
                2,
                1));

        solicitacaoList.add(new Solicitacao(2,
                Utils.addDias(new Date(), -5),
                "Solicitação teste 2",
                3,
                1));

        solicitacaoList.add(new Solicitacao(3,
                Utils.addDias(new Date(), -5),
                "Solicitação teste 3",
                3,
                1));

        solicitacaoList.add(new Solicitacao(4,
                Utils.addDias(new Date(), -5),
                "Solicitação teste 4",
                3,
                1));

        solicitacaoList.add(new Solicitacao(5,
                Utils.addDias(new Date(), -5),
                "Solicitação teste 5",
                3,
                1));

        solicitacaoList.add(new Solicitacao(6,
                Utils.addDias(new Date(), -5),
                "Solicitação teste 6",
                3,
                1));

        solicitacaoList.add(new Solicitacao(7,
                Utils.addDias(new Date(), -5),
                "Solicitação teste 7",
                3,
                1));
    }

    public Solicitacao() {
    }

    public Solicitacao(Integer cdSolicitacao, Date dtSolicitacao, String descricao, Integer cdFuncionario, Integer cdResponsavel) {
        this.cdSolicitacao = cdSolicitacao;
        this.dtSolicitacao = dtSolicitacao;
        this.descricao = descricao;
        this.cdFuncionario = cdFuncionario;
        this.cdResponsavel = cdResponsavel;
    }

    public Integer getCdSolicitacao() {
        return cdSolicitacao;
    }

    public void setCdSolicitacao(Integer cdSolicitacao) {
        this.cdSolicitacao = cdSolicitacao;
    }

    public Date getDtSolicitacao() {
        return dtSolicitacao;
    }

    public void setDtSolicitacao(Date dtSolicitacao) {
        this.dtSolicitacao = dtSolicitacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCdFuncionario() {
        return cdFuncionario;
    }

    public void setCdFuncionario(Integer cdFuncionario) {
        this.cdFuncionario = cdFuncionario;
    }

    public Integer getCdResponsavel() {
        return cdResponsavel;
    }

    public void setCdResponsavel(Integer cdResponsavel) {
        this.cdResponsavel = cdResponsavel;
    }

    public static List<Solicitacao> getSolicitacaoList() {
        return solicitacaoList;
    }
}
