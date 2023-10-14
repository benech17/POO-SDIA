public class CombatTest {

      // Variables statiques pour le nombre de tests réussis et échoués
    private static int passedTests = 0;
    private static int failedTests = 0;

    // Coloration de la sortie console
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        CombatTest tester = new CombatTest();
        tester.runAllTests();
        tester.displayResult(passedTests,failedTests);
    }

    public void runAllTests(){
        try{
            testWarriorVsWarrior();
            testKnightVsWarrior();
            testKnightVsPikemanHilly();
            testKnightVsPikemanFlat();
            testArcherVsPikemanFlat();
            testArcherVsPikemanHilly();
        }catch (AssertionError e) {
            failedTests++;
            System.out.println(" >> "+ANSI_RED + e.getMessage() + " - Failed"+ANSI_RESET);
        }
    }

    public void displayResult(int passedTests, int failedTests){
        System.out.println("\n+------------------ Tests completed ! ------------------+");
        System.out.println("|"+ANSI_GREEN+"     Passed: " + passedTests +ANSI_RESET+"                                         |");
        System.out.println("|"+ANSI_RED+"     Failed: " + failedTests +ANSI_RESET+"                                         |");
        System.out.println("+-------------------------------------------------------+");

    }
    
    public static void testWarriorVsWarrior() {
        String testName = "test Warrior Vs Warrior" ;

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
        assert warrior1.getHealth() == 90 : "Warrior1 health should be equal to 90";
        assert warrior2.getHealth() == 90 : "Warrior2 health should be equal to 90";
        passedTests++;
        System.out.println("  >> "+ANSI_GREEN+ testName + " - Passed"+ANSI_RESET);

    }

    public static void testKnightVsWarrior() {
        String testName = "test Knight Vs Warrior" ;

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
        assert knight.getHealth() == 75 : "Knight health should be reduced after combat";
        assert warrior.getHealth() == 20 : "Warrior health should be reduced after combat";
        passedTests++;
        System.out.println("  >> "+ANSI_GREEN+ testName + " - Passed"+ANSI_RESET);

    }

    public static void testKnightVsPikemanHilly() {
        String testName = "test Knight Vs Pikeman Hilly" ;

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
        assert knight.getHealth() == 0 : "Knight health should be reduced after combat in hilly terrain";
        assert pikeman.getHealth() == 50 : "Pikeman health should be reduced after combat in hilly terrain";
        passedTests++;
        System.out.println("  >> "+ANSI_GREEN+ testName + " - Passed"+ANSI_RESET);

    }

    public static void testKnightVsPikemanFlat() {
        String testName = "test Knight Vs Pikeman Flat" ;

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
        assert knight.getHealth() == 0 : "Knight health should be reduced after combat in flat terrain";
        assert pikeman.getHealth() == 70 : "Pikeman health should be reduced after combat in flat terrain";
        passedTests++;
        System.out.println("  >> "+ANSI_GREEN+ testName + " - Passed"+ANSI_RESET);

    }

    public static void testArcherVsPikemanFlat() {
        String testName = "test ArcherVsPikeman Flat" ;
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
        assert archer.getHealth() == 50 : "Archer health should be reduced after combat in flat terrain";
        assert pikeman.getHealth() == 80 : "Pikeman health should be reduced after combat in flat terrain";
        passedTests++;
        System.out.println("  >> "+ANSI_GREEN+ testName + " - Passed"+ANSI_RESET);

    }

    public static void testArcherVsPikemanHilly() {
        String testName = "test ArcherVsPikeman Hilly" ; 
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
        assert archer.getHealth() == 50 : "Archer health should be reduced after combat in hilly terrain";
        assert pikeman.getHealth() == 70 : "Pikeman health should be reduced after combat in hilly terrain";
        passedTests++;
        System.out.println("  >> "+ANSI_GREEN+ testName + " - Passed"+ANSI_RESET);

    }
}