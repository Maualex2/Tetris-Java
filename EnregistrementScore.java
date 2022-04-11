import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EnregistrementScore extends JFrame{
        int Score;
        String nom;
        JTextField Field;
        JButton Val;
        JPanel Page;
        public EnregistrementScore(int Score){
            this.Score=Score;
            setSize(300,300);
            setLocation(400, 100);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
            Val = new JButton("Enregistrer");
            Val.setLayout(null);
            Val.setBounds(70,150,150,50);

            Field = new JTextField("Votre Pseudo");
            Field.setLayout(null);
            Field.setBounds(40,50,200,50);


            Page= new JPanel();
            Page.setLayout(null);
            Page.setBounds(0,0,300,300);
            Page.add(Val);
            Page.add(Field);
            this.add(Page);

            setVisible(true);
        }
}
