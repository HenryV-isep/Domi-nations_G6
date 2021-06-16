package Main;

public class Board {

    // Attrubuts of this class
    private boolean isEmpty;
    private DominoSideOne domino1;
    private DominoSideTwo domino2;
    private Castle castle;

    // Getter and Setter
    public DominoSideOne getDomino1() {
        return domino1;
    }

    public void setDomino1( DominoSideOne domino1 ) {
        this.domino1 = domino1;
    }

    public DominoSideTwo getDomino2() {
        return domino2;
    }

    public void setDomino2( DominoSideTwo domino2 ) {
        this.domino2 = domino2;
    }

    public Castle getCastle() {
        return castle;
    }

    public void setCastle( Castle castle ) {
        this.castle = castle;
    }

    public boolean isEmpty() {
            return isEmpty;
        }

    public void setEmpty( boolean empty ) {
            isEmpty = empty;
        }

    // Constructor
    public Board( Castle castle ) {
        this.isEmpty = true;
        this.castle = castle;
    }

    public Board( DominoSideOne domino ) {
        this.isEmpty = true;
        this.domino1 = domino;
    }

    public Board( DominoSideTwo domino ) {
        this.isEmpty = true;
        this.domino2 = domino;
    }

}
