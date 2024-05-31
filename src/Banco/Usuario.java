package Banco;

import java.util.Objects;

public class Usuario {

    private static int cont = 1;
    private int id;
    private String nome;
    private String rg;
    private String cpf;
    private short idade;

    public Usuario(String nome, String rg ,String cpf,short idade){
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.idade = idade;
        this.id = cont;
        cont++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public short getIdade() {
        return idade;
    }

    public void setIdade(short idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\nnome: " + nome +
                "\nrg: " + rg +
                "\ncpf: " + cpf +
                "\nidade: " + idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
