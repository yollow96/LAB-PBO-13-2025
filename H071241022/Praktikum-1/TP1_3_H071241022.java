//jangan ada tanggal 32, klo begitu outputnya tanggal tidak valid, bulan

import java.util.Scanner;

public class tp1_3 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus",
    "September", "Oktober", "November", "Desember"};
        System.out.print("Input: ");
        String input = scanner.nextLine();

        try {
            String[] parts = input.split("-");

            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]) - 1; //aa
            int year = Integer.parseInt(parts[2]);
            if (year < 50){
                year += 2000;
            }else {
                year += 1900;
            }

            if (month < 1 || month > 12){
                System.out.println("Bulan tidak valid");
                return;
            }

            if (day < 1 || day > 31){
                System.out.println("Tanggal tidak valid");
                return;
            }

            System.out.println(day + " " + bulan[month] + " " + year);
        } catch (NumberFormatException e){
            System.out.println("Input tidak valid");
        }finally{
            scanner.close();
        }
    }
}
