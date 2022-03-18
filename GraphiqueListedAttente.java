import java.awt.*;
import javax.swing.*;
public class GraphiqueListedAttente extends JPanel{
    public TerrainDeJeu Jeu;
     
    public GraphiqueListedAttente(TerrainDeJeu Jeu){
        this.Jeu=Jeu;
    }
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(100,100,700,700);


        int [][]tab=Jeu.FormeEnAttente.Coordonnees[][];
        for (int i = 0; i < tab.length; i++) {
            g.setColor(Jeu.FormeEnAttente.color);
            g.fillRect(400+tab[i][1]*100, 400+tab[i][2]*100, 100, 100);
        }

        g.setColor(Color.gray);
        for (int i = 0; i < 6; i++) {
            g.drawLine(100+100*i,100,100+100*i,700);
            g.drawLine(100,100+100*i,100,100+100*i);
        }

        
    }
}
