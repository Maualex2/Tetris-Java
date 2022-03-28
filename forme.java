import java.awt.Color;
public abstract class forme {
    
    public Color couleur;
    public int [][]Coordonees;
    public int []origine;
    
    public forme( Color c){
        couleur= c;

    }
    public abstract void descendre();
}
