package ATM.Notes;
public class Note<T extends Notes> {
    T[] arr= (T[])new Notes[4];
    int length=0;
    public void add(Notes notes) {
        if (length < 4) {
            arr[length] = (T) notes;
            length++;
        }
    }
    public T[] getArr() {
        return arr;
    }
}

