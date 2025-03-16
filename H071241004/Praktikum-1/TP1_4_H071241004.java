import java.util.Scanner;

public class TP1_4_H071241004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        int angka = scanner.nextInt();
        scanner.close();

        long faktor = 1;
        for (int i = 1; i <= angka; i++) {
            faktor *= i;
        }

        System.out.print("Output : " + faktor);
    }
}