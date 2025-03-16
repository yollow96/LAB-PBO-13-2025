import java.util.Scanner;

public class TP1_1_H071241004 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan Judul Film : ");
        String judul = scanner.nextLine();

        String[] kalimat = judul.split(" ");

        for (int i = 0; i < kalimat.length; i++){
            if (kalimat[i].length() > 0){

                kalimat[i] = Character.toUpperCase(kalimat[i].charAt(0)) + kalimat[i].substring(1).toLowerCase();
            }
        }

        String outputJudul = String.join(" ", kalimat);

        System.out.println("Hasil : " + outputJudul);

        scanner.close();
    }
}