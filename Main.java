 import java.awt.Color;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        // création des formes utilisées
        LinkedList<forme> figure= new LinkedList<forme>();
        int [] origine={0,0};
        int [][] tab={{origine[0]-1,origine[0]+1,origine[0]+1},{origine[1],origine[1],origine[1]+1}};
        forme Tsimo= new forme (Color.RED , tab , 't');
        figure.add(Tsimo);
        int [][]tab2={{origine[0],origine[0]+1,origine[0]+1},{origine[1]+1,origine[1]+1,origine[1]}};
        forme Osimo= new forme(Color.yellow,tab2,'o');
        figure.add(Osimo);
        int [][]tab3={{origine[0]-1,origine[0]+1,origine[0]+1},{origine[1],origine[1],origine[1]+1}};
        forme Lsimo= new forme(Color.cyan, tab3, 'l');
        figure.add(Lsimo);
        int [][]tab4={{origine[0]-1,origine[0]-1,origine[0]+1},{origine[1]+1,origine[1],origine[1]}};
        forme Jsimo= new forme(Color.blue,tab4,'j');
        figure.add(Jsimo);
        int [][] tab5={{origine[0]-1,origine[0]+1,origine[0]+2},{origine[1],origine[1],origine[1]}};
        forme Isimo= new forme(Color.orange,tab5,'i');
        figure.add(Isimo);
        int [][]tab6={{origine[0]-1,origine[0],origine[0]+1},{origine[1],origine[1]+1,origine[1]+1}};
        forme Ssimo= new forme(Color.green,tab6,'s');
        figure.add(Ssimo);
        int [][]tab7={{origine[0]-1,origine[0],origine[0]+1},{origine[1]+1,origine[1]+1,origine[1]}};
        forme Zsimo= new forme (Color.magenta,tab7,'z');
        figure.add(Zsimo);
        // tableau de forme utilisés pour le choix aléatoire
        
        TerrainDeJeu Jeu = new TerrainDeJeu(figure);
        Interface f = new Interface(Jeu);
        
        }
        
}
