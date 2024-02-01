package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;


// key "k" - GamePiece + Interaction - GET_POINT (Gives point if the player lands on it)
public class Key extends GamePiece implements Drawable{
	protected char symbol;
	private String label ;
	// Stores the piece location, which will be needed to interact
	// with the player. 
	private int location;

	public Key(char s, String l, int lo) {
		super(s, l, lo);
		this.symbol = s;
		this.label = l;
		this.location = lo;
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		
		return InteractionResult.GET_POINT; //Increase the level 
	}
	
	public void draw() {
		System.out.println('k');
	}
	
}
