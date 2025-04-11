public class TP2_2_H071241023 {
    public static void main(String[] args) {
        Produk pulpen = new Produk();
        pulpen.ID = "P001";
        pulpen.nama = "Kenko Hi-tech";
        pulpen.stok = 1;
        pulpen.harga = 10000;
        System.out.println("ID: " + pulpen.ID + "\n" + "Nama: " + pulpen.nama + "\n" + "Stok: " + pulpen.cekStok() + "\n" + "Harga: " +  pulpen.harga);
    }
}

class Produk {
    String ID;
    String nama;
    int stok;
    int harga;


    public String cekStok() {
        if (stok > 0) {
            return "" + stok;
        } else {
            return "Habis";
        }
    }
}
