package Main;

public class Domino {
	public DominoSideOne dominoSideOne;
	public DominoSideTwo dominoSideTwo;
	private int number;
	private String nameFile;
	private boolean isSelected;
	private boolean isPlaced;

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean selected) {
		isSelected = selected;
	}

	public boolean isPlaced() {
		return isPlaced;
	}

	public void setPlaced(boolean placed) {
		isPlaced = placed;
	}

	public String getNameFile() {
		return nameFile;
	}

	public int getNumber() {
		return number;
	}
	
	public Domino( DominoSideOne dominoSideOne, DominoSideTwo dominoSideTwo, int number, String nameFile ) {
		super();
		this.dominoSideOne = dominoSideOne;
		this.dominoSideTwo = dominoSideTwo;
		this.number = number;
		this.nameFile = nameFile;
	}
}