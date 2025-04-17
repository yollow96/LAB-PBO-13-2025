class BattlePower {
    String name;
    int level;
    Kekuatan kekuatan;

    public BattlePower() {
        this.name = "Unknown";
        this.level = 0;
        this.kekuatan = new Kekuatan();
    }

    public BattlePower(String name, int level, Kekuatan kekuatan) {
        this.name = name;
        this.level = level;
        this.kekuatan = kekuatan;
    }

    public String tryBattlePower(BattlePower enemy) {
        int myPower = this.kekuatan.power;
        int enemyPower = enemy.kekuatan.power;

        if (elemenCounter(this.kekuatan.elemen, enemy.kekuatan.elemen)) {
            myPower += 10;
        }

        if (elemenCounter(enemy.kekuatan.elemen, this.kekuatan.elemen)) {
            enemyPower += 10;
        }
        return levelUp(enemy, myPower, enemyPower);
    }

    public String levelUp(BattlePower enemy, int myPower, int enemyPower) {
        this.kekuatan.power = myPower;
        enemy.kekuatan.power = enemyPower;

        if (myPower > enemyPower) {
            this.level++;
            return "Selamat! " + this.name + " menang";
        } else if (myPower < enemyPower) {
            enemy.level++;
            return "Selamat! " + enemy.name + " menang";
        } else {
            return "Waduh.. seri bro";
        }
    }

    public boolean elemenCounter(String e1, String e2) {
        return (e1.equals("air") && e2.equals("api")) ||
                (e1.equals("api") && e2.equals("tanah")) ||
                (e1.equals("tanah") && e2.equals("udara")) ||
                (e1.equals("udara") && e2.equals("air"));
    }

    public void tampilkanInfo() {
        System.out.println("Nama   : " + name);
        System.out.println("Level  : " + level);
        System.out.println("Elemen : " + kekuatan.elemen);
        System.out.println("Power  : " + kekuatan.power);
        System.out.println();
    }
}