package models;

public class Profile {
    /*
     * TODO:
     * Tambahkan attribute, method, atau constructor
     * yang dibutuhkan di kelas user
     */
    private String fullname;
    private int age;
    private String hobby;
    private String nickname;

    public Profile() {

    }

    public Profile(String fullname, int age, String hobby, String nickname) {
        this.fullname = fullname;
        this.age = age;
        this.hobby = hobby;
        this.nickname = nickname;
    }

    public void setFullname(String fullName) {
        this.fullname = fullName;
    }

    public String getFullname() {
        return fullname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}