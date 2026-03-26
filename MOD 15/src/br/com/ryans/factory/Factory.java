package br.com.ryans.factory;

public abstract class Factory {
    public abstract Car retrieveCar(String requestedGrade);

    public Car create(String requetedGrade) {
        Car car = retrieveCar(requetedGrade);
        car = prepareCar(car);
        return car;

    }
    private Car prepareCar(Car car) {
        car.clean();
        car.mechanicCheck();
        car.fuelCar();
        return car;
    }
}
