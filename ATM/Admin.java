package ATM;

import java.util.ArrayList;

public class Admin {
        private String adminName;
        private String adminPin;
        public  ArrayList<Transactions> transactions = new ArrayList<>();
        public Admin(String adminName,String adminPin){
            this.adminName = adminName;
            this.adminPin = adminPin;
        }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public void setAdminPin(String adminPin) {
        this.adminPin = adminPin;
    }
    public String getAdminName(){
            return this.adminName;
    }
    public String getAdminPin(){
            return adminPin;
    }
    public  ArrayList<Transactions> getAdminTransactions(){
            return transactions;
}
}
