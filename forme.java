import java.awt.Color;
public class forme {
    
    public double [][]Coordonees;
    public double []origine;
    public Color couleur;

    public forme(double [][] tab, double []dim, Color c){
        couleur= c;
        Coordonees=tab;
        origine=dim;

    }
    public void descendre(){
        origine[1]=origine[1]+1;
    }

}
