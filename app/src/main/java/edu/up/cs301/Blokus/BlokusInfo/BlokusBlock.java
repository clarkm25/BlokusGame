package edu.up.cs301.Blokus.BlokusInfo;

import android.graphics.Path;

import java.io.Serializable;

import edu.up.cs301.Blokus.BlokusViews.DrawBoard;

/**
 * Class for each of the Blokus block pieces and their array representations
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st 2022
 */
public class BlokusBlock implements Serializable {

    //For Serializable interface
    public static final long serialVersionUID = 7210794871L;

    //Instance Variables
    private int type;
    private int blockScore;
    private int[][] pieceArr;

    /** No param ctor */
    public BlokusBlock()
    {
        this.type = 5;
        this.blockScore = 4;
        this.pieceArr = new int[5][5];
        for(int i = 0; i<5; i++)
        {
            for(int j = 0; j<5; j++)
            {
                this.pieceArr[i][j] = 0;
            }
        }
        this.pieceArr[0][0] = 2;
        this.pieceArr[0][1] = 1;
        this.pieceArr[1][0] = 1;
        this.pieceArr[1][1] = 1;
    }

    public BlokusBlock(BlokusBlock toCopy)
    {
        this.type = toCopy.type;
        this.blockScore = toCopy.blockScore;
        this.pieceArr = new int[5][5];
        for(int i = 0; i<5; i++)
        {
            for(int j = 0; j<5; j++)
            {
                this.pieceArr[i][j] = toCopy.pieceArr[i][j];
            }
        }
    }
    /** Getters of BlokusBlock variables */
    public int getType()
    {
        return this.type;
    }

    public int getBlockScore()
    {
        return this.blockScore;
    }

    public int[][] getPieceArr()
    {
        return this.pieceArr;
    }

    /** Setters of BlokusBlock variables */
    public void setType(int toSet)
    {
        this.type = toSet;
    }

    public void setBlockScore(int toSet)
    {
        this.blockScore = toSet;
    }

    public void setPieceArr(int[][] toSet)
    {
        if(toSet == null)
        {
            return;
        }
        else
        {
            for(int i = 0; i<5; i++)
            {
                for(int j = 0; j<5; j++)
                {
                    this.pieceArr[i][j] = toSet[i][j];
                }
            }
        }
    }

