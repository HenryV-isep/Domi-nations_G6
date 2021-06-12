package Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Domino {
	public DominoSideOne dominoSideOne;
	public DominoSideTwo dominoSideTwo;
	private int number;
	
	public static void readCsv(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("dominos.csv")); 
		StringBuilder sb = new StringBuilder(); 
		while (scanner.hasNextLine()) { 
		 sb.append(scanner.nextLine()) 
		 .append("\n"); 
		} 
		scanner.close(); 
		String data = sb.toString();
		@SuppressWarnings("unused")
		String[] lines = data.split("\n");
	}

	@SuppressWarnings("null")
	public int getNumber() throws FileNotFoundException {
		String[] lines = null;
		readCsv(lines);
		for (int i = 1; i<lines.length; i++) {
			String s = lines[i];
			String[] dataLines = s.split(";");
			//SideOne
				//Crown
			String strSideOneCrown = dataLines[0];
			int intOneCrown = Integer.valueOf(strSideOneCrown);
				//Type
			String strSideOneType = dataLines[1];
			//SideTwo
				//Crown
			String strSideTwoCrown = dataLines[2];
			int intTwoCrown = Integer.valueOf(strSideTwoCrown);
				//Type
			String strSideTwoType = dataLines[3];
			//Number
			String strN = dataLines[4];
			int intTile = Integer.valueOf(strN);
			
			if(dominoSideOne.getType().equals(strSideOneType) && dominoSideOne.getCrown() == intOneCrown && dominoSideTwo.getType().equals(strSideTwoType)  && dominoSideTwo.getCrown() == intTwoCrown) {
				number = intTile;	
			}
			
			/*Verify
			if(strSideOneType.equals("Champs") && 1 == nOneCrown && strSideTwoType.equals("Montage")  && 0 == nTwoCrown) {
				number = nTile;
			}*/
		}
		return number;
	}

	public void getNumber(int number) {
		this.number = number;
	}
	
}
