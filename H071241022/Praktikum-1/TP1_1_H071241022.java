import java.util.Scanner;

public class tp1_1{

    public static void main(String[] args){

        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan Judul Film: ");
        String input = x.nextLine();

        String output = kapital(input);
        System.out.println(output);

        x.close();
    }


    public static String kapital(String input){
        String[] words = input.split(" ");
        StringBuilder hurufKapital = new StringBuilder();

        for (String word : words){
            hurufKapital.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");

        }
        return hurufKapital.toString();
    }

}
    
    
