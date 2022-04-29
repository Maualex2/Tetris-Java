import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import javax.sound.sampled.*;
import static java.nio.file.StandardOpenOption.*;


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
    int niveau;
    JButton Regles;
    JButton ScoreP ;
    MesReglesDuJeu fenetreRegles= new MesReglesDuJeu();
    Son Musique;
    int ScoreMax;
    String NomScoreMax;
    IA IA;
    Icon startIcon;
    Icon pauseIcon;
    Icon logoIcon;
    Icon scoreIcon;
    

    public Interface(TerrainDeJeu jeu,IA IA){
        super("Tetris");
        this.IA=IA;
        iChrono=0;
        Jeu=jeu;
        setSize(800,900);
        setLocation(200, 0);
        niveau=0;
        ScoreMax=0;
        ScoreMax();
        
       Icon startIcon = new ImageIcon("./playN2.png");
       Icon pauseIcon = new ImageIcon("./pauseN2.png");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //GraphiqueTerrain de jeu
        GraphiqueTerrain = new GraphiqueTerrain(Jeu);
        GraphiqueTerrain.setLayout(null);

        //GraphiqueListedAttente
        GraphiqueListedAttente= new GraphiqueListedAttente(jeu);
        GraphiqueListedAttente.setLayout(null);
        GraphiqueListedAttente.setBounds(480,150,250,200);
        GraphiqueListedAttente.setBackground(Color.cyan);

        //Stat 
        Stat = new JPanel();
        Stat.setLayout(null);
        Stat.setBounds(480,400,200,350);
        Stat.setBackground(Color.blue);

        //Bouton Start 
        //Start = new JButton("Start");
        Start = new JButton(startIcon) ; 
        Stat.add(Start);
        Start.setBounds(75,200,50,50);
        Start.setLayout(null);
        Start.setBackground(Color.black); 
       // Start.setFont(new Font("Arial", Font.BOLD, 25));
        Start.addActionListener(this); 
        
        //Logo du jeu
        JLabel logo = new JLabel(new ImageIcon("./logo150.png"));
		logo.setSize(600,100);
		logo.setLocation(100,10);
        //Score
		Score=new JLabel("Score : " + Jeu.points);  
		Score.setBounds(50,70, 150, 50);  
        Score.setForeground(Color.red); 
        Score.setFont(new Font("Arial", Font.BOLD, 25)); 
		Stat.add(Score);


        //Chrono
        Chrono = new Timer(1000,this);
        Defilement= new Timer(700,this);
        
        affChrono = new JLabel("Temps :");
        affChrono.setBounds(20, 10, 150, 50);
        affChrono.setBackground(Color.GREEN);
        affChrono.setForeground(Color.red); 
        affChrono.setFont(new Font("Arial", Font.BOLD, 25));  
		Stat.add(affChrono);

        //score max
        JLabel scoreTextMax= new JLabel("<html> Score max à battre : <br>"+ScoreMax+" de "+NomScoreMax+"<html>");
        scoreTextMax.setBounds(10,120,200,70);
        scoreTextMax.setForeground(Color.RED);
        Stat.add(scoreTextMax);

        //Règles du jeu
        Regles = new JButton("Règles");
        Regles.setBounds(30,270,150,50);
        Regles.setLayout(null);
        Regles.setBackground(Color.red);
        Regles.setFont(new Font("Arial", Font.BOLD, 25));
        Regles.addActionListener(this); 
        Stat.add(Regles);

        //Fenetre entiere
        Page= new JPanel();
        Page.setLayout(null);
        Page.setBounds(0,0,800,900);
        Page.setBackground(Color.MAGENTA);
        Page.add(GraphiqueTerrain);
        Page.add(GraphiqueListedAttente);
        Page.add(Stat);
        Page.add(logo);
        
        this.add(Page);


        //Clavier
        this.setFocusable(true);//permet de suivre le clavier sur toute la fenetre
        this.setFocusTraversalKeysEnabled(false);//jsp
        addKeyListener(this);

        
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
   
        if (e.getSource() == Start) {
            
              if (Chrono.isRunning()) { //chrono en route
                    Chrono.stop(); 
                    Defilement.stop();
                    Musique.stopSon();
                   // Start.setText("Start");
                   Start.setIcon(new ImageIcon("./playN2.png"));
                  
         } else {
		   //démarrer le jeu
           Musique = new Son();
           // Start.setText("Pause");
           Start.setLayout(null);
           Start.setIcon(new ImageIcon("./pauseN2.png"));
          
            this.requestFocus();
           Chrono.start();
           Defilement.start();
           affChrono.setText("Temps : "+String.valueOf(iChrono));
		    }
        }
        if(e.getSource()== Chrono){
            iChrono++;
            affChrono.setText("Temps :"+String.valueOf(iChrono));
            Score.setText("Score :" + Jeu.points); 
            
        }
        if(e.getSource()== Defilement){
            Jeu.descendre();
            
            GraphiqueListedAttente.repaint();
            if (Jeu.perdu()){
                Defilement.stop();
                Chrono.stop();
                System.out.println("PERDU");
                JOptionPane.showMessageDialog(this,"Fin de la partie "+"\n"+ "Score final ="+ Jeu.points+"\n"+ "Vous avez survécu "+iChrono+" secondes");
                EnregistrementScore i = new EnregistrementScore(Jeu.points);
            }
            GraphiqueTerrain.repaint();
            if(iChrono%20==0 && niveau!=16){
                niveau++;
                Defilement = new Timer(700-niveau*30, this);
                Defilement.start();
            }
            Score.setText("Score :" + Jeu.points); 
        }
        if(e.getSource() == Regles) {
            fenetreRegles.setVisible(true);
        }
     }
    

    public void keyPressed(KeyEvent e) {
        // Méthode obligatoire pour que le keyListener fonctionne 
        // Vide car on ne s'en sert pas ici   
    }

    public void keyTyped(KeyEvent e) {
        char caractere = e.getKeyChar();
        if((((int)caractere==81)||(int)caractere==113) && iChrono>0){
            //Defilement.stop();
            Jeu.bougerGauche();
            GraphiqueTerrain.repaint();
            //System.out.println("Gauche");
            //Defilement.start();
        }
        if((((int)caractere==68)||(int)caractere==100 )&& iChrono>0){
            //Defilement.stop();
            Jeu.bougerDroite();
            //System.out.println("Droite");
            GraphiqueTerrain.repaint();
            //Defilement.start();
        }
        if((((int)caractere==83)||(int)caractere==115 )&& iChrono>0){
            Defilement.stop();
            Jeu.descendre();
            //System.out.println("Descendre");
            GraphiqueTerrain.repaint();
            Defilement.start();
        }
        if((((int)caractere==90)||(int)caractere==122 )&& iChrono>0){
            //Defilement.stop();
            Jeu.tourner();
            System.out.println("tourner");
            GraphiqueTerrain.repaint();
            //Defilement.start();
        }
        if((((int)caractere==97)||(int)caractere==65)&& iChrono>0){
            //Defilement.stop();
            IA.joue1Coup();
            //System.out.println("coup IA");
            GraphiqueTerrain.repaint();
            //Defilement.start();
        }
        if((((int)caractere==69)||(int)caractere==101)&& iChrono>0){
            //Defilement.stop();
            Jeu.DescenteInstantane();
            //System.out.println("descente instantané");
            GraphiqueTerrain.repaint();
            //Defilement.start();
        }

    }
    
    public void keyReleased(KeyEvent e) {
        // Méthode obligatoire pour que le keyListener fonctionne 
        // Vide car on ne s'en sert pas ici   
    }
    public void ScoreMax(){
        File doc = new File("score.txt");
        
        try {
            BufferedReader obj = new BufferedReader(new FileReader(doc));
            String strng;
            
            while ((strng = obj.readLine()) != null){
                String [] parts = strng.split( " " );
                int temp = Integer.parseInt(parts[2]);
                if(temp>ScoreMax){
                    ScoreMax=temp;
                    NomScoreMax=parts[4];
                }
            }
        
        } catch (Exception e) {
            System.out.println("Erreur : "+ e);
        }
        
    }
}
