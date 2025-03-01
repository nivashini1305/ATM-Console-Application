package ATM;

import java.util.ArrayList;

public class Transactions {
    private static ArrayList<Transactions> transactions=new ArrayList<>();//arraylist for transaction
    private String typeOfTransaction;//declares string variable for the transaction(either deposit or withdraw)
    private long balanceAmount;//declares a variable for balance
    private String name;
    public Transactions(String typeOfTransaction,long balanceAmount,String name){//constructor for transaction
        this.typeOfTransaction=typeOfTransaction;
        this.balanceAmount=balanceAmount;
        this.name=name;
    }
//getter and setter method
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Transactions> getTransactions() {//getter method for transaction
        return transactions;
    }
    public void setBalance(long balance) {//setter method for balance
        this.balanceAmount = balance;
    }
    public long getBalanceAmount(){//getter method for balance
        return balanceAmount;
    }
    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }
    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }
}
