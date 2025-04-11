class Cuboid {
    double height;
    double width;
    double lenght;

    double getVolume() {
        // lengkapi
        return height * width * lenght;
    }
}

public class TP2_3_H071241023 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        // lengkapi
        cuboid.height = 15;
        cuboid.width = 15;
        cuboid.lenght = 20;
        System.out.printf("Volume = %.2f", cuboid.getVolume());
    }
}
