import javax.swing.*;
import java.awt.*;


public class MesReglesDuJeu extends JFrame{

    JPanel conteneur;
    JLabel logo;
    JTextArea Objectif;
    JTextArea lesTouches;
    JLabel LigneComp;
    JTextArea complete;
    JLabel FinduJeu;
    JTextArea perdre;
    JTextArea battezVotreScore;

    public MesReglesDuJeu  (){
        super("Règle du Tetrinsa");
        setSize(500,600);
        setLocation(1000, 100);
        

        // logo
        logo = new JLabel(new ImageIcon("./logo.png"));
		logo.setSize(300,80);
		logo.setLocation(100,20);

        //Texte Objectif
        Objectif=new JTextArea("Bienvenue à Tetrinsa! Nous sommes heureux de vous faire découvrir le jeu du Tetris! L'objectif est simple : Faire le score le plus élevé en un minimum de temps."+"\n"+" Le plateau de jeu se compose en trois parties: la zone score avec le bouton start/pause qui permettra de lancer votre partie ou de la mettre en pause; le plateau de jeu où vous suivrez l'évolution de votre partie et la pièce en attente qui présente la prochaine pièce jouée." );
		Objectif.setBounds(20,120,450,100);
		Objectif.setBackground(Color.red);
		Objectif.setForeground(Color.white);
        Objectif.setLineWrap(true);

        // plateau 
        JLabel plateau = new JLabel(new ImageIcon("./plateau.png"));
		logo.setSize(300,80);
		logo.setLocation(250, 200);

        // ligneComplete
        complete =new JTextArea(" Pour cela, vous devez former des lignes complètes. Complèter la ligne la fera automatiquement disparaitre et vous fera gagner des points. Compléter plusieurs lignes fera doubler le nombre de points gagné. ");
        complete.setBounds(20,400,450,60);
		complete.setBackground(Color.red);
		complete.setForeground(Color.white);
        complete.setLineWrap(true);
         
        // LigneComp
        LigneComp = new JLabel(new ImageIcon("./ligneCompleteAV.JPG"));
		LigneComp.setSize(200,80);
		LigneComp.setLocation(30,480);

        JLabel LigneComp2 = new JLabel(new ImageIcon("./ligneCompleteAP.JPG"));
		LigneComp2.setSize(200,80);
		LigneComp2.setLocation(250,480);

        //déplacement des touches
        lesTouches =new JTextArea(" Pour déplacer les tétrisimos, vous devez utiliser les touches D,S,Q,Z. D sert à déplacer la pièce sur la droit, Q sur la gauche. Z sert à tourner de 90° la pièce. La touche S sert à accélerer la descente ");
        lesTouches.setBounds(20,400,480,100);
		lesTouches.setBackground(Color.red);
		lesTouches.setForeground(Color.white);
        lesTouches.setLineWrap(true);

        conteneur = new JPanel();
		conteneur.setLayout(null);
		conteneur.setBounds(0,0,500,900) ;
		conteneur.setBackground(Color.black);

        //scroll
        JScrollPane scroll= new JScrollPane(conteneur);
        scroll.setBounds(0,0,10,400);
        this.add(scroll);

        //conteneur.add(logo);
        conteneur.add(Objectif);
        conteneur.add(complete);
        conteneur.add(logo);
        conteneur.add(lesTouches);
        conteneur.add(plateau);
        conteneur.add(LigneComp);
        conteneur.add(LigneComp2);
        add(conteneur);
		
		setVisible(false);
    }
    
}
