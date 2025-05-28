import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Library {
    protected ArrayList<LibraryItem> items = new ArrayList<>();
    protected ArrayList<Member> members = new ArrayList<>();
    protected LibraryLogger logger = LibraryLogger.getInstance();
    Scanner input = new Scanner(System.in);

    public String addItem(LibraryItem item) {

        try {
            findItemById(item.getItemId());
            return "Gagal menambahkan ID " + item.getItemId() + " sudah digunakan";
        } catch (NoSuchElementException e) {

        }
        
        String jenis = "";
        if (item instanceof Book) {
            jenis = "buku";
        } else if (item instanceof DVD) {
            jenis = "DVD";
        } else {
            jenis = "item";
        }
        
        items.add(item);
        logger.logActivity(jenis + " " + item.getTitle() + " ditambahkan");
        return "Item berhasil ditambahkan";
    }
    
    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        throw new NoSuchElementException("Item tidak ditemukan");
    }

    public void getLibraryStatus() {
        System.out.println("+------------+----------------------+-------------+");
        System.out.println("|  ID Item   |        Judul         |   Status    |");
        System.out.println("+------------+----------------------+-------------+");
        for (LibraryItem item : items) {
            String status;
            if (item.getIsBorrowed()) {
                status = "Dipinjam";
            } else {
                status = "Tersedia";
            }
            System.out.printf("| %-10s | %-20s | %-11s |\n",
                    item.getItemId(),
                    item.getTitle(),
                    status);
        }
        System.out.println("+------------+----------------------+-------------+");
    }

    public String addMember(Member member) {
        members.add(member);
        logger.logActivity("Anggota " + member.getName() + " ditambahkan");
        return "Anggota " + member.getName() + " berhasil ditambahkan.";
    }

    public Member findMemberById(int id) throws Exception {
        for (Member m : members) {
            if (m.getMemberId() == id) {
                return m;
            }
        }
        throw new Exception("Member tidak ditemukan");
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}
