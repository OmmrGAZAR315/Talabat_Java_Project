package Pages;

import Main.Main;

public class OwnerPage extends MainMenu {

    public static void WelcomeOwner() throws InterruptedException {
        System.out.println("Welcome Owner");
        System.out.println("1 - Login");
        System.out.println("2 - New user, New Restaurant, Register Now,");
        System.out.println("3 - Exit");
        System.out.println();
        System.out.println();
        System.out.println();
        switch (in.nextLine()) {
            case "1" -> {
                LoginPage.Login(false);
                Restaurant.setOwnerName(Main.ownerList.get(MainMenu.ownerAddress).getUserName());
                OwnerFunctions.spacer();
                Main.ownerList.get(ownerAddress).restaurants[RestaurantAddress].MangeRestaurant();
            }
            case "2" -> {
                RegisterPage.Register(false);
                OwnerFunctions.spacer();
                WelcomeOwner();
            }
            case "3" -> Main.RunMe();
            default -> {
                System.out.println("Wrong input, Please try again, use numbers (1, 2, 3)");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                WelcomeOwner();
            }
        }
    }

}
