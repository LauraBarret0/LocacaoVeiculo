package com.locadora.veiculo;

public enum Categoria {

    ECONOMICO(80),
    INTERMEDIARIO(120),
    EXECUTIVO(200),
    MOTO(50),
    VAN(180);

    private double valor;

    Categoria(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}