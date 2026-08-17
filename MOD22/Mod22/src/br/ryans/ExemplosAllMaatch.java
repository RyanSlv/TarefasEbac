package br.ryans;

import java.util.List;

public class ExemplosAllMaatch {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoas();

        boolean result = lista.stream()
                .allMatch(pessoa -> pessoa.getNacionalidade().equals("Mexico"));

        System.out.println(result);

    }
}
