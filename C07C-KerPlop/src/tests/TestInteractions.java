/*
* Test that Frog hits player (interaction) only when player is to the left or 
* to the right of the frog
 */

package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import levelPieces.Frog;
import levelPieces.Snake;
import levelPieces.Key;
import levelPieces.Doorway;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

class TestInteractions {

	@Test
	void testFrog() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Frog jumpy = new Frog('f', "Frog", 7);
		gameBoard[7] = jumpy;
		assertEquals(InteractionResult.HIT, jumpy.interact(gameBoard, 6));
		assertEquals(InteractionResult.HIT, jumpy.interact(gameBoard, 8));

		for (int i = 0; i < 6; i++){
			assertEquals(InteractionResult.NONE, jumpy.interact(gameBoard, i));
		}
		assertEquals(InteractionResult.NONE, jumpy.interact(gameBoard, 7))
		for (int i = 9; i < GameEngine.BOARD_SIZE; i++){
			assertEquals(InteractionResult.NONE, jumpy.interact(gameBoard, i));
		}
	}

	@Test
	void testSnake() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Snake hiss = new Snake('s', "Snake", 13);
		gameBoard[13] = hiss;
		assertEquals(InteractionResult.HIT, hiss.interact(gameBoard, 13));
		for (int i = 0; i < 13; i++){
			assertEquals(InteractionResult.NONE, hiss.interact(gameBoard, i));
		}
		for (int i = 14; i < GameEngine.BOARD_SIZE; i++){
			assertEquals(InteractionResult.NONE, hiss.interact(gameBoard, i));
		}
	}

	@Test
	void testKey() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Key car = new Key('k', "Key", 19);
		gameBoard[19] = car;
		assertEquals(InteractionResult.GET_POINT, car.interact(gameBoard, 19));
		for (int i = 0; i < 19; i++){
			assertEquals(InteractionResult.NONE, car.interact(gameBoard, i));
		}
		for (int i = 20; i < GameEngine.BOARD_SIZE; i++){
			assertEquals(InteractionResult.NONE, car.interact(gameBoard, i));
		}
	}

	@Test
	void testDoorway() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Doorway revolving = new Doorway('d', "Doorway", 5);
		gameBoard[5] = revolving;
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++){
			assertEquals(InteractionResult.NONE, revolving.interact(gameBoard, i));
		}
	}

	


}
