import java.awt.Color;
public class forme{
    
    public Color couleur;
    public int[][] Coordonnees; // premiere colonne abscisse, 2eme colonne ordonnee
    public int[] origine;
    public char nom;

    public forme(Color c, int[][] coor, char n){
        int[] tab = {6,0};
        origine = tab;
        couleur = c;
        Coordonnees = coor;
        nom = n;
    }

    public forme(forme f){ // Permet de faire des copies de forme
        this.couleur=f.couleur;
        int [][] tab = new int[f.Coordonnees.length][f.Coordonnees[0].length];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j]=f.Coordonnees[i][j];
            }
        }
        this.Coordonnees=tab;
        int [] or = {f.origine[0],f.origine[1]};
        this.origine= or;
        this.nom=f.nom;

    }

    public void descendre(){
        origine[1]=origine[1]+1;
    }

    public void gauche(){
        origine[0]=origine[0]-1;
    }

    public void droite(){
        origine[0]=origine[0]+1;
    }

    public void rotation(){
        int[][] nouvellesCoordonnees= new int[4][2];
        for (int i=0; i<this.Coordonnees.length; i++){
            nouvellesCoordonnees[i][0] = this.Coordonnees[i][1];
            nouvellesCoordonnees[i][1] = -this.Coordonnees[i][0];
        }
        this.Coordonnees = nouvellesCoordonnees;
    }

}
