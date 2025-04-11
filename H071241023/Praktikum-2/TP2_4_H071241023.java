public class TP2_4_H071241023 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Tamalanrea Indah";
        alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Farhan";
        mahasiswa.nim = "H071231025";

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}

// disuruh buat class
class Alamat {
    String jalan;
    String kota;

    String getAlamat() {
        return jalan + ", " + kota;
        
    }
}

class Mahasiswa {
    String nama;
    String nim;
    Alamat alamat;

    String getNama() {
        return nama;
    }

    String getNim() {
        return nim;
    }

    String getAlamat() {
        return alamat.getAlamat();
    }
}
