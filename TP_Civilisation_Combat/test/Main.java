public class Main {
    public static void main(String[] args) {
        /*Grid grid = new Grid(5, 5, TerrainType.FLAT);  // Create a 5x5 grid
        // Crée quelques unités différentes
        Unit warrior = new Warrior(100, 1);
        Unit archer = new Archer(100, 1);
        Unit pikeman = new Pikeman(100, 1);
        Unit knight = new Knight(100, 1);

        // Place les unités dans la grille à différentes positions
        grid.getGrid()[1][1].setUnit(warrior);
        grid.getGrid()[2][3].setUnit(archer);
        grid.getGrid()[4][0].setUnit(pikeman);
        grid.getGrid()[3][2].setUnit(knight);

        // Affiche la grille
        grid.displayGrid();*/

           // Création d'une grille 5x5 avec un terrain plat
        Grid grid = new Grid(5, 5, TerrainType.FLAT);

        // Création de deux unités : un Archer et un Knight
        Unit archer = new Archer(100, 1);
        Unit knight = new Knight(100, 1);

        // Placement des unités dans la grille
        grid.getGrid()[2][2].setUnit(archer);
        grid.getGrid()[2][3].setUnit(knight);

        // Affichage de la grille avant le combat
        System.out.println("Grille avant le combat:");
        grid.displayGrid();

        // L'Archer attaque le Knight
        archer.attack(knight,grid.getGrid()[2][2], grid.getGrid()[2][3], grid.getGrid()[2][2].getTerrain());

        // Affichage de la grille après le combat
        System.out.println("\nGrille après l'attaque de l'Archer sur le Knight:");
        grid.displayGrid();

        // Le Knight riposte et attaque l'Archer
        knight.attack(archer, grid.getGrid()[2][2],grid.getGrid()[2][3], grid.getGrid()[2][3].getTerrain());

        // Affichage de la grille après le combat
        System.out.println("\nGrille après la riposte du Knight:");
        grid.displayGrid();

        archer.attack(knight,grid.getGrid()[2][2], grid.getGrid()[2][3], grid.getGrid()[2][2].getTerrain());

        // Affichage de la grille après le combat
        System.out.println("\nGrille après l'attaque de l'Archer sur le Knight:");
        grid.displayGrid();

        archer.attack(knight,grid.getGrid()[2][2], grid.getGrid()[2][3], grid.getGrid()[2][2].getTerrain());

        // Affichage de la grille après le combat
        System.out.println("\nGrille après l'attaque de l'Archer sur le Knight:");
        grid.displayGrid();

        archer.attack(knight,grid.getGrid()[2][2], grid.getGrid()[2][3], grid.getGrid()[2][2].getTerrain());

        // Affichage de la grille après le combat
        System.out.println("\nGrille après l'attaque de l'Archer sur le Knight:");
        grid.displayGrid();

        archer.attack(knight,grid.getGrid()[2][2], grid.getGrid()[2][3], grid.getGrid()[2][2].getTerrain());

        // Affichage de la grille après le combat
        System.out.println("\nGrille après l'attaque de l'Archer sur le Knight:");
        grid.displayGrid();

        archer.attack(knight,grid.getGrid()[2][2], grid.getGrid()[2][3], grid.getGrid()[2][2].getTerrain());

        // Affichage de la grille après le combat
        System.out.println("\nGrille après l'attaque de l'Archer sur le Knight:");
        grid.displayGrid();
    
    }
}
