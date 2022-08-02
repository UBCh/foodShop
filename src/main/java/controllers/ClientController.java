package controllers;

import dao.ClientDAO;
import dao.ShopDAO;
import dao.StrimDao;
import entity.*;

import java.io.IOException;
import java.util.Arrays;

public class ClientController {


    public static void clientBuy() throws IOException {
        String nameCasher = "Ivanov";
        Check.setCashier(nameCasher);
        Client client = new Client("Pirogkov", 12000F);
        ClientDAO clientDAO = new ClientDAO(client);
        ShopDAO shopDAO = new ShopDAO( );
        shopDAO.getShop( ).setCash(10000F);

        Good chicken = new Good("chicken", 300F);
        Good beef = new Good("beef", 900F);
        Good milk = new Good("milk", 100F);
        Good apple = new Good("apple", 250F);
        StrimDao.createFile("warehouse");
        shopDAO.addGood(chicken, 100);
        shopDAO.addGood(beef, 100);
        shopDAO.addGood(milk, 100);
        shopDAO.addGood(apple, 100);
        shopDAO.addGood(chicken, 100);
        shopDAO.addGood(beef, 100);
        StrimDao.createFile("finance");
        ShopDAO.addCash(shopDAO.getShop( ).getCash( ));
        shopDAO.addEmployee(nameCasher, EmployeeType.CASHIER);
        clientDAO.setStrime("Basket");
        clientDAO.addGoodToBasket(chicken, 3);
        clientDAO.addGoodToBasket(milk, 1);
        clientDAO.addGoodToBasket(apple, 12);
        clientDAO.removeGoodFromBasket(apple, 3);
        String[] basket = ClientDAO.gettingBasketData( );
        clientDAO.buy(basket);
        System.out.println(Arrays.toString(clientDAO.gettingChecKData( )));
        clientDAO.setStrime("Basket");
        clientDAO.addGoodToBasket(chicken, 1);
        clientDAO.addGoodToBasket(milk, 3);
        clientDAO.addGoodToBasket(apple, 24);
        clientDAO.removeGoodFromBasket(apple, 1);
        String[] basket2 = ClientDAO.gettingBasketData( );
        clientDAO.buy(basket2);
        System.out.println(Arrays.toString(clientDAO.gettingChecKData( )));
        clientDAO.setStrime("Basket");
        clientDAO.addGoodToBasket(milk, 5);
        clientDAO.addGoodToBasket(apple, 6);
        clientDAO.addGoodToBasket(beef, 1);

    }


}
