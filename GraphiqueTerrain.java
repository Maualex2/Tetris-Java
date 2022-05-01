import javax.swing.*; 
import java.awt.*; 

public class GraphiqueTerrain extends JPanel {
    public TerrainDeJeu Jeu;

    public GraphiqueTerrain (TerrainDeJeu Jeu){ //Affiche le terrain de jeu
		this.Jeu = Jeu;
		setLayout(null);
		setSize(120*3+1,210*3+1); 
		setLocation(50,150); 
	}	
	
	public void paint(Graphics g){ 

		for (int i=0; i<Jeu.Terrain.length; i++){ //Affichage des blocs 
			for (int j=0; j<Jeu.Terrain[i].length; j++){
				g.setColor(Jeu.Terrain[i][j].couleur);
				g.fillRect(i*30,j*30, 30, 30);
			}
		}
			
		for (int i=0; i<Jeu.EnJeu.Coordonnees.length; i++){ //Affichage des blocs (donc des formes)
				g.setColor(Jeu.EnJeu.couleur); 
				g.fillRect((Jeu.EnJeu.Coordonnees[i][0]+Jeu.EnJeu.origine[0])*30,(Jeu.EnJeu.Coordonnees[i][1]+Jeu.EnJeu.origine[1])*30, 30, 30);
		}
		
		g.setColor(Color.CYAN); //Affichages des lignes
		for (int i=0; i<13; i++){
			for (int j=0; j<22; j++){
				g.drawLine(i*30,j*30, i*30, (j+1)*30);
				g.drawLine(i*30,j*30, (i+1)*30, j*30);
			}
		}

	}
}	
