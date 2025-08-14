import java.util.Scanner;
import java.util.Arrays;

public class Lista1 {

    public static void main(String args []) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite os nomes separando-os com virgula : ");

        String resposta = s.nextLine();
        String[] vetNome = resposta.split("\\s*,\\s*");
        Arrays.sort(vetNome);

        for (int i=0; i<vetNome.length; i++){
            System.out.println("" + vetNome[i]);
        }
    
        s.close();
    
    }

}
