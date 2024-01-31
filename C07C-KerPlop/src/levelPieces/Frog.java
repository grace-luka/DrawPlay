package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

// frog "f" - HIT (Jumps to an open space only if there is an open space next to it, can hit you within 2 spaces)
public class Frog extends GamePiece implements Moveable{
	protected char symbol;
	private String label ;
	// Stores the piece location, which will be needed to interact
	// with the player. 
	private int location;

	public Frog(char s, String l, int lo) {
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
		// TODO Auto-generated method stub
		
	}

}
