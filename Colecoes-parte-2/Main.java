import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> NomeMas = new ArrayList<>();
        List<String> NomeFem = new ArrayList<>();
        List<String> Nomes = new ArrayList<>();

        Scanner leia2 = new Scanner(System.in);
        System.out.print("Digite os nomes (ex: Ana -f, João -m): ");
        String nome2 = leia2.nextLine();

        String[] nome2Sep = nome2.split(", ");

        for (int x = 0; x < nome2Sep.length; x++) {
            Nomes.add(nome2Sep[x].trim());
        }

        for (int x = 0; x < Nomes.size(); x++) {
            String temp = Nomes.get(x);
            String[] temp2 = temp.split("-");

            if (temp2.length < 2) continue;

            String nome = temp2[0].trim();
            String genero = temp2[1].trim().toLowerCase();

            if (genero.equals("m")) {
                NomeMas.add(nome);
            } else if (genero.equals("f")) {
                NomeFem.add(nome);
            }
        }

        Collections.sort(NomeFem);
        Collections.sort(NomeMas);

        System.out.println("Lista original: " + Nomes);
        System.out.println("Nomes femininos: " + NomeFem);
        System.out.println("Nomes masculinos: " + NomeMas);
    }
}