import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        
        int pilihanMenu = 0;

        while (pilihanMenu < 1 || pilihanMenu > 5) {
            System.out.println("Mau cek data apa?");
            System.out.println("1. Mobil");
            System.out.println("2. Motor");
            System.out.println("3. Sepeda");
            System.out.println("4. Sapu terbang");
            System.out.println("5. Nda ada ji");
            System.out.print("> ");
            pilihanMenu = input.nextInt();
            System.out.println();

            if (pilihanMenu < 1 || pilihanMenu > 5) {
                System.out.println("Masukkan pilihan menu yang benar");
            }
        }

        if (pilihanMenu == 1) {
            Mobil mobil = new Mobil("Honda", "Civic");
            System.out.println("DATA MOBIL");
            System.out.println("---------------");
            System.out.print("Masukkan jumlah pintu: ");
            int jumlahPintu = input.nextInt();
            mobil.setJumlahPintu(jumlahPintu);
            System.out.print("Masukkan kapasitas mesin: ");
            double kapasitasMesin = input.nextInt();
            mobil.setKapasitasMesin(kapasitasMesin);
            System.out.print("Masukkan jumlah kursi: ");
            int jumlahKursi = input.nextInt();
            mobil.setJumlahKursi(jumlahKursi);
            System.out.print("Masukkan jenis bahan bakar: ");
            input.nextLine();
            String bahanBakar = input.nextLine();
            mobil.setBahanBakar(bahanBakar);
            System.out.print("Masukkan kecepatan mobil: ");
            double kecepatanMobil = input.nextDouble();
            mobil.setKecepatan(kecepatanMobil);
            System.out.println();

            System.out.println("Detail Mobil");
            System.out.println("------------------------");
            System.out.println("Tipe kendaraan: " + mobil.getTipeKendaraan());
            System.out.println("Merek: " + mobil.merek);
            System.out.println("Model: " + mobil.model);
            System.out.println("Jumlah pintu: " + mobil.getJumlahPintu());
            System.out.println("Kapasitas mesin: " + mobil.getKapasitasMesin() + "L");
            System.out.println("Jumlah pintu: " + mobil.getJumlahPintu());
            System.out.println("Bahan bakar: " + mobil.getBahanBakar());
            System.out.println("Kecepatan: " + mobil.getKecepatan() + " km/jam");


            System.out.println();
            System.out.println("Mau lihat pajak? (ya/tidak)");
            System.out.print("> ");
            String pajakMobil = input.next();
            if (pajakMobil.equalsIgnoreCase("ya")) {
                System.out.println("Pajak: " + mobil.hitungPajak());
            }

            input.nextLine();
            System.out.println("Mau bergerak? (ya/tidak)");
            System.out.print("> ");
            String bergerakMobil = input.next();
            if (bergerakMobil.equalsIgnoreCase("ya")) {
                mobil.mulai();
            }

            System.out.println();
            System.out.println("Mau berhenti? (ya/tidak)");
            System.out.print("> ");
            String berhentiMobil = input.next();
            if (berhentiMobil.equalsIgnoreCase("ya")) {
                mobil.berhenti();
            }

            System.out.println();
            System.out.println("Mau periksa kondisi mobilmu? (ya/tidak)");
            System.out.print("> ");
            String kondisiMobil = input.next();
            if (kondisiMobil.equalsIgnoreCase("ya")) {
                mobil.periksaKondisi();
            }

            System.out.println();
            System.out.println("Mau servis nda? (ya/tidak)");
            System.out.print("> ");
            String servisMobil = input.next();
            if (servisMobil.equalsIgnoreCase("ya")) {
                Thread.sleep(5000);
                mobil.lakukanService();
                Thread.sleep(2000);
                System.out.println("Biaya servis: " + mobil.hitungBiayaService("berat"));
                Thread.sleep(2000);
                System.out.println("Servis berikutnya: " + mobil.getWaktuServiceBerikutnya());
            }


        } else if (pilihanMenu == 2) {
            Motor motor = new Motor("Honda", "Suprax");
            System.out.println();
            System.out.println("DATA MOTOR");
            System.out.println("---------------");
            System.out.print("Masukkan jenis motor: ");
            String jenisMotor = input.next();
            motor.setJenisMotor(jenisMotor);
            System.out.print("Masukkan kapasitas tangki: ");
            double kapasitasTangki = input.nextDouble();
            motor.setKapasitasTangki(kapasitasTangki);
            System.out.print("Masukkan tipe suspensi: ");
            String tipeSuspensi = input.next();
            motor.setTipeSuspensi(tipeSuspensi);
            System.out.print("Masukkan kecepatan motor: ");
            double kecepatanMotor = input.nextDouble();
            motor.setKecepatan(kecepatanMotor);

            System.out.println();
            System.out.println("Detail Motor");
            System.out.println("------------------------");
            System.out.println("Tipe kendaraan: " + motor.getTipeKendaraan());
            System.out.println("Merek: " + motor.merek);
            System.out.println("Model: " + motor.model);
            System.out.println("Jenis motor: " + motor.getJenisMotor());
            System.out.println("Kapasitas tangki: " + motor.getKapasitasTangki() + "L");
            System.out.println("Tipe suspensi: " + motor.getTipeSuspensi());
            System.out.println("Kecepatan: " + motor.getKecepatan() + " km/jam");

            System.out.println();
            System.out.println("Mau lihat pajak? (ya/tidak)");
            System.out.print("> ");
            String pajakMotor = input.next();
            if (pajakMotor.equalsIgnoreCase("ya")) {
                System.out.println("Pajak: " + motor.hitungPajak());
            }

            System.out.println();
            System.out.println("Mau bergerak? (ya/tidak)");
            System.out.print("> ");
            String bergerakMotor = input.next();
            if (bergerakMotor.equalsIgnoreCase("ya")) {
                motor.mulai();
            }

            System.out.println();
            System.out.println("Mau berhenti? (ya/tidak)");
            System.out.print("> ");
            String berhentiMotor = input.next();
            if (berhentiMotor.equalsIgnoreCase("ya")) {
                motor.berhenti();
            }

            System.out.println();
            System.out.println("Mau periksa kondisi motormu? (ya/tidak)");
            System.out.print("> ");
            String kondisiMotor = input.next();
            if (kondisiMotor.equalsIgnoreCase("ya")) {
                motor.periksaKondisi();
            }

            System.out.println();
            System.out.println("Mau servis nda? (ya/tidak)");
            System.out.print("> ");
            String servisMotor = input.next();
            if (servisMotor.equalsIgnoreCase("ya")) {
                Thread.sleep(5000);
                motor.lakukanService();
                Thread.sleep(2000);
                System.out.println("Biaya servis: " + motor.hitungBiayaService("berat"));
                Thread.sleep(2000);
                System.out.println("Servis berikutnya: " + motor.getWaktuServiceBerikutnya());
            }

        } else if (pilihanMenu == 3) {

            Sepeda sepeda = new Sepeda("Poligon", "Premier 4");
            System.out.println();
            System.out.println("DATA SEPEDA");
            System.out.println("---------------");
            System.out.print("input jenis sepeda: ");
            input.nextLine();
            String jenisSepeda = input.nextLine();
            sepeda.setJenisSepeda(jenisSepeda);
            System.out.print("input jumlah gear: ");
            int jumlahGear = input.nextInt();
            sepeda.setJumlahGear(jumlahGear);
            System.out.print("input ukuran roda: ");
            int ukuranRoda = input.nextInt();
            sepeda.setUkuranRoda(ukuranRoda);
            System.out.print("Masukkan kecepatan sepeda: ");
            double kecepatanSepeda = input.nextDouble();
            sepeda.setKecepatan(kecepatanSepeda);

            System.out.println();
            System.out.println("Detail sepeda");
            System.out.println("------------------------");
            System.out.println("Tipe kendaraan: " + sepeda.getTipeKendaraan());
            System.out.println("Merek: " + sepeda.merek);
            System.out.println("Model: " + sepeda.model);
            System.out.println("Jenis sepeda: " + sepeda.getJenisSepeda());
            System.out.println("Jumlah gear: " + sepeda.getJumlahGear());
            System.out.println("Ukuran roda: " + sepeda.getUkuranRoda());
            System.out.println("Kecepatan: " + sepeda.getKecepatan());

            System.out.println();
            System.out.println("Mau lihat pajak? (ya/tidak)");
            System.out.print("> ");
            String pajakSepeda = input.next();
            if (pajakSepeda.equalsIgnoreCase("ya")) {
                System.out.println("Pajak: " + sepeda.hitungPajak());
            }

            System.out.println();
            System.out.println("Mau bergerak? (ya/tidak)");
            System.out.print("> ");
            String bergerakSepeda = input.next();
            if (bergerakSepeda.equalsIgnoreCase("ya")) {
                sepeda.mulai();
            }

            System.out.println();
            System.out.println("Mau berhenti? (ya/tidak)");
            System.out.print("> ");
            String berhentiSepeda = input.next();
            if (berhentiSepeda.equalsIgnoreCase("ya")) {
                sepeda.berhenti();
            }

            System.out.println();
            System.out.println("Mau periksa kondisi sepedamu? (ya/tidak)");
            System.out.print("> ");
            String kondisiSepeda = input.next();
            if (kondisiSepeda.equalsIgnoreCase("ya")) {
                sepeda.periksaKondisi();
            }

            System.out.println();
            System.out.println("Mau servis nda? (ya/tidak)");
            System.out.print("> ");
            String servisSepeda = input.next();
            if (servisSepeda.equalsIgnoreCase("ya")) {
                Thread.sleep(5000);
                sepeda.lakukanService();
                Thread.sleep(2000);
                System.out.println("Biaya servis: " + sepeda.hitungBiayaService("berat"));
                Thread.sleep(2000);
                System.out.println("Servis berikutnya: " + sepeda.getWaktuServiceBerikutnya());
            }

        } else if (pilihanMenu == 4) {
            sapuTerbang sapu = new sapuTerbang("cap Mak Lampir", "Turbo 30000cc");
            System.out.println();
            System.out.println("DATA SAPU TERBANG");
            System.out.println("---------------");
            System.out.print("input berat sapu: ");
            double berat = input.nextDouble();
            sapu.setBerat(berat);
            System.out.print("input panjang sapu: ");
            double panjang = input.nextDouble();
            sapu.setPanjang(panjang);
            System.out.print("Masukkan kecepatan sapu terbang: ");
            double kecepatanSapu = input.nextDouble();
            sapu.setKecepatan(kecepatanSapu);

            System.out.println();
            System.out.println("Detail Sapu Terbang");
            System.out.println("------------------------");
            System.out.println("Tipe kendaraan: " + sapu.getTipeKendaraan());
            System.out.println("Merek: " + sapu.merek);
            System.out.println("Model: " + sapu.model);
            System.out.println("Berat sapu: " + sapu.getBerat());
            System.out.println("Panjang sapu: " + sapu.getPanjang());
            System.out.println("Kecepatan: " + sapu.getKecepatan());

            System.out.println();
            System.out.println("Mau lihat pajak? (ya/tidak)");
            System.out.print("> ");
            String pajakSapu = input.next();
            if (pajakSapu.equalsIgnoreCase("ya")) {
                System.out.println("Pajak: " + sapu.hitungPajak());
            }

            System.out.println();
            System.out.println("Mau bergerak? (ya/tidak)");
            System.out.print("> ");
            String bergerakSapu = input.next();
            if (bergerakSapu.equalsIgnoreCase("ya")) {
                sapu.mulai();
            }

            System.out.println();
            System.out.println("Mau berhenti? (ya/tidak)");
            System.out.print("> ");
            String berhentiSapu = input.next();
            if (berhentiSapu.equalsIgnoreCase("ya")) {
                sapu.berhenti();
            }
        } else if (pilihanMenu == 5) {
            System.out.println("Yaudah..");
        }
    }
}