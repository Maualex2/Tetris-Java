import javax.swing.*;
import java.awt.*;

public class MesReglesDuJeu extends JFrame{

    JPanel conteneur;
    JLabel logo;
    JTextArea Objectif;
    JLabel LesTouches;
    JTextArea lesTouches;
    JLabel LigneComp;
    JTextArea complete;
    JLabel FinduJeu;
    JTextArea perdre;
    JTextArea battezVotreScore;

    public MesReglesDuJeu (){
        super("Règle du Tetrinsa");
        setSize(500,600);
        setLocation(1000, 100);
        

        //scroll
        JScrollPane scroll= new JScrollPane(conteneur);
        scroll.setBounds(0,0,320,150);

        // logo
        //logo = new JLabel(new ImageIcon("./insa_logo.png"));
		//logo.setSize(300,80);
		//logo.setLocation(100,60);

        //Texte Objectif
        Objectif=new JTextArea("Bienvenue à Tetrinsa! Nous sommes heureux de vous faire découvrir le jeu du Tetris! L'objectif est simple : Faire le score le plus élevé en un minimum de temps." );
		Objectif.setBounds(20,100,450,40);
		Objectif.setBackground(Color.red);
		Objectif.setForeground(Color.white);
        Objectif.setLineWrap(true);

        //pour cela ligneComplete
        complete =new JTextArea(" Pour cela, vous devez former des lignes complètes. Complèter la ligne la fera automatiquement disparaitre et vous fera gagner des points. Compléter plusieurs lignes fera doubler le nombre de points gagné. ");
        complete.setBounds(20,250,450,60);
		complete.setBackground(Color.red);
		complete.setForeground(Color.white);
        complete.setLineWrap(true);
         
        // LigneComp
        //LigneComp = new JLabel(new ImageIcon("./insa_logo.png"));
		//LigneComp.setSize(300,80);
		//LigneComp.setLocation(20,330);

        JPanel conteneur = new JPanel();
		conteneur.setLayout(null);
		conteneur.setBounds(0,0,500,900) ;
		conteneur.setBackground(Color.black);

        //conteneur.add(logo);
        conteneur.add(Objectif);
        conteneur.add(complete);
        //conteneur.add(LigneComplete);
        add(conteneur);
		
		setVisible(false);
    }
    
}
