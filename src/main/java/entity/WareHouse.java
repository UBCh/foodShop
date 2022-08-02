package entity;

public class WareHouse {

    String name = "warehouse";

    public WareHouse() {
    }

    public WareHouse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(String nameGood, Float prise, int amount) {
        String wH = "";
        return wH + nameGood + "," + prise + "," + amount;

    }


}
