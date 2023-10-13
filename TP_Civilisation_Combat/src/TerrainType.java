public enum TerrainType {
    FLAT("Flat Terrain", 0, 0),
    HILLY("Hilly Terrain", 0, 10);

    private final String name;
    private final int attackModifier;
    private final int defenseModifier;

    TerrainType(String name, int attackModifier, int defenseModifier) {
        this.name = name;
        this.attackModifier = attackModifier;
        this.defenseModifier = defenseModifier;
    }

    public String getName() {
        return name;
    }

    public int getAttackModifier(Unit attacker) {
        return attackModifier;
    }

    public int getDefenseModifier(Unit attacker) {
        if (this == HILLY && attacker instanceof Knight) {
            return defenseModifier * 2;
        }
        return defenseModifier;
    }
}