import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Member {
    private String name;
    private int memberId;
    private ArrayList<LibraryItem> borrowedItem = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String borrow(LibraryItem item, int days) {
        if (item.getIsBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia (sudah dipinjam)");
        }

        item.borrow(days);
        borrowedItem.add(item);
        return "item " + item.getTitle() + " berhasil dipinjam selama " + days + " hari";
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItem.contains(item)) {
            return "Item " + item.getTitle() + " tidak sedang dipinjam, jadi tidak bisa dikemballikan";
        }

        item.returnItem();
        borrowedItem.remove(item);

        double totalDenda = item.calculateFine(daysLate);
        return "item " + item.getTitle() + " berhasil dikembalikan dengan denda " + 
                totalDenda;
    }

    public ArrayList<LibraryItem> getBorrowedItems() {

        System.out.println("+------------+----------------------+");
        System.out.println("|     ID     |        Judul         |");
        System.out.println("+------------+----------------------+");

        for (LibraryItem item : borrowedItem) {
            System.out.printf("| %-10d | %-20s |\n", item.getItemId(), item.getTitle());
        }
        System.out.println("+------------+----------------------+");

        return borrowedItem;
    }
}


