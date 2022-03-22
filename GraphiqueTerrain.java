import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class GraphiqueTerrain extends JPanel {
    public TerrainDeJeu TerrainJeu;

    public GraphiqueTerrain (TerrainDeJeu Terrain){
		TerrainJeu = Terrain;
		
		setLayout(null);
		setSize(133*2,232*2); //12*10+13 et 21*10+22
		setLocation(0,0); 
		setBackground(Color.cyan);
		
		for (int i=0; i<12; i++){
			for (int j=0; j<21; j++){
				JPanel p = new JPanel();
				p.setLayout(null);
				p.setSize(10*2,10*2);
				p.setLocation(((i+1)*11+1)*2,((j+1)*11+1)*2);
				p.setBackground(Color.black); //p.setBackground(TerrainJeu.Terrain[i][j].couleur)?
				add(p);
			}
		}
	}		
}
