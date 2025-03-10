import java.util.Scanner;
public class TP1_5_H071241023 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String password = input.nextLine();
        input.close();
        
        String pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]){8,}+$";
        if (password.matches(pattern)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
        
    }
    
    
}
