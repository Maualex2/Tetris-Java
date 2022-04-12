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
        Objectif=new JTextArea("Bienvenue à Tetrinsa! Nous sommes heureux de vous faire découvrir le jeu du Tetris! L'objectif est simple : Faire le score le plus élevé en un minimum de temps."+"\n"+" Le plateau de jeu se compose en trois parties: la zone score avec le bouton start/pause qui permettra de lancer votre partie ou de la mettre en pause; le plateau de jeu où vous suivrez l'évolution de votre partie et la pièce en attente qui présente la prochaine pièce jouée. " );
		Objectif.setBounds(20,100,450,100);
		Objectif.setBackground(Color.red);
		Objectif.setForeground(Color.white);
        Objectif.setLineWrap(true);

        // plateau 
        //JLabel plateau = new JLabel(new ImageIcon("./plateau.png"));
		//logo.setSize(300,80);
		//logo.setLocation(200, 210);

        //pour cela ligneComplete
        complete =new JTextArea(" Pour cela, vous devez former des lignes complètes. Complèter la ligne la fera automatiquement disparaitre et vous fera gagner des points. Compléter plusieurs lignes fera doubler le nombre de points gagné. ");
        complete.setBounds(20,250,450,60);
		complete.setBackground(Color.red);
		complete.setForeground(Color.white);
        complete.setLineWrap(true);
         
        // LigneComp
        LigneComp = new JLabel(new ImageIcon("./ligneCompleteAV.JPG"));
		LigneComp.setSize(200,80);
		LigneComp.setLocation(20,330);
        JLabel LigneComp2 = new JLabel(new ImageIcon("./ligneCompleteAP.JPG"));
		LigneComp2.setSize(200,80);
		LigneComp2.setLocation(300,330);

        JPanel conteneur = new JPanel();
		conteneur.setLayout(null);
		conteneur.setBounds(0,0,500,900) ;
		conteneur.setBackground(Color.black);

        //conteneur.add(logo);
        conteneur.add(Objectif);
        conteneur.add(complete);
        conteneur.add(LigneComp);
        conteneur.add(LigneComp2);
        add(conteneur);
		
		setVisible(false);
    }
    
}
