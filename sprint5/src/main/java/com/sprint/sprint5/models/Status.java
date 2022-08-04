package com.sprint.sprint5.models;

public enum Status {

    EM_ANDAMENTO("Em andamento"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado");

    private String valor;

    Status(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public Status setValor(String valor) {
        this.valor = valor;
        return this;
    }
}
