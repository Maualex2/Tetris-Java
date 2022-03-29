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

		for (int i=0; i<12; i++){
			for (int j=0; j<21; j++){
				g.setColor(Color.BLACK); //TerrainJeu.Terrain[i][j].couleur
				g.fillRect(i*30,j*30, 30, 30);
			}
		}
			
		g.setColor(Color.CYAN);
		for (int i=0; i<13; i++){
			for (int j=0; j<22; j++){
				g.drawLine(i*30,j*30, i*30, (j+1)*30);
				g.drawLine(i*30,j*30, (i+1)*30, j*30);
			}
		}
			
	}	
}
