import java.util.Scanner;

public class TP1_3_H071241023 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            String date = input.nextLine();
            input.close();

            String[] strSplit = date.split("-");
            
            String dd = strSplit[0];
            String mm = strSplit[1];
            String yy = strSplit[2];

            int MM, YY, DD;
        
            DD = Integer.parseInt(dd);
            MM = Integer.parseInt(mm);
            YY = Integer.parseInt(yy);
        
            if (MM < 1 || MM > 12) {
                System.out.println("Bulan tidak valid");
                return;
            }

            String[] monthName = { "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                    "Juli", "Agustus", "September", "Oktober", "November", "Desember" };
            String month = monthName[MM - 1];

            int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            
            
            boolean leap = (YY % 4 == 0 && YY % 100 != 0) || ( YY % 400 == 0);
            if (MM == 2 && leap) {
                daysInMonth[1] = 29;
            }
            
            if (DD < 1 || DD > daysInMonth[MM - 1]) {
                System.out.println("Tanggal tidak valid");
                return;
            }

            int year;
            if (YY > 50) {
                year = 1900 + YY;
            } else {
                year = 2000 + YY;
            }
            
            System.out.println(DD + " " + month + " " + year);

        } catch (Exception e) {
            System.out.println("Error!! input tidak valid");
            return;
        }
    }
}