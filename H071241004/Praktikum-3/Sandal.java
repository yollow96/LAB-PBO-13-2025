class Size {
    int ukuran;
    double insole;

    public String getSize() {
        return "Size " + ukuran + ", Insole " + insole;
    }
}

public class Sandal {
    String merekSandal;
    Size size = new Size();
    double damageLemaparan = 20;

    public String getMerekSandal() {
        return merekSandal;
    }

    public void setMerekSandal(String merekSandal) {
        this.merekSandal = merekSandal;
    }

    public double getDamageLemaparan(String target) {
        if (target.equals("Kepala")) {
            return (size.ukuran / 10) + damageLemaparan + 5;
        } else if (target.equals("Badan")) {
            return (size.ukuran / 10) + damageLemaparan + 3;
        } else {
            return (size.ukuran / 10) + damageLemaparan;
        }
    }

    public double getDamageLemaparan() {
        return (size.ukuran / 10) + damageLemaparan;
    }

    public void setDamageLemaparan(int damageLemaparan) {
        this.damageLemaparan = damageLemaparan;
    }
}
