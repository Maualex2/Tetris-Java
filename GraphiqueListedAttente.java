import java.awt.*;
import javax.swing.*;

public class GraphiqueListedAttente extends JPanel{
    public TerrainDeJeu Jeu;
     
    public GraphiqueListedAttente(TerrainDeJeu Jeu){ // Construit la fenetre pour afficher la forme suivante
        this.Jeu=Jeu;
    }
    
    public void paint(Graphics g){  // Dessine la forme suivante
        g.setColor(Color.black);
        g.fillRect(0,0,250,210);

        int[][] tab= Jeu.FormeEnAttente.Coordonnees; 
         for (int i = 0; i < tab.length; i++) { //Affiche les blocs
            g.setColor(Jeu.FormeEnAttente.couleur);
            g.fillRect(90+(tab[i][0])*30, 60+(tab[i][1])*30, 30, 30);
        } 
        //Affiche les lignes
        g.setColor(Color.CYAN);
        for (int i = 0; i < 7; i++) {
            g.drawLine(30+30*i,0,30+30*i,210);
            g.drawLine(30,30*i,210,30*i);
        } 
        g.drawLine(30,210,210,210);
        
    }
}
