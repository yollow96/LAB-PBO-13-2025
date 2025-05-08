public class TP3_1_H071241023 {
    public static void main(String[] args) {
        BattlePower char1 = new BattlePower("Budi", 7, new Kekuatan("api", 50));
        BattlePower char2 = new BattlePower("Udin", 8, new Kekuatan("api", 40));
        System.out.println("\n--------- HASIL ---------");
        System.out.println("\n-------------------------");
        System.out.println("| " + char1.tryBattlePower(char2) + "  |");
        System.out.println("-------------------------\n");
        char1.tampilkanInfo();
        char2.tampilkanInfo();
    }
}



