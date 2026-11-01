import java.util.Random;

public class Tamagotchi {
    private static final Random alea = new Random();

    private int age;
    private int dureeDeVie;
    private int maxEnergie;
    private int energie;
    private String nom;

    // Question 1 : constructeur
    public Tamagotchi(String nom) {
        this.nom = nom;
        this.age = 0;
        this.dureeDeVie = 9 + alea.nextInt(6);        // 9 à 14
        this.maxEnergie = 5 + alea.nextInt(5);        // 5 à 9
        this.energie = 3 + alea.nextInt(maxEnergie - 2); // 3 à maxEnergie
    }

    public String getNom() {
        return nom;
    }

    // Question 2 : parler
    public void parler() {
        if (energie > 5) {
            System.out.println(nom + " : tout va bien ! (heureux)");
        } else {
            System.out.println(nom + " : je suis affamé !");
        }
    }

    // Question 3 : manger
    public void manger() {
        if (energie >= maxEnergie) {
            System.out.println(nom + " : je n'ai pas faim !!");
        } else {
            energie = Math.min(maxEnergie, energie + 1 + alea.nextInt(3)); // +1 à +3, plafonné
            System.out.println(nom + " : Merci !");
        }
    }

    // Question 4 : âge limite atteint ?
    public boolean ageLimite() {
        return age >= dureeDeVie;
    }

    // Question 5 : vivre
    public boolean vivre() {
        if (age == dureeDeVie) {              // (a)
            return true;
        }
        if (energie <= 0) {                   // (b)
            System.out.println(nom + " : je meurs... Arrrggh !");
            return false;
        }
        age++;                                // (c)
        energie--;
        if (ageLimite()) {
            System.out.println(nom + " : c'est gagné pour moi !");
        } else {
            parler();
        }
        return true;
    }
}
