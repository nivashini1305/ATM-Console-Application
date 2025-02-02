package ATM;

public class Transactions {
    private String name;
    private String transaction;
    private long balance;
    public Transactions(String name,String transaction,long balance){
        this.name=name;
        this.transaction=transaction;
        this.balance=balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }
    public long getBalance() {
        return balance;
    }
    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
