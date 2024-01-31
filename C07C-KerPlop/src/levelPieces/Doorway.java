package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;

//doorway "d" - GamePiece + Interaction - ADVANCE (interacts on same location)
public class Doorway extends GamePiece{
    protected char symbol;
	private String label ;
	// Stores the piece location, which will be needed to interact
	// with the player. 
	private int location;

    public Doorway(char s, String l, int lo) {
		super(s, l, lo);
		this.symbol = s;
		this.label = l;
		this.location = lo;
	}

	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		
		return InteractionResult.ADVANCE; //Increase the level 
	}




}
