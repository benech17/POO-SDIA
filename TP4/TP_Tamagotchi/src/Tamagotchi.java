public class Tamagotchi {
    private State state;
    private int happinessLevel;
    private int playCountSinceLastMeal;

    // constructor
    public Tamagotchi() {
        this.happinessLevel = 0;
        this.state = new HappyState();
        this.playCountSinceLastMeal = 0;
    }

    // setter
    public void setState(State state) {
        this.state = state;
    }

    // getter
    public int getHappinessLevel() {
        return happinessLevel;
    }

    @Override
    public String toString() {
        String stateEmoji;
        if (state instanceof HappyState) {
            stateEmoji = "\uD83D\uDE01";  // 😀
        } else if (state instanceof SadState) {
            stateEmoji = "\uD83D\uDE22";  // 😢
        } else {
            stateEmoji = "\uD83C\uDF54";  // 🍔
        }
        return "Tamagotchi { " + 
               "State: " + state.getClass().getSimpleName().split("State")[0]+" "+stateEmoji +
               ", Happiness lvl: " + happinessLevel + 
               " }";
    }

    // Actions Eating
    public void feed() throws IllegalStateException { 
        this.playCountSinceLastMeal = 0;  // Reset play count after feeding
        if (state instanceof HappyState) {
            this.happinessLevel ++ ;
        }
        if (state instanceof HungryState) {
            makeHappy();
        }
        // modif avec try-catch
        if (state instanceof SadState) {
            throw new IllegalStateException("I'm sad, I don't wanna eat :( "); 
        }
    }

    // Actions Playing alone
    public void playAlone() {
        this.playCountSinceLastMeal ++;
        if (state instanceof HungryState) {
            this.happinessLevel -= 4;
        } 
        else if (state instanceof HappyState) {
            this.happinessLevel += 2;
            if (this.playCountSinceLastMeal >= 2) {
                makeHungry();
            }
        }
        else if (state instanceof SadState) {
            makeHappy();
        } 
    }
   
    public void playWithOther(Tamagotchi friend){
        //if (this.state.getClass().getSimpleName().split("State")[0] =="Hungry" || friend.state) 
    }

    public void ignore() {
        happinessLevel--;
        if (happinessLevel <= -2) {
            makeSad();
        }
    }

    public void makeHappy() {
        state.makeHappy(this);
    }

    public void makeSad() {
        state.makeSad(this);
    }

    public void makeHungry() {
        state.makeHungry(this);
    }
}
