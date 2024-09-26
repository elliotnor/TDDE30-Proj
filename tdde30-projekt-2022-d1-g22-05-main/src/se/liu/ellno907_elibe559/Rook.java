package se.liu.ellno907_elibe559;

import java.util.LinkedList;
import java.util.List;
/**
 * A class that dictates the properties of the Rook-piece. Extends Piece.
 */
public class Rook extends Piece
{
    public Rook(int colour, Square square, String icon){
	super(colour, square, icon);
    }

    @Override
    public List<Square> fetchLegalMoves(Board theBoard){
	LinkedList<Square> legalMoves = new LinkedList<Square>();
	Square[][] board = theBoard.getSqArray();
	int xCoord = this.getCurrentPosition().getxCoord();
	int yCoord = this.getCurrentPosition().getyCoord();
	int[] occupies = getLinearOcc(board, xCoord,yCoord);

	for (int y = occupies[0]; y <= occupies[1]; y++){
	    if (y != yCoord)
		legalMoves.add(board[yCoord][y]);
	}

	for (int x=occupies[2]; x <= occupies[3]; x++){
	    if (x != xCoord)
		legalMoves.add(board[yCoord][x]);
	}
	return legalMoves;
    }
}
