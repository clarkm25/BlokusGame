package edu.up.cs301.Blokus.BlokusInfo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import edu.up.cs301.Blokus.BlokusViews.DrawBoard;

/**
 * Class for each of the Blokus block pieces.
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st 2022
 */
public class BlokusBlock {
    private int type;
    private int blockScore;

    /** No param ctor */
    public BlokusBlock() {
        this.type = -1;
        this.blockScore = 5;
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

    /** Setters of BlokusBlock variables */
    public void setType(int toSet)
    {
        this.type = toSet;
    }

    public void setBlockScore(int toSet)
    {
        this.blockScore = toSet;
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

        if (player == 1) {
            x = DrawBoard.LEFT_BOXES; //Left boxes
        }
        else if (player == 2) {
            x = DrawBoard.LEFT_BOXES; //Left boxes
        }
        else if (player == 3) {
            x = DrawBoard.RIGHT_BOXES; //Right boxes
        }
        else if (player == 4) {
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

        if (player == 1) {
            y = DrawBoard.TOP_BOXES; //Top boxes
        }
        else if (player == 2) {
            y = DrawBoard.BOTTOM_BOXES; //Bottom boxes
        }
        else if (player == 3) {
            y = DrawBoard.TOP_BOXES; //Top Boxes
        }
        else if (player == 4) {
            y = DrawBoard.BOTTOM_BOXES; //Bottom boxes
        }

        return y;
    } //getY

    public Paint getColor(int player) {
        Paint playerColor = new Paint();

        if(player == 1) {
            playerColor.setColor(Color.RED);
        }
        else if (player == 2) {
            playerColor.setColor(Color.BLUE);
        }
        else if (player == 3) {
            playerColor.setColor(Color.GREEN);
        }
        else if (player == 4) {
            playerColor.setColor(Color.YELLOW);
        }
        else {
            playerColor.setColor(Color.BLACK); //set to black if there is no player
        }
        return playerColor;
    }

    /**
     * block1
     *
     * Creates piece given a player and whether or not a piece is being drawn on board or player box
     *
     * @param player
     * @return piece1 - Path for first piece
     */
    public Path block1(Canvas c, int player, boolean onBoard) {
        Path piece1 = new Path();
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            c.drawRect(10 + x, 30 + y, 40 + x, 60 + y, this.getColor(player));
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
    public Path block2(Canvas c, int player, boolean onBoard) {
        Path piece2 = new Path();
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            c.drawRect(60 + x, 30 + y, 150 + x, 60 + y, this.getColor(player));
        }
        else if (onBoard == true) {

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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            piece3.moveTo(170 + x,30 + y);
            piece3.lineTo(260 + x,30 + y);
            piece3.lineTo(260 + x,90 + y);
            piece3.lineTo(200 + x,90 + y);
            piece3.lineTo(200 + x,60 + y);
            piece3.lineTo(170 + x,60 + y);
            piece3.lineTo(170 + x,30 + y);
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
    public Path block4(Canvas c, int player, boolean onBoard) {
        Path piece4 = new Path();
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            c.drawRect(300 + x, 30 + y, 360 + x, 90 + y, this.getColor(player));        }
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            piece5.moveTo(380 + x,30 + y);
            piece5.lineTo(440 + x,30 + y);
            piece5.lineTo(440 + x,90 + y);
            piece5.lineTo(410 + x,90 + y);
            piece5.lineTo(410 + x,60 + y);
            piece5.lineTo(380 + x,60 + y);
            piece5.lineTo(380 + x,30 + y);        }
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
        int x = this.getX(player);
        int y = this.getY(player);

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
            piece6.lineTo(490 + x,60 + y);        }
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
    public Path block7(Canvas c, int player, boolean onBoard) {
        Path piece7 = new Path();
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            c.drawRect(10 + x,100 + y, 70 + x,130 + y, this.getColor(player));        }
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            piece8.moveTo(80 + x,100 + y);
            piece8.lineTo(140 + x,100 + y);
            piece8.lineTo(140 + x,130 + y);
            piece8.lineTo(170 + x,130 + y);
            piece8.lineTo(170 + x,160 + y);
            piece8.lineTo(110 + x,160 + y);
            piece8.lineTo(110 + x,130 + y);
            piece8.lineTo(80 + x,130 + y);
            piece8.lineTo(80 + x,100 + y);        }
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            piece9.moveTo(180 + x,200 + y);
            piece9.lineTo(270 + x,200 + y);
            piece9.lineTo(270 + x,170 + y);
            piece9.lineTo(240 + x,170 + y);
            piece9.lineTo(240 + x,140 + y);
            piece9.lineTo(210 + x,140 + y);
            piece9.lineTo(210 + x,170 + y);
            piece9.lineTo(180 + x,170 + y);
            piece9.lineTo(180 + x,200 + y);        }
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            //piece10.
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            //piece11.
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            //piece12.
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            //piece13.
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            //piece14.
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            //piece15.
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            //piece16.
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            //piece17.
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            //piece18.
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            //piece19.
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            //piece20.
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
        int x = this.getX(player);
        int y = this.getY(player);

        if (onBoard == false) {
            //piece21.
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
        return "Type: " + this.type + " Score: " + this.blockScore + "\n";
    }
}
