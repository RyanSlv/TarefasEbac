package br.com.ryans.Observer;

public class Demo {

    public static void main(String args[]){
        Journalist jor = new Journalist();
        jor.add(new TV());
        jor.notifyAll("test");
    }
}
