import java.util.Scanner;

public class No3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bulan = {
                "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        try {
            System.out.print("Masukkan tanggal (dd-mm-yy): ");
            String tanggal = scanner.nextLine();
            String[] splitTanggal = tanggal.split("-");

            if (splitTanggal.length != 3) {
                throw new IllegalArgumentException("Format tanggal harus dd-mm-yy.");
            }

            int nomorTanggal = Integer.parseInt(splitTanggal[0]);
            int nomorBulan = Integer.parseInt(splitTanggal[1]);
            int nomorTahun = Integer.parseInt(splitTanggal[2]);

            if (nomorTahun < 0 || nomorTahun > 99) {
                throw new IllegalArgumentException("Tahun tidak valid! Tahun harus antara 00 dan 99.");
            }

            int tahunLengkap = (nomorTahun < 50) ? 2000 + nomorTahun : 1900 + nomorTahun;

            if (nomorBulan < 1 || nomorBulan > 12) {
                throw new IllegalArgumentException("Bulan tidak valid!");
            }

            boolean tanggalValid = cekTanggal(nomorBulan, tahunLengkap, nomorTanggal, bulan[nomorBulan - 1]);

            if (!tanggalValid) {
                throw new IllegalArgumentException("Tanggal tidak valid!");
            }

            System.out.println(nomorTanggal + " " + bulan[nomorBulan - 1] + " " + tahunLengkap);

        } catch (NumberFormatException e) {
            System.err.println("Error: Format angka tidak valid. Pastikan hanya memasukkan angka.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static boolean cekTanggal(int bulan, int tahun, int tanggal, String namaBulan) {
        int batasTanggal = 0;

        String[] bulanDengan31Hari = { "Januari", "Maret", "Mei", "Juli", "Agustus", "Oktober", "Desember" };
        String[] bulanDengan30Hari = { "April", "Juni", "September", "November" };

        if (bulan == 2) {
            batasTanggal = (tahun % 4 == 0 && (tahun % 100 != 0 || tahun % 400 == 0)) ? 29 : 28;
        }

        for (String temp : bulanDengan31Hari) {
            if (temp.equals(namaBulan)) {
                batasTanggal = 31;
                break;
            }
        }

        for (String temp : bulanDengan30Hari) {
            if (temp.equals(namaBulan)) {
                batasTanggal = 30;
                break;
            }
        }

        return tanggal >= 1 && tanggal <= batasTanggal;
    }
}