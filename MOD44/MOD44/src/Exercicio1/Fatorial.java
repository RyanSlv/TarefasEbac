package Exercicio1;

public class Fatorial {

    public static long calcularFatorial(long n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * calcularFatorial(n - 1);
    }

    public static void main(String[] args) {
        long n = 7;

        System.out.println("Fatorial de " + n + " é: " + calcularFatorial(n));
    }
}
