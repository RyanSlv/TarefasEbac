package Exercicio3;

import java.util.NoSuchElementException;
import java.util.concurrent.LinkedBlockingDeque;

public class ListaEncadeada {

    public static class Node {

        private int valor;
        private Node proximo;

        public Node(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }
    }

    private Node inicio;
    private int tamanho = 0;

    public void push(int valor) {
        Node novo = new Node(valor);
        novo.proximo = inicio;
        inicio = novo;
        tamanho++;
    }

    public Node pop() {
        if (inicio == null) {
            throw new NoSuchElementException("Lista vazia");
        }

        Node removido = inicio;
        inicio = inicio.proximo;
        removido.proximo = null;
        tamanho--;

        return removido;
    }

    public void insert(int index, int valor) {
        if (index < 0 || index > tamanho) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            push(valor);
            return;
        }

        Node anterior = elementAt(index - 1);
        Node novo = new Node(valor);

        novo.proximo = anterior.proximo;
        anterior.proximo = novo;
        tamanho++;
    }

    public void remove(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            pop();
            return;
        }

        Node anterior = elementAt(index - 1);
        anterior.proximo = anterior.proximo.proximo;
        tamanho--;
    }

    public Node elementAt(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IndexOutOfBoundsException();
        }

        Node atual = inicio;

        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }

        return atual;
    }

    public int size() {
        return tamanho;
    }

    public void printList() {
        Node atual = inicio;

        while (atual != null) {
            System.out.println(atual.valor + " -> ");
            atual = atual.proximo;
        }

        System.out.println("Null");
    }
}
