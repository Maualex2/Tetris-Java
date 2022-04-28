public class IA {
    TerrainDeJeu Jeu;

    public IA(TerrainDeJeu Terrain) {
        this.Jeu = Terrain;
    }

    public void joue1Coup() {
            int meilleurNbRotationsDroite = 0;
            int meilleurNbDeplacementsDroite = 0;
            int meilleureEvaluation = -9999;
            int evaluation;
            TerrainDeJeu copieTerrain;

            for (int nbRotationsDroite = 0; nbRotationsDroite <= 3; ++nbRotationsDroite) { //Iterere toutes les rotations possibles
                
                for (int nbDeplacementsDroite = 0; nbDeplacementsDroite <= 12;++nbDeplacementsDroite) {
                     // Itere tous les deplacements possibles
                
                    copieTerrain = new TerrainDeJeu(Jeu);// Creer une copie du Terrain
                    // Teste le coup sur la copie du controleur
                    
                    for (int i = 0; i < nbRotationsDroite; ++i) {
                        copieTerrain.tourner();
                        //System.out.println(copieControleurPlateau.EnJeu.Coordonnees[1][0]);
                    }
                    copieTerrain.miseAGauche();
                    for (int i = 0; i < nbDeplacementsDroite; ++i) {
                        copieTerrain.bougerDroite();
                    }
                    copieTerrain.DescenteInstantane();
                    // Evalue le coup
                    
                    evaluation = evaluation(copieTerrain);
                    // Sauvegarde le coup si meilleur
                    if (evaluation > meilleureEvaluation) {
                        meilleureEvaluation = evaluation;
                        meilleurNbDeplacementsDroite = nbDeplacementsDroite;
                        meilleurNbRotationsDroite = nbRotationsDroite;
                    }
                }
            }
            
            for (int i = 0; i < meilleurNbRotationsDroite; i++) {
                Jeu.tourner();
            }
            Jeu.miseAGauche();
            for (int i = 0; i < meilleurNbDeplacementsDroite; i++) {
                Jeu.bougerDroite();
            }
            Jeu.DescenteInstantane();
        }

    public int evaluation(TerrainDeJeu f) {
        int nbcaseinitiale = 0;
        int nbcasefinal = 0;
        /* for (int i = 0; i < f.Terrain[0].length; i++) {
            for (int j = 0; j < f.Terrain.length; j++) {
                if (f.Terrain[j][i].vide==false) {
                    nbcasefinal++;
                }
            }
        }
        for (int i = 0; i < Jeu.Terrain[0].length; i++) {
            for (int j = 0; j < Jeu.Terrain.length; j++) {
                if (Jeu.Terrain[j][i].vide==false) {
                    nbcasefinal++;
                }
            }
        }
        if ((Math.abs(nbcasefinal-nbcaseinitiale)>20)){
            return 100000000;
        } */
        if (Math.abs(f.points-Jeu.points)>10) {
            return 1000000;
        }
        return  (f.EnJeu.Coordonnees[0][1]+f.hauteur)+(f.EnJeu.Coordonnees[1][1]+f.hauteur)+(f.EnJeu.Coordonnees[2][1]+f.hauteur)+(f.EnJeu.Coordonnees[3][1]+f.hauteur);
    }
    
}
