package com.sprint.sprint5.models;

public enum TipoPagamento {

    CREDIT_CARD("Credit card"),
    PIX("Pix"),
    BANK_PAYMENT_SLIP("Bank Payment Slip");

    private String valor;

    TipoPagamento(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public TipoPagamento setValor(String valor) {
        this.valor = valor;
        return this;
    }
}
