package com.locadora.cliente;

public class Cliente {

    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Endereco endereco;
    private CNH cnh;

    public Cliente(String nome, String cpf, String telefone, Endereco endereco, CNH cnh) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cnh = cnh;
    }

    public void atualizarTelefone(String novoTelefone) { this.telefone = novoTelefone;}

    public void atualizarEmail(String novoEmail) {this.email = novoEmail;}

    public void atualizarEndereco(Endereco novoEndereco) {this.endereco = novoEndereco;}

    public boolean temCnhValida() {return cnh.estaValida(); }
}