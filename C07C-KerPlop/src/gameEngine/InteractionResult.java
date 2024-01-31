package gameEngine;

/**
 * Interacting with a game piece must yield one of these results.
 * 
 * @author Mark Baldwin
 * @author Cyndi Rader
 * 
 */
public enum InteractionResult {
	HIT, KILL, ADVANCE, GET_POINT, NONE;
}

/*
Game Pieces:

1. Interact
	a) doorway "d" - GamePiece + Interaction - ADVANCE (interacts on same location)
	b) black hole "b" - GamePiece + Interaction - KILL (Will kill a player that is on that space or one space away in any direction) 
	c) key "k" - GamePiece + Interaction - GET_POINT (Gives point if the player lands on it)
	d) snake "s" - HIT (Will kill a player if it is in the same space)
	e) frog "f" - HIT (Jumps to an open space only if there is an open space next to it, can hit you within 2 spaces)
	
2. Move
	a) snake "s" - Moves two spaces each time, moves left and right.
	b) frog "f" - HIT (Jumps to an open space only if there is an open space next to it, can hit you within 2 spaces)

	
3. Drawable
	a) Bridge "B" - Implements Drawable - Does Nothing

*/