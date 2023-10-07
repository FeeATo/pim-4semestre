package com.unip.pim.payctions.exception;

public class PayctionsException extends Exception {

    private String msgErro;
    private Exception ex;
    private String metodo;
    private Class classe;

    public PayctionsException(String msgErro, String metodo, Class classe, Exception ex) {
        this.msgErro = msgErro;
        this.ex = ex;
        this.metodo = metodo;
        this.classe = classe;
    }

    public String getMsgErro() {
        return msgErro;
    }

    public Exception getEx() {
        return ex;
    }

    public String getMetodo() {
        return metodo;
    }

    public Class getClasse() {
        return classe;
    }
}
