public class Tamagotchi {
    private State state;
    protected int happinessLevel;
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
        return "Le Tamagotchi est " + state.getClass().getSimpleName().split("State")[0]+" "+stateEmoji +
               " avec un Happiness lvl de : " + happinessLevel ;
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

    // Actions Eating
    public void feed() throws IllegalStateException { 
        this.playCountSinceLastMeal = 0;  // Reset play count after feeding
        try {
            if (state instanceof HappyState) {
                this.happinessLevel ++ ;
            }
            if (state instanceof HungryState) {
                makeHappy();
            }
        
            if (state instanceof SadState) {
                throw new IllegalStateException("I'm sad, I don't wanna eat :( "); 
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());     
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
   
    public void playWith(Tamagotchi otherPet){
        if (this.state instanceof HungryState || otherPet.state instanceof HungryState) {
            return;  // If any pet is hungry, they don't play
        }

        if (this.state instanceof HappyState) {
            this.happinessLevel += 4;
            this.playCountSinceLastMeal++;
            if (this.playCountSinceLastMeal >= 2) {
                this.makeHungry();
            }
        } else if (this.state instanceof SadState) {
            this.makeHappy();
        }

        if (otherPet.state instanceof HappyState) {
            otherPet.happinessLevel += 4;
            otherPet.playCountSinceLastMeal++;
            if (otherPet.playCountSinceLastMeal >= 2) {
                otherPet.makeHungry();
            }
        } else if (otherPet.state instanceof SadState) {
            otherPet.makeHappy();
        }
    }

}
