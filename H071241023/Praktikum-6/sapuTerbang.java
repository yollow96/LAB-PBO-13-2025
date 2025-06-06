public class sapuTerbang extends Kendaraan implements IBergerak {
    private double berat;
    private double panjang;
    private double kecepatan;


    public sapuTerbang(String merek, String model) {
        super(merek, model);
    }
    
    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public double getPanjang() {
        return panjang;
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }
    

    @Override
    public double hitungPajak() {
        return 0;
    }

    @Override
    public String getTipeKendaraan() {
        return "sapu terbang";
    }

    // IBergerak
    @Override
    public boolean mulai() {
        System.out.println("sapu terbang mulai terbang ke angkasa");
        return true;
    }
    
    @Override
    public boolean berhenti() {
        System.out.println("sapu terbang sudah mendarat dengan selamat :D");
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }
}
