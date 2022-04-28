import javax.swing.*;
import java.awt.*;


public class MesReglesDuJeu extends JFrame{

    JPanel conteneur;
    JLabel logo;
    JTextArea Objectif;
    JTextArea lesTouches;
    JLabel LigneComp;
    JTextArea complete;
    JTextArea perdre;
    JTextArea battezVotreScore;

    public MesReglesDuJeu  (){
        super("Règle du Tetrinsa");
        setSize(500,700);
        setLocation(1000, 50);
        
        conteneur = new JPanel();
		conteneur.setLayout(null);
		conteneur.setBounds(0,0,500,900) ;
		conteneur.setBackground(Color.black);

        // logo
        logo = new JLabel(new ImageIcon("./logo.png"));
		logo.setSize(300,80);
		logo.setLocation(100,10);

        //Texte Objectif
        Objectif=new JTextArea("Bienvenue à Tetrinsa! Nous sommes heureux de vous faire découvrir le jeu du Tetris! L'objectif est simple : Faire le score le plus élevé en un minimum de temps."+"\n"+" Le plateau de jeu se compose en trois parties: -la zone score avec le bouton start et pause qui permettra de lancer votre partie ou de la mettre en pause;"+"\n"+" -Le plateau de jeu où vous suivrez l'évolution de votre partie "+"\n"+"-Et la pièce en attente qui présente la prochaine pièce jouée." );
		Objectif.setBounds(20,120,450,100);
		Objectif.setBackground(Color.red);
		Objectif.setForeground(Color.white);
        Objectif.setLineWrap(true);

        // ligneComplete
        complete =new JTextArea(" Pour gagner des points, vous devez former des lignes complètes. Complèter la ligne la fera automatiquement disparaitre. Compléter plusieurs lignes fera doubler le nombre de points gagné. ");
        complete.setBounds(20,230,450,60);
		complete.setBackground(Color.red);
		complete.setForeground(Color.white);
        complete.setLineWrap(true);
         
        // LigneComp
        LigneComp = new JLabel(new ImageIcon("./ligneCompleteAV.JPG"));
		LigneComp.setSize(200,80);
		LigneComp.setLocation(30,300);

        JLabel LigneComp2 = new JLabel(new ImageIcon("./ligneCompleteAP.JPG"));
		LigneComp2.setSize(200,80);
		LigneComp2.setLocation(250,300);

        //déplacement des touches
        lesTouches =new JTextArea(" Pour guidez les tétrisimos, vous utiliserez les touches D,S,Q,Z,A."+"\n"+" -D sert à déplacer la pièce sur la droit, "+"\n"+"-Q sert à la déplacer sur la gauche"+"\n"+" -Z sert à tourner de 90° la pièce"+"\n"+" -La touche S sert à accélerer la descente "+"\n"+"-A permettra de faire un coup automatique généré par une IA");
        lesTouches.setBounds(20,400,450,100);
		lesTouches.setBackground(Color.red);
		lesTouches.setForeground(Color.white);
        lesTouches.setLineWrap(true);

        // perdre
        perdre=new JTextArea("Vous perdez quand un de vos tétriminos se pose sur la dernière ligne du jeu."+"\n"+" Faites Attention aux temps car toutes les 20 secondes, la vitesse de jeu accèlere.Gagnez donc un max de points le plus rapidement possible.");
        perdre.setBounds(20,510,450,50);
		perdre.setBackground(Color.red);
		perdre.setForeground(Color.white);
        perdre.setLineWrap(true);

        //battez votre score
        battezVotreScore=new JTextArea("N'hésitez plus et essayez de battre votre score pour atteindre le podium. N'oubliez pas d'enregsitrer votre nom à la fin de la partie dans la nouvelle fenêtre. "+"\n"+"Vous connaissez maintenant tout du jeu. Allez donc vous amusez et que le meilleur gagne!");
        battezVotreScore.setBounds(20,580,450,70);
		battezVotreScore.setBackground(Color.red);
		battezVotreScore.setForeground(Color.white);
        battezVotreScore.setLineWrap(true);

        //conteneur.add(logo);
        conteneur.add(Objectif);
        conteneur.add(complete);
        conteneur.add(logo);
        conteneur.add(lesTouches);
        conteneur.add(LigneComp);
        conteneur.add(LigneComp2);
        conteneur.add(perdre);
        conteneur.add(battezVotreScore);
        add(conteneur);
		
		setVisible(false);
    }
    
}
