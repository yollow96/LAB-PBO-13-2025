public class Pelindung {
    String badan;
    String kepala;

    public String getPelindung(){
        return "Atasan " + kepala + ", Badan " + badan;
    }

    public int getDef(int random){
        // int defense = 0;
        if (random == 0){
            if (badan.equalsIgnoreCase("Hoodie")){
                return 4;
            }else {
                return 2;
            }
        }else {
            if (kepala.equalsIgnoreCase("Helm")){
                return 5;
            }else {
                return 3;
            }
        }
        // return defense;
    }
}
