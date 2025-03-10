import java.util.Scanner;

public class TP1_4_H071241023 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(factorial(num));
        input.close();
    }
    
    public static int factorial(int n) {
        return n == 0 ? 1 : n * factorial(n - 1);
    }

}