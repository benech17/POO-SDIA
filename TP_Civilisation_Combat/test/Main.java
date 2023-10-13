public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(5, 5, TerrainType.FLAT);  // Create a 5x5 grid
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
        grid.displayGrid();
    }
}
