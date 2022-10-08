package Classes;

import java.util.ArrayList;

public class Customer extends Person {
    private String phoneNum;
    private String address;
    private ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Order> getOrders() {
        return orders;
    }


    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(String userName, String passWord, String phoneNum, String address) {
        super(userName, passWord);
        this.phoneNum = phoneNum;
        this.address = address;
    }
}
