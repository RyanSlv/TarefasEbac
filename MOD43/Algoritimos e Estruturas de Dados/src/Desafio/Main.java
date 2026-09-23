package Desafio;

public class Main {

    public static void main(String[] args) {
        MapaHash mapa = new MapaHash();

        mapa.push(101, 150);
        mapa.push(102, 200);
        mapa.push(103, 350);

        System.out.println("Produto 101: " + mapa.get(101));
        System.out.println("Produto 102: " + mapa.get(102));

        mapa.push(102, 250);
        System.out.println("Produto atualizado: " + mapa.get(102));

        mapa.push(111, 500);

        mapa.delete(101);
        System.out.println("Produto 111: " + mapa.get(111));

        mapa.clear();
        System.out.println("Mapa limpo!");
    }
}
