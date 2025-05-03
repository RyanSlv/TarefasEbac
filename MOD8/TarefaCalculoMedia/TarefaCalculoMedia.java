public class TarefaCalculoMedia {
    private int nota;

    public int getnota() {
        return nota;
    }
    public void setnota(int nota){
        this.nota = nota;
    }

    public static void main(String[] args){
        double nota1 = 9;
        double nota2 = 5;
        double nota3 = 10;
        double nota4 = 8;

        double finalMedia = (nota1 + nota2 + nota3 + nota4)/4; 

        System.out.println("Sua média é: " + finalMedia);

        if (finalMedia >= 6){
            System.out.println("Aprovado! \n");
        }
        else {
            System.out.println("Reprovado! \n");
        }
    }

}
