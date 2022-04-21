public class IA {
    TerrainDeJeu Terrain;

    public IA(TerrainDeJeu Terrain) {
        this.Terrain = Terrain;
    }

    public void joue1Coup() {
            int meilleurNbRotationsDroite = 0;
            int meilleurNbDeplacementsDroite = 0;
            int meilleureEvaluation = -9999;
            int evaluation;
            TerrainDeJeu copieControleurPlateau;

            for (int nbRotationsDroite = 0; nbRotationsDroite <= 3; ++nbRotationsDroite) { //Iterere toutes les rotations possibles
                
                for (int nbDeplacementsDroite = 0; nbDeplacementsDroite <= 12;++nbDeplacementsDroite) {
                     // Itere tous les deplacements possibles
                
                    copieControleurPlateau = new TerrainDeJeu(Terrain);// Creer une copie du Terrain
                    // Teste le coup sur la copie du controleur
                    for (int i = 0; i < nbRotationsDroite; ++i) {
                        copieControleurPlateau.tourner();
                    }
                    copieControleurPlateau.miseAGauche();
                    for (int i = 0; i < nbDeplacementsDroite; ++i) {
                        copieControleurPlateau.bougerDroite();
                    }
                    copieControleurPlateau.DescenteInstantane();
                    // Evalue le coup
                    evaluation = evaluation(copieControleurPlateau);
                    // Sauvegarde le coup si meilleur
                    if (evaluation > meilleureEvaluation) {
                        meilleureEvaluation = evaluation;
                        meilleurNbDeplacementsDroite = nbDeplacementsDroite;
                        meilleurNbRotationsDroite = nbRotationsDroite;
                    }
                }
            }
            for (int i = 0; i < meilleurNbRotationsDroite; i++) {
                Terrain.tourner();
                }
                Terrain.miseAGauche();
                for (int i = 0; i < meilleurNbDeplacementsDroite; i++) {
                Terrain.bougerDroite();
                }
                Terrain.DescenteInstantane();
        }

    public int evaluation(TerrainDeJeu f) {
        return f.hauteur * 5 + f.points;
    }
}
