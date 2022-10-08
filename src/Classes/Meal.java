package Classes;

public class Meal {
    private String name;
    private double price;
    private String description;

    public Meal(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void MealSetter(String str, String x) {
        switch (x) {
            case "1" -> this.name = str;
            case "2" -> this.price = Double.parseDouble(str);
            case "3" -> this.description = str;

        }
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
