package br.ryans;

import java.util.List;

public class ExemplosLimit {

    public static void main(String[] args){
        List<Pessoa> lista = new Pessoa().populaPessoas();

        lista.stream().limit(2);
    }
}
