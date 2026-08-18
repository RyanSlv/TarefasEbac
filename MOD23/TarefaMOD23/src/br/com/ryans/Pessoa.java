package br.com.ryans;

import java.util.List;

public class Pessoa {

    private String nome;
    private String genero;
    private Integer idade;

    public Pessoa(String nome, String genero, Integer idade) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;

    }

    public Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Pessoa> nomesPessoas() {
        Pessoa pessoa1 = new Pessoa("Ana Oliveira", "Feminino", 18);
        Pessoa pessoa2 = new Pessoa("Gabriel Henrique", "Masculino", 30);
        Pessoa pessoa3 = new Pessoa("Camila Ferreira", "Feminino", 35);
        Pessoa pessoa4 = new Pessoa("Beatriz Almeida", "Feminino", 27);
        Pessoa pessoa5 = new Pessoa("Matheus Aparecido", "Masculino", 23);
        return List.of(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5);
    }
}
