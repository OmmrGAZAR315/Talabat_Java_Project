package Pages;

import Classes.*;

import java.util.ArrayList;

import Main.Main;

import static Pages.MainMenu.*;


public interface OwnerStaticData {
    public static ArrayList<Owner> OwnerInfo() {
        ArrayList<Owner> ownerList = new ArrayList<>();
        ownerList.add(new Owner("Fouad Sawiris", "kinge9e0@"));//0
        ownerList.add(new Owner("ibrahim mahmoud", "GreenBBurger"));//1
        ownerList.add(new Owner("Yassin Mansour", "Mcfdds78"));//2
        ownerList.get(0).setRestaurantName("Burger King");
        ownerList.get(0).setRestaurantName("McDonald's");
        ownerList.get(1).setRestaurantName("Fish for free");
        ownerList.get(1).setRestaurantName("Koshary Sayed Hanafy");
        ownerList.get(2).setRestaurantName("3m Ahmed");
        ownerList.get(2).setRestaurantName("Pizza el Falah");
        return ownerList;
    }


    public static ArrayList<Meal> getRestaurantMeals(String restaurantName) {
        ArrayList<Meal> PizzaelFalah = new ArrayList<>();
        PizzaelFalah.add(new Meal("Big Tasty", 90, "Big tasty is good"));//0
        PizzaelFalah.add(new Meal("Big Mac", 60, "Big Mac is bad"));//1
        PizzaelFalah.add(new Meal("Cheese Burger", 25, "Big Mac is bad"));//2
        PizzaelFalah.add(new Meal("Chicken MacDo", 21, "Chicken MacDo is nono"));//3
        PizzaelFalah.add(new Meal("Chicken Fillet", 65, "Pane fille omk a7la"));//4
        PizzaelFalah.add(new Meal("Carmel sundae", 65, "El 23zmmmm"));//5
        ArrayList<Meal> Fish_for_free = new ArrayList<>();
        Fish_for_free.add(new Meal("Big Star", 90, "best koshary"));//0
        Fish_for_free.add(new Meal("kosharry", 60, "bbbbb"));//1
        Fish_for_free.add(new Meal("salsa", 25, "vvdsv"));//2
        Fish_for_free.add(new Meal("om ali", 21, "vsdfvds"));//3
        Fish_for_free.add(new Meal("tagen pasta", 65, "dsvsdvsdv"));//4
        Fish_for_free.add(new Meal("roz bel dairy", 65, "23z mmmm"));//5
        ArrayList<Meal> BurgerKing = new ArrayList<>();
        BurgerKing.add(new Meal("famous", 90, "vsdvdsvd"));//0
        BurgerKing.add(new Meal("nta famous", 60, "svdsvdsv"));//1
        BurgerKing.add(new Meal("mashhoor", 25, "sdvsdvdsv"));//2
        BurgerKing.add(new Meal("sandwich 8aly", 21, "grwergergtr"));//3
        BurgerKing.add(new Meal("small sandwich bs 8aly bardo", 65, "sdvgerhtrnt"));//4
        BurgerKing.add(new Meal("heta gato men el forn", 65, "svrberberb"));//5
        ArrayList<Meal> McDonaldMeals = new ArrayList<>();
        McDonaldMeals.add(new Meal("Big Tasty", 90, "Big tasty is good"));//0
        McDonaldMeals.add(new Meal("Big Mac", 60, "Big Mac is bad"));//1
        McDonaldMeals.add(new Meal("Cheese Burger", 25, "Big Mac is bad"));//2
        McDonaldMeals.add(new Meal("Chicken MacDo", 21, "Chicken MacDo is nono"));//3
        McDonaldMeals.add(new Meal("Chicken Fillet", 65, "Pane fille omk a7la"));//4
        McDonaldMeals.add(new Meal("Carmel sundae", 65, "El 23zmmmm"));//5
        ArrayList<Meal> kosharayHanfy = new ArrayList<>();
        kosharayHanfy.add(new Meal("Big Star", 90, "best koshary"));//0
        kosharayHanfy.add(new Meal("kosharry", 60, "bbbbb"));//1
        kosharayHanfy.add(new Meal("salsa", 25, "vvdsv"));//2
        kosharayHanfy.add(new Meal("om ali", 21, "vsdfvds"));//3
        kosharayHanfy.add(new Meal("tagen pasta", 65, "dsvsdvsdv"));//4
        kosharayHanfy.add(new Meal("roz bel dairy", 65, "23z mmmm"));//5
        ArrayList<Meal> am_Ahmed = new ArrayList<>();
        am_Ahmed.add(new Meal("famous", 90, "vsdvdsvd"));//0
        am_Ahmed.add(new Meal("nta famous", 60, "svdsvdsv"));//1
        am_Ahmed.add(new Meal("mashhoor", 25, "sdvsdvdsv"));//2
        am_Ahmed.add(new Meal("sandwich 8aly", 21, "grwergergtr"));//3
        am_Ahmed.add(new Meal("small sandwich bs 8aly bardo", 65, "sdvgerhtrnt"));//4
        am_Ahmed.add(new Meal("heta gato men el forn", 65, "svrberberb"));//5
        switch (restaurantName) {
            case "mcdonald's" -> {
                return McDonaldMeals;
            }
            case "koshary sayed hanafy" -> {
                return kosharayHanfy;
            }
            case "burger king" -> {
                return BurgerKing;
            }
            case "fish for free" -> {
                return Fish_for_free;
            }
            case "3m ahmed" -> {
                return am_Ahmed;
            }
            case "pizza el falah" -> {
                return PizzaelFalah;
            }
        }
        return new ArrayList<>();
    }

