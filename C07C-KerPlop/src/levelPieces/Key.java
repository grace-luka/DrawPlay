/**
 * Authors: Grace Luka and Caroline Schreier
 * Class: Key - This class represents our key gamepiece, which interacts and can be drawn but is not moveable. 
 The key object has a status of GET_POINT if they are in the same location as the player, which allows the player to
 advance to the next level. Otherwise, the key does not interact.
 * Date: 2/5/2024
 * Sources:
 */


package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;


// key "k" - GamePiece + Interaction - GET_POINT (Gives point if the player lands on it)
public class Key extends GamePiece implements Drawable{
	protected char symbol;
	private String label;
	private int location;

	public Key(char s, String l, int lo) {
		super(s, l, lo);
		this.symbol = s;
		this.label = l;
		this.location = lo;
	}
	
	// If the player and the key are in the same location, the interaction result is GET_POINT
	// and the player moves to the next level. Otherwise, nothing happens. 
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == location) {
			return InteractionResult.GET_POINT; //Increase the level 
		} else {
			return InteractionResult.NONE;
		}
	}
	
}
