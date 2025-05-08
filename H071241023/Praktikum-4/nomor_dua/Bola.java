package Nomor2;

public class Bola {
    private double jariJari;

    public Bola(double jariJari) {
        this.jariJari = jariJari;
    }

    public double getVolume() {
        return (4.0/3) * (Math.PI) * Math.pow(jariJari, 3);
    }

    public double getLuasPermukaan() {
        return 4 * Math.PI * Math.pow(jariJari, 2);
    }
}

