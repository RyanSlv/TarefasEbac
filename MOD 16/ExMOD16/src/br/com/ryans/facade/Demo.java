package br.com.ryans.facade;

public class Demo {

    public static void main(String[] args) {
        IApartmentService service = new ApartmentService();
        service.registerApartment(new Apartment(1, "Antonio João"));
    }
}
