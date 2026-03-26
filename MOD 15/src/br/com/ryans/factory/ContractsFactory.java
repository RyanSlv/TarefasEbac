package br.com.ryans.factory;

public class ContractsFactory extends Factory {

    @Override
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade))
            return new Bentley(770, "Premium fuel", "Black", "Full");
        else {
            return new Mustang(500, "Premium fuel", "Red","Full");
        }
    }
}



