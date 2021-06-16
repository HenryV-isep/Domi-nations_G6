package Main;

public class DominoSideOne{
	
	// Attributs of this class 
	private int crown;
	private String type;

	//  Getter and Setter
	public int getCrown() {
		return crown;
	}

	public void setType( String type ) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	// Constructor
	public DominoSideOne( int crown, String type ){
		super();
		this.crown = crown;
		this.type = type;
	}
}
