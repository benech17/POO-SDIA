
public class HappyState implements State {
    @Override
    public void makeHappy(Tamagotchi tamagotchi) {
        // nothing changes
    }

    @Override
    public void makeSad(Tamagotchi tamagotchi) {
        tamagotchi.setState(new SadState());
    }

    @Override
    public void makeHungry(Tamagotchi tamagotchi) {
        tamagotchi.setState(new HungryState());
    }
}
