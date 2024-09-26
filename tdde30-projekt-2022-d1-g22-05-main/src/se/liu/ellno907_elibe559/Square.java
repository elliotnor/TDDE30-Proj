package se.liu.ellno907_elibe559;
import javax.swing.*;
import java.awt.*;

/**
 * A class that represents a singular square on the board.
 */
public class Square extends JComponent {
    private Board board;
    private  int colour;
    private Piece ocPiece;
    private boolean showPiece;
    private int xCoord;
    private int yCoord;

    public Square(Board board, int colour, int xCoord, int yCoord){
        this.board = board;
        this.colour = colour;
        this.showPiece = true; //Show the piece located on a selected square
        this.xCoord = xCoord;
        this.yCoord = yCoord;

        this.setBorder(BorderFactory.createEmptyBorder());
    }

    public int getxCoord(){
        return this.xCoord;
    }

    public int getyCoord(){
        return this.yCoord;
    }

    public int getColour(){
        return this.colour;
    }

    public boolean isOccupied(){
        return (this.ocPiece != null);
    }

    public Piece getOcPiece(){
        return ocPiece;
    }

    public void setShowPiece(boolean bol){
        this.showPiece = bol;
    }

    public void setPiece(Piece piece){
        this.ocPiece = piece;
        piece.setPiecePos(this);
    }

    public Piece removePiece(){
        Piece piece = this.ocPiece;
        this.ocPiece = null;
        return piece;
    }

    public void captureToKill(Piece piece){
        Piece killedPiece = getOcPiece();
        if (killedPiece.getColour() == 0) {
            board.blackPieces.remove(killedPiece);
        }
        if (killedPiece.getColour() == 1){
            board.whitePieces.remove(killedPiece);
        }
        this.ocPiece = piece;
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        /**Extra colours for testing**/
        //graphics.setColor((new Color(155,0,100))); //Pink
        //graphics.setColor((new Color(255,255,255))); //White
        //graphics.setColor((new Color(0,26,255))); //Blue

        if (this.colour == 1){
            graphics.setColor((new Color(250,229,158))); //Yellowish
        }
        else{
            graphics.setColor((new Color(48,105,65))); //Green
        }
        graphics.fillRect(this.getxCoord(), this.getyCoord(),this.getWidth(),this.getHeight());
        if(ocPiece != null && showPiece){
            ocPiece.drawIt(graphics);
        }
    }

}