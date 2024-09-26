package se.liu.ellno907_elibe559;

import java.util.LinkedList;
import java.util.List;
/**
 * A class that dictates the properties of the King-piece. Extends Piece.
 */
public class King extends Piece
{
    public King(int colour, Square square, String icon){
        super(colour, square, icon);
    }

    @Override
    public List<Square> fetchLegalMoves(Board theBoard){
        LinkedList<Square> legalMoves = new LinkedList<>();
        Square[][] board = theBoard.getSqArray();
        int xCoord = this.getCurrentPosition().getxCoord();
        int yCoord = this.getCurrentPosition().getyCoord();

        for (int i = 1; i > -2; i--) {
            for (int k = 1; k > -2; k--) {
                if(!(i == 0 && k == 0)) {
                    if(!board[yCoord + k][xCoord + i].isOccupied() ||
                        board[yCoord + k][xCoord + i].getOcPiece().getColour()
                        != this.getColour()) {
                        legalMoves.add(board[yCoord + k][xCoord + i]);
                        }
                    }
                }
            }
        return legalMoves;
    }
}
