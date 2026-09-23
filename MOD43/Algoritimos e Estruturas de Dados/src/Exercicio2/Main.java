package Exercicio2;

public class Main {

    public static void main (String[] args) {

        Fila fila = new Fila();

        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        System.out.println("Primeiro: " + fila.front());
        System.out.println("Último: " + fila.rear());
        System.out.println("Removido: " + fila.dequeue());
        System.out.println("Novo primeiro: " + fila.front());
        System.out.println("Tamanho: " + fila.size());
        System.out.println("Está vazia? " + fila.isEmpty());

    }
}
