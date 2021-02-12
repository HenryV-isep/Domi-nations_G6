package tours;

public class Main {
	public static void main(String[] args) {
		tour();
	}


	public static void tour() {
		for (int t = 0 ; t==8 ; t++) {
			System.out.println(t);
			if (t%2 == 0) {
				System.out.println("Tour numero "+ t +"\n Mr.Jack Commence");
			} else {
				System.out.println("Tour numero "+ t + "\n L'enqueteur Commence");
			}
		}
	}
}