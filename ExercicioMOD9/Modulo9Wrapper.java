import java.util.Scanner;

public class Modulo9Wrapper {
    public static void main(String args[]) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = leia.nextInt();
        leia.close();
        
        System.out.println("O número " + numero + " foi armazenado em uma variavel primitiva.");

        Integer numero2 = numero;
        System.out.println("Agora o número " + numero2 + " foi armazenado em uma variavel Wrapper.");
    }
}
