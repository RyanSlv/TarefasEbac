package Exercicio1;

import java.math.BigInteger;

public class FatorialBigInteger {

    public static BigInteger calcularFatorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        return n.multiply(calcularFatorial(n.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {
        BigInteger n = BigInteger.valueOf(101);

        System.out.println("Fatorial de " + n + " é:");
        System.out.println(calcularFatorial(n));
    }
}
