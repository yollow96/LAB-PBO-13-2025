import java.util.Scanner;

public class TP1_2_H071241004 {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        try {
            System.out.print("\nMasukkan angka yang ingin dicari : ");
            int angka = input.nextInt();

            boolean ditemukan = false;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {

                    if (nums[i][j] == angka) {
                        System.out.println("Angka " + angka + " ditemukan pada posisi ["+ i + "]["+ j +"]");
                        ditemukan = true;

                        break;
                    }
                }
            }

            if (!ditemukan) {
                System.out.println("Angka " + angka + " tidak ditemukan");
            }
        }
        catch (Exception e) {
            System.out.println("Maaf, input yang Anda masukkan tidak valid");
        }
        finally {
            input.close();
        }
    }
}