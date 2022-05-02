public class IA {
    TerrainDeJeu Jeu;

    public boolean iaEngaged = false;

    public boolean isIaEngaged() {
        return iaEngaged;
    }


    public IA(TerrainDeJeu Terrain) {
        this.Jeu = Terrain;
    }

    public void joue1Coup() { //Calcul le meilleur coup sur le terrain actuel
            int meilleurNbRotationsDroite = 0;
            int meilleurNbDeplacementsDroite = 0;
            int meilleureEvaluation = -9999;
            int evaluation;
            TerrainDeJeu copieTerrain;
            iaEngaged = true;

            for (int nbRotationsDroite = 0; nbRotationsDroite <= 3; ++nbRotationsDroite) { //Iterere toutes les rotations possibles
                
                for (int nbDeplacementsDroite = 0; nbDeplacementsDroite <= 12;++nbDeplacementsDroite) {
                     // Itere tous les deplacements possibles
                
                    copieTerrain = new TerrainDeJeu(Jeu);// Creer une copie du Terrain
                    // Teste le coup sur la copie du controleur
                    copieTerrain.descendre();
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
            Jeu.descendre();
            for (int i = 0; i < meilleurNbRotationsDroite; i++) {
                Jeu.tourner();
            }
            Jeu.miseAGauche();
            for (int i = 0; i < meilleurNbDeplacementsDroite; i++) {
                Jeu.bougerDroite();
            }
            //Jeu.DescenteInstantane();
        }

    public int evaluation(TerrainDeJeu f) {
        if (Math.abs(f.points-Jeu.points)>10) { //Regarde si une ligne a disparu
            return 1000000;
        }
        //sinon calcule un score dépendant de la position des blocs de la forme
        return  f.points+(f.EnJeu.Coordonnees[0][1]+f.hauteur)+(f.EnJeu.Coordonnees[1][1]+f.hauteur)+(f.EnJeu.Coordonnees[2][1]+f.hauteur)+(f.EnJeu.Coordonnees[3][1]+f.hauteur);
    }
    
}
