package Exercicio3;

public class Main {

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        lista.push(30);
        lista.push(20);
        lista.push(10);

        System.out.println("Lista inicial: ");
        lista.printList();

        lista.insert(1, 15);

        System.out.println("Após inserir: ");
        lista.printList();

        lista.remove(2);

        System.out.println("Após remover: ");
        lista.printList();

        System.out.println("Elemento índice 1: " + lista.elementAt(1).getValor());

        System.out.println("Pop: " + lista.pop().getValor());

        System.out.println("Tamanho: " + lista.size());

        System.out.println("Lista final: ");
        lista.printList();
    }
}
