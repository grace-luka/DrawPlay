/**
 * Authors: Grace Luka and Caroline Schreier
 * Class: Frog - this class represents one of our moveable and interacting pieces. We implemented the 
 * interaction class when a player came within one space of the frog, but the player is allowed to step onto
 * the frog and take no damage. We also implemented the move method for this class, allowing the frog to
 * jump over a space on the next level. 
 * Date: 2/5/2024
 * Sources: 
 */

package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

// frog "f" - HIT (Jumps to an open space only if there is an open space next to it, can hit you within 2 spaces)
public class Frog extends GamePiece implements Moveable, Drawable{
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

	// If the player is in the same place as the frog, they have "jumped onto" the frog, and nothing happens.
	// If the player is adjacent to the frog, the interaction result is HIT, and if the player is farther away
	// the frog, nothing happens.
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == (location + 1) || playerLocation == (location - 1)){
			return InteractionResult.HIT; //Increase the level
		} else {
			return InteractionResult.NONE;
		}
	}

	// If the space two to the right is available, the frog moves there. Otherwise, if the space two to
	// the left is available, the frog moves there. Otherwise, the frog does not move.
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// if two moves to the right is still on the board and is empty, move two moves to the right
		if ((location + 2 < gameBoard.length) && (gameBoard[location + 2] == null)) {
			location += 2;
		}
		// if two moves to the left is still on the board and is empty, move two moves to the left
		else if ((location - 1 >= 0) && (gameBoard[location - 1] == null)){
			location -= 2;
		}
	}

}
