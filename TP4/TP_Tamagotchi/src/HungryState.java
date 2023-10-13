
public class HungryState implements State {
    @Override
    public void makeHappy(Tamagotchi tamagotchi) {
        tamagotchi.setState(new HappyState());
    }

    @Override
    public void makeSad(Tamagotchi tamagotchi) {
        tamagotchi.setState(new SadState());
    }

    @Override
    public void makeHungry(Tamagotchi tamagotchi) {
        // nothing changes
    }
}
