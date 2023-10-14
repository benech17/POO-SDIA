public class CombatTest {

    public static void main(String[] args) {
        testWarriorVsWarrior();
        testKnightVsWarrior();
        testKnightVsPikemanHilly();
        testKnightVsPikemanFlat();
        testArcherVsPikemanFlat();
        testArcherVsPikemanHilly();
    }

    public static void testWarriorVsWarrior() {
        // Initialisation
        Unit warrior1 = new Warrior(100, 1);
        Unit warrior2 = new Warrior(100, 1);
        Case case1 = new Case(TerrainType.FLAT);
        Case case2 = new Case(TerrainType.FLAT);
        case1.setUnit(warrior1);
        case2.setUnit(warrior2);

        // Combat
        warrior1.attack(case2.getUnit(), case1, case2, TerrainType.FLAT);

        // Assertions
        assert warrior1.getHealth() < 100 : "Warrior1 health should be reduced after combat";
        assert warrior2.getHealth() < 100 : "Warrior2 health should be reduced after combat";
    }

    public static void testKnightVsWarrior() {
        // Initialisation
        Unit knight = new Knight(100, 2);
        Unit warrior = new Warrior(100, 3);
        Case case1 = new Case(TerrainType.HILLY);
        Case case2 = new Case(TerrainType.HILLY);
        case1.setUnit(knight);
        case2.setUnit(warrior);

        // Combat
        knight.attack(case2.getUnit(), case1, case2, TerrainType.HILLY);

        // Assertions
        assert knight.getHealth() < 100 : "Knight health should be reduced after combat";
        assert warrior.getHealth() < 100 : "Warrior health should be reduced after combat";
    }

    public static void testKnightVsPikemanHilly() {
        // Initialisation
        Unit knight = new Knight(100, 2);
        Unit pikeman = new Pikeman(100, 3);
        Case case1 = new Case(TerrainType.HILLY);
        Case case2 = new Case(TerrainType.HILLY);
        case1.setUnit(knight);
        case2.setUnit(pikeman);

        // Combat
        knight.attack(case2.getUnit(), case1, case2, TerrainType.HILLY);

        // Assertions
        assert knight.getHealth() < 100 : "Knight health should be reduced after combat in hilly terrain";
        assert pikeman.getHealth() < 100 : "Pikeman health should be reduced after combat in hilly terrain";
    }

    public static void testKnightVsPikemanFlat() {
        // Initialisation
        Unit knight = new Knight(100, 2);
        Unit pikeman = new Pikeman(100, 3);
        Case case1 = new Case(TerrainType.FLAT);
        Case case2 = new Case(TerrainType.FLAT);
        case1.setUnit(knight);
        case2.setUnit(pikeman);

        // Combat
        knight.attack(case2.getUnit(), case1, case2, TerrainType.FLAT);

        // Assertions
        assert knight.getHealth() < 100 : "Knight health should be reduced after combat in flat terrain";
        assert pikeman.getHealth() < 100 : "Pikeman health should be reduced after combat in flat terrain";
    }

    public static void testArcherVsPikemanFlat() {
        // Initialisation
        Unit archer = new Archer(100, 1);
        Unit pikeman = new Pikeman(100, 3);
        Case case1 = new Case(TerrainType.FLAT);
        Case case2 = new Case(TerrainType.FLAT);
        case1.setUnit(archer);
        case2.setUnit(pikeman);

        // Combat
        archer.attack(case2.getUnit(), case1, case2, TerrainType.FLAT);

        // Assertions
        assert archer.getHealth() < 100 : "Archer health should be reduced after combat in flat terrain";
        assert pikeman.getHealth() < 100 : "Pikeman health should be reduced after combat in flat terrain";
    }

    public static void testArcherVsPikemanHilly() {
        // Initialisation
        Unit archer = new Archer(100, 1);
        Unit pikeman = new Pikeman(100, 3);
        Case case1 = new Case(TerrainType.HILLY);
        Case case2 = new Case(TerrainType.HILLY);
        case1.setUnit(archer);
        case2.setUnit(pikeman);

        // Combat
        archer.attack(case2.getUnit(), case1, case2, TerrainType.HILLY);

        // Assertions
        assert archer.getHealth() < 100 : "Archer health should be reduced after combat in hilly terrain";
        assert pikeman.getHealth() < 100 : "Pikeman health should be reduced after combat in hilly terrain";
    }
}