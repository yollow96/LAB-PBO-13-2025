class Produk {
    int id;
    String nama;
    boolean stok;
    int harga;

    String getProduk() {
        return "ID: " + id + ", Nama: " + nama + ", Stok: " + stok + ", Harga: " + harga;
    }

    String cekStok() {
        return stok ? "Produk tersedia" : "Produk tidak tersedia";
    }
}

public class TP2_2_H071241004 {
    public static void main(String[] args) {
        Produk produk = new Produk();

        produk.id = 123;
        produk.nama = "Sabun";
        produk.stok = true;
        produk.harga = 2000;

        System.out.println(produk.getProduk());

        System.out.println(produk.cekStok());
    }
}
