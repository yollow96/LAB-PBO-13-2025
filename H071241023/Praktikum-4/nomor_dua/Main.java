package Nomor2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("PIlih bangun ruang: ");
        System.out.println("1. Balok");
        System.out.println("2. Kubus");
        System.out.println("3. Bola");
        System.out.println("Pilihan: ");
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                System.out.println("Masukkan panjang: ");
                double panjang = input.nextDouble();
                input.nextLine();

                System.out.println("Masukkan lebar: ");
                double lebar = input.nextDouble();
                input.nextLine();

                System.out.println("Masukkan tinggi: ");
                double tinggi = input.nextDouble();
                input.nextLine();

                Balok balok = new Balok(panjang, lebar, tinggi);
                System.out.println("Volume balok: " + balok.getVolume());
                System.out.println("Luas permukaan balok: " + balok.getLuasPermukaan());
                break;

            case 2:
                System.out.println("Masukkan sisi: ");
                double sisi = input.nextDouble();
                Kubus kubus = new Kubus(sisi);
                System.out.println("Volume kubus: " + kubus.getVolume());
                System.out.println("Luas kubus: " + kubus.getLuasPermukaan());
                break;

            case 3:
                System.out.println("Masukkan jari-jari: ");
                double jariJari = input.nextDouble();
                Bola bola = new Bola(jariJari);
                System.out.println("Volume bola: " + bola.getVolume());
                System.out.println("Volume bola: " + bola.getLuasPermukaan());
                break;

            default:
                System.out.println("Pilihan tidak valid");
        }
    }
}


