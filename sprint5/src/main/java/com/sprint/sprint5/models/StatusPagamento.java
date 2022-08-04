package com.sprint.sprint5.models;

public enum StatusPagamento {

    PROCESSANDO("Processando"),
    REJEITADO("Rejeitado"),
    APROVADO("Aprovado");

    private String valor;

    StatusPagamento(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public StatusPagamento setValor(String valor) {
        this.valor = valor;
        return this;
    }
}
