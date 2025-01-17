package ATM;

import java.util.ArrayList;

public class Transactions {
    private static ArrayList<Transactions> transactions=new ArrayList<>();//arraylist for transaction
    private String typeOfTransaction;//declares string variable for the transaction(either deposit or withdraw)
    private long balance;//declares a variable for balance
    public Transactions(String typeOfTransaction,long balance){//constructor for transaction
        this.typeOfTransaction=typeOfTransaction;
        this.balance=balance;
    }

    public static ArrayList<Transactions> getTransactions() {//getter method for transaction
        return transactions;
    }
    public void setBalance(long balance) {//setter method for balance
        this.balance = balance;
    }
    public long getBalance(){//getter method for balance
        return balance;
    }
    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }
    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }
}
