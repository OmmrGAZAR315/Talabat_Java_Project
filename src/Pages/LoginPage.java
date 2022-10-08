package Pages;

import Classes.Customer;
import Classes.Owner;
import Main.Main;

import static Pages.CustomerPage.WelcomeCustomer;

public class LoginPage extends MainMenu {

    static void Login(boolean thisIsCustomer) throws InterruptedException {
        boolean UserMistake = true;
        int x;
        System.out.println();
        System.out.println();
        System.out.println("Please enter the following :");
        System.out.print(" Username : ");
        userName = in.nextLine().toLowerCase();
        if (!thisIsCustomer) {
            System.out.println("( To see all the names of your owned restaurants press enter )");
            System.out.print(" Restaurant Name : ");
            restaurantName = in.nextLine().toLowerCase();
        }
        System.out.print(" Password : ");
        password = in.nextLine();
        if (thisIsCustomer) {
            //Customer
            for (x = 0; x < Main.customerList.size(); x++) {
                Customer customerShortCut = Main.customerList.get(x);

                validUser = OwnerFunctions.validUser(customerShortCut);
                if (validUser) {
                    UserMistake = false;
                    CustomerAddress = x;
                    break;
                }
            }
            if (x == Main.customerList.size() && UserMistake) {
                System.out.println();
                System.out.println("Invalid UserName and Password. ");
                System.out.println();
                WelcomeCustomer();
            }
        } else {
            for (x = 0; x < Main.ownerList.size(); x++) {

                Owner OwnerShortCut = Main.ownerList.get(x);

                validUser = OwnerFunctions.validUser(OwnerShortCut);


                if (validUser && OwnerShortCut.getRestaurantName(restaurantName)) {
                    ownerAddress = x;
                    UserMistake = false;
                    break;

                } else if (validUser) {
                    System.out.println();
                    System.out.println();
                    UserMistake = false;
                    System.out.println("Welcome Mr." + OwnerFunctions.capitalizeWord(Main.ownerList.get(ownerAddress).getUserName()));
                    boolean plural = OwnerShortCut.getRestaurantName().size() > 1;
                    if (OwnerShortCut.getRestaurantName().size() == 0) {
                        System.out.println();
                        System.out.println("Error 404 : Not Found");
                        System.out.println("you don't have a Restaurant");
                        System.out.println("please add at least one Restaurant, ( press Enter )");
                        System.out.println();
                        System.out.println();
                    } else {
                        System.out.println(" your owned Restaurant" + (plural ? "s : " : " : ") + OwnerShortCut.getRestaurantName());
                        System.out.println();
                        System.out.print("Press Enter to continue");
                        System.out.println();
                        System.out.println();

                    }
                    in.nextLine();
                    OwnerPage.WelcomeOwner();
                }

            }
            if (x == Main.ownerList.size() && UserMistake) {
                System.out.println();
                System.out.println("Invalid UserName and Password. ");
                System.out.println();
                OwnerPage.WelcomeOwner();
            }
        }
    }

}
