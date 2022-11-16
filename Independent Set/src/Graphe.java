import java.util.ArrayList;
import java.util.List;

public class Graphe {
    public int size;
    public List<Integer> sommets = new ArrayList<>();
    public List <List<Integer>>Arcs = new ArrayList();

    Graphe (int size){
        this.size = size;
        for (int i = 0; i < size; i++) {
            this.sommets.add(i);
            this.Arcs.add(i, new ArrayList());
        }
    }

    public void addArc (int src, int dist){
        this.Arcs.get(src).add(dist);
        this.Arcs.get(dist).add(src);
    }
    public void addSommet (int nbSommet){
        for (int i = 0; i < nbSommet; i++) {
            this.Arcs.add(this.size , new ArrayList());
            this.sommets.add(this.size , i);
            this.size += 1;
        }
    }
    public void deletArc (int src, int dist){
        this.Arcs.get(src).set(dist, null);
        this.Arcs.get(dist).set(src, null);
    }
    public int getDegreeSommet (int sommet){
        return this.Arcs.get(sommet).size();
    }
    public List<Integer> getNeighbours (int sommet){
        List<Integer> neighbours = new ArrayList<>();
        for (int i : this.Arcs.get(sommet)) {
            neighbours.add(i);
        }
        return neighbours;
    }
    public List<Integer> getSommetsTriés () {
        int temp, j, t;
        for (int i = 1; i < this.size; i++) {
            temp = this.getDegreeSommet(this.sommets.get(i));
            j = i;
            t = this.sommets.get(i);
            while (j > 0 && this.getDegreeSommet(this.sommets.get(j-1)) > temp) {
                this.sommets.set(j, this.sommets.get(j - 1));
                j --;
            }
            this.sommets.set(j, t);
        }
        return this.sommets;
    }


}