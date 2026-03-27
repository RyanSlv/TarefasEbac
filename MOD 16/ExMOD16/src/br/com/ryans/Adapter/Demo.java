package br.com.ryans.Adapter;

import java.io.File;

public class Demo {

    public static void main(String args[]) {
        String file = "test.txt";
        DropBox drop = new DropBox();
        FilePersistence arquivo = new DropBoxAdapter(drop);
        arquivo.gravar(new File(file));

    }
}
