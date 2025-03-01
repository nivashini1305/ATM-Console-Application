package ATM.Notes;

public abstract class Notes implements Cloneable{
    private String note;//declares a variable for note
    private long count;//declares avariable for note count
    protected Notes(String note,long count){//constructor for notes
        this.note=note;
        this.count=count;
    }
// getter and setter methods for note count
    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
