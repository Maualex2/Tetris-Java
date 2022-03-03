public class Main {
    public static void main(String[] args) {
        
        bloc[][] TerraindeJeu = new bloc[21][13];
        for (int i = 0; i < TerraindeJeu.length; i++) {
            TerraindeJeu[i][0]= new limiteterrain();
            TerraindeJeu[i][12]= new limiteterrain();
        }
        for (int i = 0; i < TerraindeJeu[1].length; i++) {
            TerraindeJeu[0][i]= new limiteterrain();
            TerraindeJeu[20][i]= new limiteterrain();
        }
        Fenetre f = new Fenetre();
    }
}
