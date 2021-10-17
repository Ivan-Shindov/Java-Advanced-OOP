package jediGalaxy;

public class BattleField {
    private int[][] field;

    public BattleField(int rows, int cols) {
        this(rows,cols,0);
    }

    public BattleField(int rows, int cols,int beginValue) {
        this.field = new int[rows][cols];
        this.fillField(beginValue);
    }


    private void fillField(int beginValue) {
        for (int row = 0; row < this.field.length; row++) {
            for (int col = 0; col < this.field[row].length; col++) {
                this.field[row][col] = beginValue++;
            }
        }
    }

    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < this.field.length && col >= 0 && col < this.field[row].length;
    }

    public void setValue(int row, int col, int value) {
        this.field[row][col] = value;
    }

    public int getColLength(int row) {
        return this.field[row].length;
    }

    public int getValue(int row, int col) {
        return this.field[row][col];
    }
}
