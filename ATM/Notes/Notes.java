package ATM.Notes;
public class Notes {
    private String note;
    private long count;
    public Notes(String note,long count){
        this.note=note;
        this.count=count;
    }
    public void setCount(long count) {
        this.count = count;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getNote() {
        return note;
    }

    public long getCount() {
        return count;
    }
}
