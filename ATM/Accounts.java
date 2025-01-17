package ATM;

import java.util.ArrayList;

public class Accounts {
    private String userId;
    private String pin;
    private ArrayList<Transactions> transactions=new ArrayList<>();
    public Accounts(String userId,String pin){
        this.userId=userId;
        this.pin=pin;
    }

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
