package se.liu.ellno907_elibe559;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

public class Board extends JPanel implements MouseListener, MouseMotionListener
{

    //Data fields
    private final Square[][] board; //Logical representation
    private final GameWindow gameWindow; //GUI representation
    public final List<Piece> blackPieces;
    public final List<Piece> whitePieces;
    public List<Square> moves; //movable
    private boolean wTurn; //True => White's turn
    private Piece currentPiece;
    private int currentXcoord;
    private int currentYcoord;

    //Construct a new board
    public Board(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        board = new Square[8][8]; //set size of a chessboard
        blackPieces = new LinkedList<>();
        whitePieces = new LinkedList<>();
        setLayout(new GridLayout(8, 8, 0, 0));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (((y % 2) == 0 && (x % 2) == 0) || ((y % 2) == 1 && (x % 2) == 1)) { //add white pieces
                    board[y][x] = new Square(this, 1, x, y);
                    this.add(board[y][x]);
                } else {
                    board[y][x] = new Square(this, 0, x, y); //add black pieces
                    this.add(board[y][x]);
                }
            }
        }
        initPieces(); //Set the board for a new game
        this.setPreferredSize(new Dimension(400, 400));
        this.setMaximumSize(new Dimension(400, 400));
        this.setMinimumSize(this.getPreferredSize());
        this.setSize(new Dimension(400, 400));

        wTurn = true;
    }

    private void initPieces() { //Set the standardized layout of the board
        //Add the pawns
        System.out.println("Creating board");
        System.out.println("Creating pieces");
        for (int x = 0; x < 8; x++) {
            board[1][x].setPiece(new Pawn(0, board[1][x],"images/bp.png")); //Black pawns
            board[6][x].setPiece(new Pawn(1, board[6][x], "images/wp.png")); //White pawns
        }
        System.out.println("Pawns complete");

        //Add the white pieces
        board[7][3].setPiece(new Queen(1,board[7][3],"images/wqueen.png"));
        board[7][4].setPiece(new King(1,board[0][4],"images/wking.png"));
        board[7][0].setPiece(new Rook(1,board[7][0],"images/wr.png"));
        board[7][7].setPiece(new Rook(1,board[7][7],"images/wr.png"));
        board[7][1].setPiece(new Knight(1,board[7][1],"images/wk.png"));
        board[7][6].setPiece(new Knight(1,board[7][6],"images/wk.png"));
        board[7][2].setPiece(new Bishop(1,board[7][2],"images/wb.png"));
        board[7][5].setPiece(new Bishop(1,board[7][5],"images/wb.png"));

        //Add the black pieces
        board[0][3].setPiece(new Queen(0,board[0][3],"images/bqueen.png"));
        board[0][4].setPiece(new King(0,board[0][4],"images/bking.png"));
        board[0][0].setPiece(new Rook(0,board[0][0],"images/br.png"));
        board[0][7].setPiece(new Rook(0,board[0][7],"images/br.png"));
        board[0][1].setPiece(new Knight(0,board[0][1],"images/bk.png"));
        board[0][6].setPiece(new Knight(0,board[0][6],"images/bk.png"));
        board[0][2].setPiece(new Bishop(0,board[0][2],"images/bb.png"));
        board[0][5].setPiece(new Bishop(0,board[0][5],"images/bb.png"));

        for (int y = 0; y<2; y++){
            for (int x = 0; x<8; x++){
                blackPieces.add(board[y][x].getOcPiece());
                whitePieces.add(board[7-y][x].getOcPiece());
            }
        }
        System.out.println("GAME-INIT COMPLETE");
    }

    public boolean getWTurn(){
        return wTurn;
    }

    public void setCurrentPiece(Piece piece){
        this.currentPiece = piece;
    }

    public Piece getCurrentPiece(){
        return this.currentPiece;
    }

    public Square[][] getSqArray(){
        return this.board;
    }

    //Draws and fills the board
    @Override
    public void paintComponent(Graphics graphics){
    for (int x=0; x<8;x++){
        for (int y=0; y<8;y++){
            Square square = board[y][x];
            square.paintComponent(graphics);}}

        if (currentPiece != null){
            if ((currentPiece.getColour() == 0 && wTurn) || (currentPiece.getColour() == 0 && !wTurn)){

                final Image icon = currentPiece.getIcon();
                //Observer set to null since component does not need to be notified
                graphics.drawImage(icon, currentXcoord, currentYcoord, null);
            }
        }
    }

    //Mouse event listeners
    @Override public void mousePressed(MouseEvent e) {
        currentXcoord = e.getX();
        currentYcoord = e.getY();

        Square sq = (Square) this.getComponentAt(new Point(e.getX(), e.getY()));

        if (sq.isOccupied()) {
            currentPiece = sq.getOcPiece();
            if (currentPiece.getColour() == 0 && wTurn)
                return;
            if (currentPiece.getColour() == 1 && !wTurn)
                return;
            sq.setShowPiece(false);
        }
        repaint();
    }

    //Moves the selected piece to the released square
    @Override public void mouseReleased(final MouseEvent e) {
        Square square = (Square) this.getComponentAt(new Point(e.getX(),e.getY()));
        System.out.println("MOUSE RELEASED");
        if (currentPiece != null){
            if (currentPiece.getColour() == 1 && !wTurn){ //Situation not allowed
                return;
            }

            if (currentPiece.getColour() == 0 && wTurn){ //Situation not allowed
                return;
            }

            //Situation allowed, proceed
            List<Square> legalMoves = currentPiece.fetchLegalMoves(this);
            if (legalMoves.contains(square)){
                square.setShowPiece(true);
                currentPiece.move(square);
            }
            else{
                currentPiece.getCurrentPosition().setShowPiece(true);
                currentPiece = null;
            }
        }
    }

    //Tracks the mouse while in motion
    @Override public void mouseDragged(final MouseEvent e) {
        System.out.println("MOUSE DRAGGED");
        currentXcoord = e.getX() - 24;
        currentYcoord = e.getY() - 24;
        repaint();
    }

//Idle mouse listeners
    @Override public void mouseClicked(final MouseEvent e) {
    }

    @Override public void mouseMoved(final MouseEvent e) {
    }

    @Override public void mouseEntered(final MouseEvent e) {
    }

    @Override public void mouseExited(final MouseEvent e) {
    }
}