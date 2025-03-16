import java.util.Scanner;

public class TP1_3_H071241004 {
    
    public static void main(String[] args) {

        String[] bulan = {
        "Januari", "Februari", "Maret", "April", "Mei", "Juni",
        "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan tanggal dalam format dd-mm-yy: ");
        String tanggalInput = scanner.nextLine();

        String[] pemisah = tanggalInput.split("-");

        int dd = Integer.parseInt(pemisah[0]);
        int mm = Integer.parseInt(pemisah[1]);
        int yy = Integer.parseInt(pemisah[2]);

        if (yy < 100) {
            yy += 2000;
        }

        if (mm > 12 | dd > 31) {
            System.out.println("Inputan yang anda masukkan salah");
        }
        else {
            String namaBulan = bulan[mm - 1];
            String hasilKonversi = dd + " " + namaBulan + " " + yy;
            System.out.println(hasilKonversi);
        }

        scanner.close();

    }
}
