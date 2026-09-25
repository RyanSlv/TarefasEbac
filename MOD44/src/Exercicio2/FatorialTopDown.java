package Exercicio2;

import java.math.BigInteger;

public class FatorialTopDown {

    private static BigInteger[] memo;

    public static BigInteger calcularFatorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        if (memo[n] != null) {
            return memo[n];
        }

        memo[n] = BigInteger.valueOf(n).multiply(calcularFatorial(n - 1));

        return memo[n];
    }

    public static void main(String[] args) {
        int n = 7;

        memo = new BigInteger[n + 1];

        System.out.println("Fatorial de " + n + " é: " + calcularFatorial(n));
    }
}
