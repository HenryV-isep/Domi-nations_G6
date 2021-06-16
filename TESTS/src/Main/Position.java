package Main;

public class Position {
    private int column;
    private int row;
    public Domino dominoSelected;

    public int getColumn() {
        return column;
    }
    public void setColumn(char column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }

    public Position(int column,int row, Domino dominoSelected){
        this.column = column;
        this.row = row;
        this.dominoSelected = dominoSelected;
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
