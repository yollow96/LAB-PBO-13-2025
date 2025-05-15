import java.util.Random;

public class SangPelempar {
    String nama;
    Sandal sandal = new Sandal();
    Pelindung pelindung = new Pelindung();
    int health = 50;

    public SangPelempar(String nama){
        this.nama = nama;
    }
    public SangPelempar(String nama,  int hp){
        this.nama = nama;
        this.health = hp;
    }
    public SangPelempar(String nama, String merekSandal,int ukuran, double insole,String pelindungKepala, String pelindungBadan){
        this.nama = nama;
        this.sandal.merekSandal = merekSandal;
        this.sandal.size.ukuran = ukuran;
        this.sandal.size.insole = insole;
        this.pelindung.kepala = pelindungKepala;
        this.pelindung.badan = pelindungBadan;
    }
    public SangPelempar(String nama, String merekSandal,int ukuran, double insole,String pelindungKepala, String pelindungBadan,int hp){
        this.nama = nama;
        this.sandal.merekSandal = merekSandal;
        this.sandal.size.ukuran = ukuran;
        this.sandal.size.insole = insole;
        this.pelindung.kepala = pelindungKepala;
        this.pelindung.badan = pelindungBadan;
        this.health = hp;
    }
    public void throwing(SangPelempar enemy){
        Random random = new Random();
        System.out.printf("%s Saling Melempar Sandal Dengan %s\n",this.nama, enemy.nama);
        System.out.println("_____________________________________");
        int Random = random.nextInt(2); //mengambil angka random 0-1
        int Random1 = random.nextInt(2);
        String target;
        if (Random == 0){
            target = "Badan";
        }else {
            target = "Kepala";
        }
        String target1;
        if (Random1 == 0){
            target1 = "Badan";
        }else {
            target1 = "Kepala";
        }
        this.health -= (enemy.sandal.getDamageLemaparan(target) - this.pelindung.getDef(Random));
        if (target.equals("Kepala")){
            System.out.printf("%s mengenai %s %s, mendapatkan 5 damage tambahan\n",this.nama, target, enemy.nama);
        }else {
            System.out.printf("%s mengenai %s %s, mendapatkan 3 damage tambahan\n",this.nama, target, enemy.nama);
        }
        
        enemy.health -= (this.sandal.getDamageLemaparan(target1) - enemy.pelindung.getDef(Random));
        if (target1.equals("Kepala")){
            System.out.printf("%s mengenai %s %s, mendapatkan 5 damage tambahan\n",enemy.nama, target1, this.nama);
        }else { 
            System.out.printf("%s mengenai %s %s, mendapatkan 3 damage tambahan\n",enemy.nama, target1, this.nama);
        }

        if (enemy.health <= 0){
            System.out.println();
            System.out.printf("%s had been crying\n", enemy.nama);
        }
    }

    public void checkStatus(){
        System.out.printf("=========== %s Status ===========\n",nama);
        System.out.println("Nama\t\t: " + nama);
        System.out.println("Merek Sandal\t: " + sandal.getMerekSandal() + ", " + sandal.size.getSize());
        System.out.println("Damage Sandal\t: " + sandal.getDamageLemaparan());
        System.out.println("Pelindung\t: " + pelindung.getPelindung());
        if (health <= 0){
            System.out.println("Health\t\t: " + nama + " Sedang menangis");
        }else {
        System.out.println("Health\t\t: " + health);
        }
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int hp) {
        this.health = hp;
    }

}
