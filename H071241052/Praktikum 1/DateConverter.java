import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DateConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String input = scanner.nextLine();
        scanner.close();

        String[] parts = input.split("-");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        // Konversi tahun ke format 4 digit
        year += (year >= 0 && year <= 50) ? 2000 : 1900;
        
        // Daftar nama bulan dalam bahasa Indonesia
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

        // Cetak hasil konversi
        if (bulanMap.containsKey(month)) {
            System.out.println(day + " " + bulanMap.get(month) + " " + year);
        } else {
            System.out.println("Bulan tidak valid!");
        }
    }
}
