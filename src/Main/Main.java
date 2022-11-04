package Main;

import Classes.Customer;
import Classes.Owner;
import Pages.*;

import java.util.ArrayList;

import static Pages.MainMenu.loading;
import static Pages.OwnerFunctions.spacer;

public class Main implements OwnerStaticData, CustomerStaticData {
    public static char page;
    public static ArrayList<Owner> ownerList = OwnerStaticData.OwnerInfo();
    public static ArrayList<Customer> customerList = CustomerStaticData.CustomerInfo();

    public static void main(String[] args) throws InterruptedException {
        loading();
        spacer();
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
