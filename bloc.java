import java.awt.Color;
public class Bloc {
    Color couleur;
    boolean dernierbloc;
    boolean vide;

    public Bloc(Color c, boolean d, boolean v){
        couleur=c;
        dernierbloc= d;
        vide=false; //d
    }
}
