package com.sprint.sprint5.models;

public enum Marca {

    MASTERCARD("Mastercard"),
    VISA("Visa");

    private String valor;

    Marca(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public Marca setValor(String valor) {
        this.valor = valor;
        return this;
    }
}
