public class tp2_1 {

    public static class Person {
        String name; 
        int age;
        boolean isMale;

        public void setName(String name){
            this.name = name;
        }
        
        public String getName(){
            return name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge(){
            return age;
        }

        public void setGender(boolean isMale){
            this.isMale = isMale;
        }

        public String getGender(){
            return isMale ? "Male" : "Female";
        }

        public static void main(String[] args){
            Person person = new Person();

            person.setName("Sophie");
            person.setAge(19);
            person.setGender(false);

            System.out.println("Nama: " + person.getName());
            System.out.println("Age: " + person.getAge());
            System.out.println("Gender: " + person.getGender());
        }
    }


}