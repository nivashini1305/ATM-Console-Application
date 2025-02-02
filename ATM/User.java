package ATM;

import java.util.ArrayList;

public class User {
    private String userId;
    private String userPin;
    private  long balance;
    public  ArrayList<Transactions> transactions = new ArrayList<>();
    public User(String userId,String userPin){
        this.userId=userId;
        this.userPin=userPin;

    }
    public void setUserId(String userId){
        this.userId=userId;
    }
    public String getUserId(){
       return  userId;
    }
    public  void setUserPin(String userPin){
        this.userPin=userPin;
    }
    public String getUserPin(){
        return userPin;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public  ArrayList<Transactions> getTransactions() {
        return transactions;
    }
}
