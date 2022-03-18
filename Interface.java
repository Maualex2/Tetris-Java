import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
public class Interface extends JFrame{
    JPanel Terrain;
    JPanel GraphiqueListedAttente;
    JPanel Page;
    TerrainDeJeu Jeu;
    public Interface(TerrainDeJeu jeu){
        super("Tetris");
        Jeu=jeu;
        setSize(800,900);
        setLocation(460, 140);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Terrain de jeu
        Terrain= new JPanel();
        Terrain.setLayout(null);
        Terrain.setBounds(20,50,400,800);
        Terrain.setBackground(Color.black);

        //GraphiqueListedAttente
        GraphiqueListedAttente= new GraphiqueListedAttente(jeu);
        GraphiqueListedAttente.setLayout(null);
        GraphiqueListedAttente.setBounds(440,50,300,800);
        GraphiqueListedAttente.setBackground(Color.red);

        //Fenetre entiere
        Page= new JPanel();
        Page.setLayout(null);
        Page.setBounds(0,0,800,900);
        Page.setBackground(Color.yellow);
        Page.add(Terrain);
        Page.add(GraphiqueListedAttente);
        this.add(Page);

        setVisible(true);
        

    }
}
