import java.awt.Color;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // création des formes utilisées
        LinkedList<forme> figure= new LinkedList<forme>();
        int[][] tab1 = {{-1,0},{+1,0},{+1,1},{0,0}};
        forme Tsimo = new forme (Color.RED, tab1, 't');
        figure.add(Tsimo);
        int[][] tab2 = {{0,1},{+1,1},{1,0},{0,0}};
        forme Osimo = new forme(Color.yellow, tab2, 'o');
        figure.add(Osimo);
        int[][] tab3 = {{-1,1},{+1,1},{0,1},{0,0}};
        forme Lsimo = new forme(Color.cyan, tab3, 'l');
        figure.add(Lsimo);
        int[][] tab4 = {{-1,1},{-1,0},{1,0},{0,0}};
        forme Jsimo = new forme(Color.blue, tab4, 'j');
        figure.add(Jsimo);
        int[][] tab5 = {{-1,0},{+1,0},{+2,0},{0,0}};
        forme Isimo = new forme(Color.orange, tab5, 'i');
        figure.add(Isimo);
        int[][] tab6 = {{-1,0},{0,1},{1,1},{0,0}};
        forme Ssimo = new forme(Color.green, tab6, 's');
        figure.add(Ssimo);
        int[][] tab7 = {{-1,1},{0,1},{1,0},{0,0}};
        forme Zsimo = new forme (Color.magenta, tab7, 'z');
        figure.add(Zsimo);
        // tableau de forme utilisées pour le choix aléatoire
        
        TerrainDeJeu Jeu = new TerrainDeJeu(figure);
        IA IA = new IA(Jeu);
        Interface f = new Interface(Jeu,IA);
    }
        
}
