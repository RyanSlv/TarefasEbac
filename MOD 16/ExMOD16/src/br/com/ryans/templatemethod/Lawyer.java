package br.com.ryans.templatemethod;

public class Lawyer extends Worker{
    @Override
    protected void work() {
        System.out.println("Working as a lawyer");
    }

    @Override
    protected void returnHome() {
        System.out.println("Returning home early");
    }

    @Override
    protected void goToWork() {
        super.goToWork();
    }

    @Override
    protected void startRoutine() {
        super.startRoutine();
    }

    @Override
    protected void wakeUp() {
        super.wakeUp();
    }
}
