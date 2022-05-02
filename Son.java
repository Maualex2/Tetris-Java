import java.io.*;
import javax.sound.sampled.*;

public class Son {

    Clip clip;
    ///Constructeur de l'objet audio

    public Son() {
        jouerSon("multimedia/Tetris.wav");

    }

   ///Méthode permettant de lancer le fichier audio

    public void jouerSon(String cheminAcces) {
         ///Si le fichier audio n'est pas trouvé, l'exception est gérée par le catch
        try {
            new File(cheminAcces);
            clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource(cheminAcces));
            clip.open(ais);
            clip.start();
            clip.loop(100);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopSon() {
	clip.stop();	
    }

}

