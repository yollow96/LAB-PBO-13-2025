package TypeRacer;

import java.util.ArrayList;
import java.util.Random;

public class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> raceContestant = new ArrayList<>();
    private ArrayList<Result> raceStanding = new ArrayList<>();

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRaceContestant() {
        return raceContestant;
    }

    // Bisa diganti sesuai keinginan masing-masing
    private String[] wordsToTypeList = {
            "Di Bikini Bottom ada Spongebob Squarepants, dia memang keren suka main drumband",
            "Dia jadi koki masaknya krabby patty, menjalani hari hidup bersama Garry",
            "Ayo sama-sama sebutkan nama-nama makhluk dalam sana di Bikini Bottom jaya",
            "Namun ada juga namanya Patrick Star, walau dia cetar tapi hidupnya liar",
            "Tinggal dalam batu tapi suka membantu, sayang hanya satu otaknya itu buntu"
    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    // TODO (4)
    // Buat method addResult yang mana digunakan untuk menambahkan typer yang
    // telah selesai (mengetik semua kata), ke dalam list race standing.

    public void addResult(Result typer) {
        if (!raceStanding.contains(typer)) {
            raceStanding.add(typer);
        }
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================\n");

        // TODO (5)
        // Tampilkan klasemen akhir dari kompetisi, dengan format
        // {posisi}. {nama} = {waktu penyelesaian dalam detik} detik

        for (int i = 0; i < raceStanding.size(); i++) {
            Result typer = raceStanding.get(i);
            System.out.println((i + 1) + ". " + typer.getName() + " = " + typer.getFinishTime() + " detik");
        }
    }

    public void startRace() {
        // TODO (6)
        // Jalankan kompetisi untuk tiap kontestan

        for (Typer typer : raceContestant) {
            typer.start();
        }
    }

    // TODO (7)
    // selama semua peserta belum selesai maka tampilkan typing progress-nya setiap
    // 2 detik, dengan format:
    // Typing Progress ...
    // ===================
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}


    public void displayRaceStandingPeriodically() throws InterruptedException {

        while (raceStanding.size() < raceContestant.size()) {
            System.out.println("Typing Progress ...");
            System.out.println("===================");

            for (Typer tukangKetik : raceContestant) {
                System.out.println(tukangKetik.getBotName() + " => " + tukangKetik.getWordsTyped());
            }

            System.out.println();
            Thread.sleep(2000);
        }

        // TODO (8)
        // Setelah semua typer selesai, tampilkan race standing setelah semua typer
        // selesai

        System.out.println("Typing Progress ...");
        System.out.println("===================");

        for (Typer tukangKetik : raceContestant) {
            System.out.println(tukangKetik.getBotName() + " => " + tukangKetik.getWordsTyped());
        }

        System.out.println();

        printRaceStanding();
    }
}
