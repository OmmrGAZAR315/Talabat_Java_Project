package Pages;

import Main.Main;

import Classes.Meal;
import Classes.Order;

import java.util.ArrayList;

public class Restaurant extends MainMenu {
    int chosenMeal;
    public String mealName;
    boolean plural;
    public boolean reExecute1;
    public String mealPrice;
    public String mealDesc;
    private ArrayList<Order> orders = new ArrayList<>();
    private String restaurantName;
    private static String OwnerName;
    private ArrayList<Meal> mealList = new ArrayList<>();


    public String getRestaurantName() {
        return restaurantName;
    }

    public ArrayList<Meal> getMealList() {
        return mealList;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setMealList(ArrayList<Meal> mealList) {
        this.mealList = mealList;
    }

    public static void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public void setRestaurantName(String str) {
        restaurantName = str;
    }

    public void MangeRestaurant() throws InterruptedException {
        System.out.println();
        System.out.println();
        System.out.println("Welcome Mr." + OwnerName);
        System.out.println("Your Restaurant " + OwnerFunctions.capitalizeWord(restaurantName));
        System.out.println();
        System.out.println("What can i do for you ?");
        System.out.println("1 - Add a meal");
        System.out.println("2 - Edit meals");
        System.out.println("3 - Remove meals");
        System.out.println("4 - Restaurant's Orders");
        System.out.println("5 - Log Out");
        System.out.println();
        System.out.println();
        System.out.println();
        switch (in.nextLine().toLowerCase()) {
            case "add", "1" -> Add();
            case "edit", "2" -> Edit();
            case "remove", "3" -> Remove();
            case "order", "4" -> Orders();
            case "logout", "5" -> {
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
                        OwnerPage.WelcomeOwner();
                    }
                    case "no", "n" -> MangeRestaurant();
                }
            }
            default -> {
                OwnerFunctions.displayError("please try again");
                MangeRestaurant();
            }
        }
    }


    private void Add() throws InterruptedException {


        do {
            do reExecute = MealNameMistakes(); while (reExecute);
            do reExecute = MealPriceMistakes(); while (reExecute);
            do reExecute = MealDescMistakes(); while (reExecute);

            do {
                reExecute1 = false;
                System.out.println("  Are you sure ? Y/N");
                switch (in.nextLine().toLowerCase()) {
                    case "yes", "y" -> mealList.add(new Meal(mealName, Double.parseDouble(mealPrice), mealDesc));
                    case "no", "n" -> {
                        try {
                            do {
                                System.out.println("Go to Restaurant settings (Y) or retry add a meal (N)");
                                switch (in.nextLine().toLowerCase()) {
                                    case "y", "yes":
                                        MangeRestaurant();
                                    case "n", "no":
                                        Add();
                                    default: {
                                        System.out.println();
                                        System.out.println("wrong input, please try again");
                                        System.out.println();
                                        System.out.println();
                                    }
                                }
                            } while (true);
                        } catch (Exception e) {
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            MangeRestaurant();
                        }
                    }
                    default -> {
                        System.out.println();
                        System.out.println("wrong input, please try again");
                        System.out.println();
                        System.out.println();
                        reExecute1 = true;
                    }
                }
            } while (reExecute1);
        } while (reExecute);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        MangeRestaurant();
    }

    void Edit() throws InterruptedException {
        if (mealList.size() != 0) {
            do {
                do {
                    reExecute = false;
                    System.out.println("  Choose which meal you want to edit it. ( numbers only )");
                    for (int x = 0; x < mealList.size(); x++) {
                        System.out.println(x + 1 + " - " + OwnerFunctions.capitalizeWord(mealList.get(x).getName()));
                    }
                    System.out.println("or enter Exit");
                    System.out.println();
                    System.out.println();
                    System.out.println();

                    try {
                        String changePage = in.nextLine().toLowerCase();
                        if (changePage.equals("exit")) MangeRestaurant();
                        chosenMeal = Integer.parseInt(changePage) - 1;
                    } catch (NumberFormatException e) {
                        OwnerFunctions.displayError("please try again");
                        reExecute = true;
                    }
                } while (reExecute);
                if (chosenMeal >= mealList.size() || chosenMeal < 0) {
                    plural = mealList.size() > 1;
                    OwnerFunctions.displayError("you don't have more than " + mealList.size() + " meal" + (plural ? "s" : ""));
                    Edit();
                } else

                    System.out.println("   Choose which part you to edit");
                System.out.println("   1 - Meal Name");
                System.out.println("    2 - Price");
                System.out.println("     3 - Meal Description");
                System.out.println();
                System.out.println();
                System.out.println();
                chosenEditorNumber = in.nextLine();
                switch (chosenEditorNumber) {
                    case "1" -> {
                        do {
                            System.out.println("Meal Name was :" + OwnerFunctions.capitalizeWord(mealList.get(chosenMeal).getName()));
                            reExecute = MealNameMistakes();
                        } while (reExecute);
                        do {
                            updateMealInfo(mealName);
                        } while (reExecute);
                    }
                    case "2" -> {
                        do {
                            System.out.println("Meal Price was :" + mealList.get(chosenMeal).getPrice());
                            System.out.println("Please enter the following");
                            reExecute = MealPriceMistakes();
                        } while (reExecute);
                        do {
                            updateMealInfo(mealPrice);
                        } while (reExecute);
                    }
                    case "3" -> {
                        do {
                            System.out.println("Meal Description was :" + mealList.get(chosenMeal).getDescription());
                            System.out.println("Please enter the following");
                            reExecute = MealDescMistakes();
                        } while (reExecute);
                        do {
                            updateMealInfo(mealDesc);
                        } while (reExecute);
                    }

                    default -> {
                        OwnerFunctions.displayError("Only number is allowed");
                        reExecute = true;
                    }
                }
                MangeRestaurant();
            } while (reExecute);
        } else {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("  Error 404 : Not Found");
            System.out.println("  you don't have a meal in your restaurant");
            System.out.println("   please add at least a meal");
            System.out.println();
            System.out.println();
            System.out.print("  Press Enter to continue");
            System.out.println();
            System.out.println();
            in.nextLine();
            MangeRestaurant();
        }

    }

    private void Remove() throws InterruptedException {

        if (mealList.size() != 0) {
            try {
                do {
                    reExecute = false;
                    System.out.println("  Choose which meal you want to remove it. ( numbers only )");
                    for (int x = 0; x < mealList.size(); x++) {
                        System.out.println(x + 1 + " - " + OwnerFunctions.capitalizeWord(mealList.get(x).getName()));
                    }
                    System.out.println("or enter Exit");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    String changePage = in.nextLine().toLowerCase();
                    if (changePage.equals("exit")) MangeRestaurant();
                    int chosenMeal = Integer.parseInt(changePage) - 1;
                    if (chosenMeal >= mealList.size() || chosenMeal < 0) {
                        boolean plural = mealList.size() > 1;
                        OwnerFunctions.displayError("you don 't have more than " + mealList.size() + " meal" + (plural ? "s" : ""));
                        Remove();
                    } else
                        System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
                    System.out.println("" + (chosenMeal + 1) + " - | Meals |       Price |    |  Description       |");
                    System.out.print(("    | " + mealList.get(chosenMeal).getName() + "  |   "));
                    System.out.print(+mealList.get(chosenMeal).getPrice() + "  |   ");
                    System.out.println(mealList.get(chosenMeal).getDescription() + "   | ");
                    System.out.println("    ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");

                    System.out.println();
                    System.out.println();
                    do {
                        System.out.println("  Are you sure ? Y/N");
                        switch (in.nextLine().toLowerCase()) {
                            case "yes", "y" -> {
                                mealList.remove(chosenMeal);
                                MangeRestaurant();
                            }
                            case "no", "n" -> {
                                try {
                                    do {
                                        System.out.println("Go to Restaurant settings (Y) or retry removing a meal (N)");
                                        switch (in.nextLine().toLowerCase()) {
                                            case "y", "yes":
                                                MangeRestaurant();
                                            case "n", "no":
                                                Remove();
                                            default: {
                                                System.out.println();
                                                System.out.println("wrong input, please try again");
                                                System.out.println();
                                                System.out.println();
                                            }
                                        }
                                    } while (true);
                                } catch (Exception e) {
                                    System.out.println();
                                    System.out.println();
                                    System.out.println();
                                    System.out.println();
                                    MangeRestaurant();
                                }
                            }
                            default -> {
                                System.out.println();
                                System.out.println("wrong input, please try again");
                                System.out.println();
                                System.out.println();
                                reExecute1 = true;
                            }
                        }

                    } while (reExecute1);
                } while (reExecute);
            } catch (IndexOutOfBoundsException e) {
                boolean plural = mealList.size() > 1;
                OwnerFunctions.displayError("you don't have more than " + mealList.size() + " meal" + (plural ? "s" : ""));
                Remove();
            } catch (NumberFormatException no) {
                OwnerFunctions.displayError("Only number is allowed");
                Remove();
            }


        } else {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("    Error 404 : Not Found");
            System.out.println("    you don't have a meal in your restaurant");
            System.out.println("    please add at least a meal");
            System.out.println();
            System.out.println();
            System.out.print("   Press Enter to continue");
            System.out.println();
            System.out.println();
            in.nextLine();
            MangeRestaurant();

        }
    }

    private void Orders() throws InterruptedException {
        try {
            reExecute = true;
            int x = 1;
            System.out.println();
            System.out.println();
            System.out.println("restaurant : " + OwnerFunctions.capitalizeWord(restaurantName));
            for (; x <= Main.ownerList.get(MainMenu.ownerAddress).restaurants[MainMenu.RestaurantAddress].getOrders().size(); x++) {
                if (reExecute) {
                    reExecute = false;
                    System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|");
                    System.out.println("    | Order ID | Order Name|  | Quantity  |    |  Date   |        |  Additional Notes          |");
                    System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾ ");
                }
                uniqueID = (int) (Math.random() * (254645467 - 655464654 + 1) + 655464654);
                System.out.print("    |" + uniqueID + " | " + orders.get(x - 1).getMealName() + "  |   ");
                System.out.print("  " + Main.ownerList.get(MainMenu.ownerAddress).restaurants[MainMenu.RestaurantAddress].getOrders().get(x - 1).getQuantity() + "  |   ");
                System.out.print("    " + Main.ownerList.get(MainMenu.ownerAddress).restaurants[MainMenu.RestaurantAddress].getOrders().get(x - 1).getDate_Time() + "  |    ");
                System.out.println("        " + Main.ownerList.get(MainMenu.ownerAddress).restaurants[MainMenu.RestaurantAddress].getOrders().get(x - 1).getNotes() + "  |");
                System.out.println("    |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾ ");
                if (x % 3 == 0 && x != orders.size()) {
                    reExecute = true;
                    System.out.println();
                    System.out.println();
                    System.out.print("check for more orders!");
                    System.out.println();
                    System.out.println();
                    in.nextLine();
                }
            }

            System.out.println();
            System.out.println();
            if (orders.size() == 0) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("Error 404 : Not Found");
                System.out.println("you don't have any previous orders in your restaurant");
            }
            System.out.println();
            System.out.println();
            System.out.print("Press Enter to continue");
            System.out.println();
            System.out.println();
            in.nextLine();
            MangeRestaurant();
        } catch (NullPointerException Null) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("  Error 404 : Not Found");
            System.out.println("   you don't have a meal in your restaurant");
            System.out.println("   please add at least a meal");
            System.out.println();
            System.out.println();
            System.out.print("    Press Enter to continue");
            System.out.println();
            System.out.println();
            in.nextLine();
            MangeRestaurant();
        }
    }


    private boolean MealDescMistakes() {
        System.out.println();
        System.out.print("Meal Description :");
        mealDesc = in.nextLine();
        reExecute = mealDesc.length() > 160;
        if (reExecute) System.out.println("   Meal description characters can't be more than 60");
        return reExecute;
    }

    private boolean MealPriceMistakes() throws InterruptedException {
        System.out.println();
        System.out.print("Meal Price :");
        mealPrice = in.nextLine();
        try {
            reExecute = Double.parseDouble(mealPrice) > 600;
        } catch (NumberFormatException e) {
            OwnerFunctions.displayError(" price can't be anything but numbers");
            return true;
        }
        if (reExecute) System.out.println("   Meal Price can't be more than 600 ya magnoon");
        return reExecute;
    }

    private boolean MealNameMistakes() {
        System.out.println();
        System.out.println("  Please enter the following :");
        System.out.println();
        System.out.print("Meal Name : ");
        mealName = in.nextLine();
        reExecute = mealName.equals("") || mealName.length() > 50;
        if (reExecute)
            System.out.println("    Meal Name characters can't be more than 50 or be null");
        return reExecute;
    }

    private void updateMealInfo(String updateMealInfo) throws InterruptedException {
        System.out.println("   Are you sure ? Y/N");
        switch (in.nextLine().toLowerCase()) {
            case "yes", "y" -> {
                mealList.get(chosenMeal).MealSetter(updateMealInfo, chosenEditorNumber);
            }
            case "n", "no" -> {
                try {
                    do {
                        System.out.println("Go to Restaurant settings (Y) or retry editing a meal (N)");
                        switch (in.nextLine().toLowerCase()) {
                            case "y", "yes":
                                MangeRestaurant();
                            case "n", "no":
                                Edit();
                            default: {
                                System.out.println();
                                System.out.println("wrong input, please try again");
                                System.out.println();
                                System.out.println();
                            }
                        }
                    } while (true);
                } catch (Exception e) {
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    MangeRestaurant();
                }
            }
            default -> {
                System.out.println();
                System.out.println("wrong input, please try again");
                System.out.println();
                System.out.println();
                reExecute = true;
            }
        }
    }
}
