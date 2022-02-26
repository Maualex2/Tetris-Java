import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
public class Fenetre extends JFrame{
    JPanel Terrain;
    JPanel Interface;
    JPanel Page;
    public Fenetre(){
        super("Tetris");
        setSize(800,900);
        setLocation(460, 140);
        //Terrain de jeu
        Terrain= new JPanel();
        Terrain.setLayout(null);
        Terrain.setBounds(20,50,400,800);
        Terrain.setBackground(Color.black);

        //Interface
        Interface= new JPanel();
        Interface.setLayout(null);
        Interface.setBounds(440,50,300,800);
        Interface.setBackground(Color.red);

        //Fenetre entière
        Page= new JPanel();
        Page.setLayout(null);
        Page.setBounds(0,0,800,900);
        Page.setBackground(Color.yellow);
        Page.add(Terrain);
        Page.add(Interface);
        this.add(Page);


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
