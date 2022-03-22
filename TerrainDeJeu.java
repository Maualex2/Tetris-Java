import java.util.LinkedList;
import java.awt.Color;

public class TerrainDeJeu {
    public bloc[][] Terrain;
    public int points;
    public LinkedList<forme> FormeJouee;
    public LinkedList<forme[]> FormeStandard;
    public forme FormeEnAttente;
    public forme EnJeu;

    public TerrainDeJeu(LinkedList<forme[]> FormeStandard){
        this.FormeStandard=FormeStandard;
        Terrain = new bloc[21][13];
    }

    public void LigneComplete(){ // parcourt le tableau et compte les blocs
        int bonus = 0;
        for (int i = 0; i < Terrain.length; i++) {
            int nonvide = 0;
            for (int j = 0; j < Terrain[i].length; j++) {
                if (Terrain[i][j].vide == false) {
                    nonvide++;
                }
            }
            if (nonvide==13){
                DecaleEnBas(i);
                bonus++; // j'ai juste fait un bonus pour valoriser les enchainements
                points=points+13*bonus;
            }
        }
    }

    public void DecaleEnBas(int ligne){ // c'est une méthode qui décale les blocs qui ne sont pas fixes vers le bas à partir d'une ligne que l'on précise
        for (int i = ligne; i > 0 ; i--) { //ligne parcourt du bas du tableau jusqu'en haut
            for (int j = 0; j < Terrain[i].length; j++) { // Colonne
                if(!Terrain[i][j].dernierbloc){
                    Terrain[i-1][j]=Terrain[i][j];
                    Terrain[i][j]= new bloc(Color.BLACK, false, true);
                }
            }
        }
    }
    public void GagnePerdu(){ //Définir la notion de Perdu et de gagner

    }
    public void ajouterForme(){

    }
    /* public void bougerDroite(){ //@Maualex2 c'est pas très optimisé car je fais 2 tour du tableau
        boolean possible = true;
        for (int i = 0; i < Terrain[12].length; i++) { // @Maualex2 teste si la forme est sur le coté droit
            if (Terrain[i][12].dernierbloc==true) {
                possible=false;
                return;
            }
        }
        for (int i = 0; i < Terrain.length; i++) { // @Maualex2 on verifie que le coté droit est bien vide ou rempli d'un des blocs de la forme
            for (int j = 0; j < Terrain[i].length; j++) {
                if(Terrain[i][j].dernierbloc==true && (!Terrain[i][j+1].vide==true || !Terrain[i][j+1].dernierbloc==true)){
                    possible=false; // @Maualex2 On peut mettre un return pour que ce soit plus rapide
                }
            }
        }
        if(possible==true){// ensuite on fait le déplacement;
            for (int i = 0; i < Terrain.length; i++) { // on verifie que le coté droit est bien vide ou rempli d'un des blocs de la forme
                for (int j = 0; j < Terrain[i].length; j++) {
                    if(Terrain[i][j].dernierbloc==true ){
                    Terrain[i][j+1]=Terrain[i][j];
                    Terrain[i][j]=new bloc(Color.black,false,true);
                    }
                }
            }
        }
    }
    public void bougerGauche(){
        boolean possible = true;
        for (int i = 0; i < Terrain[0].length; i++) { // @Maualex2 teste si la forme est sur le coté droit
            if (Terrain[i][12].dernierbloc==true) {
                possible=false;
                return;
            }
        }
        for (int i = 0; i < Terrain.length; i++) { // @Maualex2 on verifie que le coté droit est bien vide ou rempli d'un des blocs de la forme
            for (int j = 0; j < Terrain[i].length; j++) {
                if(Terrain[i][j].dernierbloc==true && (!Terrain[i][j-1].vide==true || !Terrain[i][j-1].dernierbloc==true)){
                    possible=false; // @Maualex2 On peut mettre un return pour que ce soit plus rapide
                }
            }
        }
        if(possible==true){// ensuite on fait le déplacement;
            for (int i = 0; i < Terrain.length; i++) { // on verifie que le coté droit est bien vide ou rempli d'un des blocs de la forme
                for (int j = 0; j < Terrain[i].length; j++) {
                    if(Terrain[i][j].dernierbloc==true ){
                    Terrain[i][j-1]=Terrain[i][j];
                    Terrain[i][j]=new bloc(Color.black,false,true);
                    }
                }
            }
        }
    } */
    public void descendre(){
      EnJeu.descendre();//Il faut vérifier qu'il n'y a pas de bloc en bas 
    

    }
    public void tourner(){
      // TODO document why this method is empty
    }


}
