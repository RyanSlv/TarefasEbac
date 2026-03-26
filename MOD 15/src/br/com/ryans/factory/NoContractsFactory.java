package br.com.ryans.factory;

public class NoContractsFactory extends Factory{

    @Override
    Car retrieveCar(String requestedGrade) {
        if ("B".equals(requestedGrade))
            return new Ram(305, "Standard fuel", "Silver","Full");
        else {
            return new Corolla(170, "Standard fuel", "Blue", "Full");
        }
    }
}


