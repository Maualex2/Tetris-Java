import java.awt.Color;
public class forme {
    
    public double [][]Coordonees;
    public double []origine;
    public Color couleur;
    public String type;

    public forme(double [][] tab, double []dim, Color c, String a){
        couleur= c;
        Coordonees=tab;
        origine=dim;
        type=a;

    }

}
