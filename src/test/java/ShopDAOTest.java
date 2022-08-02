import controllers.ClientController;
import dao.ClientDAO;
import dao.ShopDAO;
import dao.StrimDao;
import dao.WarehousDAO;
import entity.Client;
import entity.EmployeeType;
import entity.Good;
import entity.Strime;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class ShopDAOTest {

    @Test
    public void createGoodWarehouseTest() throws IOException {
        ShopDAO shopDAO=new ShopDAO();
        WarehousDAO warehousDAO=new WarehousDAO();
        Good chicken=new Good("chicken", 300F);
        Good beef=new Good("beef", 900F);
        Good milk=new Good("milk", 100F);
        Good apple=new Good("apple", 250F);
        warehousDAO.createWareHouse();
        warehousDAO.addGoodsWareHouse(warehousDAO.getWareHous().toString( chicken.getName(),chicken.getPrice(),100 ));
        warehousDAO.addGoodsWareHouse(warehousDAO.getWareHous().toString( beef.getName(),beef.getPrice(),100 ));
        warehousDAO.addGoodsWareHouse(warehousDAO.getWareHous().toString( milk.getName(),milk.getPrice(),100 ));
        warehousDAO.addGoodsWareHouse(warehousDAO.getWareHous().toString( apple.getName(),apple.getPrice(),100 ));

//    int expected=4;
//    Assert.assertEquals(shopDAO.getShop().getStore().size(),expected);
    }

    @Test
    public  void  removeGoodWareHousTest() throws IOException {
        ShopDAO shopDAO=new ShopDAO();
        WarehousDAO warehousDAO=new WarehousDAO();
        Good chicken=new Good("chicken", 300F);
        String infoGood=warehousDAO.getWareHous().toString( chicken.getName(),chicken.getPrice(),35 );
        warehousDAO.removalGoodWareHouse(chicken,25);
//        Integer expected= 50;
//        Integer actual= shopDAO.getShop().getStore().get(chicken);
//        Assert.assertEquals(actual,expected);

    }

  @Test
  public void addGoodTest() throws IOException {

    ShopDAO shopDAO=new ShopDAO();
    Good chicken=new Good("chicken", 300F);
    Good beef=new Good("beef", 900F);
    Good milk=new Good("milk", 100F);
    Good apple=new Good("apple", 250F);






//    shopDAO.addGood(chicken,100);
//    shopDAO.addGood(beef,100);
//    shopDAO.addGood(milk,100);
//    shopDAO.addGood(apple,100);

//    int expected=4;
//    Assert.assertEquals(shopDAO.getShop().getStore().size(),expected);
  }

  @Test
  public void findGoodTest() throws IOException {

    ShopDAO shopDAO=new ShopDAO();
    Good chicken=new Good("chicken", 300F);
    Good beef=new Good("beef", 900F);
    Good milk=new Good("milk", 100F);
    Good apple=new Good("apple", 250F);

    shopDAO.addGood(chicken,100);
    shopDAO.addGood(beef,100);
    shopDAO.addGood(milk,100);
    shopDAO.addGood(apple,100);
    Good expected=chicken;
    Good actual=shopDAO.findGood(chicken);
    Assert.assertEquals(actual,expected);
  }

  @Test
  public void addEmployeeTest() throws IOException {

    ShopDAO shopDAO=new ShopDAO();
    shopDAO.addEmployee("Пирожков", EmployeeType.CASHIER);
//    assertTrue(shopDAO.getShop().getEmployees().containsKey("Пирожков"));

  }
  @Test
  public void removeGoodTest() throws IOException {

    ShopDAO shopDAO=new ShopDAO();
    Good chicken=new Good("chicken", 300F);
    Good beef=new Good("beef", 900F);
    Good milk=new Good("milk", 100F);
    Good apple=new Good("apple", 250F);

    shopDAO.addGood(chicken,100);
    shopDAO.addGood(beef,100);
    shopDAO.addGood(milk,100);
    shopDAO.addGood(apple,100);
//    boolean result=shopDAO.removeGood(milk,100);
//    assertTrue(result);
  }


  @Test
   public void printStore() throws IOException {
    ShopDAO shopDAO=new ShopDAO();
      Good chicken=new Good("chicken", 300F);
      Good beef=new Good("beef", 900F);
      Good milk=new Good("milk", 100F);
      Good apple=new Good("apple", 250F);

      shopDAO.addGood(chicken,100);
      shopDAO.addGood(beef,100);
      shopDAO.addGood(milk,100);
      shopDAO.addGood(apple,100);
//      HashMap<Good,Integer> hashMap=shopDAO.showGoods();
//    System.out.println( hashMap );
//    Assert.assertNotEquals(null,hashMap);

  }

  @Test
  public void createCheckTest(){

    ShopDAO shopDAO=new ShopDAO();
    Good chicken=new Good("chicken", 300F);
    Good beef=new Good("beef", 900F);
    Good milk=new Good("milk", 100F);
    Good apple=new Good("apple", 250F);
    Map<Good,Integer> basket=new HashMap<Good,Integer>();
    basket.put(chicken,1);
      basket.put(beef,1);
      basket.put(milk,1);
      basket.put(apple,2);
//    Check newCheck=shopDAO.createCheck(basket,"Вредный");
//    System.out.println( newCheck.getGoodList());
//   int expected=4;
//    Assert.assertEquals(newCheck.getGoodList().size(),expected);
}
//   @Test
// public  void  removeGoodByAmountTest() throws IOException {
//
//     ShopDAO shopDAO=new ShopDAO();
//     Good chicken=new Good("chicken", 300F);
//     Good beef=new Good("beef", 900F);
//     Good milk=new Good("milk", 100F);
//     Good apple=new Good("apple", 250F);
//
//     shopDAO.addGood(chicken,100);
//     shopDAO.addGood(beef,100);
//     shopDAO.addGood(milk,100);
//     shopDAO.addGood(apple,100);
//     shopDAO.removeGood(chicken,50);
//     Integer expected= 50;
//     Integer actual= shopDAO.getShop().getStore().get(chicken);
//     Assert.assertEquals(actual,expected);
//
//   }

    @Test
    public  void  strimTest() throws IOException {
        String nameCasher = "Ivanov";
        Client client = new Client("Pirogkov", 12000F);
        ClientDAO clientDAO = new ClientDAO(client);
        ShopDAO shopDAO = new ShopDAO( );
        shopDAO.getShop().setCash(10000F);
        shopDAO.addCash( shopDAO.getShop().getCash());
//
        Good chicken = new Good("chicken", 300F);
        Good beef = new Good("beef", 900F);
        Good milk = new Good("milk", 100F);
        Good apple = new Good("apple", 250F);


        Strime strime=new Strime();
        StrimDao strimDaoWarehouse=new StrimDao(strime);
        strimDaoWarehouse.createFile("warehouse");
        shopDAO.addGood(chicken, 100);
        shopDAO.addGood(beef, 100);
        shopDAO.addGood(milk, 100);
        shopDAO.addGood(apple, 100);

        shopDAO.addGood(chicken, 100);
        shopDAO.addGood(beef, 100);


        StrimDao strimDaoFinance =new StrimDao(new Strime("finance"));
        strimDaoFinance.createFile("finance");
       shopDAO.addEmployee(nameCasher, EmployeeType.CASHIER);
        clientDAO.setStrime("Basket");
        clientDAO.addGoodToBasket(chicken,3);
        clientDAO.addGoodToBasket(milk,1);
        clientDAO.addGoodToBasket(apple,12);
        String[] basket=clientDAO.gettingBasketData();
        clientDAO.removeGoodFromBasket(apple,3);


    }

    @Test
    public  void  strim1Test() throws IOException {
        ClientController.clientBuy();
    }


    @Test
    public  void  strimCreateFileTest() throws IOException {
        Client client=new Client("Pirogkov", 12000F);
       StrimDao strimDao=new StrimDao(new Strime("cashiers"));
        strimDao.createFile("cashiers");}

    @Test
    public  void  strimCleanFileTest() throws IOException {
        StrimDao.clearFile("test.txt");}

    @Test
    public  void  strimDeleteFileTest() throws IOException {
        StrimDao.deleteFile("src/main/java/artifact/test.txt");}

    @Test
    public  void  strimExistingFileTest() throws IOException {
        assertTrue(StrimDao.existingFile("src/main/java/artifact/PupkinBasket"));}

@Test
     public  void strimCreateBasket() throws IOException {
    Good chicken=new Good("chicken", 300F);
    Client client = new Client("Pirogkov", 12000F);
    ClientDAO clientDAO = new ClientDAO(client);
    if (StrimDao.checkingStockAvailability("warehouse", chicken)) {
        clientDAO.addGoodToBasket(chicken, 2);

       Strime strime =new Strime(client.getNameClient()+ "wallet");


           }
}



//    @Test
//    public void addBasketTest() throws IOException {
//        Client client=new Client("Pupkin", 10000F);
//        Strime strime=new Strime(client.getNameClient()+"Basket");
//        ClientDAO clientDAO=new ClientDAO(client,strime);
//        Good chicken=new Good("chicken", 300F);
//        Good beef=new Good("beef", 900F);
//        Good milk=new Good("milk", 100F);
//        Good apple=new Good("apple", 250F);
//
//       clientDAO.addGoodToBasket(chicken,100);
//        clientDAO.addGoodToBasket(beef,100);
//        clientDAO.addGoodToBasket(milk,100);
//        clientDAO.addGoodToBasket(apple,100);
//        int expected=4;
//        String[] basketGods=client.getBasket("PupkinBasket");
//        for (int i = 0; i < basketGods.length; i++) {
//            System.out.println( basketGods[i] );
//        }
//        Assert.assertEquals(basketGods.length,expected);
//    }

}
