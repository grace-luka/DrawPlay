package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

// snake "s" - HIT (Will kill a player if it is in the same space)
// snake "s" - Moves one space each time, moves left and right.
public class Snake extends GamePiece implements Moveable, Drawable {
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
	public InteractionResult interact(Drawable [] gameBoard, int location) {
		return InteractionResult.HIT; //Increase the level 
	}
	
	@Override
	public void move(Drawable[] gameBoard, int location) {
		if ((location + 1 < gameBoard.length) && (gameBoard[location + 1] == null)) {
			location++;
		}
		else if ((location - 1 <= 0) && (gameBoard[location - 1] == null)){
			location--;
//			int i = location;
//			while(i < gameBoard.length){
//				if (gameBoard[i] == null){
//					location = i;
//					break;
//				}
//				else{
//					i++;
//				}
//			}
		}
		else if ((gameBoard[location + 1] == null))
	}

	@Override
	public void draw() {
		System.out.println('s');
	}


}

// Can you implement two Classes at once? (ex: Moveable and Drawable)
// Could you go over a move method for one of the gamepiece classes?
