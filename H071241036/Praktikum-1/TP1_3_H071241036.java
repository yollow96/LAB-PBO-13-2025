import java.text.ParseException; // ini untuk memberitahukan error ketika terjadi kegagalan dalam parsing
import java.text.SimpleDateFormat; // untuk mengubah string menjadi Date
import java.util.Date; // untuk menggunakan format date
import java.util.Locale; // untuk menggunakan format yang dipake di suatu negara
import java.util.Scanner; 

public class Nomor3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan tanggal (dd-MM-yy): ");
        String inputTanggal = scanner.nextLine();
        scanner.close();
        
        String outputTanggal = konversiTanggal(inputTanggal);
        System.out.println("Hasil konversi: " + outputTanggal);
    }

    public static String konversiTanggal(String tanggal) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yy");
            Date date = inputFormat.parse(tanggal);

            SimpleDateFormat outputFormat = new SimpleDateFormat("d MMMM yyyy", new Locale("id", "ID"));
            return outputFormat.format(date);
        } catch (ParseException e) {
            return "Format tanggal tidak valid";
        }
    }
}
