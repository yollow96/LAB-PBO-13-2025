import java.util.Scanner;

public class Nomor_1 {

    public static String toJudul(String str) {
        String[] words = str.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words ){
            if (!word.isEmpty()){
                result.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())    
                    .append(" ");
            }
        }

        return result.toString().trim();

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan judul film: ");
        String input = scanner.nextLine();
        scanner.close();

        String output = toJudul(input);
        System.out.println(output);
    }
}