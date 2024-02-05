/**
 * Authors: Grace Luka and Caroline Schreier
 * Class: Doorway - this class represnts one of our unmovable and interaction classes, this doorway advances
 * you to the next level of the same when it shares a space with the player. We implemented the advance 
 * result for this classes interaction. 
 * Date: 2/5/2024
 * Sources: 
 */

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
		if (playerLocation == location){
			//Increase the level
			return InteractionResult.ADVANCE;
		}
		else{
			return InteractionResult.NONE;
		}
	}
	
}
