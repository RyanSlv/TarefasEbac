package br.com.ryans.Observer;

public class TV implements Observer{
    @Override
    public void update(Subject subject) {
        System.out.println("Getting the news on TV" + subject.toString());
    }
}
