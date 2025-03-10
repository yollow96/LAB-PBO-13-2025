// import java.util.Scanner;

import java.util.Scanner;

public class TP1_1_H071241023 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Judul Film : ");
        String str = input.nextLine();
        input.close();
        String[] wordSplit = str.split(" ");
        String result = "";
        
        for (int i = 0; i < wordSplit.length; i++) {
            String word = wordSplit[i];
            if (word.length() > 0) {
                char firstCharacter = Character.toUpperCase(word.charAt(0));
                String restOfWord = word.substring(1).toLowerCase();
                result += firstCharacter + restOfWord + " ";
            }
        }
        System.out.println(result);
    }
}