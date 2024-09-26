package se.liu.ellno907_elibe559;

import java.util.List;
/**
 * A class that dictates the properties of the Bishop-piece. Extends Piece.
 */
public class Bishop extends Piece
{
    public Bishop(int colour, Square square, String icon){
	super(colour,square,icon);
    }

    @Override
    public List<Square> fetchLegalMoves(Board theBoard){
	Square[][] board = theBoard.getSqArray();
	return getDiagonalOcc(board,this.getCurrentPosition().getxCoord(), this.getCurrentPosition().getyCoord());
    }
}
