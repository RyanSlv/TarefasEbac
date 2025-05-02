public class Caderno {
    private int quantFolhas;

    public Caderno(int quantFolhas) {
        this.quantFolhas = quantFolhas;
    }

    public int getQuantFolhas() {
        return quantFolhas;
    }

    public void Conteudo() {
        System.out.println("Caderno possui " + quantFolhas + " folhas!");
    }
}