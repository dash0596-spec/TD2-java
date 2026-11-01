import java.util.Scanner;

public class SimulTamagotchis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 0;
while (n <= 0) {
    System.out.print("Combien de tamagotchis ? ");
    try {
        n = Integer.parseInt(sc.nextLine().trim());
        if (n <= 0) {
            System.out.println("Veuillez taper un nombre supérieur à 0.");
        }
    } catch (NumberFormatException e) {
        System.out.println("Veuillez taper un nombre.");
    }
}

        Tamagotchi[] colonie = new Tamagotchi[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Quel nom pour le nouveau tamagotchi : ");
            colonie[i] = new Tamagotchi(sc.nextLine().trim());
        }

        int cycle = 0;
        while (true) {
            cycle++;
            System.out.println("-------Cycle no " + cycle + " -------");

            // 1) Tous les tamagotchis vivent ; si l'un meurt -> perdu
            for (Tamagotchi t : colonie) {
                if (!t.vivre()) {
                    System.out.println("PERDU !!");
                    return;
                }
            }

            // 2) Tous ont atteint l'âge limite -> gagné
            boolean tousArrives = true;
            for (Tamagotchi t : colonie) {
                if (!t.ageLimite()) {
                    tousArrives = false;
                }
            }
            if (tousArrives) {
                System.out.println("GAGNÉ !!");
                return;
            }

            // 3) Menu : seuls ceux qui n'ont pas fini sont proposés
            for (int i = 0; i < n; i++) {
                if (!colonie[i].ageLimite()) {
                    System.out.print("(" + i + ") " + colonie[i].getNom() + " ");
                }
            }
            System.out.println();
 boolean nourri = false;
while (!nourri) {
    System.out.print("Nourrir quel tamagotchi ? ");
    try {
        int choix = Integer.parseInt(sc.nextLine().trim());
        if (choix >= 0 && choix < n && !colonie[choix].ageLimite()) {
            colonie[choix].manger();
            nourri = true;
        } else {
            System.out.println("Numéro invalide, recommencez.");
        }
    } catch (NumberFormatException e) {
        System.out.println("Veuillez taper un nombre.");
    }
}
       }
    }
}
