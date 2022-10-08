package Pages;

import Classes.Customer;
import Classes.Meal;
import Classes.Order;
import Classes.Owner;
import Main.Main;

import java.util.ArrayList;

import static Pages.MainMenu.*;


public interface CustomerFunctions {


    static void CustomerHomePage() throws InterruptedException {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Welcome Mr." + OwnerFunctions.capitalizeWord(Main.customerList.get(CustomerAddress).getUserName()));
        System.out.println();
        System.out.println("1 - Restaurants and Fast Food");
        System.out.println("2 - Previous orders");
        System.out.println("3 - Log Out");
        System.out.println();
        System.out.println();
        System.out.println();
        switch (in.nextLine()) {
            case "1" -> {
                Choose_A_Restaurant();
            }
            case "2" -> CustomerOrders();

            case "3" -> {
                {
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("Are you sure ? Y/N");
                    switch (in.nextLine().toLowerCase()) {
                        case "yes", "y" -> {
                            System.out.println();
                            System.out.println();
                            System.out.print("Goodbye");
                            System.out.print(".");
                            Thread.sleep(1000);
                            System.out.print(".");
                            Thread.sleep(1000);
                            System.out.print(".");
                            Thread.sleep(1000);
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            CustomerPage.WelcomeCustomer();
                        }
                        case "no", "n" -> CustomerHomePage();
                    }
                }
            }
            default -> {
                System.out.println();
                System.out.println("Invalid input, please try again");
                System.out.println();
                System.out.println();
                System.out.println();
                CustomerHomePage();
            }
        }
    }

    private static void Choose_A_Restaurant() throws InterruptedException {

        int index = 0;
        System.out.println();
        System.out.println("Enter a restaurant Name!");
        System.out.println();
        for (int ownerLopper = 0; ownerLopper < Main.ownerList.size(); ownerLopper++) {
            Owner ownerShortCut = Main.ownerList.get(ownerLopper);
            for (int restaurantLooper = 0; restaurantLooper < ownerShortCut.getRestaurantName().size(); restaurantLooper++) {
                index++;
                System.out.println(index + " - " + ownerShortCut.getRestaurantName().get(restaurantLooper));
            }
        }
        System.out.println();
        System.out.println();
        chosenRestaurant = in.nextLine().toLowerCase().trim();
        findChosenRestaurant();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("-------------Welcome to " + Main.ownerList.get(ownerAddress).restaurants[RestaurantAddress].getRestaurantName() + "-------------");
        System.out.println("Choose your meal");
        System.out.println();

        index = 0;
        for (int x = 0; x < Main.ownerList.get(ownerAddress).restaurants[RestaurantAddress].getMealList().size(); x++) {
            index++;
            System.out.println(index + " - " + Main.ownerList.get(ownerAddress).restaurants[RestaurantAddress].getMealList().get(x).getName());
        }
        do {
            reExecute = false;
            do {
                reExecute = false;
                try {
                    System.out.println();
                    chosenMeal = Integer.parseInt(in.nextLine()) - 1;
                } catch (NumberFormatException e) {
                    OwnerFunctions.displayError("please try again");
                    reExecute = true;
                }
            } while (reExecute);
            if (chosenMeal <= index || chosenMeal != 0) {
                System.out.println();
                System.out.println();
                mealName = Main.ownerList.get(ownerAddress).restaurants[RestaurantAddress].getMealList().get(chosenMeal).getName();
                System.out.println("Meal Name : " + mealName);
                System.out.println("Meal Price : " + Main.ownerList.get(ownerAddress).restaurants[RestaurantAddress].getMealList().get(chosenMeal).getPrice());
                mealDesc = Main.ownerList.get(ownerAddress).restaurants[RestaurantAddress].getMealList().get(chosenMeal).getDescription();
                System.out.println("Meal Description : " + mealDesc);
                System.out.println();
                System.out.println();
                do {
                    System.out.println("How Many you want from this item?");
                    System.out.print(" - ");

                    reExecute = false;
                    try {
                        mealQuantity = Integer.parseInt(in.nextLine());
                        System.out.println();
                        System.out.println("Any additional notes");
                        System.out.print(" - ");
                        mealNotes = in.nextLine();
                        if (mealQuantity > 10) {
                            System.out.println("invalid quantity, maximum limit is 9");
                            OwnerFunctions.displayError("please try again");
                            reExecute = true;
                        } else if (mealQuantity != 0) {
                            Main.customerList.get(CustomerAddress).getOrders().add(new Order(mealName, mealQuantity, mealNotes));
                            Main.ownerList.get(ownerAddress).restaurants[RestaurantAddress].getOrders().add(new Order(mealName, mealQuantity, mealNotes));
                        }
                    } catch (NumberFormatException e) {
                        OwnerFunctions.displayError("Please try again");
                        reExecute = true;
                    }
                } while (reExecute);
            } else {
                OwnerFunctions.displayError("please try again");
                reExecute = true;
            }
            CustomerHomePage();
        } while (reExecute);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private static void findChosenRestaurant() throws InterruptedException {
        boolean succeed = true;
        int k;
        for (k = 0; k < Main.ownerList.size(); k++) {
            for (int j = 0; j < Main.ownerList.get(k).getRestaurantName().size(); j++) {
                if (Main.ownerList.get(k).restaurants[j].getRestaurantName().equals(chosenRestaurant)) {
                    succeed = false;
                    ownerAddress = k;
                    RestaurantAddress = j;
                    break;
                }
            }
        }
        if (k == Main.ownerList.size() && succeed) {
            OwnerFunctions.displayError("Please try again");
            Choose_A_Restaurant();
        }

    }

    static void CustomerOrders() throws InterruptedException {
        if (Main.customerList.get(CustomerAddress).getOrders().size() != 0) {
            Customer customerShortCut = Main.customerList.get(CustomerAddress);
            reExecute = true;
            int x = 1;
            System.out.println();
            System.out.println();
            for (; x <= customerShortCut.getOrders().size(); x++) {
                if (reExecute) {
                    reExecute = false;
                    System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
                    System.out.println("    | Order ID | Order Name|  | Quantity  |    |  Date   |        |  Additional Notes          |");
                    System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾ ");
                }
                uniqueID = (int) (Math.random() * (254645467 - 655464654 + 1) + 655464654);
                System.out.print("    |" + uniqueID + " | " + customerShortCut.getOrders().get(x - 1).getMealName() + "  |   ");
                System.out.print("  " + customerShortCut.getOrders().get(x - 1).getQuantity() + "  |   ");
                System.out.print("    " + customerShortCut.getOrders().get(x - 1).getDate_Time() + "  |    ");
                System.out.println("        " + customerShortCut.getOrders().get(x - 1).getNotes() + "  |");
                System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾ ");
                if (x % 3 == 0 && x != customerShortCut.getOrders().size()) {
                    reExecute = true;
                    System.out.println();
                    System.out.println();
                    System.out.print("check for more orders!, (press enter )");
                    System.out.println();
                    System.out.println();
                    in.nextLine();
                }
            }

            System.out.println();
            System.out.println();
            System.out.print("Press Enter to continue");
            System.out.println();
            System.out.println();
        } else {
            System.out.println();
            System.out.println();
            System.out.println("you don't have any previous orders, ( press enter )");
            System.out.println();
            System.out.println();
            System.out.println();
        }
        in.nextLine();
        CustomerHomePage();

    }

}