    /**
     * getPiece
     *
     * Takes the type supplied in the setType() method above and sends back the piece array for
     * the given piece.
     *
     * Also sets the piece's score based on how many tiles there are.
     *
     * @return The array of a given piece
     */
    public int[][] getPiece() {
        switch(type) {
            case 1:
                this.pieceArr[0][0] = 2;

                this.setBlockScore(1);
            case 2:
                this.pieceArr[0][0] = 2;
                this.pieceArr[0][1] = 1;
                this.pieceArr[0][2] = 1;

                this.setBlockScore(3);
            case 3:
                this.pieceArr[0][0] = 2;
                this.pieceArr[0][1] = 1;
                this.pieceArr[0][2] = 1;
                this.pieceArr[1][1] = 1;
                this.pieceArr[1][2] = 1;

                this.setBlockScore(1);

            case 4:
                this.pieceArr[0][0] = 2;
                this.pieceArr[0][1] = 1;
                this.pieceArr[1][0] = 1;
                this.pieceArr[1][1] = 1;

                this.setBlockScore(4)
                ;
            case 5:
                this.pieceArr[0][0] = 2;
                this.pieceArr[0][1] = 1;
                this.pieceArr[1][1] = 1;

                this.setBlockScore(3);

            case 6:
                this.pieceArr[1][0] = 2;
                this.pieceArr[1][1] = 1;
                this.pieceArr[0][1] = 1;
                this.pieceArr[2][1] = 1;
                this.pieceArr[1][2] = 1;

                this.setBlockScore(5);

            case 7:
                this.pieceArr[0][0] = 2;
                this.pieceArr[0][1] = 1;

                this.setBlockScore(2);

            case 8:
                this.pieceArr[0][0] = 2;
                this.pieceArr[0][1] = 1;
                this.pieceArr[1][1] = 1;
                this.pieceArr[1][2] = 1;

                this.setBlockScore(4);

            case 9:
                this.pieceArr[1][0] = 2;
                this.pieceArr[1][1] = 1;
                this.pieceArr[0][1] = 1;
                this.pieceArr[1][2] = 1;

                this.setBlockScore(4);

            case 10:
                this.pieceArr[0][0] = 2;
                this.pieceArr[0][1] = 1;
                this.pieceArr[1][1] = 1;
                this.pieceArr[1][2] = 1;
                this.pieceArr[1][3] = 1;

                this.setBlockScore(5);

            case 11:
                this.pieceArr[0][0] = 2;
                this.pieceArr[1][0] = 1;
                this.pieceArr[1][1] = 1;
                this.pieceArr[1][2] = 1;
                this.pieceArr[2][2] = 1;

                this.setBlockScore(5);

            case 12:
                this.pieceArr[0][0] = 2;
                this.pieceArr[0][1] = 1;
                this.pieceArr[0][2] = 1;
                this.pieceArr[0][3] = 1;
                this.pieceArr[1][3] = 1;

                this.setBlockScore(5);

            case 13:
                this.pieceArr[1][0] = 2;
                this.pieceArr[1][1] = 1;
                this.pieceArr[0][1] = 1;
                this.pieceArr[1][2] = 1;
                this.pieceArr[1][3] = 1;

                this.setBlockScore(5);

            case 14:
                this.pieceArr[2][0] = 2;
                this.pieceArr[1][0] = 1;
                this.pieceArr[1][1] = 1;
                this.pieceArr[0][1] = 1;
                this.pieceArr[0][2] = 1;

                this.setBlockScore(5);

            case 15:
                this.pieceArr[2][0] = 2;
                this.pieceArr[2][1] = 1;
                this.pieceArr[1][1] = 1;
                this.pieceArr[1][2] = 1;
                this.pieceArr[0][1] = 1;

                this.setBlockScore(5);

            case 16:
                this.pieceArr[0][0] = 2;
                this.pieceArr[0][1] = 1;
                this.pieceArr[1][0] = 1;
                this.pieceArr[2][0] = 1;
                this.pieceArr[2][1] = 1;

                this.setBlockScore(5);

            case 17:
                this.pieceArr[1][0] = 2;
                this.pieceArr[1][1] = 1;
                this.pieceArr[1][2] = 1;
                this.pieceArr[0][2] = 1;
                this.pieceArr[2][2] = 1;

                this.setBlockScore(5);

            case 18:
                this.pieceArr[0][0] = 2;
                this.pieceArr[0][1] = 1;
                this.pieceArr[0][2] = 1;
                this.pieceArr[1][2] = 1;

                this.setBlockScore(4);

            case 19:
                this.pieceArr[0][0] = 2;
                this.pieceArr[0][1] = 1;
                this.pieceArr[0][2] = 1;
                this.pieceArr[0][3] = 1;
                this.pieceArr[0][4] = 1;

                this.setBlockScore(5);

            case 20:
                this.pieceArr[0][0] = 2;
                this.pieceArr[0][1] = 1;
                this.pieceArr[0][2] = 1;
                this.pieceArr[0][3] = 1;

                this.setBlockScore(4);

            case 21:
                this.pieceArr[0][0] = 2;
                this.pieceArr[1][0] = 1;
                this.pieceArr[2][0] = 1;
                this.pieceArr[2][1] = 1;
                this.pieceArr[2][2] = 1;

                this.setBlockScore(5);
        }

        return this.pieceArr;
    }

    /**
     * getX
     *
     * Helper method that gets an x position for a given player (either left or right)
     *
     * @param player
     * @return x
     */
    public int getX(int player) {
        int x = 0;

        if (player == 0) {
            x = DrawBoard.LEFT_BOXES; //Left boxes
        }
        else if (player == 1) {
            x = DrawBoard.LEFT_BOXES; //Left boxes
        }
        else if (player == 2) {
            x = DrawBoard.RIGHT_BOXES; //Right boxes
        }
        else if (player == 3) {
            x = DrawBoard.RIGHT_BOXES; //Right boxes
        }

        return x;
    } //getX

    /**
     * getY
     *
     * Helper method that gets an y position for a given player (either left or right)
     *
     * @param player
     * @return y
     */
    public int getY(int player) {
        int y = 0;

        if (player == 0) {
            y = DrawBoard.TOP_BOXES; //Top boxes
        }
        else if (player == 1) {
            y = DrawBoard.BOTTOM_BOXES; //Bottom boxes
        }
        else if (player == 2) {
            y = DrawBoard.TOP_BOXES; //Top Boxes
        }
        else if (player == 3) {
            y = DrawBoard.BOTTOM_BOXES; //Bottom boxes
        }

        return y;
    } //getY


