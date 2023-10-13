public class PlaygroundTest {
    public static void main(String[] args) {
        Tamagotchi t1 = new Tamagotchi();
        System.out.println(t1);

        t1.feed();
        System.out.println("After eating : "+t1);

        t1.playAlone();
        System.out.println("After playing alone : "+t1);
        
        t1.playAlone();
        System.out.println("After playing alone : "+t1);

        Tamagotchi t2 = new Tamagotchi();
        t1.playWith(t2);
        System.out.println("After playing with t2 : "+t1);
    }
}
