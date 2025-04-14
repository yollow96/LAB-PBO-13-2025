class Cuboid{
    double height;
    double width;
    double length;

    double getVolume(){
        return width*length*height;
    }
}

public class tp2_3{
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        cuboid.height = 10;
        cuboid.width = 5;
        cuboid.length = 90;

        System.out.printf("Volume = %.2f", cuboid.getVolume());
    }
}