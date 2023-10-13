
public class TamagotchiTest {

    private static int passedTests = 0;
    private static int failedTests = 0;

    public static void main(String[] args) {
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
       

        System.out.println("\nTests completed!");
        System.out.println("Passed: " + passedTests);
        System.out.println("Failed: " + failedTests);
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

    private static void checkCondition(boolean condition, String testName) {
        if (condition) {
            System.out.println(testName + " - Passed");
            passedTests++;
        } else {
            System.out.println(testName + " - Failed");
            failedTests++;
        }
    }

}

