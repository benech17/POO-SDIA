public class Knight extends Unit {
    private boolean isCharging;

    public Knight(int health, int experience) {
        super("Knight", health, experience, 20, 5);
    }

    public void charge() {
        isCharging = true;
    }

    @Override
    public int getAttackModifier(Unit defender) {
        if (isCharging && !(defender instanceof Pikeman)) {
            return 2;
        }
        return 1;
    }

    // Réinitialise l'état de charge après une attaque
    public void resetCharge() {
        isCharging = false;
    }
}
