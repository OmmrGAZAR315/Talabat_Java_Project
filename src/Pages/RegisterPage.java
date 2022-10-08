package Pages;

import Classes.Owner;
import Main.Main;

public class RegisterPage extends MainMenu {

    static void Register(boolean thisIsCustomer) throws InterruptedException {
        System.out.println();
        System.out.println();
        System.out.println("Please enter the following :");
        do {
            System.out.print(" Username : ");
            validUser = false;
            userName = OwnerFunctions.Looper(" Username : ", 6);
            validUser = OwnerFunctions.Finder(userName, thisIsCustomer);
            System.out.println(validUser ? "This UserName is taken" : "");
        } while (validUser);
        if (!thisIsCustomer) {
            validUser = OwnerFunctions.Finder(userName, false);
            Owner OwnerShortCut = Main.ownerList.get(ownerAddress);
            if (validUser && OwnerShortCut.getRestaurantName().size() != 0) {
                boolean plural = OwnerShortCut.getRestaurantName().size() > 1;
                System.out.println(" your owned Restaurant" + (plural ? "s : " : " : ") + OwnerShortCut.getRestaurantName());
                System.out.print("New Restaurant Name : ");
            } else {
                System.out.print(" Restaurant Name : ");
                restaurantName = OwnerFunctions.Looper(" Restaurant Name : ", 0);

            }
        } else {
            do {
                reExecute = false;
                System.out.print(" Mobile Number : " + countryCode);
                try {
                    mobileNum = String.valueOf((Double.parseDouble(in.nextLine())));
                    if (!(Double.parseDouble(mobileNum) != 10)) {
                        reExecute = true;
                        System.out.println("Mobile Number is 11 numbers");
                    }
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Invalid characters only numbers are allowed");
                    System.out.println();
                    reExecute = true;
                }
            } while (reExecute);
            System.out.print(" Address : ");
            address = in.nextLine();
        }
        System.out.print(" Password : ");
        password = OwnerFunctions.Looper();
        if (validUser) {
            OwnerFunctions.Looper(password, restaurantName);
        } else {
            System.out.print(" Confirm Password : ");
            OwnerFunctions.Looper(password, thisIsCustomer);
        }
    }
}
