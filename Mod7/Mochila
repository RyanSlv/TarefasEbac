public class Main {
    public static void main(String[] args) {
        Mochila mochila = new Mochila();
        mochila.Conteudo();
    }
}

class Mochila {
    private Estojo estojo;
    private Caderno caderno;

    public Mochila() {
        this.estojo = new Estojo(24);
        this.caderno = new Caderno(80);
    }

    public void Conteudo() {
        System.out.println("Dentro da mochila tem:");
        estojo.Conteudo();
        caderno.Conteudo();
    }
}

class Estojo {
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

class Caderno {
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