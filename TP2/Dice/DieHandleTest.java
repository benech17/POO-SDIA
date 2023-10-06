package TP2.Dice;

public class DieHandleTest {
    
    public static void main(String[] args) {
        DieHandle handle = new DieHandle();

        handle.addDie(Die.withFaces(6));
        handle.addDie(Die.withFaces(12));
        handle.addDie(Die.withFaces(20));
    
            // Lancer tous les dés et afficher le résultat total
        System.out.println("Total après le lancement: " + handle.roll());
    }
    
}
