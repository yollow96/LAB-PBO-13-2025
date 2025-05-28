import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hero chooseHero = null;

        while (chooseHero == null) {
            try {
                System.out.println("Pilih Karakter: ");
                System.out.println("1. Archer");
                System.out.println("2. Wizard");
                System.out.println("3. Fighter");
                System.out.println("Masukkan pilihan: ");
                System.out.print("> ");

                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        chooseHero = new Archer("Pemanah");
                        break;
                    case 2:
                        chooseHero = new Wizard("Penyihir");
                        break;
                    case 3:
                        chooseHero = new Fighter("Penyerang");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid");
                }
            } catch (Exception e) {
                System.out.println("Input harus angka");
                input.nextLine();
            }
        }
        
        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Serang");
                System.out.println("2. Keluar");
                System.out.print("> ");

                int menuChoice = input.nextInt();
                input.nextLine();
                switch (menuChoice) {
                    case 1:
                        chooseHero.serang();
                        break;
                    case 2:
                        System.out.println("Game selesai!");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid");
                }
            } catch (Exception e) {
                System.out.println("Input harus angka");
                input.nextLine();
            }
        }
    }
}