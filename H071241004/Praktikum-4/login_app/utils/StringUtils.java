package login_app.utils;

public class StringUtils {
    /*
     * Method static untuk mengembalikan nickName berdasarkan fullName
     * 1. Jika fullName hanya 1 kata, maka nickName = fullName
     * 2. Jika fullName lebih dari 1 kata, maka nickName = kata kedua
     */
    
    public static String getNickName(String fullName) {
        // Memecah fullName berdasarkan spasi
        String[] words = fullName.split(" ");
        
        // Jika hanya ada satu kata dalam fullName, nickName = fullName
        if (words.length == 1) {
            return words[0];
        }
        
        // Jika ada lebih dari satu kata, nickName adalah kata kedua
        return words[1];
    }

    // Main method untuk pengujian
    public static void main(String[] args) {
        // Contoh pengujian
        System.out.println(getNickName("Agus"));           // Output: Agus
        System.out.println(getNickName("Eurico Devon"));   // Output: Devon
    }
}
