package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

// snake "s" - HIT (Will kill a player if it is in the same space)
// snake "s" - Moves two spaces each time, moves left and right.
public class Snake extends GamePiece implements Moveable{
	protected char symbol;
	private String label ;
	// Stores the piece location, which will be needed to interact
	// with the player. 
	private int location;
	
	public Snake(char s, String l, int lo) {
		super(s, l, lo);
		this.symbol = s;
		this.label = l;
		this.location = lo;
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		return InteractionResult.HIT; //Increase the level 
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		
	}

}
