import java.util.Scanner;

public class Nomor2 {
    public static void main(String[] args) {
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Masukkan angka yang ingin anda cari: ");
            int angkaTarget = scanner.nextInt();

            for (int baris = 0; baris < array.length; baris++) { 
                for (int kolom = 0; kolom < array[baris].length; kolom++) {
                    if (array[baris][kolom] == angkaTarget) {
                        System.out.println("Angka " + angkaTarget + " ditemukan pada posisi [" + baris + "][" + kolom + "]");
                        return; 
                    }
                }
            }

            System.out.println("Angka tidak ditemukan dalam array.");
        } catch (Exception e) {
            System.out.println("Input tidak valid! Harap masukkan angka.");
        } finally {
            scanner.close(); 
        }
    }
}
