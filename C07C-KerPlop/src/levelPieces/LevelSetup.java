/**
 * Authors:
 * Class:
 * Date:
 * Sources: https://www.w3schools.com/java/java_arraylist.asp
 https://www.geeksforgeeks.org/generating-random-numbers-in-java/
 
 */

package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import java.util.ArrayList;
import java.util.Random;

public class LevelSetup {
	
	private ArrayList<GamePiece> interactingPieces = new ArrayList<GamePiece>();
    private ArrayList<Moveable> movingPieces = new ArrayList<Moveable>();

    public void createLevel(int levelNum){
        Random rand = new Random();

        int numFrogs = rand.nextInt(3);
        for (int i = 0; i <= numFrogs; i++) {
            int frogPosition = rand.nextInt(20) + 1;
        	Frog ribbit = new Frog('f', "Frog", frogPosition);
            interactingPieces.add(ribbit);
        	movingPieces.add(ribbit);
        }

        int numSnakes = rand.nextInt(3);
        for (int i = 0; i <= numSnakes; i++) {
        	int snakePosition = rand.nextInt(20) + 1;
        	Snake hiss = new Snake('s', "Snake", snakePosition);
        	interactingPieces.add(hiss);
        	movingPieces.add(hiss);
        }
        
        int numBlackhole = rand.nextInt(2);
        for (int i =0; i <= numBlackhole; i++) {
        	int blackHolePosition = rand.nextInt(20);
        	Blackhole hole = new Blackhole('b', "Blackhole", blackHolePosition);
        	interactingPieces.add(hole);
        }
        
        int numDoorway = rand.nextInt(2);
        for (int i = 0; i <= numDoorway; i++) {
        	int doorwayPosition = rand.nextInt(20);
        	Doorway door = new Doorway('d', "Doorway", doorwayPosition);
        	interactingPieces.add(door);
        }

        int numBridges = rand.nextInt(3);
        for (int i = 0; i <= numSnakes; i++){
            int bridgePosition = rand.nextInt(20) + 1;
            Bridge cobbleStone = new Bridge('b', "Bridge", bridgePosition);
            interactingPieces.add(cobbleStone);
        }

        
    	
    }
    
    public Drawable[] getBoard(){
        Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        return gameBoard;
    }
    
    public ArrayList<GamePiece> getInteractingPieces() {
    	return interactingPieces;
    }
    
    public ArrayList<Moveable> getMovingPieces() {
        return movingPieces;
    }
    
    public int getPlayerStartLoc() {
        return startingLocation;
    }
    
}
