package Exercicio1;

import java.util.NoSuchElementException;

public class Pilha {

    private int[] elementos = new int[10];
    private int tamanho = 0;

    public void push(int valor) {
        if (tamanho == elementos.length) {
            int[] novo = new int[elementos.length * 2];

            for (int i = 0; i < tamanho; i++) {
                novo[i] = elementos[i];
            }

            elementos = novo;
        }

        elementos[tamanho] = valor;
        tamanho++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Pilha vazia");
        }
        tamanho--;
        return elementos[tamanho];
    }

    public int top() {
        if (isEmpty()) {
            throw new NoSuchElementException("Pilha vazia");
        }
        return elementos[tamanho - 1];
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }
}
