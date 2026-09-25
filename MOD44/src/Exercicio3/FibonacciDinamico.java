package Exercicio3;

public class FibonacciDinamico {

    private static final int MAX_ELEMENTOS = 100;
    private static final int[] elementosFib = new int[MAX_ELEMENTOS];

    public static int encontrarElementoPD(int n) {
        if (n < 0 || n >= MAX_ELEMENTOS) {
            throw new IllegalArgumentException("n deve estar entre 0 e 99");
        }

        for (int i = 0; i < MAX_ELEMENTOS; i++) {
            elementosFib[i] = -1;
        }

        return encontrarElemento(n);
    }

    public static int encontrarElemento(int n) {
        if (elementosFib[n] == -1) {
            if (n <= 1) {
                elementosFib[n] = n;
            } else {
                elementosFib[n] = encontrarElemento(n - 1) + encontrarElemento(n - 2);
            }
        }

        return elementosFib[n];
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println("Fibonacci de " + n + " é: " + encontrarElementoPD(n));
    }
}
