package Classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private final String notes;
    private final String mealName;
    private final int quantity;


    private final String Date_Time;


    public Order(String mealName, int quantity, String notes) {
        this.mealName = mealName;
        this.quantity = quantity;
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        Date_Time = myDateObj.format(myFormatObj);
        this.notes = notes;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate_Time() {
        return Date_Time;
    }

    public String getNotes() {
        return notes;
    }

    public String getMealName() {
        return mealName;
    }


}
