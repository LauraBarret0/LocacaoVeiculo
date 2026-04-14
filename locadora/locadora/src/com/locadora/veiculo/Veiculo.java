package com.locadora.veiculo;

import java.util.UUID;

public class Veiculo {

    private String id;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private Categoria categoria;
    private boolean alugado;

    public Veiculo(String placa, String marca, String modelo, int ano, Categoria categoria) {
        this.id = UUID.randomUUID().toString(); // id único
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.categoria = categoria;
        this.alugado = false;
    }

    public boolean estaDisponivel() {
        return !alugado;
    }

    public void marcarComoAlugado() {
        if (alugado) {
            throw new RuntimeException("Veículo já alugado!");
        }
        alugado = true;
    }

    public void marcarComoDisponivel() {
        alugado = false;
    }

    public double getValorDiaria() {
        return categoria.getValor();
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }
}