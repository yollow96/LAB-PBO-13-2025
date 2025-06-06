public class DVD extends LibraryItem{
    int duration;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "DVD " + getTitle() + "dengan ID " + getItemId() + " ber-durasi " + this.duration;
    }

    @Override
    public String borrow(int days) {
        if (isBorrowed) {
            throw new IllegalArgumentException("Item sedang dipinjam dan belum dikembalikan");
        }
        if (days > 7 ) {
            throw new IllegalArgumentException("Maksimal peminjaman adalah 7 hari");
        }
        this.isBorrowed = true;
        return getTitle() + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000;
    }
}
