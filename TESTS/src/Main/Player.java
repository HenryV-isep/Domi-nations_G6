package Main;

public class Player {
	public King king;
	public Castle castle;
	private String name;
	private int score = 0;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}

	public String getName() {
		return name;
	}
	public void setName() {
		this.name = name;
	}
	
	private String color;
	public String getColor() {
		return color;
	}
	public void setColor() {
		this.color = color;
	}

	public Player(String name, String color) {
		super();
		this.name = name;
		this.color = color;

	}

}
