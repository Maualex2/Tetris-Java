import java.awt.Color;
public abstract class forme {
    
    public Color couleur;
    public int [][]Coordonees; // premère colonne abscisse, 2ème colonne ordonée
    public int []origine;

    public forme( Color c){
        couleur= c;

    }
    public void descendre(){
        origine[1]=origine[1]+1;
    };
    public void gauche(){
        origine[0]=origine[0]-1;
    }
    public void droite(){
        origine[0]=origine[0]-1;
    }

}
