package Main;

import Classes.Customer;
import Classes.Owner;
import Pages.*;

import java.util.ArrayList;

public class Main implements OwnerStaticData, CustomerStaticData {
    public static char page;
    public static ArrayList<Owner> ownerList = OwnerStaticData.OwnerInfo();
    public static ArrayList<Customer> customerList = CustomerStaticData.CustomerInfo();

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(500);
        System.out.println("-------------------Talabat-------------------");
        Thread.sleep(1000);
        System.out.println("          Talabat Kol youm fel engaz");
        Thread.sleep(1500);
        System.out.print("Loading");
        Thread.sleep(1700);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        OwnerStaticData.callingMangeRestaurant();
        RunMe();
    }

    public static void RunMe() throws InterruptedException {
        MainMenu.firstScreen();
        switch (page) {
            case '1' -> OwnerPage.WelcomeOwner();
            case '2' -> CustomerPage.WelcomeCustomer();
        }
    }
}
