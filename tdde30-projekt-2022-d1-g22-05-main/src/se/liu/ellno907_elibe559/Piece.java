package se.liu.ellno907_elibe559;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;


public abstract class Piece {
    private final int colour;
    private Square currentPosition;
    private BufferedImage imageIcon;

    protected Piece(int colour, Square square, String iconName) {
	this.colour = colour;
	this.currentPosition = square;

	URL iconURL = ClassLoader.getSystemResource(iconName);
	try {
	    BufferedImage image = ImageIO.read(iconURL);
	    this.imageIcon = image;
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public boolean move(Square square){
	Piece occupied = square.getOcPiece();
	if (occupied != null){
	    if (occupied.getColour() == this.colour){
		return false;
	    }

	    else square.captureToKill(this);
	    }

	currentPosition.removePiece();
	this.currentPosition = square;
	currentPosition.setPiece(this);
	return true;
	}

	public Square getCurrentPosition() {
	    return currentPosition;
	}

    public void setPiecePos(Square square){
	this.currentPosition = square;
    }

    public int getColour(){
	return colour;
    }

    public BufferedImage getIcon(){
	return imageIcon;
    }

    public void drawIt(Graphics graphics){
	int xCrd = currentPosition.getxCoord();
	int yCrd = currentPosition.getyCoord();
	graphics.drawImage(this.imageIcon, xCrd, yCrd, null);
    }

    public int[] getLinearOcc(Square[][] board, int xCoord, int yCoord){
	return null;
    } //To be implemented

    public List<Square> getDiagonalOcc(Square[][] board, int xCoord, int yCoord){
	return null;
    } // To be implemented


    public abstract List<Square> fetchLegalMoves(Board board); // To be overwritten in each subclass of piece
}