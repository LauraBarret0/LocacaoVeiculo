package com.locadora.locacao;

import com.locadora.cliente.Cliente;
import com.locadora.veiculo.Veiculo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Locacao {

    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataRetirada;
    private LocalDate dataPrevista;
    private LocalDate dataReal;

    public Locacao(Cliente cliente, Veiculo veiculo, LocalDate retirada, LocalDate prevista) {

        if (!cliente.temCnhValida()) {
            throw new RuntimeException("CNH vencida!");
        }

        if (!veiculo.estaDisponivel()) {
            throw new RuntimeException("Veículo indisponível!");
        }

        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataRetirada = retirada;
        this.dataPrevista = prevista;

        veiculo.marcarComoAlugado();
    }

    public double calcularValorBase() {
        long dias = ChronoUnit.DAYS.between(dataRetirada, dataPrevista);
        return dias * veiculo.getValorDiaria();
    }

    public long calcularDiasAtraso(LocalDate devolucao) {
        long dias = ChronoUnit.DAYS.between(dataPrevista, devolucao);
        return Math.max(dias, 0);
    }

    public double calcularMulta(LocalDate devolucao) {
        return calcularDiasAtraso(devolucao) * 50;
    }

    public double calcularValorTotal(LocalDate devolucao) {
        return calcularValorBase() + calcularMulta(devolucao);
    }

    public void registrarDevolucao(LocalDate devolucao) {
        this.dataReal = devolucao;
        veiculo.marcarComoDisponivel();
    }
}