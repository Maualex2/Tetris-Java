 import java.awt.Color;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        // création des formes utilisées
        int [] origine={0,0};
        int [][] tab={{origine[0]-1,origine[0]+1,origine[0]+1},{origine[1],origine[1],origine[1]+1}};
        forme Tsimo= new forme (Color.RED , tab , 't');
        
        int [][]tab2={{origine[0],origine[0]+1,origine[0]+1},{origine[1]+1,origine[1]+1,origine[1]}};
        forme Osimo= new forme(Color.yellow,tab2,'o');
        int [][]tab3={{origine[0]-1,origine[0]+1,origine[0]+1},{origine[1],origine[1],origine[1]+1}};
        forme Lsimo= new forme(Color.cyan, tab3, 'l');
        int [][]tab4={{origine[0]-1,origine[0]-1,origine[0]+1},{origine[1]+1,origine[1],origine[1]}};
        forme Jsimo= new forme(Color.blue,tab4,'j');
        int [][] tab5={{origine[0]-1,origine[0]+1,origine[0]+2},{origine[1],origine[1],origine[1]}};
        forme Isimo= new forme(Color.orange,tab5,'i');
        int [][]tab6={{origine[0]-1,origine[0],origine[0]+1},{origine[1],origine[1]+1,origine[1]+1}};
        forme Ssimo= new forme(Color.green,tab6,'s');
        int [][]tab7={{origine[0]-1,origine[0],origine[0]+1},{origine[1]+1,origine[1]+1,origine[1]}};
        forme Zsimo= new forme (Color.magenta,tab7,'z');
        // tableau de forme utilisés pour le choix aléatoire
        LinkedList<forme> figure= {Tsimo,Osimo,Lsimo,Jsimo, Isimo, Ssimo,Zsimo};
        TerrainDeJeu Jeu = new TerrainDeJeu(figure)
        Interface f = new Interface(null,figure);
        
        }
        
}
