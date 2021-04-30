package Main;

import Main.swing;

public class Main {
	public static void main(String[] args) {
		swing inter = new swing();
	}



	static String tour( int tour) {
		if (tour%2 == 0) {
			return "Tour numero "+ tour +"\nMr.Jack Commence";
		} else {
			return "Tour numero "+ tour + "\nL'enqueteur czommence";
		}
	}
}

