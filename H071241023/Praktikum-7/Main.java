import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Library pustaka = new Library();
    static Scanner input = new Scanner(System.in);
    static ArrayList<LibraryItem> items = new ArrayList<>();
    static ArrayList<Member> daftarAnggota = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih opsi: ");
            String inputMenu = input.nextLine().trim();

            if (inputMenu.isEmpty()) {
                System.out.println("Input tidak boleh kosong.\n");
                continue;
            }

            int pilihan;
            try {
                pilihan = Integer.parseInt(inputMenu);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka\n");
                continue;
            }

            if (pilihan < 1 || pilihan > 8) {
                System.out.println("Pilihan menu tidak tersedia. Silakan pilih antara 1 sampai 8\n");
                continue;
            }
            try {
                switch (pilihan) {
                    case 1:
                        tambahItem(pustaka);
                        break;
                    case 2:
                        tambahAnggota();
                        break;
                    case 3:
                        pinjamItem();
                        break;
                    case 4:
                        kembalikanItem();
                        break;
                    case 5:
                        pustaka.getLibraryStatus();
                        break;
                    case 6:
                        System.out.println(pustaka.getLogger().getLogs());
                        break;
                    case 7:
                        lihatItemAnggota();
                        break;
                    case 8:
                        System.out.println("Terima Kasih!\n");
                        return;
                    default:
                        System.out.println("Opsi tidak tersedia!\n");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void tambahItem(Library pustaka) {
        String pilihan;
        do {
            System.out.print("Jenis item(1: Buku, 2: DVD): ");
            pilihan = input.nextLine().trim();

            if (pilihan.isEmpty()) {
                System.out.println("Input tidak boleh kosong! Silakan masukkan 1 atau 2.\n");
                continue;
            }
            if (!pilihan.equals("1") && !pilihan.equals("2")) {
                System.out.println("Input salah! Masukkan angka hanya antara 1 atau 2.\n");
                continue;
            }
            break;
        } while (true);

        String title;
        do {
            System.out.print("Judul: ");
            title = input.nextLine().trim();

            if (title.isEmpty()) {
                System.out.println("Input judul tidak boleh kosong!\n");
                continue;
            }
            break;
        } while (true);

        int id = 0;
        while (true) {
            System.out.print("ID item: ");
            String idInput = input.nextLine().trim();

            if (idInput.isEmpty()) {
                System.out.println("Input tidak boleh kosong!\n");
                continue;
            }

            try {
                id = Integer.parseInt(idInput);
                if (id <= 0) {
                    System.out.println("Masukkan angka positif!\n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Harus berupa angka\n");
            }
        }
        if (pilihan.equals("1")) {
            String author;
            do {
                System.out.print("Penulis: ");
                author = input.nextLine().trim();

                if (author.isEmpty()) {
                    System.out.println("Penulis tidak boleh kosong!\n");
                    continue;
                }
                break;
            } while (true);

            LibraryItem item = new Book(title, id, author);
            System.out.println(pustaka.addItem(item));
        } else {
            int durasi = 0;
            while (true) {
                System.out.print("Durasi: ");
                String durasiInput = input.nextLine().trim();

                if (durasiInput.isEmpty()) {
                    System.out.println("Input tidak boleh kosong!\n");
                    continue;
                }
                try {
                    durasi = Integer.parseInt(durasiInput);
                    if (durasi <= 0) {
                        System.out.println("Durasi harus berupa angka positif!\n");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Input tidak valid! Durasi harus angka\n");
                }
            }
            LibraryItem item = new DVD(title, id, durasi);
            System.out.println(pustaka.addItem(item));
        }
    }

    private static void tambahAnggota() {
        String name;
        int memberId;

        do {
            System.out.print("Nama Anggota: ");
            name = input.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Input tidak boleh kosong! Silahkan masukkan nama dengan benar!\n");
                continue;
            }
            break;
        } while (true);

        memberId = 0;
        while (true) {
            System.out.print("ID Anggota: ");
            String idInput = input.nextLine().trim();

            if (idInput.isEmpty()) {
                System.out.println("Input tidak boleh kosong\n");
                continue;
            }
            try {
                memberId = Integer.parseInt(idInput);
                if (memberId <= 0) {
                    System.out.println("Masukkan angka positif!\n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Harus berupa angka\n");
            }
        }
        Member member = new Member(name, memberId);
        pustaka.addMember(member);
    }

    private static void pinjamItem() {
        int idAnggota;
        int idItem;
        int hari;
        
        idAnggota = 0;
        while (true) {
            System.out.print("ID Anggota: ");
            String idAnggotaInput = input.nextLine().trim();

            if (idAnggotaInput.isEmpty()) {
                System.out.println("Input tidak boleh kosong!\n");
                continue;
            }

            try {
                idAnggota = Integer.parseInt(idAnggotaInput);
                if (idAnggota <= 0) {
                    System.out.println("Masukkan angka positif!\n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka positif!\n");
            }
        }

        idItem = 0;
        while (true) {
            System.out.print("ID Item: ");
            String idItemInput = input.nextLine().trim();

            if (idItemInput.isEmpty()) {
                System.out.println("Input tidak boleh kosong!\n");
                continue;
            }

            try {
                idItem = Integer.parseInt(idItemInput);
                if (idItem <= 0) {
                    System.out.println("Masukkan angka positif!\n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka positif!\n");
            }
        }

        hari = 0;
        while (true) {
            System.out.print("Jumlah hari: ");
            String hariInput = input.nextLine().trim();

            if (hariInput.isEmpty()) {
                System.out.println("Input tidak boleh kosong!\n");
                continue;
            }

            try {
                hari = Integer.parseInt(hariInput);
                if (hari <= 0) {
                    System.out.println("Masukkan angka positif!\n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka positif!\n");
            }
        }

        try {
            Member member = pustaka.findMemberById(idAnggota);
            LibraryItem item = pustaka.findItemById(idItem);
            String result = member.borrow(item, hari);
            pustaka.getLogger().logActivity(item.getDescription() + " dipinjam oleh " + member.getName());
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Gagal meminjam: " + e.getMessage() + "\n");
        }
    }

    private static void kembalikanItem() throws Exception {
        int idAnggota;
        int idItem;
        int telat;
        
        while (true) {
            System.out.print("ID Anggota: ");
            String idAnggotaInput = input.nextLine().trim();

            if (idAnggotaInput.isEmpty()) {
                System.out.println("Input tidak boleh kosong!\n");
                continue;
            }

            try {
                idAnggota = Integer.parseInt(idAnggotaInput);
                if (idAnggota <= 0) {
                    System.out.println("Masukkan angka positif!\n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka positif!\n");
            }
        }

        Member member = pustaka.findMemberById(idAnggota);
        if (member == null) {
            System.out.println("Member tidak ditemukan\n");
            return;
        }

        if (member.getBorrowedItems().isEmpty()) {
            System.out.println("Member belum meminjam item apapun.\n");
            return;
        }
        
        while (true) {
            System.out.print("ID Item: ");
            String idItemInput = input.nextLine().trim();

            if (idItemInput.isEmpty()) {
                System.out.println("Input tidak boleh kosong!\n");
                continue;
            }

            try {
                idItem = Integer.parseInt(idItemInput);
                if (idItem <= 0) {
                    System.out.println("Masukkan angka positif!\n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka positif!\n");
            }
        }

        telat = 0;
        while (true) {
            System.out.print("Jumlah hari keterlambatan: ");
            String telatInput = input.nextLine().trim();

            if (telatInput.isEmpty()) {
                System.out.println("Input tidak boleh kosong!\n");
                continue;
            }

            try {
                telat = Integer.parseInt(telatInput);
                if (telat < 0) {
                    System.out.println("Masukkan angka positif!\n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka positif!\n");
            }
        }

        
        try {
            LibraryItem item = pustaka.findItemById(idItem);
            if (!member.getBorrowedItems().contains(item)) {
                System.out.println("Item ini tidak sedang dipinjam oleh anggota tersebut.\n");
                return;
            }

            String result = member.returnItem(item, telat);
            pustaka.getLogger().logActivity(item.getDescription() + " dikembalikan oleh " + member.getName());
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Gagal mengembalikan: " + e.getMessage() + "\n");
        }
    }

    private static void lihatItemAnggota() {
        int id;
        id = 0;
        while (true) {
            System.out.print("ID Anggota: ");
            String idInput = input.nextLine().trim();

            if (idInput.isEmpty()) {
                System.out.println("Input tidak boleh kosong!\n");
                continue;
            }

            try {
                id = Integer.parseInt(idInput);
                if (id <= 0) {
                    System.out.println("Masukkan angka positif!\n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka positif!\n");
            }
        }

        try {
            Member member = pustaka.findMemberById(id);
            ArrayList<LibraryItem> items = member.getBorrowedItems();
            if (items.isEmpty()) {
                System.out.println("Anggota belum meminjam item apapun\n");
            } else {
                System.out.println("Item sedang dipinjam oleh " + member.getName());
                for (LibraryItem item : items) {
                    System.out.println("- " + item.getDescription());
                }
            }
        } catch (Exception e) {
            System.out.println("Anggota tidak ditemukan.\n");
        }
    }
}
