public class tp2_2 {

    public static class Product{
        String id; 
        String name;
        int stok;
        double harga;

        
        public Product(String id, String name, int stok, double harga){
            this.id = id;
            this.name = name;
            this.stok = stok;
            this.harga = harga;
        }

        
        public String getId(){
            return id;
        }
        
        public String getName(){
            return name;
        }

        public int getStok(){
            return stok;
        }

        public double getHarga(){
            return harga;
        }

        public boolean isAvailable(){
            return stok > 0;
        }

        public void displayAll(){
            System.out.println("Produk id: " + id);
            System.out.println("Nama Produk: " + name);
            System.out.println("Stok: " + stok);
            System.out.println("Harga produk: " + harga);
            System.out.println("Available: " + (isAvailable() ? "Yes" : "No"));
        }

        public static void main(String[] args){
            Product product = new Product("HA11", "Laptop", 10, 12);

            
            product.displayAll();
        }
    } 
}
