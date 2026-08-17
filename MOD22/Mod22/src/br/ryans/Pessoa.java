package br.ryans;

import java.util.List;
import java.util.Objects;

public class Pessoa {

    private String id;

    private String nome;

    private String nacionalidade;

    private Integer idade;

    public Pessoa() {

    }

    public Pessoa(String id, String nome, String nacionalidade, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
    }

    public Pessoa(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getNacionalidade(), pessoa.getIdade());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List populaPessoas(){
        Pessoa pessoa1 = new Pessoa("p1", "Matheus Henrique", "Brasil", 18);
        Pessoa pessoa2 = new Pessoa("p2", "Hernandez Roja", "Mexico", 32);
        Pessoa pessoa3 = new Pessoa("p3", "João Paulo", "Canada", 48);
        Pessoa pessoa4 = new Pessoa("p4", "Neymar Junior", "Brasil",18);
        return List.of(pessoa1,pessoa2,pessoa3,pessoa4);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(getId(), pessoa.getId()) && Objects.equals(getNome(), pessoa.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome());
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", idade=" + idade +
                '}';
    }
}
