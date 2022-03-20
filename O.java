import java.awt.Color;
public class O extends Forme{
    
    public int [][]Coordonnees=new int [2][4];
    public int [] origine = new int[2];

    public O(Color c){
        super (c);
        Coordonnees={0, 0},{1, 0}, {0, 1}, {1, 1};
        origine={0, 0};
    }
}
