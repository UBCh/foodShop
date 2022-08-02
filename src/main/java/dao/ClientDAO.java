package dao;

import entity.Check;
import entity.Client;
import entity.Good;
import entity.Strime;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class ClientDAO {

    static Client client;
    static Strime strime;
    StrimDao strimDao = new StrimDao(strime);

    public ClientDAO(Client newClient) {
        client = newClient;
        strime = new Strime(client.getNameClient( ) + "Basket");

    }

    public static Strime getStrime() {
        return strime;
    }

    public static void setStrime(String nameStrim) {
        Strime strime = new Strime(client.getNameClient( ) + nameStrim);
    }

    public static String[] gettingBasketData() {
        setStrime("Basket");
        Strime newStrime = getStrime( );
        String gg = Strime.getNamefilePath( );
        String tmp = Strime.inputFiles(gg);
        return StrimDao.reformatContents(tmp);
    }

    public static String[] gettingChecKData() {
        Strime getChecK = new Strime(client.getNameClient( ) + "Сheque");
        String tmp = Strime.inputFiles(Strime.getNamefilePath( ));
        return StrimDao.reformatContents(tmp);
    }

    public Client getClient() {
        return client;
    }

    public void addGoodToBasket(Good good, Integer amount) throws IOException {
        String path = strime.getNamefilePath( );
        String infoForRecord = good.toString( ) + amount;
        if (StrimDao.checkingStockAvailability("src/main/java/artifact/warehouse", good)) {
            if (!(Files.exists(Path.of(path)))) {
                StrimDao.createFile(client.getNameClient( ) + "Basket");
                Strime.outputFile(path, infoForRecord, true);

            } else {

                String[] tmp = gettingBasketData( );
                if (tmp.equals("") | tmp.equals("\n")) {
                    Strime.outputFile(path, infoForRecord, true);
                } else {
                    int indikator = 0;
                    for (int z = 0; z < tmp.length; ) {
                        if (good.getName( ).equals(tmp[z])) {
                            indikator = indikator + 1;
                        }
                        z = z + 2;
                    }
                    if (indikator == 0) {
                        Strime.outputFile(path, infoForRecord, true);
                    } else {
                        for (int j = 0; j < tmp.length; ) {
                            if (good.getName( ).equals(tmp[j])) {
                                int money = (Integer.parseInt(tmp[j + 2]));
                                String w = tmp[j + 2];
                                System.out.println(w);
                                tmp[j + 2] = String.valueOf(money + amount);
                                break;
                            }
                            j = j + 2;
                        }
                        Strime.cleanFile(path);
                        for (int q = 0; q < tmp.length; ) {
                            System.out.println(tmp[q]);
                            Strime.outputFile(path, tmp[q], true);
                            q++;
                        }
                    }

                }
            }

        }
//        else{ ошибка- товара нет на складе}
    }

    public void removeGoodFromBasket(Good good, Integer amount) throws IOException {
        String[] goodBasket = gettingBasketData( );
        String path = Strime.getNamefilePath( );
        if (StrimDao.checkingStockAvailability(path, good)) {
            int indikator = 0;
            for (int i = 0; i < goodBasket.length; ) {

                if (good.getName( ).equals(goodBasket[i])) {


                    if (Integer.parseInt(goodBasket[i + 2]) <= amount) {
                        goodBasket[i] = "";
                        goodBasket[i + 1] = "";
                        goodBasket[i + 2] = "";
                    } else {
                        int money = (Integer.parseInt(goodBasket[i + 2]));
                        String w = goodBasket[i + 2];
                        System.out.println(w);
                        goodBasket[i + 2] = String.valueOf(money - amount);
                    }
                    indikator = indikator + 1;
                }
                i = i + 2;
            }
            if (indikator > 0) {
                Strime.cleanFile(path);
                for (int q = 0; q < goodBasket.length; ) {
                    System.out.println(goodBasket[q]);
                    Strime.outputFile(path, goodBasket[q], true);
                    q++;
                }
            }
//            else {ошибка товар в корзине не найден}
        }
    }

    // покупка
    public void buy(String[] basket) throws IOException {
        Float total = client.getCash( ); // деньги клиента
        Strime buyStrim = new Strime(client.getNameClient( ) + "Wallet");
        String patch = Strime.getNamefilePath( );
        Float summa = 0F; // сумма покупки
        for (int i = 0; i < basket.length; ) {
            String fff = basket[i + 2];
            fff = fff + "";
            float quantityGoods = Integer.parseInt(basket[i + 2]);
            String nameDeleteGood = basket[i];
            // перевод 300.0 в число -временное решение
            String s = basket[i + 1];
            char[] xernya = s.toCharArray( );
            char[] itogXernya = new char[3];
            itogXernya[0] = xernya[0];
            itogXernya[1] = xernya[1];
            itogXernya[2] = xernya[2];
            s = new String(itogXernya);
            int productPrice = Integer.parseInt(s.trim( ));

            Good deleteGood = new Good(nameDeleteGood, (float) productPrice);
            summa = productPrice * quantityGoods;
            ShopDAO.removeGood(deleteGood, (int) quantityGoods);
            i = i + 3;
        }
        addCheck(basket, summa);
        if (summa <= total) {
            total = total - summa;
            client.setCash(total);
            setStrime("Wallet");
            Strime.outputFile(Strime.getNamefilePath( ), String.valueOf(total), false);
        }
        removeCash(summa);

    }

    public Float removeCash(Float summa) throws IOException {
        Float money = ShopDAO.shop.getCash( );
        ShopDAO.shop.setCash(money + summa);
        money = money + summa;
        ShopDAO.addCash(money);
        return money;
    }

    public void addCheck(String[] basket, Float summa) throws IOException {
        Strime buyStrim = new Strime(client.getNameClient( ) + "Сheque");
        Check check = new Check(summa);
        Strime.outputFile(Strime.getNamefilePath( ), check.toString( ), true);
        String result = Arrays.toString(basket);
        Strime.outputFile(Strime.getNamefilePath( ), result, true);
        setStrime(client.getNameClient( ) + "Basket");
        StrimDao.clearFile(client.getNameClient( ) + "Basket");
    }

}
