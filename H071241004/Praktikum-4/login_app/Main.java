package login_app;

import java.util.ArrayList;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;
import login_app.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Memanggil method runApp();
        runApp();
    }

    private static void runApp() {
        // Menu Utama Aplikasi
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        // Menginput pilihan menu
        int selectMenu = sc.nextInt();
        sc.nextLine();
        switch (selectMenu) {
            case 1:
                // Membuka Halaman Login
                showLoginMenu();
                break;
            case 2:
                // Membuka Halaman Register
                showRegisterMenu();
                break;
            default:
                // Mengulang Pemanggilan Menu Utama
                runApp();
        }
    }

    private static void showLoginMenu() {
        // Halaman Login
        System.out.println("-------------------------");
        System.out.println("Login");
        // Menginput Username dan Menyimpannya di attribute username;
        System.out.println("Masukkan Username");
        System.out.print("> ");

        String username = sc.next();
        // Membuat variabel userIndex yang mana nanti akan menampung index dari user
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            // Mengecek apakah user index ke i dari listUser memiliki username yang sama
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i; // Ganti userIndex dengan Index dari User Tersebut
                break; // Hentikan perulangan setelah menemukan username
            }
        }

        // Saat userIndex tidak sama dengan -1 atau userIndexnya ditemukan
        if (userIndex != -1) {
            // Menginput Password
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.next();

            // Mengecek apakah password dari User yang login berdasarkan username
            boolean isPasswordMatch = false;
            if (listUser.get(userIndex).getPassword().equals(password)) {
                isPasswordMatch = true;
            }

            // Jika passwordnya sama maka berhasil login
            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                showDetailUser(listUserProfile.get(userIndex)); // Panggil showDetailUser dengan profile yang ditemukan
                System.exit(0); // Keluar dari aplikasi
            } else {
                // Saat password salah akan menampilkan password salah
                System.out.println("Password Salah");
            }
        } else {
            System.out.println("Username Tidak Ditemukan");
        }
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        // Menginput username dan password
        System.out.println("Username");
        System.out.print("> ");
        String username = sc.nextLine();
        System.out.println("Password");
        System.out.print("> ");
        String password = sc.nextLine();

        // Membuat atau Instance objek Profile baru
        Profile profile = new Profile("UsernameDefault", "email@example.com", "Alamat Default");

        // Menginput Data Profile
        System.out.println("Nama Lengkap");
        System.out.print("> ");
        String fullName = sc.nextLine();
        System.out.println("Umur");
        System.out.print("> ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.println("Hobby");
        System.out.print("> ");
        String hobby = sc.nextLine();

        // Memberikan nilai fullName, age, dan hobby ke objek profile
        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);

        // Menentukan Nickname menggunakan method static dari StringUtils
        profile.setNickName(StringUtils.getNickName(fullName));

        // Membuat objek User baru dengan username, password, dan profile
        User user = new User(username, password, profile);

        // Menambahkan user dan profile ke dalam list
        listUser.add(user);
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        // Tampilkan semua data profile user yang login
        System.out.println("-------------------------");
        System.out.println("Detail User:");
        System.out.println("Nama Lengkap: " + profile.getFullName());
        System.out.println("Umur: " + profile.getAge());
        System.out.println("Hobby: " + profile.getHobby());
        System.out.println("Nickname: " + profile.getNickName());
        System.out.println("-------------------------");
    }
}
