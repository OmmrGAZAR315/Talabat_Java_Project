package Pages;

import Main.Main;

import Classes.Customer;
import Classes.Owner;
import Classes.Person;

public interface OwnerFunctions {


    static void ifLeftTime_0() throws InterruptedException {
        if (MainMenu.leftTimes == 0) {
            System.out.println();
            System.out.println("You have failed 3 times. Please try again");
            MainMenu.firstScreen();
        }
    }

    static void spacer() {
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
    }

    static void Looper(String password, String restaurantName) throws InterruptedException {
        MainMenu.leftTimes = 3;
        do {
            MainMenu.reExecute = false;
            if (ConfirmPassword(password, restaurantName)) {
                System.out.println();
                System.out.println("Wrong Password, Remaining attempts: " + MainMenu.leftTimes + ". ");
                System.out.print(" Password : ");
                MainMenu.in.next();
                MainMenu.reExecute = true;
            }
        } while (MainMenu.reExecute);
    }

    static boolean ConfirmPassword(String password, String restaurantName) throws InterruptedException {
//Owner Password checker
        if (Main.ownerList.get(MainMenu.ownerAddress).getPassword().equals(password)) {
            Main.ownerList.get(MainMenu.ownerAddress).setRestaurantName(restaurantName);
        } else if (--MainMenu.leftTimes > 0) return true;
        else ifLeftTime_0();
        return false;
    }


    static boolean Finder(String userName, boolean thisIsCustomer) {
        if (!thisIsCustomer) {
            for (int x = 0; x < Main.ownerList.size(); x++) {
                if (Main.ownerList.get(x).getUserName().equals(userName)) {
                    MainMenu.ownerAddress = x;
                    return true;
                }
            }
        } else {

            for (int x = 0; x < Main.customerList.size(); x++) {
                if (Main.customerList.get(x).getUserName().equals(userName)) {
                    return true;
                }
            }

        }
        return false;
    }

    static void AddToList(boolean thisIsCustomer) {
        if (thisIsCustomer) {
            Main.customerList.add(new Customer(MainMenu.userName, MainMenu.password, MainMenu.mobileNum, MainMenu.address));
        } else {
            Main.ownerList.add(new Owner(MainMenu.userName, MainMenu.password));
            Main.ownerList.get(Main.ownerList.size() - 1).setRestaurantName(MainMenu.restaurantName);
        }
    }

    static String Looper(String secondStatement, int x) throws InterruptedException {
        //userName and Restaurant
        MainMenu.leftTimes = 3;
        String s;
        do {
            MainMenu.reExecute = false;
            s = MainMenu.in.nextLine().toLowerCase().trim();
            if (UserMistakes(s, secondStatement, x)) MainMenu.reExecute = true;
        } while (MainMenu.reExecute);
        return s;
    }

    static boolean UserMistakes(String s, String secondStatement, int x) throws InterruptedException {
        if (s.isEmpty()) {
            if (--MainMenu.leftTimes > 0) {
                System.out.println();
                System.out.println("This field is required, Remaining attempts: " + MainMenu.leftTimes + ". ");
                System.out.print(secondStatement);
                return true;
            } else ifLeftTime_0();
        } else if (s.length() < x) {
            if (--MainMenu.leftTimes > 0) {
                System.out.println();
                System.out.println("Minimum length is 6, Remaining attempts: " + MainMenu.leftTimes + ". ");
                System.out.print(secondStatement);
                return true;
            } else ifLeftTime_0();
        }
        return false;
    }

    static String Looper() throws InterruptedException {
        //Password
        MainMenu.leftTimes = 3;
        String s;
        do {
            MainMenu.reExecute = false;
            s = MainMenu.in.nextLine();
            if (UserMistakes(s)) MainMenu.reExecute = true;
        } while (MainMenu.reExecute);
        return s;
    }

    static boolean UserMistakes(String s) throws InterruptedException {
        //Password
        if (s.contains(" ")) {
            if (--MainMenu.leftTimes > 0) {
                System.out.println();
                System.out.println("wrong password format, Remaining attempts: " + MainMenu.leftTimes + ".");
                System.out.println("password doesn't have space");
                System.out.print("Password : ");
                return true;
            } else ifLeftTime_0();
        } else if (s.length() < 6) {
            if (--MainMenu.leftTimes > 0) {
                System.out.println();
                System.out.println("wrong password format, Remaining attempts: " + MainMenu.leftTimes + ".");
                System.out.println("Minimum length is 6");
                System.out.print("Password : ");
                return true;
            } else ifLeftTime_0();
        }
        return false;
    }

    static void Looper(String password, boolean thisIsCustomer) throws InterruptedException {
        //Confirm Password
        MainMenu.leftTimes = 3;
        do {
            MainMenu.reExecute = ConfirmPassword(password, thisIsCustomer);
        } while (MainMenu.reExecute);
    }

    static boolean ConfirmPassword(String password, Boolean thisIsCustomer) throws InterruptedException {
        //Customer password checker
        if (password.equals(MainMenu.in.nextLine())) {
            AddToList(thisIsCustomer);
        } else if (--MainMenu.leftTimes > 0) {
            System.out.println("Password isn't match, Remaining attempts: " + MainMenu.leftTimes + ".");
            System.out.print(" Confirm Password : ");
            return true;
        } else ifLeftTime_0();
        return false;
    }

    static boolean validUser(Person ShortCut) {
        return ShortCut.getPassword().equals(MainMenu.password) && ShortCut.getUserName().equals(MainMenu.userName);
    }

    static void displayError(String str) {
        System.out.println();
        System.out.println();
        System.out.println("Invalid input, " + str);
        System.out.println();
        System.out.println();
        System.out.println();
    }


    public static String capitalizeWord(String str) throws InterruptedException {
        String capitalizeWord = "";
        try {
            String[] words = str.split("\\s");
            for (String w : words) {
                String first = w.substring(0, 1);
                String afterFirst = w.substring(1);
                capitalizeWord += first.toUpperCase() + afterFirst + " ";
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Meal Name is not found, please try again");
            System.out.println();
            System.out.println();
            System.out.println();
            Main.ownerList.get(MainMenu.ownerAddress).restaurants[MainMenu.RestaurantAddress].MangeRestaurant();
        }
        return capitalizeWord.trim();
    }
}

