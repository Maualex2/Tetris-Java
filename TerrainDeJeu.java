import java.util.LinkedList;

public class TerrainDeJeu {
    public Bloc[][] Terrain;
    public int points;
    public LinkedList<int[][]> FormeJouee;
    public LinkedList<int[][]> FormeStandard;
    public LinkedList<int[][]> FormeEnAttente;

    public TerrainDeJeu(LinkedList<int[][]> FormeStandard){
        this.FormeStandard=FormeStandard;
        Terrain = new Bloc[21][13];
    }

    public void LigneComplete(){
        //à mon avis il faut aussi faire appel à une méthode qui décale tout les blocs se serait plus beau à coder
    }
    public void DecaleEnBas(int ligne){

    }

}
