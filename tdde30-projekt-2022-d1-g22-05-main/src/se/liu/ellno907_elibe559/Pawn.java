package se.liu.ellno907_elibe559;

import java.util.LinkedList;
import java.util.List;
/**
 * A class that dictates the properties of the Pawn-piece. Extends Piece.
 */
public class Pawn extends Piece
{
    private boolean movedPiece;

    public Pawn(final int colour, final Square square, final String icon) {
	super(colour, square, icon);
    }

    @Override
    public boolean move(Square finalSquare){
	boolean theBoolean = super.move(finalSquare);
	movedPiece = true;
	return theBoolean;
    }

    @Override
    public List<Square> fetchLegalMoves(Board theBoard){
	LinkedList<Square> legalMoves = new LinkedList<Square>();
	Square[][] board = theBoard.getSqArray();

	int xCoord = this.getCurrentPosition().getxCoord();
	int yCoord = this.getCurrentPosition().getyCoord();
	int colour = this.getColour();

	//Investigate legal moves
	 if (colour == 0){
	     if (!movedPiece){
		 if(!board[yCoord + 2][xCoord].isOccupied()){
		     legalMoves.add(board[yCoord+2][xCoord]);
		 }
	     }

	     if (yCoord+1 < 8){
		 if (!board[yCoord + 1][xCoord].isOccupied()){
		     legalMoves.add(board[yCoord +1][xCoord]);
		 }
	     }

	     if (xCoord+1 < 8 && yCoord+1 < 8){
		 if ( board[yCoord+1][xCoord+1].isOccupied()){
		     legalMoves.add(board[yCoord+1][xCoord+1]);
		 }
	     }

	     if (xCoord - 1 >= 0 && yCoord + 1 < 8){
		 if(board[yCoord+1][xCoord-1].isOccupied()){
		     legalMoves.add(board[yCoord+1][xCoord-1]);
		 }
	     }
	 }

	 if (colour == 1){
	     if (!movedPiece){
		 if(!board[yCoord-2][xCoord].isOccupied()){
		     legalMoves.add(board[yCoord-2][xCoord]);
		 }
	     }

	     if (yCoord-1 >=0){
		 if (!board[yCoord-1][xCoord].isOccupied()){
		     legalMoves.add(board[yCoord-1][xCoord]);
		 }
	     }

	     if (yCoord-1 >=0 && xCoord+1 < 8){
		 if (board[yCoord-1][xCoord+1].isOccupied()){
		     legalMoves.add(board[yCoord-1][xCoord+1]);
		 }
	     }

	     if (yCoord-1 >=0 && xCoord-1 >=0){
		 if (board[yCoord-1][xCoord-1].isOccupied()){
		     legalMoves.add(board[yCoord-1][xCoord-1]);
		 }
	     }
	 }
	 return legalMoves;
    }
}