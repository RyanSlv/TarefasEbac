public class Estojo {
    private int quantLapis;

    public Estojo(int quantLapis) {
        this.quantLapis = quantLapis;
    }

    public int getQuantLapis() {
        return quantLapis;
    }

    public void Conteudo() {
        System.out.println("Estojo possui " + quantLapis + " lápis!");
    }
}