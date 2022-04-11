import javax.swing.*;
import java.awt.*;

public class MesReglesDuJeu extends JFrame{

    JPanel conteneur;
    JLabel logo;
    JTextField Objectif;
    JLabel LesTouches;
    JTextField lesTouches;
    JLabel LigneComp;
    JTextField complete;
    JLabel FinduJeu;
    JTextField perdre;
    JTextField battezVotreScore;

    public MesReglesDuJeu (){
        super("Règle du Tetrinsa");
        setSize(500,600);
        setLocation(1000, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;

        JScrollPane scroll= new JScrollPane(conteneur);
        scroll.setBounds(0,0,320,150);

        JPanel conteneur = new JPanel();
		conteneur.setLayout(null);
		conteneur.setBounds(0,0,500,900) ;
		conteneur.setBackground(Color.black);
        add(conteneur);
		
		setVisible(false);
    }
    
}
