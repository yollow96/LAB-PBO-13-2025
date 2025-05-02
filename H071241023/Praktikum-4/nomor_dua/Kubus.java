package Nomor2;

public class Kubus {
    private double sisi;

    public Kubus(double sisi) {
        this.sisi = sisi;
    }

    public double getVolume() {
        return Math.pow(sisi, 3);
    }

    public double getLuasPermukaan() {
        return 6 * Math.pow(sisi, 2);
    }
}
