package br.com.ryans.Observer;

import java.util.ArrayList;
import java.util.List;

public class Journalist implements Subject {


    public List<Observer> observers = new ArrayList<>();

    private String titulo;

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }


    @Override
    public void notifyAll(String titulo) {
        this.titulo = titulo;
        for (Observer ob : this.observers) {
            ob.update(this);
        }
    }
}
