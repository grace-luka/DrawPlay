/**
 * Authors: Grace Luka and Caroline Schreier
 * Class: Snake - This class represents our snake gamepiece. The snake is moveable, drawable, and interacts.
 The snake moves forward one space if it can, if not it moves backwards if it can, and if not it stays still.
 Its interaction result is HIT, and it only hits if it is in the same location as the player.  
 * Date: 2/5/2024
 * Sources:
 */


package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import gameEngine.Player;

// snake "s" - HIT (Will kill a player if it is in the same space)
// snake "s" - Moves one space each time, moves left and right.
public class Snake extends GamePiece implements Moveable{
	protected char symbol;
	private String label ;
	//private int location;
	
	public Snake(char s, String l, int lo) {
		super(s, l, lo);
		this.symbol = s;
		this.label = "snake";
		this.location = lo;
	}
	
	// If the player and snake are in the same location, the interaction result is HIT. Otherwise,
	// there is no interaction result.
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == location){
			return InteractionResult.HIT;
		} else {
			return InteractionResult.NONE;
		}
	}
	
	// The snake moves right if it is available, if not it moves left, if neither are available it stays in place
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// if you're not in the farthest right place on the board and the next spot to the right is empty, move right
		if ((location + 1 < gameBoard.length) && (gameBoard[location + 1] == null)) {
			location++;
		}
		// if you're not in the farthest left place and the next spot to the left is empty, move left
		else if ((location - 1 >= 0) && (gameBoard[location - 1] == null)){
			location--;
		}
	}


}