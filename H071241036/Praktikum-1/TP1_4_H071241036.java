import java.util.Scanner;

public class Nomor4 {
    public static int hitungFaktorial(int n) {
        if (n == 0) return 1;
        return n * hitungFaktorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        int angka = scanner.nextInt();
        scanner.close();

        int hasil = hitungFaktorial(angka);
        System.out.println("Faktorial: " + hasil);
    }
}
