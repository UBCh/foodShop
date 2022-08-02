package dao;

import entity.Good;
import entity.Strime;
import entity.WareHouse;

import java.io.IOException;

public class WarehousDAO {

    static WareHouse wareHous = new WareHouse( );
    static Strime strime = new Strime(wareHous.getName( ));
    static String path = Strime.getNamefilePath( );

    public WarehousDAO() {
        wareHous = wareHous;
    }

    public static WareHouse getWareHous() {
        return wareHous;
    }

    public static void createWareHouse() throws IOException {
        String tmp = wareHous.getName( );
        StrimDao.createFile(tmp);

    }

    public static void addGoodsWareHouse(String infoGood) throws IOException {
        Strime.outputFile(Strime.getNamefilePath( ), infoGood, true);
    }

    public static String[] gettingWarehouseData() {
        String tmp = Strime.inputFiles(path);
        return StrimDao.reformatContents(tmp);
    }

    public static void removalGoodWareHouse(Good good, int amount) throws IOException {
        String infoGood = wareHous.toString(good.getName( ), good.getPrice( ), amount);
        String[] wareH = gettingWarehouseData( );
        String[] delete = infoGood.split(",");
        int y = Integer.parseInt(delete[2].trim( ));
        for (int i = 0; i < wareH.length; ) {
            int x = Integer.parseInt(wareH[i + 2]);

            if (wareH[i].equals(delete[0])) {
                if (x < y) {
                } // ошибка - нет на складе
                else if (x > y) {
                    wareH[i + 2] = String.valueOf(x - y);
                } else if (x == y) {
                    wareH[i] = "";
                    wareH[i + 1] = "";
                    wareH[i + 2] = "";
                }
            } else {
            }// ошибка - нет на складе
            i = i + 3;
        }
        Strime.cleanFile(path);

        for (int q = 0; q < wareH.length; ) {
            System.out.println(wareH[q]);
            Strime.outputFile(path, wareH[q], true);
            q++;
        }
        // ошибка - нет на складе

//        System.out.println("the product was not found in stock");

    }

    public void setStrime(WareHouse wareHous) {
        strime = new Strime(wareHous.getName( ));
    }


}


