class Alamat{
    String jalan;
    String kota;

    public String toString(){
        return jalan + ", " + kota;
    }
}

class Mahasiswa {
    Alamat alamat;
    String nama;
    String nim;

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }
    
    public Alamat getAlamat() {
        return alamat;
    }
}



public class TP2_4_H071241004 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Jipang Raya";
        alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "A.M. Haadi Assa'di";
        mahasiswa.nim = "H071241004";

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}