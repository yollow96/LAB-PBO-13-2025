import java.util.InputMismatchException;
import java.util.Scanner;

public class TP1_2_H071241023 {
    public static void main(String[] args) {
        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        try {
            Scanner input = new Scanner(System.in);
            int num = input.nextInt();
            input.close();
            
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[i][j] == num) {
                        System.out.println("Found" + " "+ num + " at" + " " + "[" + i + "]" + "[" + j + "]");
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error!! please enter a number");
        }
    }
}