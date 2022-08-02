package dao;

import entity.*;

import java.io.IOException;
import java.time.LocalDate;

public class ShopDAO {


    public static Shop shop = Shop.getINSTANCE( );

    public static void removeGood(Good good, int amount) throws IOException {
        StrimDao strimDao = new StrimDao(new Strime("warehouse"));
        String path = Strime.getNamefilePath( );
//        вызываем метод в управлении складом по удалению
        if (StrimDao.checkingStockAvailability(path, good)) {
            WarehousDAO.removalGoodWareHouse(good, amount);
        }
    }

    public static void addCash(Float amount) throws IOException {
        StrimDao strimDao = new StrimDao(new Strime("finance"));
        String path = Strime.getNamefilePath( );
        LocalDate localDate = LocalDate.now( );
        Strime.outputFile(path, String.valueOf(localDate)+"/"+ String.valueOf(amount), true);

    }

    public final Shop getShop() {

        return shop;
    }

    public void addGood(Good good, int amount) throws IOException {
        StrimDao strimDao = new StrimDao(new Strime("warehouse"));
        String str = good.toString( ) + amount;     //+ "#";
        String path = Strime.getNamefilePath( );
        WarehousDAO warehousDAO = new WarehousDAO( );
        String[] tmp = WarehousDAO.gettingWarehouseData( );
        if (tmp.length < 2) {
            Strime.outputFile(path, str, true);
        } else {
            int indikator = 0;

            for (int j = 0; j < tmp.length; ) {
                if (good.getName( ).equals(tmp[j])) {
                    indikator = indikator + 1;
                    int money = (Integer.parseInt(tmp[j + 2]));
                    String w = tmp[j + 2];
                    System.out.println(w);
                    tmp[j + 2] = String.valueOf(money + amount);
                    break;
                }
                j = j + 3;
            }
            if (indikator == 0) {
                for (int q = 0; q < 3; ) {
                    String[] result = StrimDao.reformatContents(str);
                    Strime.outputFile(path, result[q], true);
                    q++;
                }
            } else {
                Strime.cleanFile(path);
                for (int q = 0; q < tmp.length; ) {
                    System.out.println(tmp[q]);
                    Strime.outputFile(path, tmp[q], true);
                    q++;
                }
            }
        }
    }

    public Good findGood(Good good) throws IOException {
        StrimDao strimDao = new StrimDao(new Strime("warehouse"));
        if (StrimDao.checkingStockAvailability(Strime.getNamefilePath( ), good)) {
            return good;
        }
        return null;
    }



    public void addEmployee(String name, EmployeeType employeeType) throws IOException {
        StrimDao strimDao = new StrimDao(new Strime(employeeType.toString( )));
        String path = Strime.getNamefilePath( );
        String infoRekord = name + "#" + employeeType;
        Check.setCashier(name);
        Strime.outputFile(path, infoRekord, true);
    }

//  креатечек
}
