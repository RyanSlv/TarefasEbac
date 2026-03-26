package br.com.ryans.factory;

public class Demo {

    public static void main(String[] args){
        Customer client = new Customer("A", false);
        Factory factory = getFactory(client);
        Car car  = factory.create(client.getGradeRequest());
        car.startEngine();
    }

    private static Factory getFactory(Customer cliente){
        if(cliente.isHasCompanyContract()){
            return new ContractsFactory();
        } else {
            return new NoContractsFactory();
        }
    }
}
