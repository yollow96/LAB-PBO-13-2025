import java.util.Scanner;

public class FaktorialRekursi {
    public static int faktorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * faktorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        int n = scanner.nextInt();
        System.out.println("Output : " + faktorial(n));
        scanner.close();
    }
}
