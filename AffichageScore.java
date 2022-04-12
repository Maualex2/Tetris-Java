import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;
public class AffichageScore extends JFrame{
        public AffichageScore() {
            setSize(500,500);
            setLocation(400, 100);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel j = new JLabel("",SwingConstants.CENTER);
            j.setVerticalAlignment(SwingConstants.CENTER);
            j.setLayout(null);
            this.add(j);
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
            j.setText(Texte);
            setVisible(true);
        }
            
}