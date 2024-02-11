/*
Authors: Grace Luka and Caroline Schreier 
Class: Tests the left, right and no motion for the snake and frog. If the snake
has the ability to move left or right then it should move one space to the right (2
for the frog) and if they have the option only to move to the left then the 
snake should move once to the left (2 spaces for frog) and if they can't move
left or right because those spaces are not open, then they should do nothing. 
date: 2-8-2024
sources:
*/

package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.Bridge;
import levelPieces.Snake;
import levelPieces.Frog;

class TestRandomMovement {

	// If the gameboard is free, and there is nothing to the right or left, the frog should move two
	// spaces right and the snake should move one unit right.
	@Test
	public void testMovesRight() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		//Checking if the snake moves once to the right
		Snake slither = new Snake('s', "Snake", 2);
		gameBoard[2] = slither;
		slither.move(gameBoard, 1);
		assertEquals(3, slither.getLocation());
		
		//chacking if frog moves two places to the right
		Frog kermit = new Frog('f', "F", 15);
		gameBoard[15] = kermit;
		kermit.move(gameBoard, 1);
		assert(kermit.getLocation() == 17);
		
		
	}
	
	// If there is something to the right of frog or snake (one space away for frog, two spaces
	// away for snake) then it should check if they can move to the left instead. Since the left
	// side is free in these test cases, frog should move two spaces left and snake should move one 
	// space left.
	@Test
	public void testMovesLeft() {
		Drawable [] gameBoard2 = new Drawable[GameEngine.BOARD_SIZE];
		for (int i = 16; i < GameEngine.BOARD_SIZE; i++){
			gameBoard2[i] = new Bridge('b', "Bridge", i);
		}
		Frog jumpy = new Frog('f', "Frog", 15);
		gameBoard2[15] = jumpy;
		jumpy.move(gameBoard2, 1);
		assert(jumpy.getLocation() == 13);
		
		for (int i = 4; i < 10; i++) {
			gameBoard2[i] = new Bridge('b', "Bridge", i);
		}
		Snake python = new Snake('s', "Snake", 3);
		gameBoard2[3] = python;
		python.move(gameBoard2, 1);
		assert(python.getLocation() == 2);
		
	}

	// If there is something to the right and left of snake, then it should note that somethings there
	// and not move. If there is something two spaces away on the left and right from frog, it should
	// note that somethings there and not move.
	@Test
	public void testDoesNotMove() {

		Drawable [] gameBoard3 = new Drawable[GameEngine.BOARD_SIZE];
		for (int i = 0; i < 8; i++){
			gameBoard3[i] = new Bridge('b', "Bridge", i);
		}
		for (int i = 9; i < 16; i++){
			gameBoard3[i] = new Bridge('b', "Bridge", i);
		}
		for (int i = 17; i < GameEngine.BOARD_SIZE; i++){
			gameBoard3[i] = new Bridge('b', "Bridge", i);
		}
		Snake Nagini = new Snake('s', "Snake", 8);
		gameBoard3[8] = Nagini;
		Nagini.move(gameBoard3, 1);
		assert(Nagini.getLocation() == 8);
		
		Frog slippy = new Frog('f', "Frog", 16);
		gameBoard3[16] = slippy;
		slippy.move(gameBoard3, 1);
		assert(slippy.getLocation() == 16);
		
		/*
		@Test
		void testRandomMotion() {
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
		*/
	}
	
}
