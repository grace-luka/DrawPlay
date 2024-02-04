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

	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == (location + 1) || playerLocation == (location - 1)){
			return InteractionResult.HIT; //Increase the level
		} else {
			return InteractionResult.NONE;
		}
	}

	@Override
	public void move(Drawable[] gameBoard, int location) {
		// if two moves to the right is still on the board and is empty, move two moves to the right
		if ((location + 2 < gameBoard.length) && (gameBoard[location + 2] == null)) {
			location += 2;
		}
		// if two moves to the left is still on the board and is empty, move two moves to the left
		else if ((location - 1 >= 0) && (gameBoard[location - 1] == null)){
			location -= 2;
		}
	}
	
	@Override
	public void draw() {
		System.out.print('f');
	}

}
