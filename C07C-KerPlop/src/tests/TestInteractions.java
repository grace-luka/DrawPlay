/*
* Authors: Grace Luka and Caroline Schreier

* Class: TestInteractions - This class tests the functionality of each of the game pieces using J Unit 
* testing. Multiple tests are performed, which check both that if an interaction result is supposed to
* happen that it does happen, and check that if there is supposed to be no interaction result, that this
* is the case. 
* Sources: Example code from C09A-2 description
*
*/


package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Frog;
import levelPieces.Snake;
import levelPieces.Key;
import levelPieces.Doorway;
import levelPieces.Blackhole;
import levelPieces.Bridge;

public class TestInteractions {
	// This tests that if the frog is two spaces away from the player in either direction, the interaction
	// result will be hit, and that if the frog is not two spaces away, the interaction result will be none
	@Test
	public void testFrog() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Frog jumpy = new Frog('f', "Frog", 7);
		gameBoard[7] = jumpy;
		assertEquals(InteractionResult.HIT, jumpy.interact(gameBoard, 6));
		assertEquals(InteractionResult.HIT, jumpy.interact(gameBoard, 8));

		for (int i = 0; i < 6; i++){
			assertEquals(InteractionResult.NONE, jumpy.interact(gameBoard, i));
		}
		// if the frog and the player are in the same place, we say that the player has
		// "jumped" on the frog, and there is no interaction result
		assertEquals(InteractionResult.NONE, jumpy.interact(gameBoard, 7));
		for (int i = 9; i < GameEngine.BOARD_SIZE; i++){
			assertEquals(InteractionResult.NONE, jumpy.interact(gameBoard, i));
		}
	}

	// this tests that if the snake is adjacent to the player in either direction or in the same location
	// as the player, the interaction result will be hit, and that otherwise, the result will be none
	@Test
	public void testSnake() {
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
	

//this test tests if the player and the key re on the same location, if they are
	// then the player gets a point
	@Test
	public void testKey() {
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

// this tests that bridge does nothing. Even if the player lands on the bridge
// then the bridge should return an interaction result of none
	@Test
	public void testBridge() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Bridge oak = new Bridge('-', "Bridge", 9);
		gameBoard[9] = oak;
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++){
			assertEquals(InteractionResult.NONE, oak.interact(gameBoard, i));
		}
	}

	
// this test tests that the player advances when lading on the same location
// if the player location and the door location are the same then the interaction
// result is advance and if they are at different locations than nothing happens
	@Test
	public void testDoorway() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Doorway revolving = new Doorway('d', "Doorway", 15);
		assertEquals(InteractionResult.ADVANCE, revolving.interact(gameBoard, 15));
		gameBoard[5] = revolving;
		for (int i = 0; i < 15; i++){
			assertEquals(InteractionResult.NONE, revolving.interact(gameBoard, i));
		}
		for (int i = 17; i < GameEngine.BOARD_SIZE; i++){
			assertEquals(InteractionResult.NONE, revolving.interact(gameBoard, i));
		}
	}

	// this tests that if the player is within two spaces of the black hole, they will be
	// "sucked in" and the interaction result will be KILL
	@Test
	public void testBlackhole(){
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Blackhole swirly = new Blackhole('b', "Blackhole", 12);
		gameBoard[12] = swirly;
		assertEquals(InteractionResult.KILL, swirly.interact(gameBoard, 11));
		assertEquals(InteractionResult.KILL, swirly.interact(gameBoard, 12));
		assertEquals(InteractionResult.KILL, swirly.interact(gameBoard, 13));

		for (int i = 0; i < 11; i++){
			assertEquals(InteractionResult.NONE, swirly.interact(gameBoard, i));
		}
		for (int i = 14; i < GameEngine.BOARD_SIZE; i++){
			assertEquals(InteractionResult.NONE, swirly.interact(gameBoard, i));
		}
	}
}
