package br.ryans;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class CriandoStreams {

    public static void main(String[] args) {
        Stream<String> stream = List.of("Ryan", "Silva", "Teste").stream();

        Stream<String> set = Set.of("Ryan", "Silva", "Teste").stream();

        Map<String, String> map = Map.of("Ryan", "Silva");
        Stream<String> chaves = map.keySet().stream();
        Stream<String> values = map.values().stream();

    }
}
