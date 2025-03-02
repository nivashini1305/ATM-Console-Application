package ATM.Interfaces;

import ATM.Accounts;

public interface Actions {
      public  Accounts login();
      public void depositMoney(Accounts currentAccount);
}
