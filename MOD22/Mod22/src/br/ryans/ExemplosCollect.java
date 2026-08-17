package br.ryans;

import java.util.*;
import java.util.stream.Collectors;

public class ExemplosCollect {
    public static void main(String[] args) {
        List<Pessoa> lista = new Pessoa().populaPessoas();

        List<Pessoa> listaB = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .collect(Collectors.toList());

        listaB.forEach(System.out::println);

        System.out.println("**********");
        System.out.println("**********");

        lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("**********");
        System.out.println("**********");

        Set<Pessoa> set = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        System.out.println("**********");
        System.out.println("**********");


//        ArrayList<Pessoa> arrayList = lista.stream()
//                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
//                .collect(Collectors.toCollection(ArrayList::new));
//
//        arrayList.forEach(System.out::println);

        Map<Integer, Pessoa> map = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Mexico"))
                .collect(Collectors.toMap(Pessoa::getIdade, Pessoa::new));
                map.forEach((k, v) -> System.out.println(k + " / " + v));

        System.out.println("**********");
        System.out.println("**********");

        Map<Integer, List<Pessoa>> agrupaPorIdade = lista.stream()
//                .filter(pessoa -> pessoa.getNacionalidade().equals("Mexico"))
                .collect(Collectors.groupingBy(Pessoa::getIdade));
        agrupaPorIdade.forEach((k, v) -> System.out.println(k + " / " + v));

        System.out.println("**********");
        System.out.println("**********");

        Map<String, List<Pessoa>> agrupaPorNacionalidade = lista.stream()
                .collect(Collectors.groupingBy(Pessoa::getNacionalidade));
        agrupaPorNacionalidade.forEach((k, v) -> System.out.println(k + " / " + v));

        System.out.println("**********");
        System.out.println("**********");

        Map<String, IntSummaryStatistics> agrupaPorNacionalidadeSomadosIdades = lista.stream()
                .collect(Collectors.groupingBy(Pessoa::getNacionalidade, Collectors.summarizingInt(Pessoa::getIdade)));
        agrupaPorNacionalidadeSomadosIdades.forEach((k, v) -> System.out.println(k + " / " + v));
    }
}
