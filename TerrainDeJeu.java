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
        Terrain = new bloc[12][21]; // ligne et colonne
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
        for (int i = 0; i < Terrain[0].length; i++) {
            int nonvide = 0;
            for (int j = 0; j < Terrain.length; j++) {
                if (Terrain[j][i].vide==false) {
                    nonvide++;
                }
            }
            if (nonvide==12){
                DecaleEnBas(i);
                bonus++; // j'ai juste fait un bonus pour valoriser les enchainements
                this.points=this.points+13*bonus;
            }
        }
    }
    public void DecaleEnBas(int ligne){ // c'est une méthode qui décale les blocs qui ne sont pas fixes vers le bas à partir d'une ligne que l'on précise
        for (int i = ligne; i > 0 ; i--) { //ligne parcourt du bas du tableau jusqu'en haut
            for (int j = 0; j < Terrain.length; j++) { // Colonne
                Terrain[j][i]=Terrain[j][i-1];
                Terrain[j][i-1]= new bloc(Color.black,true);
            }
        }
    }

    public boolean perdu(){ // vérifie si la partie est perdu ou non et renvoie un booléen
        boolean test=false;
        int j=0;
        while ((j< Terrain.length)&&(!test)){
            if (Terrain[j][0].vide==false){
                test=true;
            }
            j++;
        }
        return test;
    }
    
    public void ajouterForme() {//Change la forme quand elle a atteint le bas 
        points=points+4;
        EnJeu.origine[0]=6;//Remet l'origine en place
        EnJeu.origine[1]=0;
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
                    if(Terrain[EnJeu.Coordonnees[i][0]+EnJeu.origine[0]-1][EnJeu.Coordonnees[i][1]+EnJeu.origine[1]].vide==false){
                        libre=false;
                    }
            }
        } catch ( Exception e ) {
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
            if(EnJeu.origine[1]>0){
                libre=false;
            }
            
        } finally {
            if (libre){
              EnJeu.descendre();
            }else{
                    try{
                        for (int i = 0; i < EnJeu.Coordonnees.length; i++) {
                            Terrain[EnJeu.Coordonnees[i][0]+EnJeu.origine[0]][EnJeu.Coordonnees[i][1]+EnJeu.origine[1]]=new bloc(EnJeu.couleur, false);
                        }
                    }catch(Exception e){
                            perdu();
                    }finally{
                        ajouterForme();
                        LigneComplete();
                    }
                
            }
        }
        
    }
    
    public void tourner(){
        forme temp= new forme(EnJeu);
        temp.rotation();
        boolean libre=true;
        try {
            for (int i = 0; i < temp.Coordonnees.length; i++) {
                    if(Terrain[temp.Coordonnees[i][0]+temp.origine[0]][temp.Coordonnees[i][1]+temp.origine[1]].vide==false){
                        libre=false;
                    }
            }
        } catch ( Exception e ) {
            libre=false;
        } finally {
            if (libre){
              EnJeu.rotation();
            }
        }
    }

}
