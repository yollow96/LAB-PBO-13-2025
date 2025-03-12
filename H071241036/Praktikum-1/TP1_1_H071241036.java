import java.util.Scanner;

public class TP1_1_H071241036 {
    public static String ubahHurufKapital(String text) {
        String[] kata = text.split("\\s+"); 
        StringBuilder kalimatKapital = new StringBuilder();

        for (String word : kata) {
            if (!word.isEmpty()) { 
                kalimatKapital.append(Character.toUpperCase(word.charAt((0))));
                kalimatKapital.append(word.substring(1).toLowerCase()); 
                kalimatKapital.append(" ");
            }
        }
    return kalimatKapital.toString().trim();
    }

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        System.out.print("Masukkan Judul Film: ");
        String film = x.nextLine();

        String hasil = ubahHurufKapital(film);

        System.out.print(hasil);

        x.close();
    } 
}