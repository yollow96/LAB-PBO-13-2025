public class Book extends LibraryItem {
    private String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku " + getTitle() + " oleh " + this.author + " dengan ID " + getItemId();
    }

    @Override
    public String borrow(int days) {
        if (isBorrowed) {
            throw new IllegalArgumentException("Item sedang dipinjam dan belum dikembalikan");
        }

        if (days > 14) {
            throw new IllegalArgumentException("Maksimal peminjaman adalah 14 hari");
        }

        this.isBorrowed = true;
        return getTitle() + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }

    public String printBooks() {
        return "Buku        : " + getTitle() +
                "Author     : " + this.author +
                "ID         : " + getItemId();
    }
}
