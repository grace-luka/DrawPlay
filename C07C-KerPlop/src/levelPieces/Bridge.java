package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;

// Bridge "B" - Implements Drawable - Does Nothing
public class Bridge implements Drawable{
    protected char symbol;
    private String label;
    private int location;

    public Bridge(char s, String l, int lo) {
		super();
		this.symbol = s;
		this.label = l;
		this.location = lo;
	}

    @Override
	public void draw() {
        // FIXME: Not sure if this is what this should be printing out
		System.out.print("Going over a bridge...");
	}



	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		
	}
}
