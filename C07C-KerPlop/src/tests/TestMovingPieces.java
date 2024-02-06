/*
	 * Tests random motion, used by both the Snake and Frog.
	 * Strategy: 
	 * - Place pieces in all spaces EXCEPT 0, 9, 13, 14, 17.
	 * - Ensures both end spots (0 and 20) are open.
	 * - Same piece is used in all spaces, as piece identity doesn't matter.
	 * - Set player location to space 13.
	 * - Call move function many times, ensure each open space is chosen
	 *   (13 is "open" but has the player, so it should NOT be chosen)
	 */

package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.Bridge;
import levelPieces.Snake;

class TestRandomMovement {

	@Test
	void testSnakeMotion() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		//Start with 1, leaves 0 open
		for (int i = 1; i <= 8; i++){
			gameBoard[i] = new Bridge('b', "Bridge", i);
		}
		// Leave 9 open
		for (int i = 10; i <= 12; i++){
			gameBoard[i] = new Bridge('b', "Bridge", i);
		}
		// Leave 13 and 14 open
		gameBoard[15] = new Bridge('b', "Bridge", 15);
		// Leave 17 open, assume player in 17
		for (int i = 18; i < GameEngine.BOARD_SIZE; i++){
			gameBoard[i] = new Bridge('b', "Bridge", i);
		}
		Snake slither = new Snake('s', "snake", 9);
		gameBoard[9] = slither;
		int count0 = 0;
		int count9 = 0;
		int count13 = 0;
		int count14 = 0;
		for (int i = 0; i < 300; i++){
			slither.move(gameBoard, 17);
			int loc = slither.getLocation();
			// ensure no other space is chosen
			if (loc!= 0 && loc != 9 && loc != 13 && loc != 14){
				fail("Invalid square selected");
			}
			if (loc == 0) count0++;
			if (loc == 9) count9++;
			if (loc == 13) count13++;
			if (loc == 14) count14++;
		}
		// Ensure each option is randomly chosen some number of times
		assert (count0 > 1);
		assert (count9 > 1);
		assert (count13 > 1);
		assert (count14 > 1);
	}
}
