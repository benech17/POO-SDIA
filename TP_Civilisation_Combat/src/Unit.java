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

    public int getHealth() {
        return health;
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

    @Override
    public String toString() {
        return this.unitType + "[" + this.health + "% | "+ this.experience+ "xp]";
    }

    public void attack(Unit defender, Case attackerCase, Case defenderCase, TerrainType terrain) {
        // Vérifier si l'unité défensive existe sur la defenderCase
        if (defenderCase.getUnit() == null) {
            System.out.println("There's no unit to attack on the target case.");
            return;  // Sortir de la méthode si l'unité défensive est absente
        }

        double[] attackXpModifiers = {1.0, 1.5, 2.0};
        double[] defenseXpModifiers = {1.0, 1.75, 2.5};

        double attack_xp = attackXpModifiers[this.experience - 1];
        double defend_xp = defenseXpModifiers[this.experience - 1];

        // Dd = Ap ∗ Atm + Dti
        double attackDamage = this.attackPower*attack_xp* this.getAttackModifier(defender) + terrain.getAttackModifier(this);
        // Ad=Dp∗Dtm+Ati
        double defenseDamage = defender.defensePower*defend_xp * defender.getDefenseModifier(this) + terrain.getDefenseModifier(defender);
    
        // Appliquer les dégâts
        defender.health -= attackDamage;
        this.health -= defenseDamage;
    
        // Vérifier si l'une des unités est éliminée
        if (defender.health <= 0) {
            defenderCase.removeUnit(); // L'unité défensive est éliminée
            // Déplacez l'unité attaquante vers la case de l'unité défensive
            defenderCase.setUnit(this);
            attackerCase.removeUnit();
        }
    }
}
