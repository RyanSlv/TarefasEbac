package br.com.ryans.factory;

public abstract class Car {

    private int horsePower;
    private String fuelSource;
    private String color;
    private String fuelLevel;

    public Car(int horsePower,String fuelSource,String color,String fuelLevel) {
        this.horsePower = horsePower;
        this.fuelLevel = fuelLevel;
        this.fuelSource = fuelSource;
        this.color = color;

    }

    public void startEngine(){
        System.out.println(getClass().getSimpleName());
        System.out.println("The " + fuelSource + " engine has been started, and is ready to utilize " + horsePower + " HP " ) ;

    }

    public void clean() {
        System.out.println("Car has been cleaned, and the " + color.toLowerCase() + " color shines!");
    }

    public void mechanicCheck() {
        System.out.println("Car has been checked by the mechanic. Everything looks good!");
    }

    public void fuelCar() {
        System.out.println("Car fuel is " + fuelLevel.toLowerCase());
    }


}
