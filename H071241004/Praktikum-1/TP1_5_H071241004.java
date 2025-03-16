import java.util.Scanner;

public class TP1_5_H071241004 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Password : ");
        String password = scanner.nextLine();

        boolean isValid = true;

        if (password.length() < 8){
            isValid = false;
        }

        boolean mempunyaiUpperCase = false;
        boolean mempunyaiLowerCase = false;
        boolean mempunyaiDigit = false;

        for (char c : password.toCharArray()) {

            if (Character.isUpperCase(c)){
                mempunyaiUpperCase = true;
            }
            else if (Character.isLowerCase(c)){
                mempunyaiLowerCase = true;
            }
            else if (Character.isDigit(c)) {
                mempunyaiDigit = true;
            }
                
        }

        if (!mempunyaiUpperCase || !mempunyaiLowerCase || !mempunyaiDigit){
            isValid = false;
        }

        if (isValid) {
            System.out.println("Password Valid");
        }
        else{
            System.out.println("Password Tidak Valid");
        }

        scanner.close();
            
    }
}