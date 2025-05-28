import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private static LibraryLogger instance;
    private List<String> logs = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static LibraryLogger getInstance() {
        if (instance == null) {
            instance = new LibraryLogger();
        }
        return instance;
    }

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(formatter);
        String entry = timestamp + " " + activity;
        logs.add(entry);
        return entry;
    }

    private String getTimestamp() {
        return LocalDateTime.now().format(formatter);
    }

    private void addLog(String message) {
        logs.add(getTimestamp() + " " + message);
    }

    public void logAddItem(LibraryItem item) {
        String jenis;
        if (item instanceof Book) {
            jenis = "Buku";
        } else {
            jenis = "DVD";
        }
        addLog(jenis + " " + item.getTitle() + " ditambahkan");
    }

    public void logAddMember(Member member) {
        addLog("anggota " + member.getName() + " ditambahkan");
    }

    public void logBorrow(LibraryItem item, Member member) {
        String jenis;
        if (item instanceof Book) {
            jenis = "buku";
        } else {
            jenis = "DVD";
        }
        addLog(jenis + " " + item.getTitle() + " dipinjam oleh " + member.getName());
    }

    public void logReturn(LibraryItem item, Member member) {
        String jenis;
        if (item instanceof Book) {
            jenis = "buku";
        } else {
            jenis = "DVD";
        }
        addLog(jenis + " " + item.getTitle() + " dikembalikan oleh " + member.getName());
    }

    public String getLogs() {
    if (logs.isEmpty()) {
        return "Belum ada aktivitas.";
    } else {
        return String.join("\n", logs);
    }
}

    public void clearLogs() {
        logs.clear();
    }
}
