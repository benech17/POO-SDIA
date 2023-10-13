
public class Case {
    private Unit unit;
    private TerrainType terrain;

    public Case(TerrainType terrain) {
        this.terrain = terrain;
    }

    public TerrainType getTerrain() {
        return terrain;
    }
    
    public boolean isEmpty() {
        return unit == null;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return unit != null ? unit.toString() : "-----E M P T Y-----";
    }
}
