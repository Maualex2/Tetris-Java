import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface extends JFrame implements ActionListener,KeyListener{
    JPanel GraphiqueTerrain;
    JPanel GraphiqueListedAttente;
    JPanel Page;
    JPanel Stat;
    TerrainDeJeu Jeu;
    JButton Start; 
    JLabel Score; 
    int iChrono; 
    Timer Chrono; 
    Timer Defilement;
    JLabel affChrono; 
    JTextField text;

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
        GraphiqueListedAttente.setBounds(480,50,300,200);
        GraphiqueListedAttente.setBackground(Color.cyan);

        //Stat 
        Stat = new JPanel();
        Stat.setLayout(null);
        Stat.setBounds(480,300,200,300);
        Stat.setBackground(Color.cyan);

        //Bouton Start 
        Start= new JButton("Start");
        Stat.add(Start);
        Start.setBounds(50,200,100,50);
        Start.setLayout(null);
        Start.setBackground(new Color(245,0,242)); // rose
        Start.setFont(new Font("Arial", Font.BOLD, 25));
        Start.addActionListener(this); 
        
    
        //Score
		Score=new JLabel("score ici");  
		Score.setBounds(50,120, 100, 50);  
		Stat.add(Score);

        //Chrono
        Chrono = new Timer(1000,this);
        Defilement= new Timer(700,this);
        
        affChrono = new JLabel("Temps :");
        affChrono.setBounds(20, 50, 150, 50);
        affChrono.setBackground(Color.GREEN);
        affChrono.setForeground(new Color(245,0,242)); // rose
        affChrono.setFont(new Font("Arial", Font.BOLD, 25));  
		Stat.add(affChrono);

        //Fenetre entiere
        Page= new JPanel();
        Page.setLayout(null);
        Page.setBounds(0,0,800,900);
        //Page.setBackground(Color.black);
        Page.add(GraphiqueTerrain);
        Page.add(GraphiqueListedAttente);
        Page.add(Stat);
        this.add(Page);

        //Clavier
        
        
        this.setFocusable(true);//permet de suivre le clavier sur toute la fenetre
        this.setFocusTraversalKeysEnabled(false);//jsp
        addKeyListener(this);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == Start) {
		   //démarrer le jeu
            this.requestFocus();
           iChrono=0;
           Chrono.start();
           Defilement.start();
           affChrono.setText("Temps : "+String.valueOf(iChrono));
		}
        if(e.getSource()== Chrono){
            iChrono++;
            affChrono.setText("Temps :"+String.valueOf(iChrono));
        }
        if(e.getSource()== Defilement){
            Jeu.descendre();
            GraphiqueTerrain.repaint();
            GraphiqueListedAttente.repaint();
        }
    }
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    public void keyTyped(KeyEvent e) {
        char caractere = e.getKeyChar();
        System.out.println("CAPTER");
        if(((int)caractere==81)||(int)caractere==113 && iChrono>0){
            //Defilement.stop();
            Jeu.bougerGauche();
            GraphiqueTerrain.repaint();
            System.out.println("Gauche");
            //Defilement.start();
        }
        if(((int)caractere==68)||(int)caractere==100 && iChrono>0){
            //Defilement.stop();
            Jeu.bougerDroite();
            System.out.println("Droite");
            GraphiqueTerrain.repaint();
            //Defilement.start();
        }
        if(((int)caractere==83)||(int)caractere==115 && iChrono>0){
            Defilement.stop();
            Jeu.descendre();;
            System.out.println("Descendre");
            GraphiqueTerrain.repaint();
            Defilement.start();
        }
        if(((int)caractere==90)||(int)caractere==122 && iChrono>0){
            //Defilement.stop();
            Jeu.tourner();
            System.out.println("tourner");
            GraphiqueTerrain.repaint();
            //Defilement.start();
        }

    }
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
