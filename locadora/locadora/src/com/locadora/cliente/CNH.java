package com.locadora.cliente;

import java.time.LocalDate;

public class CNH {

    private final String numero;
    private final LocalDate dataVencimento;

    public CNH(String numero, LocalDate dataVencimento) {
        this.numero = numero;
        this.dataVencimento = dataVencimento;
    }

    public boolean estaValida() {
        return dataVencimento.isAfter(LocalDate.now());
    }
}