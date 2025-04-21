class Person {
    String name;
    int age;
    boolean isMale;

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void setAge(int age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    public String getGender(){
        return isMale ? "Laki-laki" : "Perempuan";
    }
}

public class TP2_1_H071241004 {
    
    public static void main(String[] args) {
        Person person = new Person();

        person.setName("A.M. Haadi Assa'di");
        person.setAge(19);
        person.setGender(true);

        System.out.println("Nama: " + person.getName());
        System.out.println("Usia: " + person.getAge());
        System.out.println("Jenis Kelamin: " + person.getGender());
    }
}
