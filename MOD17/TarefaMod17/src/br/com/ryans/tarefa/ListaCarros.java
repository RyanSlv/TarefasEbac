package br.com.ryans.tarefa;

import java.util.ArrayList;
import java.util.List;

import br.com.ryans.tarefa.BugattiChiron;
import br.com.ryans.tarefa.FerrariF430;

public class ListaCarros {

    public static void main(String[] args) {

        List<BugattiChiron> carro = new ArrayList<>();
        BugattiChiron BChi = new BugattiChiron();
        BChi.setMarca("Bugatti");
        BChi.setCor("Azul");
        BChi.setCambio("Automático");
        BChi.setModelo("Chiron");
        carro.add(BChi);
        listaBugatti(carro);

        List<FerrariF430> carro2 = new ArrayList<>();
        FerrariF430 FF430 = new FerrariF430();
        FF430.setMarca("Ferrari");
        FF430.setCor("Vermelho");
        FF430.setCambio("Manual");
        FF430.setModelo("F430");
        carro2.add(FF430);
        listaFerrari(carro2);


    }

    private static void listaFerrari(List<? extends FerrariF430> carro) {
        for (FerrariF430 f : carro) {
            System.out.println(f.imprimirListaF430());
        }
    }

    private static void listaBugatti(List<? extends BugattiChiron> carro1) {
        for (BugattiChiron b : carro1) {
            System.out.println(b.imprimirListaChiron());
        }
    }
}
