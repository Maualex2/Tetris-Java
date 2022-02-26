import javax.swing.JFrame;
public class Fenetre extends JFrame{
    public Fenetre(){
        super("Tetris");
        setSize(1200,800);
        setLocation(460, 140);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
