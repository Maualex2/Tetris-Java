import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

public class AffichageScore extends JFrame{

        public AffichageScore() { // Construit la fenetre qui affiche l'historique des parties tout en lisant l'historique dans un fichier txt
            setSize(500,500);
            setLocation(400, 100);
            //JLabel j = new JLabel("",SwingConstants.CENTER);
            //j.setVerticalAlignment(SwingConstants.CENTER);
            JTextArea b = new JTextArea("");
            String Texte="";
            Path chemin = Paths.get("score.txt");
            InputStream input = null;
            
            try {
                input = Files.newInputStream(chemin);
             
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String s = null;
                while(reader.readLine() != null){
                    Texte=Texte+reader.readLine()+"\n";
                }
                input.close();
 
            } catch (IOException e) {
                System.out.println("Message " + e);
            }
            b.append(Texte);
            b.setEditable(false);
            JScrollPane j = new JScrollPane(b);
            j.setBounds(0,0,320,280);
            this.add(j);
        }
            
}