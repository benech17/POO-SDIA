package TP2.Dice;
import java.util.Random;


public class Die {
    // attributs 
    private int faces;
    private static final Random rand = new Random();

    // méthodes 
    public int roll() {
        return rand.nextInt(faces) + 1;
    }

    public int faces() {
        return this.faces;
    }

    private Die(int face ){
        this.faces = face; 
    }

    public static Die withFaces(int faces) {
        return new Die(faces);
    }
    
}

