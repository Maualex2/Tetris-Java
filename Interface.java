import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame implements ActionListener{
    JPanel GraphiqueTerrain;
    JPanel GraphiqueListedAttente;
    JPanel Page;
    TerrainDeJeu Jeu;
    JButton Start;
    JLabel Score; 
    int iChrono; 
    Timer Chrono; 
    JLabel affChrono; 

    public Interface(TerrainDeJeu jeu){
        super("Tetris");
        Jeu=jeu;
        setSize(800,900);
        setLocation(460, 140);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //GraphiqueTerrain de jeu
        GraphiqueTerrain = new GraphiqueTerrain(Jeu);
        GraphiqueTerrain.setLayout(null);

        //GraphiqueListedAttente
        GraphiqueListedAttente= new GraphiqueListedAttente(jeu);
        GraphiqueListedAttente.setLayout(null);
        GraphiqueListedAttente.setBounds(480,50,300,800);
        GraphiqueListedAttente.setBackground(Color.cyan);
        
        //Bouton Start 
        Start= new JButton("Start");
        Start.setBounds(50,600,100,50);
        Start.setLayout(null);
        Start.setBackground(new Color(245,0,242)); // rose
        Start.setFont(new Font("Arial", Font.BOLD, 25));
        Start.addActionListener(this); 
        GraphiqueListedAttente.add(Start);
    
        //Score
		Score=new JLabel("score ici");  
		Score.setBounds(50,250, 100, 50);  
		GraphiqueListedAttente.add(Score);

        //Chrono
        Timer Chrono = new Timer(1000,this);
        Chrono.start();

        

        //Fenetre entiere
        Page= new JPanel();
        Page.setLayout(null);
        Page.setBounds(0,0,800,900);
        Page.setBackground(Color.black);
        Page.add(GraphiqueTerrain);
        Page.add(GraphiqueListedAttente);
        this.add(Page);
        
        affChrono = new JLabel();
        affChrono.setBounds(50, 320, 100, 50);
        affChrono.setForeground(new Color(245,0,242)); // rose
        affChrono.setFont(new Font("Arial", Font.BOLD, 25));  
		GraphiqueListedAttente.add(affChrono);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
       if (e.getSource() == Start) {
		   //démarrer le jeu
        
           iChrono++;
           affChrono.setText(String.valueOf(iChrono));
		}
    }
}
