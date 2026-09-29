package Exercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculoTroco {

    public static List<Integer> calcular(int quantia, int[] moedas) {
        if (quantia < 0) throw new IllegalArgumentException("A quantia não pode ser negativa");

        int[] ordenadas = moedas.clone();
        for (int moeda : ordenadas) {
            if (moeda <= 0) throw new IllegalArgumentException("As moedas devem ser positivas");
        }
        Arrays.sort(ordenadas);

        List<Integer> troco = new ArrayList<>();
        for (int i = ordenadas.length  - 1; i >= 0; i--) {
            while (quantia >= ordenadas[i]) {
                troco.add(ordenadas[i]);
                quantia -= ordenadas[i];
            }
        }

        if (quantia != 0) throw new IllegalArgumentException("Não é possível dar o troco exato");
        return troco;
    }

    public static void main(String[] args) {
        List<Integer> troco = calcular(18, new int[]{5, 2, 1});
        System.out.println("Moedas: " + troco);
        System.out.println("Quantidade: " + troco.size());
    }
}
