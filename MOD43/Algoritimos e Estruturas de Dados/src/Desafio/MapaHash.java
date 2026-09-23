package Desafio;

import java.util.NoSuchElementException;

public class MapaHash {

    private static final int CAPACIDADE = 10;

    private int[] chaves = new int[CAPACIDADE];
    private int[] valores = new int[CAPACIDADE];

    private boolean[] ocupado = new boolean[CAPACIDADE];
    private boolean[] removido = new boolean[CAPACIDADE];

    public void push(int key, int value) {
        int indice = Math.floorMod(key, CAPACIDADE);
        int livre = -1;

        for (int i = 0; i < CAPACIDADE; i++) {
            int pos = (indice + i) % CAPACIDADE;

            if (ocupado[pos]) {
                if (chaves[pos] == key) {
                    valores[pos] = value;
                    return;
                }
            }   else {
                if (livre == -1) livre = pos;
                if (!removido[pos]) break;
            }
        }

        if (livre == -1) {
            throw new IllegalStateException("Mapa cheio");
        }

        chaves[livre] = key;
        valores[livre] = value;
        ocupado[livre] = true;
        removido[livre] = false;
    }

    public void delete(int key)  {
        int indice = Math.floorMod(key, CAPACIDADE);

        for (int i = 0; i < CAPACIDADE; i++) {
            int pos = (indice + i) % CAPACIDADE;

            if (ocupado[pos] && chaves[pos] == key) {
                ocupado[pos] = false;
                removido[pos] = true;
                return;
            }

            if (!ocupado[pos] && !removido[pos]) break;
        }
        throw new NoSuchElementException("Chave inexistente: " + key);
    }

    public int get(int key) {
        int indice = Math.floorMod(key, CAPACIDADE);

        for (int i = 0; i < CAPACIDADE; i++) {
            int pos = (indice + i) % CAPACIDADE;

            if (ocupado[pos] && chaves[pos] == key) {
                return valores[pos];
            }

            if (!ocupado[pos] && !removido[pos]) break;
        }

        throw new NoSuchElementException("Chave inexistente: " + key);
    }

    public void clear() {
        for (int i = 0; i < CAPACIDADE; i++) {
            chaves[i] = 0;
            valores[i] = 0;
            ocupado[i] = false;
            removido[i] = false;
        }
    }

}
