package TP2.Dice;

public class DieTest {
    public static void main(String[] args) {
        Die d6 = Die.withFaces(6);
        System.out.println("Dé avec " + d6.faces() + " face : ");
        for (int i = 0; i < 10; i++) {
            System.out.println("Lancement: " + d6.roll());
        }

        Die d20 = Die.withFaces(20);
        System.out.println("Dé avec " + d20.faces() + " faces :");
        for (int i = 0; i < 10; i++) {
            System.out.println("Lancement: " + d20.roll());
        }
    }
}
