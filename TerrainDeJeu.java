import java.util.LinkedList;
import java.awt.Color;

public class TerrainDeJeu {
    public bloc[][] Terrain;
    public int points;
    public LinkedList<forme> FormeJouee;
    public LinkedList<forme> FormeStandard;
    public forme FormeEnAttente;
    public forme EnJeu;

    public TerrainDeJeu(LinkedList<forme> FormeStandard){
        Terrain = new bloc[21][13];
        points = 0;
        FormeJouee = null;
        this.FormeStandard = FormeStandard;
        FormeEnAttente = this.FormeStandard.get((int)(Math.random()*this.FormeStandard.size()));
        EnJeu = this.FormeStandard.get((int)(Math.random()*this.FormeStandard.size()));       
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
                Terrain[i-1][j]=Terrain[i][j];
                Terrain[i][j]= new bloc(Color.BLACK, false);
            }
        }
    }

    public boolean perdu(){ //Définir la notion de perdu
        boolean test=false;
        int j=0;
        while ((j< Terrain[1].length)&&(!test)){
            if (Terrain[1][j].vide==false){
                test=true;
            }
            j++;
        }
        return test;
    }
    
    public void ajouterForme(){
    }

    public void bougerDroite(){
        boolean libre=true;
        try {
            for (int i = 0; i < EnJeu.Coordonnees.length; i++) {
                    if(Terrain[EnJeu.Coordonnees[i][0]+EnJeu.origine[0]+1][EnJeu.Coordonnees[i][1]+EnJeu.origine[1]].vide==false){
                        libre=false;
                    }
            }
        } catch ( Exception e ) {
          return; 
        } finally {
          if (libre){
              EnJeu.droite();
            }
        }
    }

    public void bougerGauche(){
        boolean libre=true;
        try {
            for (int i = 0; i < EnJeu.Coordonnees.length; i++) {
                    if(Terrain[EnJeu.Coordonnees[i][0]+EnJeu.origine[0]-1][EnJeu.Coordonnees[i][1]+EnJeu.origine[1]].vide==false){
                        libre=false;
                    }
            }
        } catch ( Exception e ) {
          return; 
        } finally {
          if (libre){
              EnJeu.gauche();
            }
        }
    }

    public void descendre(){
      EnJeu.descendre();//Il faut vérifier qu'il n'y a pas de bloc en bas 
    

    }
    public void tourner(){
      // TODO document why this method is empty
    }


}