    static void callingMangeRestaurant()  {
        for (int i = 0; i < Main.ownerList.size(); i++) {
            Owner ownerShortCut = Main.ownerList.get(i);
            ownerShortCut.restaurants = new Restaurant[ownerShortCut.getRestaurantName().size()];
            for (int k = 0; k < ownerShortCut.restaurants.length; k++) {
                ownerShortCut.restaurants[k] = new Restaurant();
                Restaurant restaurantShortCut = ownerShortCut.restaurants[k];
                restaurantShortCut.setRestaurantName(Main.ownerList.get(i).getRestaurantName().get(k));
                restaurantShortCut.setMealList(OwnerStaticData.getRestaurantMeals(restaurantShortCut.getRestaurantName()));
            }
        }
        OwnerStaticData.implementingData();

    }

    static void implementingData() {
        for (int x = 0; x < Main.ownerList.size(); x++) {
            Owner ownerShortCut = Main.ownerList.get(x);
            for (int y = 0; y < ownerShortCut.restaurants.length; y++) {
                Restaurant restaurantShortCut = ownerShortCut.restaurants[y];
                try {
                    restaurantShortCut.getOrders().add(new Order(restaurantShortCut.getMealList().get(5).getName(), 56, "this zero"));//customerMealIndex is required
                    restaurantShortCut.getOrders().add(new Order(restaurantShortCut.getMealList().get(1).getName(), 7, "this one"));
                    restaurantShortCut.getOrders().add(new Order(restaurantShortCut.getMealList().get(4).getName(), 23, "this two"));
                    restaurantShortCut.getOrders().add(new Order(restaurantShortCut.getMealList().get(0).getName(), 45, "this three"));
                    restaurantShortCut.getOrders().add(new Order(restaurantShortCut.getMealList().get(3).getName(), 576, "this four"));
                    restaurantShortCut.getOrders().add(new Order(restaurantShortCut.getMealList().get(1).getName(), 4, "this five"));
                    //            if (mealName != null && mealQuantity != 0) {
//                restaurantShortCut.getOrders().add(new Order(mealName, mealQuantity, mealNotes));
//            }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("TOTOTO");
                }
            }
        }


    }
}
