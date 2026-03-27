package br.com.ryans.facade;

public class ApartmentService implements IApartmentService {


    public boolean registerApartment(Apartment apartment) {
        boolean isRegistered = isApartmentRegistered(apartment);
        boolean isFieldValidation = isFieldValidation(apartment);
        if (isRegistered && !isFieldValidation) {
            return false;
        }
        return registerInDatabase(apartment);
    }

    private boolean registerInDatabase(Apartment apartment) {
        return true;
    }

    private boolean isApartmentRegistered(Apartment apartment){
        //Go to the database and check if it is registered
        return false;
    }

    private boolean isFieldValidation(Apartment apartment){

        return true;
    }

}
