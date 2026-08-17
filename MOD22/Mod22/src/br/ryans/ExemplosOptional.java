package br.ryans;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ExemplosOptional {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoas();

        Optional<Pessoa> opcional = lista.stream()
                .max(Comparator.comparing(Pessoa::getIdade));

        if (opcional.isPresent()) {
            System.out.println(opcional.get());
        }

//        opcional.ifPresent(System.out::println);

        Optional<Pessoa> opcional2 = lista.stream()
                .min(Comparator.comparing(Pessoa::getIdade));
        if(opcional2.isPresent()) {
            System.out.println(opcional2.get());
        }

    }
}