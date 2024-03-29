import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class Cat {
	// drawing constants are private - noone needs to know what we're doing
	// pick a head dimension
	private static final int HEAD_DIMENSION = 60;
	// eyes will be about 1/6 from top of head and 1/6 from left
	private static final int EYE_Y = HEAD_DIMENSION/8 + 10;
	private static final int EYE_X = HEAD_DIMENSION/8;
	private static final int EYE_SEPARATION = HEAD_DIMENSION/3 + 10;
	// pick eye dimensions
	private static final int EYE_HEIGHT = 20;
	private static final int EYE_WIDTH = 10;
	// pick mouth height, width is based on head dimension
	private static final int MOUTH_HEIGHT = 10;
	private static final int MOUTH_WIDTH = HEAD_DIMENSION/4;
	// mouth starts about 40% from left edge of head
	private static final int MOUTH_X = HEAD_DIMENSION/5 * 2 + 10;
	private static final int MOUTH_Y = HEAD_DIMENSION/5 * 3 + 10;
	
	// draw will render the Cat on the Graphics object
	public void draw(Graphics g, int catX, int catY)
	{
		Graphics2D g2 = (Graphics2D) g;
		int x=catX + 10;
		int y=catY + 10;
		// Draw the head
		g2.setColor(Color.orange);
		g2.fillOval(x, y, HEAD_DIMENSION, HEAD_DIMENSION);
		// Draw the eyes
		g2.setColor(Color.blue);
		x = catX + EYE_X + 10; 
		y = catY + EYE_Y + 10;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		x += EYE_SEPARATION;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		// Draw the mouth
		g2.setColor(Color.pink);
		x = catX + MOUTH_X + 10;
		y = catY + MOUTH_Y + 10;
		g2.fillOval(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		g2.setColor(Color.magenta);
		// Woof text appears below cat head, +10 places below 
		// so it doesn't overlap the drawing
		g2.drawString("I'm a tennis ball", catX + 50, catY + HEAD_DIMENSION +50);
		g2.drawString("boing...boing...boing",catX + 100, catY + 10);
	}
}
