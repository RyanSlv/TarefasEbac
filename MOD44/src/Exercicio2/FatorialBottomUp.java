package Exercicio2;

import java.math.BigInteger;

public class FatorialBottomUp {

    public static BigInteger calcularFatorial(int n) {
        BigInteger resultado = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }

        return resultado;
    }

    public static void main(String[] args) {
        int n = 7;

        System.out.println("Fatorial de " + n + " é: " + calcularFatorial(n));
    }
}
