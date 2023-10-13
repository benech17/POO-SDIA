public class Pikeman extends Unit {
    public Pikeman(int health, int experience) {
        super("Pikeman", health, experience, 5, 20);
    }
    
    @Override
    public int getDefenseModifier(Unit attacker) { //DTM = coef
        if (attacker instanceof Knight) {
            return 2;
        }
        return 1;
    }
}