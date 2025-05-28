import java.util.Calendar;
import java.util.Date;
public class Mobil extends Kendaraan implements IBergerak {
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;
    private double kecepatan;
    private Date tanggalServis;

    public Mobil(String merek, String model) {
        super(merek, model);
    }
    
    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlah) {
        this.jumlahPintu = jumlah;
    }

    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(double kapasitas) {
        this.kapasitasMesin = kapasitas;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlah) {
        this.jumlahKursi = jumlah;
    }

    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }
    
    public double hitungPajak() {
        return kapasitasMesin * 5000;
    }

    public String getTipeKendaraan() {
        return "Mobil";
    }

    // IBergerak
    @Override
    public boolean mulai() {
        System.out.println("Mobil mulai bergerak..");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Mobil berhenti");
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


    // IService
    
    public boolean periksaKondisi() {
        System.out.print("Memeriksa kondisi mobil");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(2000);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("Waduh mobilmu rusak!");;
        return true;
    }

    
    public void lakukanService() {
        tanggalServis = new Date();
        System.out.println("Mobil sudah diservis :D");
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
                return 5000;
            case "sedang":
                return 10000;
            case "berat":
                return 15000;
            default:
                System.out.println("service tidak dikenali");
                return 0;
        }
    }
}
