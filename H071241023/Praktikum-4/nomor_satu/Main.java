package nomor_satu;

import java.util.ArrayList;
import java.util.Scanner;
import nomor_satu.models.Profile;
import nomor_satu.models.User;
import nomor_satu.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

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
        int selectMenu = input.nextInt();
        input.nextLine();
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

        String username = input.next();
        // Membuat variabel userIndex yang mana nanti akan menampung index dari user
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            /*
             * TODO
             * Buatlah sebuah perkondisian (IF) yang akan
             * Mengecek apakah user index ke i dari listUser memiliki username yang sama
             * dengan username yang
             * diinput.
             * Jika ada ganti userIndex dengan Index dari User Tersebut, kemudian hentikan
             * perulangan
             */
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }

        // Saat userIndex tidak sama dengan -1 atau userIndexnya ditemukan
        if (userIndex != -1) {
            // Menginput Password
            System.out.println("Password");
            System.out.print("> ");
            String password = input.next();

            /*
             * TODO
             * Mengecek apakah password dari User yang login berdasarkan username
             * sama dengan password yang diinput sebelumnya, kemudian simpan
             * hasilnya di variabel isPasswordMatch
             */

            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);

            // Jika passwordnya sama maka berhasil login
            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                /*
                 * TODO
                 * panggil method showDetailUser dan kirimkan data Profile User yang login
                 * 
                 */
                showDetailUser(listUserProfile.get(userIndex));
                System.exit(0);
            } else {
                // saat password salah akan menampikan password salah
                System.out.println("Password Salah");
            }
        }
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        String username = "";
        String password = "";

        // Menginput username dan password
        while (true) {
            System.out.println("Username");
            System.out.print("> ");
            username = input.nextLine().trim();
            // tambah kondisi username tidak boleh kosong
            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong!");
                continue;
            }

            // tambah kondisi jika username telah digunakan, harus input ulang
            boolean isDuplicate = false;
            for (User user : listUser) {
                if (user.getUsername().equals(username)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                System.out.println("Username sudah digunakan, coba yang lain.");
                continue;
            }

            while (true) {
                System.out.println("Password");
                System.out.print("> ");
                password = input.nextLine().trim();
                // kondisi kalau pass gaboleh kosong
                if (password.isEmpty()) {
                    System.out.println("Password tidak boleh kosong!");
                    // pass harus min 8 karakter
                } else if (password.length() < 8) {
                    System.out.println("Password harus minimal 8 karakter");
                } else {
                    break;
                }
            }
            break;
        }
        /*
         * TODO
         * Buatlah atau Instance objek User baru, dan tambahkan
         * username dan password yang diinput sebelumnya secara langsung
         * saat instance User
         */

        /*
         * TODO
         * Buatlah atau Instance objek Profile baru
         */
        Profile profile = new Profile();
        User user = new User(username, password, profile);

        // Menginput Data Profile
        System.out.println("Nama Lengkap");
        System.out.print("> ");
        String fullName = input.nextLine().trim();
        while (fullName.isEmpty()) {
            System.out.println("Nama tidak boleh kosong.");
            System.out.println("> ");
            fullName = input.nextLine().trim();
        }

        int age = -1;
        while (true) {
            System.out.println("Umur");
            System.out.print("> ");
            String ageInput = input.nextLine().trim();

            if (ageInput.isEmpty()) {
                System.out.println("Umur tidak boleh kosong");
                continue;
            }

            try {
                age = Integer.parseInt(ageInput);
                if (age > 0)
                    break;
                else
                    System.out.println("Umur harus lebih dari 0");
            } catch (NumberFormatException e) {
                System.out.println("Inputan harus angka");
            }
        }
        
        System.out.println("Hobby");
        System.out.print("> ");
        String hobby = input.nextLine().trim();
        while (hobby.isEmpty()) {
            System.out.println("Hobby tidak boleh kosong");
            System.out.println("> ");
            hobby = input.nextLine().trim();
        }

        

        /*
         * TODO
         * Berikan nilai fullName, age, dan hobby ke objek profile yang telah
         * di Instance sebelumnya. Nilai ini diperoleh dari data profile yang
         * diinput sebelumnya
         */

        profile.setFullname(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);
        /*
         * TODO
         * Berikan nilai nickName ke objek profile,
         * Nilai ini diperoleh menggunakan static method yang dibuat di class
         * StringUtils, dengan mengirimkan fullName yang diinput sebelumnya
         */
        String nickname = StringUtils.getNickname(fullName);
        profile.setNickname(nickname);


        // Menambahkan user yang dibuat ke list user
        listUser.add(user);
        // Menambahkan profile user yang dibuat ke list profile
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        /*
         * TODO *
         * Tampilkan semua data profile user yang login
         */
        System.out.println("====================");
        System.out.println("SELAMAT DATANG !!");
        System.out.println("====================");;
        System.out.println("Nama Lengkap   : " + profile.getFullname());
        System.out.println("Nama Panggilan : " + profile.getNickname());
        System.out.println("Umur           : " + profile.getAge());
        System.out.println("Hobby          : " + profile.getHobby());
    }
}