package Main;

public class Player {
	private String name;
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
	public King king;
}
