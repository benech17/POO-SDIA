package TP2;

public class Test {
    public static void main(String[] args) {
        System.out.println("Welcome to Java");
        whoami("Yaniv", 24, true, 2000);
    }

    String nom = "Yaniv"; 
    int age = 24 ; // my Age 
    boolean isTall = true ;
    float cash = -9000.50 ; 
    final bool isBorn = true ;

    public static String whoami(String n, int a, boolean i, float c){
        String result = "Bonjour, je m'appelle"+n;
        return result;
    }


}
