package login_app.models;

public class Profile {
    // Atribut private untuk encapsulation
    private String username;
    private String email;
    private String address;

    // Konstruktor untuk menginisialisasi objek Profile
    public Profile(String username, String email, String address) {
        this.username = username;
        this.email = email;
        this.address = address;
    }

    // Getter untuk username
    public String getUsername() {
        return username;
    }

    // Setter untuk username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter untuk email
    public String getEmail() {
        return email;
    }

    // Setter untuk email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter untuk address
    public String getAddress() {
        return address;
    }

    // Setter untuk address
    public void setAddress(String address) {
        this.address = address;
    }

    // Metode untuk menampilkan informasi profil
    public void displayProfile() {
        System.out.println("Username: " + getUsername());
        System.out.println("Email: " + getEmail());
        System.out.println("Address: " + getAddress());
    }

    // Main method untuk pengujian
    public static void main(String[] args) {
        Profile profile = new Profile("JohnDoe", "john.doe@example.com", "123 Main St, Jakarta");
        profile.displayProfile(); // Menampilkan profil
    }
}
