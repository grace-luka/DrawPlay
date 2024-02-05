/**
 * Authors: Grace Luka and Caroline Schreier
 * Class: Blackhole - this class represents one of our unmovable interaction pieces, we did not need to 
 * implement any moveable methods as this gamepiece only interacts with the player when the player comes
 * within a space of the blackhole. This piece uses the Kill interaction and causes the player
 * to return a dead status. 
 * Date: 2/5/2024
 * Sources: 
 */

package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;


// black hole "b" - GamePiece + Interaction - KILL (Will kill a player that is on that space or one space away in any direction)
public class Blackhole extends GamePiece implements Drawable{
	protected char symbol;
	private String label ;
	private int location;

	public Blackhole(char s, String l, int lo) {
		super(s, l, lo);
		this.symbol = s;
		this.label = l;
		this.location = lo;
	}

	// If the player is in the same location as the black hole or is adjacent to the black hole on either side,
	// the interaction result is KILL. Otherwise, nothing happens.
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == location || playerLocation == location + 1 || playerLocation == location - 1){
			return InteractionResult.KILL;
		} else {
			return InteractionResult.NONE;
		}
	}
	
}
