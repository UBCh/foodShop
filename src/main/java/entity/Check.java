package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Check {

    private static String cashier;
    float summaBuy;
    private final String sellTime;

    public Check(float summaBuy) {
        cashier = cashier;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("h/m/dd/MM/YY");
        LocalDate localDate = LocalDate.now( );
        this.sellTime = String.valueOf(localDate);
        this.summaBuy = summaBuy;
    }

    public float getSummaBuy() {
        return summaBuy;
    }

    public void setSummaBuy(float summaBuy) {
        this.summaBuy = summaBuy;
    }

    public String getCashier() {
        return cashier;
    }

    public static void setCashier(String cash) {
        cashier = cash;
    }

    public String getSellTime() {
        return sellTime;
    }

    @Override
    public String toString() {
        return sellTime + "," + EmployeeType.CASHIER + ":" + getCashier( ) + "," + summaBuy;
    }
}

