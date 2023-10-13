public class Dog extends Tamagotchi {
    
    @Override
    public void feed() {
        this.happinessLevel = 5;
        super.feed();
    }
}