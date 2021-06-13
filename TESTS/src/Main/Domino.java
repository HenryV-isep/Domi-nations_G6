package Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Domino {
	public DominoSideOne dominoSideOne;
	public DominoSideTwo dominoSideTwo;
	private int number;
	private String nameFile;

	public Domino(DominoSideOne dominoSideOne, DominoSideTwo dominoSideTwo, int number, String nameFile) {
		super();
		this.dominoSideOne = dominoSideOne;
		this.dominoSideTwo = dominoSideTwo;
		this.number = number;
		this.nameFile = nameFile;
	}

	public String getNameFile() {
		return nameFile;
	}

	public int getNumber() {
		return number;
	}
	
}
