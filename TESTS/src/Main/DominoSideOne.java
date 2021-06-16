package Main;

public class DominoSideOne{
	private int crown;
	public int getCrown() {
		return crown;
	}
	private String type;

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public DominoSideOne(int crown, String type){
		super();
		this.crown = crown;
		this.type = type;
	}
	
}
