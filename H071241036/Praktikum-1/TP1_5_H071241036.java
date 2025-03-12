import java.util.Scanner;

public class Nomor5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        scanner.close();
        
        if (cekPassword(password)) {
            System.out.println("Password valid!");
        } else {
            System.out.println("Password tidak valid!\nSyarat: Minimal 8 karakter, ada huruf besar, huruf kecil, angka, dan simbol.");
        }
    }

    public static boolean cekPassword(String password) {
        if (password.length() < 8) {
            return false; 
        }
        
        boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka = false;
        boolean adaSimbol = false;

        String simbolValid = "!@#$%^&*()";

        for (int i = 0; i < password.length(); i++) {
            char karakter = password.charAt(i);
            if (Character.isUpperCase(karakter)) {
                adaHurufBesar = true;
            } else if (Character.isLowerCase(karakter)) {
                adaHurufKecil = true;
            } else if (Character.isDigit(karakter)) {
                adaAngka = true;
            } else if (simbolValid.contains(String.valueOf(karakter))) {
                adaSimbol = true;
            }
        }
        
        return adaHurufBesar && adaHurufKecil && adaAngka && adaSimbol;
    }
}
