
public class Grid {
    private Case[][] grid;

    public Grid(int width, int height, TerrainType terrainType) {
        grid = new Case[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Case(terrainType);
            }
        }
    }

    public Case[][] getGrid() {
        return grid;
    }

    public void displayGrid() {
        for (Case[] row : grid) {
            for (Case cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println();
        }
    }
}
