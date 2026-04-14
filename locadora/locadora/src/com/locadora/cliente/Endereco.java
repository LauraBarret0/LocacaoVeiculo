package com.locadora.cliente;

public class Endereco {

    private final String rua;
    private final String numero;
    private final String cidade;
    private final String cep;

    public Endereco(String rua, String numero, String cidade, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.cep = cep;
    }
}