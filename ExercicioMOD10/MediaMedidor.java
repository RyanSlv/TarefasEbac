import java.util.Scanner;


public class MediaMedidor {

    static double mediabimestre = 0;
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = s.next();
        
        System.out.println("Digite a nota do Primeiro Bimestre: ");
        double primeiroBi = s.nextDouble();

        System.out.println("Digite a nota do Segundo Bimestre: ");
        double segundoBi = s.nextDouble();

        System.out.println("Digite a nota do Terceiro Bimestre: ");
        double terceiroBi = s.nextDouble();

        System.out.println("Digite a nota do Quarto Bimestre: ");
        double quartoBi = s.nextDouble();

        double MediaBi = (primeiroBi + segundoBi + terceiroBi + quartoBi) /4;

        System.err.println(nome + " sua media foi : " + MediaBi);

        if (MediaBi >= 7){
            System.out.println(nome + "Você foi aprovado! ");
        } else if (MediaBi >= 5) {
            System.out.println(nome + " Você está de recuperação! ");
        } else {
            System.out.println(nome + " Você foi reprovado! ");
            
        }
                s.close();
    }
}

