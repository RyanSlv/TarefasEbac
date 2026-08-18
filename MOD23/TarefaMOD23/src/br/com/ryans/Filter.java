package br.com.ryans;

import java.util.List;

public class Filter {

    public static void main(String[] args) {

        List<Pessoa> lista = new Pessoa().nomesPessoas();

        long count = lista.stream()
                .filter(pessoa -> pessoa.getGenero().equals("Feminino"))
                .count();
        System.out.println("Existem " + count +" Mulheres na lista:");

        lista.stream()
                .filter(pessoa -> pessoa.getGenero().equals("Feminino"))
                .forEach(pessoa -> System.out.println("Nome: " + pessoa.getNome() + " | Idade: " + pessoa.getIdade() + " Anos."));


        System.out.println("(*****************)");


        long count2 = lista.stream()
                .filter(pessoa -> pessoa.getGenero().equals("Masculino"))
                .count();
        System.out.println("Existem " + count2 +" Homens na lista:");

        lista.stream()
                .filter(pessoa -> pessoa.getGenero().equals("Masculino"))
                .forEach(pessoa -> System.out.println("Nome: " + pessoa.getNome() + " | Idade: " + pessoa.getIdade() + " Anos."));
    }
}
