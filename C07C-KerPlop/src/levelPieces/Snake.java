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
	// Stores the piece location, which will be needed to interact
	// with the player. 
	private int location;
	
	public Snake(char s, String l, int lo) {
		super(s, l, lo);
		this.symbol = s;
		this.label = "snake";
		this.location = lo;
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == (location + 1) || playerLocation == (location - 1)){
			//Player.takeDamage();
			return InteractionResult.HIT; //Increase the level
			
		} else {
			return InteractionResult.NONE;
		}
	}
	
	@Override
	public void move(Drawable[] gameBoard, int location) {
		// if you're not in the farthest right place on the board and the next spot to the right is empty, move right
		if ((location + 1 < gameBoard.length) && (gameBoard[location + 1] == null)) {
			location++;
		}
		// if you're not in the farthest left place and the next spot to the left is empty, move left
		else if ((location - 1 >= 0) && (gameBoard[location - 1] == null)){
			location--;
		}
	}

	//@Override
	//public void draw() {
		//System.out.println('s');
	//}


}