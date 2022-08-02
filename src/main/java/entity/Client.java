package entity;

public class Client {

    Float cash;

    String nameClient;


    public Client(String nameClient, Float cash) {
        this.cash = cash;
        this.nameClient = nameClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }


    public Float getCash() {
        return cash;
    }

    public void setCash(Float cash) {
        this.cash = cash;
    }


}
