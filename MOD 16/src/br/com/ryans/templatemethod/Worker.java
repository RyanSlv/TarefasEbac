package br.com.ryans.templatemethod;

public abstract class Worker {

    public void start() {
        startRoutine();
        wakeUp();
        eatBreakfest();
        goToWork();
        work();
        returnHome();

    }

    protected void returnHome() {
        System.out.println("Returning home");
    }

    protected abstract void work();

    protected void goToWork() {
        System.out.println("Going to work");
    }

    protected void eatBreakfest() {
        System.out.println("Eating breakfest");
    }

    protected void startRoutine() {
        System.out.println("Starting Routine");

    }

    protected void wakeUp() {
        System.out.println("Getting out of bed");
    }
}
