package br.com.ryans.tarefa;

public class BugattiChiron extends Carro {

    private String marca;
    private String modelo;
    private String cor;
    private String cambio;

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String getCor() {
        return cor;
    }

    @Override
    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String getCambio() {
        return cambio;
    }

    @Override
    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String imprimirListaChiron() {
        return marca + " " + modelo + " " + cambio + " de Cor " + cor ;
    }

    public static void imprimirListaBChiron() {
        System.out.println("Marca: Bugatti, Modelo: Chiron, Motor: Automático, Cor: Azul");
    }
}
