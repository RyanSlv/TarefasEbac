package br.com.ryans.tarefa;

import java.util.ArrayList;
import java.util.List;

import br.com.ryans.tarefa.BugattiChiron;
import br.com.ryans.tarefa.FerrariF430;

public class ListaCarros {

    public static void main(String[] args) {

        List<Carro> carros = new ArrayList<>();

        BugattiChiron BChi = new BugattiChiron();
        BChi.setMarca("Bugatti");
        BChi.setCor("Azul");
        BChi.setCambio("Automático");
        BChi.setModelo("Chiron");
        carros.add(BChi);

        FerrariF430 FF430 = new FerrariF430();
        FF430.setMarca("Ferrari");
        FF430.setCor("Vermelho");
        FF430.setCambio("Manual");
        FF430.setModelo("F430");
        carros.add(FF430);

        listaCarros(carros);
    }
    private static void listaCarros(List<? extends Carro> carros) {
        for (Carro c : carros) {
            if (c instanceof FerrariF430) {
                System.out.println(((FerrariF430) c).imprimirListaF430());
            } else if (c instanceof BugattiChiron) {
                System.out.println(((BugattiChiron) c).imprimirListaChiron());

            }
        }
    }

}
