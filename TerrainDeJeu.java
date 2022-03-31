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
        Terrain = new bloc[12][21];
        for (int i = 0; i < Terrain.length; i++) {
            for (int j = 0; j < Terrain[i].length; j++) {
                Terrain[i][j]=new bloc(Color.black,true);
            }
        }
        points = 0;
        FormeJouee = null;
        this.FormeStandard = FormeStandard;
        FormeEnAttente = this.FormeStandard.get((int)(Math.random()*this.FormeStandard.size()));
        EnJeu = this.FormeStandard.get((int)(Math.random()*this.FormeStandard.size()));       
    }

    public void LigneComplete(){ // parcourt le tableau et compte les blocs A VERIFIER
        int bonus = 0;
        for (int i = 0; i < Terrain.length; i++) {
            int nonvide = 0;
            System.out.println("Nouvelle ligne");
            for (int j = 0; j < Terrain[i].length; j++) {
                if (Terrain[i][j].vide==false) {
                    nonvide++;
                }
            }
            if (nonvide==12){
                DecaleEnBas(i);
                bonus++; // j'ai juste fait un bonus pour valoriser les enchainements
                points=points+13*bonus;
            }
            System.out.println(nonvide);
        }
    }
    public void DecaleEnBas(int ligne){ // c'est une méthode qui décale les blocs qui ne sont pas fixes vers le bas à partir d'une ligne que l'on précise
        for (int i = ligne; i > 0 ; i--) { //ligne parcourt du bas du tableau jusqu'en haut
            for (int j = 0; j < Terrain[i].length; j++) { // Colonne
                Terrain[i-1][j]=Terrain[i][j];
                Terrain[i][j]= new bloc(Color.black,false);
            }
        }
    }

    public boolean perdu(){ //A reprendre car ne prends pas encompte le cas ou on fait apparaitre une pièce sur des blocs existans
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
    
    public void ajouterForme() {//Change la forme quand elle a atteint le bas 
        EnJeu.origine[0]=6;//Remet l'origine en place
        EnJeu.origine[1]=3;
        EnJeu=FormeEnAttente;
        FormeEnAttente = this.FormeStandard.get((int)(Math.random()*this.FormeStandard.size()));
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
          libre=false; 
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
                    System.out.println(EnJeu.Coordonnees[i][0]+EnJeu.origine[0]-1);
                    if(Terrain[EnJeu.Coordonnees[i][0]+EnJeu.origine[0]-1][EnJeu.Coordonnees[i][1]+EnJeu.origine[1]].vide==false){
                        libre=false;
                        System.out.println("Test");
                    }
            }
        } catch ( Exception e ) {
            System.out.println("Testerreur");
          libre=false;
        } finally {
          if (libre==true){
              EnJeu.gauche();

            }
        }
    }

    public void descendre(){
        boolean libre=true;
        //System.out.print(EnJeu.origine[0]);
        //System.out.println(EnJeu.origine[1]);
        try {
            for (int i = 0; i < EnJeu.Coordonnees.length; i++) {
                    if(Terrain[EnJeu.Coordonnees[i][0]+EnJeu.origine[0]][EnJeu.Coordonnees[i][1]+EnJeu.origine[1]+1].vide==false){
                        libre=false;
                    }
            }
        } catch ( Exception e ) {
            libre=false;
        } finally {
            if (libre){
              EnJeu.descendre();
            }else{
                for (int i = 0; i < EnJeu.Coordonnees.length; i++) {
                    Terrain[EnJeu.Coordonnees[i][0]+EnJeu.origine[0]][EnJeu.Coordonnees[i][1]+EnJeu.origine[1]]=new bloc(EnJeu.couleur, false);
                    }
                ajouterForme();
                LigneComplete();
            }
        }
        
    }
    
    public void tourner(){
      // TODO document why this method is empty
    }


}
