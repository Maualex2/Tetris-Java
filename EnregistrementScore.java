import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;


public class EnregistrementScore extends JFrame implements ActionListener{
        int Score;
        String Date;
        String nom;
        JTextField Field;
        JButton Val;
        JPanel Page;
        JLabel info;

        public EnregistrementScore(int Score){ // Construit la fenetre permettant d'enregistrer  son score
            this.Score=Score;
            setSize(300,300);
            setLocation(400, 100);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
            //Date
            DateTimeFormatter temp = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            Date=temp.format(LocalDateTime.now());

            Val = new JButton("Enregistrer");
            Val.setLayout(null);
            Val.setBounds(70,150,150,50);
            Val.addActionListener(this); 

            info= new JLabel("Entrer votre nom");
            info.setLayout(null);
            info.setBounds(90,10,150,50);

            Field = new JTextField("Anonyme");
            Field.setLayout(null);
            Field.setBounds(40,50,200,50);

            Page= new JPanel();
            Page.setLayout(null);
            Page.setBounds(0,0,300,300);
            Page.add(Val);
            Page.add(Field);
            Page.add(info);
            this.add(Page);

            setVisible(true);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Val) {
                nom=Field.getText();
                enregistrer();

            }
            
        }
        
        public void enregistrer(){ //Ecrit dans le fichier txt
            Path chemin = Paths.get("score.txt");
            String content = "Score : "+Score+" par "+nom+" le "+Date+"\n";
 
            // convertit content en un tableau d'octets
            byte[] data = content.getBytes();
 
            OutputStream output = null;
            try {
                // Un objet BufferedOutputStream est affecté à la référence OutputStream.
                output = new BufferedOutputStream(Files.newOutputStream(chemin, CREATE, APPEND));
                // Ecrire dans le fichier
                output.write(data);
 
                // vider le tampon
                output.flush();
 
                // fermer le fichier
                output.close();
 
            } catch (Exception e) {
                System.out.println("Message " + e);
            }
            this.dispose();
            System.exit(0);
        }   
}
