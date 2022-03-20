import java.awt.Color;
public class I extends Forme{
    
    public double [][]Coordonnees=new double [2][4];
    public double [] origine = new double[2];

    public I (Color c){
        super (c);
        Coordonnees={-1.5,0},{-0.5, 0},{0.5, 0},  {1.5, 0};
        origine={0, 0};
    }
}
