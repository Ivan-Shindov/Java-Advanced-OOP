package jediGalaxy;

public class Galaxy {
    private BattleField field;

    public Galaxy(BattleField battleField) {
        this.field = battleField;
    }

    public void moveSith(int sithRow, int sithCol) {
        while (sithRow >= 0 && sithCol >= 0) {
            if (this.field.isInBounds(sithRow, sithCol)) {
                this.field.setValue(sithRow, sithCol, 0);
            }
            sithRow--;
            sithCol--;
        }
    }

    public long moveJedi(int jediRow, int jediCol) {
        long sum = 0;

        while (jediRow >= 0 &&
                jediCol < this.field.getColLength(1)) {

            if (this.field.isInBounds(jediRow,jediCol)) {
                sum += this.field.getValue(jediRow,jediCol);
            }
            jediRow--;
            jediCol++;
        }

        return sum;
    }
}
