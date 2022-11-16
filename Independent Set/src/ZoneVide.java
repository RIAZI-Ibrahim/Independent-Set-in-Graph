import java.util.*;

public class ZoneVide {
            public static boolean isZoneVide(Graphe g, int [] X){
            for (int i = 0; i < g.size; i++) {
                if (X[i] == 1) {
                    for (int v : g.Arcs.get(i)) {
                        if(X[v] == 1) return false;
                    }
                }
            }
            return true;
        }

        public static int [] getZoneVideMaximal(Graphe g){
            int [] X = new int [g.size];
            for (int i = 0; i < g.size; i++) {
                X[i] = 1;
                if (!isZoneVide(g, X)) X[i] = 0;
            }
            return X;
        }
    public static int cuntOne(int [] T){
        int cpt = 0;
        for (int v : T) {
           if (v == 1) cpt ++;
        }
        return cpt;
    }
    public static int [] getZoneVideMaximum(Graphe g){
        int [] X = new int [g.size];
        int [] Y = new int [g.size];
        int cpt = 0;
        for (int i = 0; i < g.size; i++) {
            g.sommets.set(0, i);
            g.sommets.set(i, 0);
            for (int s : g.sommets) {
                X[s] = 1;
                cpt++;
                if (!isZoneVide(g, X)) {
                    X[s] = 0;
                    cpt--;
                }
            }
            g.sommets.set(0, 0);
            g.sommets.set(i, i);
            if (cuntOne(Y) <= cpt) Y = X.clone();
            for (int k = 0; k < g.size; k++) {
                X[k] = 0;
            }
            cpt = 0;
        }
        return Y;
    }
    public static int [] getZoneVideMaximumIncomplete(Graphe g){
        int [] X = new int [g.size];
        Queue <Integer> sometsTriés = new LinkedList<>(g.getSommetsTriés());

        while (!sometsTriés.isEmpty()) {
            int s = sometsTriés.iterator().next();
            for (int v : g.getNeighbours(s)) {
               sometsTriés.remove(v);
            }
            X[s] = 1;
            sometsTriés.poll();
        }
        return X;
    }

    public static void afficheZoneVide (int [] X){
        List <Integer> zoneVide = new ArrayList<>();
        for (int i = 0; i < X.length; i++) {
            if(X[i] == 1) zoneVide.add(i);
        }
        System.out.println(zoneVide);
    }
}
