
public class SadState implements State {
    @Override
    public void makeHappy(Tamagotchi tamagotchi) {
        tamagotchi.setState(new HappyState());
    }

    @Override
    public void makeSad(Tamagotchi tamagotchi) {
        // nothing changes
    }

    @Override
    public void makeHungry(Tamagotchi tamagotchi) {
        tamagotchi.setState(new HungryState());
    }
}
