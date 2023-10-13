
public class TestTamagotchi {
    public static void main(String[] args) {
        Tamagotchi tamaHappy = new Tamagotchi();
        Tamagotchi tamaHungry = new Tamagotchi();
        Tamagotchi tamaSad = new Tamagotchi();
        tamaHungry.makeHungry();
        tamaSad.makeSad();

        /* 
        //---------------- Test EATING --------------
        System.out.println("Initial state: " + tamaHappy); //happy 0
        System.out.println("Initial state: " + tamaHungry); //happy 0
        System.out.println("Initial state: " + tamaSad); //happy 0
        System.out.println(" >>>>>>>>>>> A TAAAAABBLLEEEEE <<<<<<<<<<<<<< "); 
        
        tamaHappy.feed(); 
        System.out.println("After eating : " + tamaHappy); //happy 1

        tamaHungry.feed();
        System.out.println("After eating : " + tamaHungry); //happy 0

        tamaSad.feed();
        System.out.println("After eating : " + tamaSad); //Error
        */

        tamaHappy.playAlone();
        System.out.println("After playing: " + tamaHappy); 
        tamaHappy.playAlone();
        System.out.println("After playing: " + tamaHappy); //sould be hungry now

        tamaHungry.playAlone(); 
        System.out.println("After playing: " + tamaHungry); // -4

        tamaSad.playAlone();
        System.out.println("After playing: " + tamaSad); // happy


        /*tama1.ignore();
        System.out.println("After ignoring: " + tama1);

        tama1.makeHungry();
        System.out.println("After making hungry: " + tama1);

        tama1.feed();
        System.out.println("After feeding again: " + tama1);*/
    }
}
