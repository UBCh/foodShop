package entity;

public class Shop {
    private static Shop INSTANCE = null;
    private Float cash;


    private Shop() {
    }

    public static Shop getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new Shop( );
        return INSTANCE;
    }

    public Float getCash() {
        return cash;
    }

    public void setCash(Float cash) {
        this.cash = cash;
    }


}

