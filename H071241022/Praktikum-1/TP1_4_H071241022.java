import java.util.Scanner;

public class tp1_4 {
    
    public static long factorial(int n){
        if (n == 0 || n == 1){
            return 1;
        } else {
            return n * factorial(n-1); //recursion
        }
    }
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        int n = scanner.nextInt();

        long result = factorial(n);
        System.out.println("Output " + result);

        scanner.close();
    }

    }

