package Pages;

import Classes.Customer;
import Classes.Order;
import Main.Main;

import java.util.ArrayList;

public interface CustomerStaticData {

    public static ArrayList<Customer> CustomerInfo() {
        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Fouad Sawiris", "kinge9e0@", "01222994700", "NasserCity"));//0
        customerList.add(new Customer("ibrahim mahmoud", "GreenBBurger", "01222994700", "NasserCity"));//1
        customerList.add(new Customer("Yassin Mansour", "Mcfdds78", "01222994700", "NasserCity"));//2
        return customerList;
    }

    public static void ImplementingData() throws InterruptedException {
        try {
            for (int k = 0; k < 3; k++) {
                Customer customerShortCut = Main.customerList.get(k);
                customerShortCut.getOrders().add(new Order(OwnerStaticData.getRestaurantMeals("mcdonald's").get(5).getName(), 56, "add extra sauce"));//customerMealIndex is required
                customerShortCut.getOrders().add(new Order(OwnerStaticData.getRestaurantMeals("koshary sayed hanafy").get(1).getName(), 7, "add extra sauce"));
                customerShortCut.getOrders().add(new Order(OwnerStaticData.getRestaurantMeals("mcdonald's").get(4).getName(), 23, ""));
                customerShortCut.getOrders().add(new Order(OwnerStaticData.getRestaurantMeals("burger king").get(0).getName(), 45, "add extra sauce"));
                customerShortCut.getOrders().add(new Order(OwnerStaticData.getRestaurantMeals("burger king").get(3).getName(), 576, "add extra sauce"));
                customerShortCut.getOrders().add(new Order(OwnerStaticData.getRestaurantMeals("koshary sayed hanafy").get(1).getName(), 4, "add extra sauce"));
            }
        } catch (NullPointerException e) {
            System.out.println();
            System.out.println("you don't have any available meals");
        }
    }
}
