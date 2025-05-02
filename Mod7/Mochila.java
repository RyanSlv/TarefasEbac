public class Mochila {
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