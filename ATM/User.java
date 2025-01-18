package ATM;

import java.util.ArrayList;

public class User extends Accounts {
    private long balance;//declares a balance variable
    public User(String userId,String pin,long balance){//defines a constructor
        super(userId,pin);
        this.balance=balance;
    }
//getter and setter method
    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }
}
