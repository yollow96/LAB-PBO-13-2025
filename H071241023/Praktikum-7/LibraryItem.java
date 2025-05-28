public abstract class LibraryItem {
    private String title;
    private int itemId;
    protected boolean isBorrowed;
    
    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public int getItemId() {
        return itemId;
    }

    public boolean getIsBorrowed() {
        return isBorrowed;
    }
    
    public String returnItem() {
        this.isBorrowed = false;
        return title + " dikembalikan";
    }

    public abstract String getDescription();

    public abstract String borrow(int days);

    public abstract double calculateFine(int daysLate);
}