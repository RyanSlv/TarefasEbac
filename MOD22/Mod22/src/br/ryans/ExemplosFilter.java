package br.ryans;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ExemplosFilter {

        public static void main(String[] args) {
            List<Pessoa> lista = new Pessoa().populaPessoas();
            Stream<Pessoa> stream = lista.stream()
                    .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"));

            stream.forEach(p -> System.out.println(p.getNome()));

            Predicate<Pessoa> pred = pessoa -> pessoa.getNacionalidade().equals("Brasil");
            Stream<Pessoa> stream1 = lista.stream().filter(pred);

            stream1.forEach(p -> System.out.println(p.getNome()));

            Predicate<Pessoa> pred1 = new Predicate<Pessoa>() {
                @Override
                public boolean test(Pessoa pessoa) {
                    return pessoa.getNacionalidade().equals("Brasil");
                }
            };

            Stream<Pessoa> stream2 = lista.stream().filter(pred1);

            stream2.forEach(p -> System.out.println(p.getNome()));

            Stream<Pessoa> stream3 = lista.stream().filter(new Predicate<Pessoa>() {
                @Override
                public boolean test(Pessoa pessoa) {
                    return pessoa.getNacionalidade().equals("Brasil");
                }
            });

            stream3.forEach(p -> System.out.println(p.getNome()));
        }
}
