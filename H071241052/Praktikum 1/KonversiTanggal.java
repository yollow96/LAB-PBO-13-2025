import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KonversiTanggal {
    public static void main(String[] args) {
        // HashMap untuk menyimpan jumlah hari dalam setiap bulan
        Map<Integer, Integer> hariPerBulan = new HashMap<>();
        hariPerBulan.put(1, 31);  // Januari
        hariPerBulan.put(2, 28);  // Februari (default, nanti cek tahun kabisat)
        hariPerBulan.put(3, 31);  // Maret
        hariPerBulan.put(4, 30);  // April
        hariPerBulan.put(5, 31);  // Mei
        hariPerBulan.put(6, 30);  // Juni
        hariPerBulan.put(7, 31);  // Juli
        hariPerBulan.put(8, 31);  // Agustus
        hariPerBulan.put(9, 30);  // September
        hariPerBulan.put(10, 31); // Oktober
        hariPerBulan.put(11, 30); // November
        hariPerBulan.put(12, 31); // Desember

        // HashMap untuk mengonversi nomor bulan menjadi nama bulan
        Map<Integer, String> bulanMap = new HashMap<>();
        bulanMap.put(1, "Januari");
        bulanMap.put(2, "Februari");
        bulanMap.put(3, "Maret");
        bulanMap.put(4, "April");
        bulanMap.put(5, "Mei");
        bulanMap.put(6, "Juni");
        bulanMap.put(7, "Juli");
        bulanMap.put(8, "Agustus");
        bulanMap.put(9, "September");
        bulanMap.put(10, "Oktober");
        bulanMap.put(11, "November");
        bulanMap.put(12, "Desember");

        // Input dari pengguna
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String input = scanner.nextLine();
        scanner.close();

        // Memisahkan input berdasarkan "-"
        String[] parts = input.split("-");
        if (parts.length != 3) {
            System.out.println("Format tanggal tidak valid!");
            return;
        }

        // Konversi ke integer
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        // Menyesuaikan format tahun
        year += (year >= 0 && year <= 50) ? 2000 : 1900;

        // Cek apakah bulan valid (1-12)
        if (!bulanMap.containsKey(month)) {
            System.out.println("Bulan tidak valid!");
            return;
        }

        // Cek tahun kabisat untuk Februari
        if (month == 2 && isLeapYear(year)) {
            hariPerBulan.put(2, 29);
        }

        // Cek apakah tanggal valid
        if (day < 1 || day > hariPerBulan.get(month)) {
            System.out.println("Tanggal tidak valid untuk bulan " + bulanMap.get(month) + " " + year);
            return;
        }

        // Menampilkan hasil
        System.out.println(day + " " + bulanMap.get(month) + " " + year);
    }

    // Fungsi untuk mengecek apakah tahun adalah tahun kabisat
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
