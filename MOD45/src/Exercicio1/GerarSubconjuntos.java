package Exercicio1;

import java.util.ArrayList;
import java.util.List;

public class GerarSubconjuntos {

    public static List<List<Integer>> gerar(int[] conjunto, int n) {
        List<List<Integer>> resultado = new ArrayList<>();
        if (n < 0 || n > conjunto.length) return resultado;

        buscar(conjunto, n, 0, new ArrayList<>(), resultado);
        return resultado;
    }

    private static void buscar(int[] conjunto, int n, int inicio, List<Integer> atual, List<List<Integer>> resultado) {
        if (atual.size() == n) {
            resultado.add(new ArrayList<>(atual));
            return;
        }

        for (int i = inicio; i < conjunto.length; i++) {
            atual.add(conjunto[i]);
            buscar(conjunto, n, i + 1, atual, resultado);
            atual.remove(atual.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(gerar(new int[]{1, 2, 3}, 2));
        System.out.println(gerar(new int[]{1, 2, 3, 4}, 1));
    }
}
