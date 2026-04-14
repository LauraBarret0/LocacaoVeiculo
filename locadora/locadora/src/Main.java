package com.locadora;

import com.locadora.cliente.*;
import com.locadora.veiculo.*;
import com.locadora.locacao.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Endereco endereco = new Endereco("Rua A", "123", "SP", "00000-000");
        CNH cnh = new CNH("123456", LocalDate.of(2030, 1, 1));

        Cliente cliente = new Cliente("João", "123", "99999-9999", endereco, cnh);

        Veiculo carro = new Veiculo("ABC1234", "Toyota", "Corolla", 2022, Categoria.EXECUTIVO);

        // Exemplo 1: SUCESSO
        Locacao loc = new Locacao(
                cliente,
                carro,
                LocalDate.now(),
                LocalDate.now().plusDays(3)
        );

        System.out.println("Valor base: " + loc.calcularValorBase());

        //Exemplo 2: Veículo já alugado
        try {
            new Locacao(cliente, carro, LocalDate.now(), LocalDate.now().plusDays(2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Exemplo 3: CNH vencida
        Cliente clienteInvalido = new Cliente(
                "Maria",
                "456",
                "99999",
                endereco,
                new CNH("999", LocalDate.of(2020, 1, 1))
        );

        try {
            new Locacao(clienteInvalido, carro, LocalDate.now(), LocalDate.now().plusDays(2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Exemplo 4: Devolução no prazo
        LocalDate devolucao = LocalDate.now().plusDays(3);
        System.out.println("Total sem multa: " + loc.calcularValorTotal(devolucao));

        // Exemplo 5: Devolução com atraso
        LocalDate devolucaoAtrasada = LocalDate.now().plusDays(5);
        System.out.println("Total com multa: " + loc.calcularValorTotal(devolucaoAtrasada));
    }
}