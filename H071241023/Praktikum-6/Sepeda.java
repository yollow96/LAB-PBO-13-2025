import java.util.Calendar;
import java.util.Date;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda;
    private double kecepatan;
    private Date tanggalServis;

    public Sepeda(String merek, String model) {
        super(merek, model);
    }
    
    public String getJenisSepeda() {
        return jenisSepeda;
    }

    public void setJenisSepeda(String jenis) {
        this.jenisSepeda = jenis;
    }

    public int getJumlahGear() {
        return jumlahGear;
    }

    public void setJumlahGear(int jumlah) {
        this.jumlahGear = jumlah;
    }

    public int getUkuranRoda() {
        return ukuranRoda;
    }

    public void setUkuranRoda(int ukuran) {
        this.ukuranRoda = ukuran;
    }

    public double hitungPajak() {
        return 0;
    }

    public String getTipeKendaraan() {
        return "Sepeda";
    }

    public boolean mulai() {
        System.out.println("Sepeda mulai bergerak..");
        return true;
    }

    public boolean berhenti() {
        System.out.println("Sepeda berhenti");
        return true;
    }

    public double getKecepatan() {
        return kecepatan;
    }
    
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    public boolean periksaKondisi() {
        System.out.print("Memeriksa kondisi sepeda");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(2000);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("Waduh sepedamu rusak!");;
        return true;
    }

    public void lakukanService() {
        tanggalServis = new Date();
        System.out.println("Sepeda sudah diservis :D");
    }

    public Date getWaktuServiceBerikutnya() {
        if (tanggalServis == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(tanggalServis);
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }

    public double hitungBiayaService(String jenisService) {
        switch (jenisService.toLowerCase()) {
            case "ringan":
                return 2000;
            case "sedang":
                return 5000;
            case "berat":
                return 7000;
            default:
                System.out.println("service tidak dikenali");
                return 0;
        }
    }
}
