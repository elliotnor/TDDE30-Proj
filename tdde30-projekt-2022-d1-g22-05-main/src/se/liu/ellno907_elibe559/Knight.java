package se.liu.ellno907_elibe559;

import java.util.LinkedList;
import java.util.List;


/**
 * A class that dictates the properties of the Knight-piece. Extends Piece.
 */
public class Knight extends Piece {

    public Knight(final int colour, final Square square, final String icon) {
	super(colour, square, icon);
    }

    @Override
    public List<Square> fetchLegalMoves(Board theBoard){
	LinkedList<Square> legalMoves= new LinkedList<Square>();
	Square[][] board = theBoard.getSqArray();

	int xCoord = this.getCurrentPosition().getxCoord();
	int yCoord = this.getCurrentPosition().getyCoord();

	for (int i = 2; i > -3; i--){
	    for (int k = 2; k > -3; k--){
		if (Math.abs(i) == 2^(Math.abs(k)) ==2 ){
		    if (i!=0 && k!=0){
			legalMoves.add(board[k + yCoord][i + xCoord]);
		    }
		}
	    }
	}
	return legalMoves;
    }
}
