package Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Domino {
	public DominoSideOne dominoSideOne;
	public DominoSideTwo dominoSideTwo;
	private int number;
	
	public static void readCsv(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("nat2018.csv")); 
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
		List<Integer> numList = new ArrayList<Integer>();
		for (int i = 1; i<lines.length; i++) {
			String s = lines[i];
			String[] dataLines = s.split(";");
			//SideOne
				//Crown
			String strSideOneCrown = dataLines[0];
			int nOneCrown = Integer.valueOf(strSideOneCrown);
				//Type
			String strSideOneType = dataLines[1];
			
			//SideTwo
				//Crown
			String strSideTwoCrown = dataLines[2];
			int nTwoCrown = Integer.valueOf(strSideTwoCrown);
				//Type
			String strSideTwoType = dataLines[3];
			//Number
			String strN = dataLines[4];
			int nTile = Integer.valueOf(strN);
			
			//Verify
			if(dominoSideOne.getColor().equals(strSideOneType) && dominoSideOne.getCrown() == nOneCrown && dominoSideTwo.getColor().equals(strSideTwoType)  && dominoSideTwo.getCrown() == nTwoCrown) {
				number = nTile;
			}
		}
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