    /**
     * block1
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece1 - Path for first piece
     */
    public Path block1(int player, boolean onBoard) {
        Path piece1 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player) + 10;
            y = this.getY(player) + 30;
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece1.moveTo(x, y);
            piece1.lineTo( (DrawBoard.GRIDBOX_SIZE * 1) + x, y);
            piece1.lineTo((DrawBoard.GRIDBOX_SIZE * 1) + x, (DrawBoard.GRIDBOX_SIZE * 1) + y);
            piece1.lineTo(x, (DrawBoard.GRIDBOX_SIZE * 1) + y);
            piece1.lineTo(x, y);
        }
        else if (onBoard == true) {

        }

        return piece1;
    } //block1

    /**
     * block2
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece2 - Path for second piece
     */
    public Path block2(int player, boolean onBoard) {
        Path piece2 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player) + 60;
            y = this.getY(player) + 30;
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece2.moveTo(x, y);
            piece2.lineTo((DrawBoard.GRIDBOX_SIZE * 3) + x, y);
            piece2.lineTo((DrawBoard.GRIDBOX_SIZE * 3) + x, (DrawBoard.GRIDBOX_SIZE * 1) + y);
            piece2.lineTo(x, (DrawBoard.GRIDBOX_SIZE * 1) + y);
            piece2.lineTo(x, y);
        }

        return piece2;
    } //block2

    /**
     * block3
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece3 - Path for three piece
     */
    public Path block3(int player, boolean onBoard) {
        Path piece3 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player) + 170;
            y = this.getY(player) + 30;
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece3.moveTo(x, y);
            piece3.lineTo((DrawBoard.GRIDBOX_SIZE * 3) + x, y);
            piece3.lineTo((DrawBoard.GRIDBOX_SIZE * 3) + x,(DrawBoard.GRIDBOX_SIZE * 2) + y);
            piece3.lineTo((DrawBoard.GRIDBOX_SIZE * 1) + x,(DrawBoard.GRIDBOX_SIZE * 2) + y);
            piece3.lineTo((DrawBoard.GRIDBOX_SIZE * 1) + x,(DrawBoard.GRIDBOX_SIZE * 1) + y);
            piece3.lineTo(x,(DrawBoard.GRIDBOX_SIZE * 1) + y);
            piece3.lineTo(x, y);
        }
        else if (onBoard == true) {

        }

        return piece3;
    } //block3

    /**
     * block4
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece4 - Path for four piece
     */
    public Path block4(int player, boolean onBoard, int col, int row) {
        Path piece4 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            /** FOR NORMAL 4TH PIECE - CHANGED FOR ALPHA RELEASE
            x = this.getX(player) + 300;
            y = this.getY(player) + 30;
             */

            x = 10 + this.getX(player) + ((DrawBoard.GRIDBOX_SIZE * 3) * row);
            y = 10 + this.getY(player) + ((DrawBoard.GRIDBOX_SIZE * 3) * col);
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece4.moveTo(x, y);
            piece4.lineTo((DrawBoard.GRIDBOX_SIZE * 2) + x, y);
            piece4.lineTo((DrawBoard.GRIDBOX_SIZE * 2) + x, (DrawBoard.GRIDBOX_SIZE * 2) + y);
            piece4.lineTo(x, (DrawBoard.GRIDBOX_SIZE * 2) + y);
            piece4.lineTo(x, y);
        }
        else if (onBoard == true) {

        }

        return piece4;
    } //block4

    /**
     * block5
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece5 - Path for fifth piece
     */
    public Path block5(int player, boolean onBoard) {
        Path piece5 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player);
            y = this.getY(player);
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece5.moveTo(380 + x,30 + y);
            piece5.lineTo(440 + x,30 + y);
            piece5.lineTo(440 + x,90 + y);
            piece5.lineTo(410 + x,90 + y);
            piece5.lineTo(410 + x,60 + y);
            piece5.lineTo(380 + x,60 + y);
            piece5.lineTo(380 + x,30 + y);
        }
        else if (onBoard == true) {

        }

        return piece5;
    } //block5

    /**
     * block6
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece6 - Path for sixth piece
     */
    public Path block6(int player, boolean onBoard) {
        Path piece6 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player);
            y = this.getY(player);
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece6.moveTo(490 + x,60 + y);
            piece6.lineTo(520 + x,60 + y);
            piece6.lineTo(520 + x,30 + y);
            piece6.lineTo(550 + x,30 + y);
            piece6.lineTo(550 + x,60 + y);
            piece6.lineTo(580 + x,60 + y);
            piece6.lineTo(580 + x,90 + y);
            piece6.lineTo(550 + x,90 + y);
            piece6.lineTo(550 + x,120 + y);
            piece6.lineTo(520 + x,120 + y);
            piece6.lineTo(520 + x,90 + y);
            piece6.lineTo(490 + x,90 + y);
            piece6.lineTo(490 + x,60 + y);
        }
        else if (onBoard == true) {

        }

        return piece6;
    } //block6

    /**
     * block7
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece7 - Path for seventh piece
     */
    public Path block7(int player, boolean onBoard) {
        Path piece7 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player);
            y = this.getY(player);
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece7.moveTo(10 + x, 100 + y);
            piece7.lineTo(70 + x, 100 + y);
            piece7.lineTo(70 + x, 130 + y);
            piece7.lineTo(10 + x, 130 + y);
            piece7.lineTo(10 + x, 100 + y);
        }
        else if (onBoard == true) {

        }

        return piece7;
    } //block7

    /**
     * block8
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece8 - Path for eighth piece
     */
    public Path block8(int player, boolean onBoard) {
        Path piece8 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player);
            y = this.getY(player);
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece8.moveTo(80 + x,100 + y);
            piece8.lineTo(140 + x,100 + y);
            piece8.lineTo(140 + x,130 + y);
            piece8.lineTo(170 + x,130 + y);
            piece8.lineTo(170 + x,160 + y);
            piece8.lineTo(110 + x,160 + y);
            piece8.lineTo(110 + x,130 + y);
            piece8.lineTo(80 + x,130 + y);
            piece8.lineTo(80 + x,100 + y);
        }
        else if (onBoard == true) {

        }

        return piece8;
    }

    /**
     * block9
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece9 - Path for ninth piece
     */
    public Path block9(int player, boolean onBoard) {
        Path piece9 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player);
            y = this.getY(player);
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece9.moveTo(180 + x,200 + y);
            piece9.lineTo(270 + x,200 + y);
            piece9.lineTo(270 + x,170 + y);
            piece9.lineTo(240 + x,170 + y);
            piece9.lineTo(240 + x,140 + y);
            piece9.lineTo(210 + x,140 + y);
            piece9.lineTo(210 + x,170 + y);
            piece9.lineTo(180 + x,170 + y);
            piece9.lineTo(180 + x,200 + y);
        }
        else if (onBoard == true) {

        }

        return piece9;
    }

    /**
     * block10
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece10 - Path for tenth piece
     */
    public Path block10(int player, boolean onBoard) {
        Path piece10 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player);
            y = this.getY(player);
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece10.moveTo(310 + x,130 + y);
            piece10.lineTo(370 + x,130 + y);
            piece10.lineTo(370 + x,160 + y);
            piece10.lineTo(430 + x,160 + y);
            piece10.lineTo(430 + x,190 + y);
            piece10.lineTo(340 + x,190 + y);
            piece10.lineTo(340 + x,160 + y);
            piece10.lineTo(310 + x,160 + y);
            piece10.lineTo(310 + x,130 + y);
        }
        else if (onBoard == true) {

        }

        return piece10;
    }

    /**
     * block11
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece11 - Path for eleventh piece
     */
    public Path block11(int player, boolean onBoard) {
        Path piece11 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player);
            y = this.getY(player);
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece11.moveTo(450 + x,130 + y);
            piece11.lineTo(480 + x,130 + y);
            piece11.lineTo(480 + x,160 + y);
            piece11.lineTo(540 + x,160 + y);
            piece11.lineTo(540 + x,220 + y);
            piece11.lineTo(510 + x,220 + y);
            piece11.lineTo(510 + x,190 + y);
            piece11.lineTo(450 + x,190 + y);
            piece11.lineTo(450 + x,130 + y);
        }
        else if (onBoard == true) {

        }

        return piece11;
    }

    /**
     * block12
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece12 - Path for twelfth piece
     */
    public Path block12(int player, boolean onBoard) {
        Path piece12 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player);
            y = this.getY(player);
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece12.moveTo(10 + x,220 + y);
            piece12.lineTo(130 + x,220 + y);
            piece12.lineTo(130 + x,280 + y);
            piece12.lineTo(100 + x,280 + y);
            piece12.lineTo(100 + x,250 + y);
            piece12.lineTo(10 + x,250 + y);
            piece12.lineTo(10 + x,220 + y);
        }
        else if (onBoard == true) {

        }

        return piece12;
    }

    /**
     * block13
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece13 - Path for thirteenth piece
     */
    public Path block13(int player, boolean onBoard) {
        Path piece13 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player);
            y = this.getY(player);
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece13.moveTo(240 + x,250 + y);
            piece13.lineTo(270 + x,250 + y);
            piece13.lineTo(270 + x,220 + y);
            piece13.lineTo(300 + x,220 + y);
            piece13.lineTo(300 + x,250 + y);
            piece13.lineTo(360 + x,250 + y);
            piece13.lineTo(360 + x,280 + y);
            piece13.lineTo(240 + x,280 + y);
            piece13.lineTo(240 + x,280 + y);
        }
        else if (onBoard == true) {

        }

        return piece13;
    }

    /**
     * block14
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece14 - Path for fourteenth piece
     */
    public Path block14(int player, boolean onBoard) {
        Path piece14 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player);
            y = this.getY(player);
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece14.moveTo(400 + x,320 + y);
            piece14.lineTo(400 + x,260 + y);
            piece14.lineTo(430 + x,260 + y);
            piece14.lineTo(430 + x,230 + y);
            piece14.lineTo(490 + x,230 + y);
            piece14.lineTo(490 + x,260 + y);
            piece14.lineTo(460 + x,260 + y);
            piece14.lineTo(460 + x,290 + y);
            piece14.lineTo(430 + x,290 + y);
            piece14.lineTo(430 + x,320 + y);
            piece14.lineTo(400 + x,320 + y);
        }
        else if (onBoard == true) {

        }

        return piece14;
    }

    /**
     * block15
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece15 - Path for fifteenth piece
     */
    public Path block15(int player, boolean onBoard) {
        Path piece15 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player);
            y = this.getY(player);
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece15.moveTo(500 + x,290 + y);
            piece15.lineTo(530 + x,290 + y);
            piece15.lineTo(530 + x,230 + y);
            piece15.lineTo(560 + x,230 + y);
            piece15.lineTo(560 + x,260 + y);
            piece15.lineTo(590 + x,260 + y);
            piece15.lineTo(590 + x,290 + y);
            piece15.lineTo(560 + x,290 + y);
            piece15.lineTo(560 + x,320 + y);
            piece15.lineTo(500 + x,320 + y);
            piece15.lineTo(500 + x,290 + y);
        }
        else if (onBoard == true) {

        }

        return piece15;
    }

    /**
     * block16
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece16 - Path for sixteenth piece
     */
    public Path block16(int player, boolean onBoard) {
        Path piece16 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player);
            y = this.getY(player);
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece16.moveTo(10 + x,320 + y);
            piece16.lineTo(10 + x,410 + y);
            piece16.lineTo(70 + x,410 + y);
            piece16.lineTo(70 + x,380 + y);
            piece16.lineTo(40 + x,380 + y);
            piece16.lineTo(40 + x,350 + y);
            piece16.lineTo(70 + x,350 + y);
            piece16.lineTo(70 + x,320 + y);
            piece16.lineTo(10 + x,320 + y);
        }
        else if (onBoard == true) {

        }

        return piece16;
    }

    /**
     * block17
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece17 - Path for second piece
     */
    public Path block17(int player, boolean onBoard) {
        Path piece17 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player);
            y = this.getY(player);
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece17.moveTo(110 + x,350 + y);
            piece17.lineTo(170 + x,350 + y);
            piece17.lineTo(170 + x,320 + y);
            piece17.lineTo(200 + x,320 + y);
            piece17.lineTo(200 + x,410 + y);
            piece17.lineTo(170 + x,410 + y);
            piece17.lineTo(170 + x,380 + y);
            piece17.lineTo(110 + x,380 + y);
            piece17.lineTo(110 + x,350 + y);
        }
        else if (onBoard == true) {

        }

        return piece17;
    }

    /**
     * block18
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece18 - Path for eighteenth piece
     */
    public Path block18(int player, boolean onBoard) {
        Path piece18 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player) + 240;
            y = this.getY(player) + 350;
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece18.moveTo(x, y);
            piece18.lineTo((DrawBoard.GRIDBOX_SIZE * 3) + x, y);
            piece18.lineTo((DrawBoard.GRIDBOX_SIZE * 3) + x, (DrawBoard.GRIDBOX_SIZE * 2) + y);
            piece18.lineTo((DrawBoard.GRIDBOX_SIZE * 2) + x, (DrawBoard.GRIDBOX_SIZE * 2) + y);
            piece18.lineTo((DrawBoard.GRIDBOX_SIZE * 2) + x, (DrawBoard.GRIDBOX_SIZE * 1) + y);
            piece18.lineTo(x, (DrawBoard.GRIDBOX_SIZE * 1) + y);
            piece18.lineTo(x, y);
        }
        else if (onBoard == true) {

        }

        return piece18;
    }

    /**
     * block19
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece19 - Path for nineteenth piece
     */
    public Path block19(int player, boolean onBoard) {
        Path piece19 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player) + 360;
            y = this.getY(player) + 350;
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece19.moveTo(x, y);
            piece19.lineTo((DrawBoard.GRIDBOX_SIZE * 5) + x, y);
            piece19.lineTo((DrawBoard.GRIDBOX_SIZE * 5) + x, (DrawBoard.GRIDBOX_SIZE * 1) + y);
            piece19.lineTo(x, (DrawBoard.GRIDBOX_SIZE * 1) + y);
            piece19.lineTo(x, y);
        }
        else if (onBoard == true) {

        }

        return piece19;
    }

    /**
     * block20
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece20 - Path for twenty piece
     */
    public Path block20(int player, boolean onBoard) {
        Path piece20 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player) + 360;
            y = this.getY(player) + 410;
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece20.moveTo(x, y);
            piece20.lineTo((DrawBoard.GRIDBOX_SIZE * 4) + x, y);
            piece20.lineTo((DrawBoard.GRIDBOX_SIZE * 4) + x, (DrawBoard.GRIDBOX_SIZE * 1) + y);
            piece20.lineTo(x, (DrawBoard.GRIDBOX_SIZE * 1) + y);
            piece20.lineTo(x, y);
        }
        else if (onBoard == true) {

        }

        return piece20;
    }

    /**
     * block21
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece21 - Path for twenty-first piece
     */
    public Path block21(int player, boolean onBoard) {
        Path piece21 = new Path();
        int x;
        int y;

        if (onBoard == false) {
            x = this.getX(player) + 520;
            y = this.getY(player) + 350;
        }
        else {
            x = 0;
            y = 0;
        }

        if (onBoard == false) {
            piece21.moveTo(x, y);
            piece21.lineTo(x, (DrawBoard.GRIDBOX_SIZE * 3) + y);
            piece21.lineTo((DrawBoard.GRIDBOX_SIZE * 3) + x, (DrawBoard.GRIDBOX_SIZE * 3) + y);
            piece21.lineTo((DrawBoard.GRIDBOX_SIZE * 3) + x, (DrawBoard.GRIDBOX_SIZE * 2) + y);
            piece21.lineTo((DrawBoard.GRIDBOX_SIZE * 1) + x, (DrawBoard.GRIDBOX_SIZE * 2) + y);
            piece21.lineTo((DrawBoard.GRIDBOX_SIZE * 1) + x, y);
            piece21.lineTo(x, y);

        }
        else if (onBoard == true) {

        }

        return piece21;
    }
    /**
     *  Returns a string version of the BlokusBlock
     */
    @Override
    public String toString()
    {
        String toReturn = "Type: " + this.type + " Score: " + this.blockScore + "\n";
        for(int i = 0; i<5; i++)
        {
            for(int j = 0; j<5; j++)
            {
                toReturn += this.pieceArr[i][j] + " ";
            }
            toReturn += "\n";
        }
        return toReturn;
    }
}
