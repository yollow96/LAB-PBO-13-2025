public class TP2_1_H071241023 {
    public static void main(String[] args) {
        Person person_1 = new Person();
        person_1.setName("Budi");
        person_1.setAge(10);
        person_1.setGender(false);

        System.out.println("Name: " + person_1.getName());
        System.out.println("Age: " + person_1.getAge());
        System.out.println("Gender: " + person_1.getGender());
    }
}

class Person { 
    String name;
    int age;
    boolean isMale;

    public void setName(String name) { 
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(Boolean isMale) {
        this.isMale = isMale;
    }
    public String getGender() {
        if (isMale) {
            return "Male";
        } else {
            return "Female";
        }
    }
    
}