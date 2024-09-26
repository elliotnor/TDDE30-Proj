package se.liu.ellno907_elibe559;

import java.util.LinkedList;
import java.util.List;
/**
 * A class that dictates the properties of the Queen-piece. Extends Piece.
 */
public class Queen extends Piece {
    public Queen(final int colour, final Square square, final String icon){
        super( colour, square, icon);
    }

    @Override
    public List<Square> fetchLegalMoves(Board theBoard){
        LinkedList<Square>legalMoves = new LinkedList<Square>();
        Square[][] board = theBoard.getSqArray();

        int xCoord = this.getCurrentPosition().getxCoord();
        int yCoord = this.getCurrentPosition().getyCoord();

        int[] occupies = getLinearOcc(board, xCoord, yCoord);

        for (int x = occupies[0]; x<=occupies[1]; x++){
            if (x != yCoord)
                legalMoves.add(board[x][xCoord]);
        }

        for (int y = occupies[2]; y <= occupies[3]; y++){
            if (y != xCoord)
                legalMoves.add(board[yCoord][y]);
        }
        List <Square> blackMoves = getDiagonalOcc(board,xCoord,yCoord);
        legalMoves.addAll(blackMoves);
        return legalMoves;
    }
}