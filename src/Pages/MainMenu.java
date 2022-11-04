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


    public static void firstScreen()  {
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
    void  spacer(){
        for(int x=0; x<20;x++) {
            System.out.println();
        }
    }
    public static void  loading() throws InterruptedException {
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
    }

}
