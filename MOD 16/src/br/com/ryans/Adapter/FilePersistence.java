package br.com.ryans.Adapter;

import java.io.File;

public interface FilePersistence {

     public void gravar(File file);

     public File ler(String path);
}
