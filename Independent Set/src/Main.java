import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Graphe g = new Graphe(13);
        int [] X = new int[g.size];
        g.addArc(0,1);
        g.addArc(0,2);
        g.addArc(0,8);
        g.addArc(1,4);
        g.addArc(1,11);
        g.addArc(2,4);
        g.addArc(2,9);
        g.addArc(4,5);
        g.addArc(5,6);
        g.addArc(5,7);
        g.addArc(5,10);

        // Q1 :
        // Cas valide .
        for (int i = 0; i < g.size; i++) {
            if (i == 1 || i == 2 || i == 3 || i == 6) X[i] = 1; // X = [0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0]
        }
        System.out.println(ZoneVide.isZoneVide(g, X));
        // Cas invalide.
        for (int i = 0; i < g.size; i++) {
            if (i == 1 || i == 2 || i == 3 || i == 4) X[i] = 1; // X = [0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0]
        }
        System.out.println(ZoneVide.isZoneVide(g, X));

        // Q2 :
        System.out.println("======== Zone Vide Maximale");
        ZoneVide.afficheZoneVide(ZoneVide.getZoneVideMaximal(g));
        // Q3 :
        long debut0 = System.nanoTime();
        System.out.println("\n======== Zone Vide Maximum");
        ZoneVide.afficheZoneVide(ZoneVide.getZoneVideMaximum(g));
        long fin0 = System.nanoTime();
        System.out.println("\n Temps d'éxecution : " + (fin0 - debut0) + "NS");
        // Q4 :
        System.out.println("\n======== Zone Vide Maximum Incomplète");
        long debut1 = System.nanoTime();
        ZoneVide.afficheZoneVide(ZoneVide.getZoneVideMaximumIncomplete(g));
        long fin1 = System.nanoTime();
        System.out.println("\n Temps d'éxecution : " + (fin1 - debut1) + "NS");

        // Test d’efficacité.
        Graphe g1 = new Graphe(700);
        Random r = new Random();
        int r1, r2;
        for (int i = 0; i < g1.size; i++) {
            r1 = r.nextInt(25);
            r2 = r.nextInt(25);
            if (r1 != r2) g1.addArc(r1, r2);
        }
        // Q3 :
        long debut2 = System.nanoTime();
        System.out.println("\n======== Zone Vide Maximum");
        System.out.println("Le nombre d'elements de la zone vide :" + ZoneVide.cuntOne(ZoneVide.getZoneVideMaximum(g1)));
        ZoneVide.afficheZoneVide(ZoneVide.getZoneVideMaximum(g1));
        long fin2 = System.nanoTime();
        System.out.println("\n Temps d'éxecution : " + (fin2 - debut2) / 1000_000 + "MS");
        // Q4 :
        long debut3 = System.nanoTime();
        System.out.println("\n======== Zone Vide Maximum Incomplète");
        System.out.println("Le nombre d'elements de la zone vide :" + ZoneVide.cuntOne(ZoneVide.getZoneVideMaximumIncomplete(g1)));
        ZoneVide.afficheZoneVide(ZoneVide.getZoneVideMaximumIncomplete(g1));
        long fin3 = System.nanoTime();
        System.out.println("\n Temps d'éxecution : " + (fin3 - debut3) /1000_000 + "MS");

    }
}
