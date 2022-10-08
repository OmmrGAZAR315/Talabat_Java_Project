package Classes;

import java.util.ArrayList;

import Pages.MainMenu;
import Pages.Restaurant;

public class Owner extends Person {
    private final ArrayList<String> restaurantName = new ArrayList<>();
    public Restaurant[] restaurants;

    public Owner(String userName, String passWord) {
        super(userName, passWord);
    }

    public ArrayList<String> getRestaurantName() {
        return restaurantName;
    }

    public boolean getRestaurantName(String comparable) {
        for (int RestaurantAddress = 0; RestaurantAddress < restaurantName.size(); RestaurantAddress++) {
            if (restaurantName.get(RestaurantAddress).equals(comparable)) {
                MainMenu.RestaurantAddress = RestaurantAddress;
                return true;
            }
        }
        return false;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName.add(restaurantName.toLowerCase());
    }
}
