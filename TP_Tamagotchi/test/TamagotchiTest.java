
public class TamagotchiTest {

    // variables static pour le nb de test passed or failed
    private static int passedTests = 0;
    private static int failedTests = 0;

    // coloration sortie console
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";


    public static void main(String[] args) {
    
        /* To test a set of test cases covering all features, 
        we decided to test each method for the three states, 
        to be sure of its behaviour.*/
        
        // test Feed method
        testFeedHappyTamagotchi();
        testFeedSadTamagotchi();
        testFeedHungryTamagotchi();

        // test PlayAlone()
        testPlayAloneHappyTamagotchi();
        testPlayAloneSadTamagotchi();
        testPlayAloneHungryTamagotchi();

        // test PlayWith()
        testPlayWithBothHappy();
        testPlayWithOneSad();

        // test Dog and Cat implementation 
        testDogFeed();
        testLonelyCatPlayWith();

        System.out.println("\n+------------------ Tests completed ! ------------------+");
        System.out.println("|"+ANSI_GREEN+"     Passed: " + passedTests +ANSI_RESET+"                                        |");
        System.out.println("|"+ANSI_RED+"     Failed: " + failedTests +ANSI_RESET+"                                         |");
        System.out.println("+-------------------------------------------------------+");

    }

    private static void testFeedHappyTamagotchi() {
        Tamagotchi pet = new Tamagotchi();
        int initialHappiness = pet.getHappinessLevel();
        pet.feed();
        checkCondition(pet.getHappinessLevel() == initialHappiness + 1, "testFeedHappyTamagotchi");
    }

    private static void testFeedSadTamagotchi() {
        Tamagotchi pet = new Tamagotchi();
        pet.makeSad();
        
        // Redirect System.out to capture the printed messages
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Execute the method that should print the exception message
        pet.feed();

        // Restore the original System.out
        System.setOut(new java.io.PrintStream(new java.io.FileOutputStream(java.io.FileDescriptor.out)));

        // Check if the expected message was printed
        boolean exceptionMessagePrinted = outContent.toString().contains("I'm sad, I don't wanna eat :(");
        checkCondition(exceptionMessagePrinted, "testFeedSadTamagotchi");
    }

    private static void testFeedHungryTamagotchi() {
        Tamagotchi pet = new Tamagotchi();
        pet.makeHungry();
        pet.feed();
        checkCondition(pet.toString().contains("Happy"), "testFeedHungryTamagotchi");
    }

    private static void testPlayAloneHappyTamagotchi() {
        Tamagotchi pet = new Tamagotchi();
        int initialHappiness = pet.getHappinessLevel();
        pet.playAlone();
        checkCondition(pet.getHappinessLevel() == initialHappiness + 2, "testPlayAloneHappyTamagotchi");
    }

    private static void testPlayAloneSadTamagotchi() {
        Tamagotchi pet = new Tamagotchi();
        pet.makeSad();
        pet.playAlone();
        checkCondition(pet.toString().contains("Happy"), "testPlayAloneSadTamagotchi");
    }

    private static void testPlayAloneHungryTamagotchi() {
        Tamagotchi pet = new Tamagotchi();
        pet.makeHungry();
        pet.playAlone();
        checkCondition(pet.getHappinessLevel() == -4, "testPlayAloneHungryTamagotchi");
    }

    private static void testPlayWithBothHappy() {
        Tamagotchi pet1 = new Tamagotchi();
        Tamagotchi pet2 = new Tamagotchi();
        pet1.playWith(pet2);
        checkCondition(pet1.getHappinessLevel() == 4 && pet2.getHappinessLevel() == 4, "testPlayWithBothHappy");
    }

    private static void testPlayWithOneSad() {
        Tamagotchi pet1 = new Tamagotchi();
        Tamagotchi pet2 = new Tamagotchi();
        pet1.makeSad();
        pet1.playWith(pet2);
        checkCondition(pet1.toString().contains("Happy") && pet2.getHappinessLevel() == 4, "testPlayWithOneSad");
    }

    private static void testDogFeed() {
        Dog dog = new Dog();
        dog.feed();
        checkCondition(dog.getHappinessLevel() == 6, "testDogFeed"); // 5 + 1 from super.feed()
    }

    private static void testLonelyCatPlayWith() {
        LonelyCat lonelyCat = new LonelyCat();
        Tamagotchi otherPet = new Tamagotchi();
        lonelyCat.playWith(otherPet);
        checkCondition(lonelyCat.toString().contains("Sad"), "testLonelyCatPlayWith");
    }

    private static void checkCondition(boolean condition, String testName) {
        if (condition) {
            System.out.println("  >> "+ANSI_GREEN+testName + " - Passed"+ANSI_RESET);
            passedTests++;
        } else {
            System.out.println("  >> "+ANSI_RED+ testName + " - Failed"+ANSI_RESET);
            failedTests++;
        }
    }

}

