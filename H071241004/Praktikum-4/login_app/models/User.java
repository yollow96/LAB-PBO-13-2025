package login_app.models;

public class User {
    // Atribut private untuk encapsulation
    private String username;
    private String password;
    private Profile profile; // Objek Profile untuk mengakses data profil pengguna

    // Konstruktor untuk menginisialisasi objek User
    public User(String username, String password, Profile profile) {
        this.username = username;
        setPassword(password); // Menggunakan setter untuk validasi password
        this.profile = profile;
    }

    // Getter untuk username
    public String getUsername() {
        return username;
    }

    // Setter untuk username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter untuk password
    public String getPassword() {
        return password;
    }

    // Setter untuk password dengan validasi panjang password
    public void setPassword(String password) {
        if (password.length() >= 8) {
            this.password = password;
        } else {
            System.out.println("Password harus lebih dari 8 karakter.");
        }
    }

    // Getter untuk profile
    public Profile getProfile() {
        return profile;
    }

    // Setter untuk profile
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    // Metode untuk menampilkan informasi user
    public void displayUserInfo() {
        System.out.println("Username: " + getUsername());
        System.out.println("Password: " + getPassword()); // Jangan tampilkan password di production code!
        profile.displayProfile(); // Menampilkan informasi profil pengguna
    }

    // Main method untuk pengujian
    public static void main(String[] args) {
        Profile profile = new Profile("JohnDoe", "john.doe@example.com", "123 Main St, Jakarta");
        User user = new User("johndoe123", "securePassword123", profile);
        user.displayUserInfo(); // Menampilkan informasi user
    }
}
