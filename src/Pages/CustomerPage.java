package Pages;

import Main.Main;

public class CustomerPage extends MainMenu {
    static boolean firstTime = true;

    public static void WelcomeCustomer() throws InterruptedException {
        System.out.println();
        System.out.println("Welcome Customer");
        System.out.println("1 - Login");
        System.out.println("2 - New user, Register Now");
        System.out.println("3 - Exit");
        System.out.println();
        System.out.println();
        System.out.println();
        switch (in.nextLine()) {
            case "1" -> {
                LoginPage.Login(true);
                OwnerFunctions.spacer();
                if (firstTime) {
                    firstTime = false;
                    CustomerStaticData.ImplementingData();
                }
                CustomerFunctions.CustomerHomePage();
            }
            case "2" -> {
                System.out.println("Choose your country");
                System.out.println("1 - Om elDonia");
                System.out.println("2 - USA");
                System.out.println();
                System.out.println();
                System.out.println();
                switch (in.nextLine()) {
                    case "1" -> {
                        countryCode = "+20";
                    }
                    case "2" -> {
                        countryCode = "+1";
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Invalid input");
                        System.out.println();
                        WelcomeCustomer();
                    }
                }
                RegisterPage.Register(true);
                OwnerFunctions.spacer();
                WelcomeCustomer();
            }
            case "3" -> Main.RunMe();
            default -> {
                System.out.println("Wrong input, Please try again, use numbers (1, 2, 3)");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                WelcomeCustomer();
            }
        }
    }
}
