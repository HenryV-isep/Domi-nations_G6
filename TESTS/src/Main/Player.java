package Main;

public class Player {
	public King king;
	public Castle castle;
	private String name;
	private int score = 0;
	private String color;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}

	public String getName() {
		return name;
	}
	

	public String getColor() {
		return color;
	}

	public Player(String name, String color) {
		super();
		this.name = name;
		this.color = color;

	}

}
