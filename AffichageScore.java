import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;
public class AffichageScore extends JFrame{
        public AffichageScore() {
            setSize(300,300);
            setLocation(400, 100);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel j = new JLabel();
            this.add(j);
            String Texte="";
            Path chemin = Paths.get("score.txt");
            InputStream input = null;
            try {
                input = Files.newInputStream(chemin);
             
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String s = null;
                while(s = reader.readLine() != null){
                    System.out.println(s);
                }
                input.close();
 
            } catch (IOException e) {
                System.out.println("Message " + e);
            }
            setVisible(true);
        }
            
}