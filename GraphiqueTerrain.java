import javax.swing.*; 
import java.awt.*; 

public class GraphiqueTerrain extends JPanel {
    public TerrainDeJeu TerrainJeu;

    public GraphiqueTerrain (TerrainDeJeu Terrain){
		TerrainJeu = Terrain;
		
		setLayout(null);
		setSize(120*3+1,210*3+1); 
		setLocation(50,50); 
	}	
	
	public void paint(Graphics g){ // les commentaires sont les formes finales, la c'est juste un test pour voir l'affichage

		for (int i=0; i<TerrainJeu.Terrain.length; i++){ //Affichage des blocs 
			for (int j=0; j<TerrainJeu.Terrain[i].length; j++){
				g.setColor(TerrainJeu.Terrain[i][j].couleur);
				g.fillRect(i*30,j*30, 30, 30);
			}
		}
			
		g.setColor(Color.CYAN); //Affichages des lignes
		for (int i=0; i<13; i++){
			for (int j=0; j<22; j++){
				g.drawLine(i*30,j*30, i*30, (j+1)*30);
				g.drawLine(i*30,j*30, (i+1)*30, j*30);
			}
		}
		for (int i=0; i<TerrainJeu.EnJeu.Coordonnees.length; i++){ //Affichage des blocs (donc des formes)
				g.setColor(TerrainJeu.EnJeu.couleur); 
				g.fillRect((TerrainJeu.EnJeu.Coordonnees[i][0]+TerrainJeu.EnJeu.origine[0])*30,(TerrainJeu.EnJeu.Coordonnees[i][1]+TerrainJeu.EnJeu.origine[1])*30, 30, 30);
		}
	}
}	
