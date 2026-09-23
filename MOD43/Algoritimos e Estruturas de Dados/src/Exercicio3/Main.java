package Exercicio3;

public class Main {

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        lista.push(30);
        lista.push(20);
        lista.push(10);

        System.out.print("Lista inicial: ");
        lista.printList();

        lista.insert(1, 15);

        System.out.print("Após inserir: ");
        lista.printList();

        lista.remove(2);

        System.out.print("Após remover: ");
        lista.printList();

        System.out.println("Elemento índice 1: " + lista.elementAt(1).getValor());

        System.out.println("Pop: " + lista.pop().getValor());

        System.out.println("Tamanho: " + lista.size());

        System.out.print("Lista final: ");
        lista.printList();
    }
}
