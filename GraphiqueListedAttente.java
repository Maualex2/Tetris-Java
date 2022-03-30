import java.awt.*;
import javax.swing.*;
public class GraphiqueListedAttente extends JPanel{
    public TerrainDeJeu Jeu;
     
    public GraphiqueListedAttente(TerrainDeJeu Jeu){
        this.Jeu=Jeu;
    }
    
    public void paint(Graphics g){ // les commentaires sont les formes finales, la c'est juste un test pour voir l'affichage
        g.setColor(Color.black);
        g.fillRect(0,0,250,210);

        int[][] tab= Jeu.FormeEnAttente.Coordonnees; 
         //int [][]tab={{0,0},{1,0},{0,1},{1,1}};
         for (int i = 0; i < tab.length; i++) {
            //g.setColor(Color.blue);
            g.setColor(Jeu.FormeEnAttente.couleur);
            g.fillRect(90+(tab[i][0])*30, 60+(tab[i][1])*30, 30, 30);
        } 

        g.setColor(Color.CYAN);
        for (int i = 0; i < 7; i++) {
            g.drawLine(30+30*i,0,30+30*i,210);
            g.drawLine(30,30*i,210,30*i);
        } 
        g.drawLine(30,210,210,210);

        
    }
}
