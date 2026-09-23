package Exercicio2;

import java.util.NoSuchElementException;

public class Fila {

    private int[] elementos = new int[10];
    private int inicio = 0;
    private int tamanho = 0;

    public void enqueue(int valor) {
        if (tamanho == elementos.length) {
            int[] novo = new int[elementos.length * 2];

            for (int i = 0; i < tamanho; i++) {
                novo[i] = elementos[(inicio + i) % elementos.length];
                }

            elementos = novo;
            inicio = 0;
            }

        int fim = (inicio + tamanho) % elementos.length;
        elementos[fim] = valor;
        tamanho++;
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Fila vazia");
            }

            int valor = elementos[inicio];
            inicio  = (inicio + 1) % elementos.length;
            tamanho--;

            return valor;
    }

    public int rear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        }

        int fim = (inicio + tamanho - 1) % elementos.length;
        return elementos[fim];
    }

    public int front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        }

        return elementos[inicio];
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}
