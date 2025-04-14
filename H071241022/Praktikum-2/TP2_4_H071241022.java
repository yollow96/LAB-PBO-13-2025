public class tp2_4 {

    //class alamat
    static class Alamat{
        String jalan;
        String kota;

        public Alamat(String jalan, String kota){
            this.jalan = jalan;
            this.kota = kota;
        }

        public String getFullAlamat(){
            return jalan + ", " + kota;
        }
    }

    //class mahasiswa
    static class Mahasiswa{
        String nama;
        String nim;
        Alamat alamat;

        public Mahasiswa(String nama, String nim, Alamat alamat){
            this.nama = nama;
            this.nim = nim;
            this.alamat = alamat;
        }

        public String getNama(){
            return nama;
        }

        public String getNim(){
            return nim;
        }

        public String getAlamat(){
            return alamat.getFullAlamat();
        }
    }
    
    public class Main{
        public static void main(String[] args){
            Alamat alamat = new Alamat("Rumah", "Makassar");

            Mahasiswa mahasiswa = new Mahasiswa("Sophie", "H071241022", alamat);

            System.out.println("Nama: " + mahasiswa.getNama());
            System.out.println("Nim: " + mahasiswa.getNim());
            System.out.println("Alamat: " + mahasiswa.getAlamat());
        }
    }
}
