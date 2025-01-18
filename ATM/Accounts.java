package ATM;

import java.util.ArrayList;

public class Accounts {
    private String userId;//declares a userId variable where the variable is common for both admin and user
    private String pin;//declares a pin variable where the variable is common for both admin and user
    private ArrayList<Transactions> transactions=new ArrayList<>();//arraylist for transaction which is common for both admin and user
    public Accounts(String userId,String pin){//constructor
        this.userId=userId;
        this.pin=pin;
    }
//getter and setter methods
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }
}
