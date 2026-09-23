package Exercicio1;

public class Main {

    public static void main(String[] args) {

        Pilha pilha = new Pilha();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Topo: " + pilha.top());
        System.out.println("Removido: " + pilha.pop());
        System.out.println("Novo topo: " + pilha.top());
        System.out.println("Tamanho: " + pilha.size());
        System.out.println("Está vazia? " + pilha.isEmpty());

    }
}
