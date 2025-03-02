package ATM.Interfaces;
import ATM.Notes.Notes;
import ATM.User;
import java.util.ArrayList;


public interface UserActionInterface extends Actions {
   public void withDrawAmount(User currentUser) throws CloneNotSupportedException;
   public long performWithdraw(long withDrawAmount, Notes notes, ArrayList<String> showNoteCount);
   public void viewBalance(User currentUser);
   public void changePin(User currentUser);
   public void viewTransaction(User currentUser);
}
