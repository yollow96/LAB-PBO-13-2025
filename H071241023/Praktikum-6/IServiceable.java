import java.util.Date;
interface IServiceable {
    public boolean periksaKondisi();
    public void lakukanService();
    public Date getWaktuServiceBerikutnya();
    public double hitungBiayaService(String jenisService);
}
