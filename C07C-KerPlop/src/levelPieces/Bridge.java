/**
 * Authors: Grace Luka and Caroline Schreier
 * Class: Bridge - this class represents are unmovable and not interacting class, this one is just drawn
 * to the gameboard and has the player and other game pieces pass over it. We did still include a
 * Interaction method as it falls under a the gamepiece parent class but only returns and interaction
 * of None
 * Date: 2/5/2024
 * Sources: 
 */

package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;

// Bridge "B" - Implements Drawable - Does Nothing
public class Bridge extends GamePiece implements Drawable{
    protected char symbol;
    private String label;
    private int location;

    public Bridge(char s, String l, int lo) {
		super(s, l, lo);
		this.symbol = s;
		this.label = l;
		this.location = lo;
	}


	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		return InteractionResult.NONE;
	}


}
