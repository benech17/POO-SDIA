
public abstract class Unit {
    private String unitType;
    private int health;
    private int experience;
    private int attackPower;
    private int defensePower;

    public Unit(String unitType, int health, int experience, int attackPower, int defensePower) {
        this.unitType = unitType;
        this.health = health;
        this.experience = experience;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    // Modificateur appliqué à la puissance d'attaque de cette unité lorsqu'elle attaque une autre unité
    public int getAttackModifier(Unit defender) {
        return 1; // Par défaut, pas de modification. Peut être surchargé par des sous-classes.
    }

    // Modificateur appliqué à la puissance de défense de cette unité lorsqu'elle est attaquée par une autre unité
    public int getDefenseModifier(Unit attacker) {
        return 1; // Par défaut, pas de modification. Peut être surchargé par des sous-classes.
    }

    // ... autres méthodes comme attack, defend, isAlive, etc. ...

    @Override
    public String toString() {
        return unitType + "[" + health + "% | "+ experience+ "xp]";
    }
}
