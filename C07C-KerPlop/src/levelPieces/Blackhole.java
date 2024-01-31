package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;

// black hole "b" - GamePiece + Interaction - KILL (Will kill a player that is on that space or one space away in any direction)
public class Blackhole extends GamePiece{
	protected char symbol;
	private String label ;
	// Stores the piece location, which will be needed to interact
	// with the player. 
	private int location;

	public Blackhole(char s, String l, int lo) {
		super(s, l, lo);
		this.symbol = s;
		this.label = l;
		this.location = lo;
	}

	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		return InteractionResult.KILL; //Increase the level 
	}
}
