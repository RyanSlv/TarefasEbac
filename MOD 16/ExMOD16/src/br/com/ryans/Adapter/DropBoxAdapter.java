package br.com.ryans.Adapter;

import java.io.File;

public class DropBoxAdapter implements FilePersistence {

    private final DropBox dropBox;

    public DropBoxAdapter(DropBox dropBox) {
        this.dropBox = dropBox;
    }

    @Override
    public void gravar(File file) {
        dropBox.download(file.getAbsolutePath());

    }

    @Override
    public File ler(String path) {
        DropBoxFile file = dropBox.download(path);
        return new File(file.getLocalPath());
    }
}
