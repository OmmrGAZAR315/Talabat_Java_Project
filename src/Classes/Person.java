package Classes;

import java.util.ArrayList;

abstract public class Person {
    private final String userName;
    private final String passWord;

    public Person(String userName, String passWord) {
        this.userName = userName.toLowerCase();
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return passWord;
    }
}
