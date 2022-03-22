import java.awt.Color;
public class Main {
    public static void main(String[] args) {
        // création des formes utilisées
        double []origine={0,0};
        double [][]tab={{-1,1},{0,1},{1,1},{0,0}};
        forme Tsimo= new forme(tab, origine,Color.RED);

        double [][]tabO={{-0.5,-0.5},{0.5,-0.5},{0.5,0.5},{0.5,-0.5}};
        forme Osimo= new forme(tabO, origine,Color.yellow);

        double [][]tabL={{-2,0},{-1,0},{0,0},{0,1}};
        forme Lsimo= new forme(tabL, origine,Color.cyan);

        double [][]tabJ={{2,0},{1,0},{0,0},{0,1}};
        forme Jsimo= new forme(tabJ, origine,Color.blue);

        double [][]tabI={{-1.5,0},{-0.5,0},{0.5,0},{1.5,0}};
        forme Isimo= new forme(tabI, origine,Color.orange);

        double [][]tabS={{0,0.5},{1,0.5},{0,-0.5},{-1,-0.5}};
        forme Ssimo= new forme(tabS, origine,Color.green);
        
        double [][]tabZ={{-1,0.5},{0,0.5},{0,-0.5},{1,-0.5}};
        forme Zsimo= new forme(tabZ, origine,Color.magenta);
        // tableau de forme utilisés pour le choix aléatoire
        forme [] figure= {Tsimo,Osimo,Lsimo,Jsimo, Isimo, Ssimo,Zsimo};

        Interface f = new Interface(null);
        
        }
        
}
