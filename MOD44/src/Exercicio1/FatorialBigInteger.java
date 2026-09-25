package Exercicio1;

import java.math.BigInteger;

public class FatorialBigInteger {

    public static BigInteger calcularFatorial(BigInteger n) {
        //Condição de parada: 0! e 1! = 1
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        //Chamada recursiva
        return n.multiply(calcularFatorial(n.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {
        BigInteger n = BigInteger.valueOf(101);

        System.out.println("Fatorial de " + n + " é:");
        System.out.println(calcularFatorial(n));
    }
}
