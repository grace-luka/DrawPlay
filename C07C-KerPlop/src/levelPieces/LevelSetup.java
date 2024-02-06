/**
 * Authors: Grace Luka and Caroline Schreier
 * Class: This class created our levels. Because the gameboard changes between levels this class had three
 * very important arrays that stored the information of our game pieces. The first array which contained
 * many of our game pieces was the interacting pieces array, any class that didnt result in a none interaction
 * was put into this list once and instance of the class was created. The next array was movable, this
 * array help instances of our snakes and frogs, once a snake or frog was created it was added to this
 * array to be used later by gameEngine. The last array was of the actual level of the game, this array held
 * all of the intances of the child classes because each of our gamepieces required to be added to the 
 * gamebaord. We also created the instances of each of the child classes by using the random function. This
 * allowed us to randomized if and where a game piece would be. 
 * Date: 2/5/2024
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
    //Whenever gamepieces with one of these attributes is created, they are added to the corresponding array list.
	private ArrayList<GamePiece> interactingPieces = new ArrayList<GamePiece>();
    private ArrayList<Moveable> movingPieces = new ArrayList<Moveable>();
    private Drawable[] levelGameBoard = new Drawable[GameEngine.BOARD_SIZE];

    public void createLevel(int levelNum){
        // creates random number of new frog objects and adds the frogs to interactingPieces, movingPieces, and levelGameBoard
        Random rand = new Random();
        int numFrogs = rand.nextInt(1);
        for (int i = 0; i <= numFrogs; i++) {
            int frogPosition = rand.nextInt(20) + 1;
        	Frog ribbit = new Frog('f', "Frog", frogPosition);
            interactingPieces.add(ribbit);
        	movingPieces.add(ribbit);
            levelGameBoard[frogPosition] = ribbit;
        }

        // creates random number of new snake objects and adds them to interactingPieces, movingPieces, and levelGameBoard
        int numSnakes = rand.nextInt(1);
        for (int i = 0; i <= numSnakes; i++) {
        	int snakePosition = rand.nextInt(20) + 1;
        	Snake hiss = new Snake('s', "Snake", snakePosition);
        	interactingPieces.add(hiss);
        	movingPieces.add(hiss);
            levelGameBoard[snakePosition] = hiss;
        }
        
        // creates random number of new blackHole object and adds it to interactingPieces and levelGameBoard
        int numBlackhole = rand.nextInt(1);
        for (int i =0; i <= numBlackhole; i++) {
        	int blackHolePosition = rand.nextInt(3);
        	Blackhole hole = new Blackhole('b', "Blackhole", blackHolePosition + 15);
        	interactingPieces.add(hole);
            levelGameBoard[blackHolePosition + 15] = hole;
        }
        
        // if there is a higher floor to go to, creates a random number of door and adds them to interactingPieces, levelGameBoard
        if (levelNum < 2) {
        	int numDoorway = rand.nextInt(2);
        	for (int i = 0; i <= numDoorway; i++) {
        		int doorwayPosition = rand.nextInt(20);
        		Doorway door = new Doorway('d', "Doorway", doorwayPosition);
        		interactingPieces.add(door);
                levelGameBoard[doorwayPosition] = door;
        	}
        }

        // creates random number of new bridges
        int bridgePosition = rand.nextInt(20);
        Bridge cobbleStone = new Bridge('-', "Bridge", bridgePosition);
        levelGameBoard[bridgePosition] = cobbleStone;

        // creates random number of new keys
        int keyPosition = rand.nextInt(20);
        Key skeleton = new Key('k', "Key", keyPosition);
        interactingPieces.add(skeleton);
        levelGameBoard[keyPosition] = skeleton;
        
    	
    }
    
    public Drawable[] getBoard(){
        return levelGameBoard;
    }
    
    public ArrayList<GamePiece> getInteractingPieces() {
    	return interactingPieces;
    }
    
    public ArrayList<Moveable> getMovingPieces() {
        return movingPieces;
    }
    
    public int getPlayerStartLoc() {
        return 0;
    }
    
}
