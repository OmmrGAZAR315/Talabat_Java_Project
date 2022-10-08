package Pages;

import Main.Main;

import java.util.Scanner;

abstract public class MainMenu implements OwnerFunctions, CustomerFunctions {
    static int mealQuantity;
    static String mealDesc;
    static String mealName;
    static String mealNotes;
    static String chosenRestaurant;
    static int chosenMeal;

    static int uniqueID;
    static int leftTimes;

    String chosenEditorNumber;
    static boolean validUser;
    static boolean reExecute;
    static Scanner in = new Scanner(System.in);
    static String restaurantName;
    static String mobileNum;
    static String address;
    static String userName;
    static String countryCode;
    static String password;
    public static int RestaurantAddress;//never changed until running loginPage again
    static int ownerAddress;//never changed until running loginPage again
    static int CustomerAddress;//never changed until running loginPage again


    public static void firstScreen() throws InterruptedException {
        do {
            reExecute = false;
            System.out.println("--------------Welcome to Talabat-----------------");
            System.out.println("              Food & Groceries");
            System.out.println();
            System.out.println("1 - Restaurant Owner");
            System.out.println("2 - Customer");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            switch (in.nextLine().toLowerCase()) {
                case "1", "owner" -> Main.page = '1';
                case "2", "customer" -> Main.page = '2';
                default -> {
                    System.out.println("Wrong input, Please try again, use numbers ( 1, 2 )");
                    reExecute = true;
                }
            }
        } while (reExecute);
    }
}
