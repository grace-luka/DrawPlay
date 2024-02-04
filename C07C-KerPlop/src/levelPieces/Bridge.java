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
		return null;
	}

}
