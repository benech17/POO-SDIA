package TP2.Dice;
import java.util.ArrayList;
import java.util.List;

public class DieHandle {
    private List<Die> dices;

    public DieHandle() {
        this.dices = new ArrayList<>();
    }

    public void addDie(Die die) {
        this.dices.add(die);
    }

    // Lance tous les dés et renvoie la somme de leurs résultats
    public int roll() {
        int total = 0;
        for (Die die : dices) {
            total += die.roll();
        }
        return total;
    }
}

