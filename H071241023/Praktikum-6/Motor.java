import java.util.Calendar;
import java.util.Date;
public class Motor extends Kendaraan implements IBergerak, IServiceable {
    private String jenisMotor;
    private double kapasitasTangki;
    private String tipeSuspensi;
    private double kecepatan;
    private Date tanggalServis;
    

    public Motor(String merek, String model) {
        super(merek, model);
    }
    
    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenis) {
        this.jenisMotor = jenis;
    }

    public double getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setKapasitasTangki(double kapasitas) {
        this.kapasitasTangki = kapasitas;
    }

    public String getTipeSuspensi() {
        return tipeSuspensi;
    }

    public void setTipeSuspensi(String tipeSuspensi) {
        this.tipeSuspensi = tipeSuspensi;
    }

    public double hitungPajak() {
        return kapasitasTangki * 5000;
    }

    public String getTipeKendaraan() {
        return "Motor";
    }

    @Override
    public boolean mulai() {
        System.out.println("Motor mulai bergerak..");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Motor berhenti");
        return true;
    }

    // IBergerak
    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    //IServiceable
    @Override
    public boolean periksaKondisi() {
        System.out.print("Memeriksa kondisi motor");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(2000);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("Waduh motormu rusak!");;
        return true;
    }

    @Override
    public void lakukanService() {
        tanggalServis = new Date();
        System.out.println("Motor sudah diservis :D");
    }

    @Override
    public Date getWaktuServiceBerikutnya() {
        if (tanggalServis == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(tanggalServis);
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaService (String jenisService) {
        switch (jenisService.toLowerCase()) {
            case "ringan":
                return 3000;
            case "sedang":
                return 7000;
            case "berat":
                return 10000;
            default:
                System.out.println("service tidak dikenali");
                return 0;
        }
    }

}
