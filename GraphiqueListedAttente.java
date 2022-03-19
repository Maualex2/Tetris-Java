import java.awt.*;
import javax.swing.*;
public class GraphiqueListedAttente extends JPanel{
    public TerrainDeJeu Jeu;
     
    public GraphiqueListedAttente(TerrainDeJeu Jeu){
        this.Jeu=Jeu;
    }
    public void paint(Graphics g){ // les commentaires sont les formes finales, la c'est juste un test pour voir l'affichage
        g.setColor(Color.black);
        g.fillRect(50,50,700,700);

        //Jeu.FormeEnAttente.Coordonnees[][] 
         int [][]tab={{0,0},{1,0},{0,1},{1,1}};
         for (int i = 0; i < tab.length; i++) {
            g.setColor(Color.blue);
            //g.setColor(Jeu.FormeEnAttente.color);
            g.fillRect(150+(tab[i][0])*50, 150+(tab[i][1])*50, 50, 50);
        } 

        g.setColor(Color.red);
        for (int i = 0; i < 6; i++) {
            g.drawLine(50+50*i,50,50+50*i,300);
            g.drawLine(50,50+50*i,350,50+50*i);
        } 

        
    }
}
