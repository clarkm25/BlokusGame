package edu.up.cs301.Blokus.BlokusViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;

import java.io.Serializable;

import edu.up.cs301.Blokus.BlokusInfo.BlokusBlock;
import edu.up.cs301.Blokus.BlokusInfo.BlokusGameState;
import edu.up.cs301.game.GameFramework.utilities.FlashSurfaceView;

/**
 * Class that draws all of the Blokus information required for the game on a surface view. Shows
 * pieces, player boxes, grid, and score/ player turn.
 *
 * @author Max Clark, Skyelar Cann, Gavin Raguindin
 * @version March 31st 2022
 */
public class DrawBoard extends FlashSurfaceView implements Serializable{

    //For Serializable interface
    public static final long serialVersionUID = 2398472938471L;

    /* Instance variables */
    public static final int GRIDBOX_SIZE = 30;
    public static final int BOARD_START_HEIGHT = 50;
    public static final int BOARD_START_WIDTH = 700;
    public static final int LEFT_BOXES = 50;
    public static final int RIGHT_BOXES = 1350;
    public static final int TOP_BOXES = 10;
    public static final int BOTTOM_BOXES = 465;
    public static final int PBOX_HEIGHT = 450;
    public static final int PBOX_WIDTH = 600;

    /* Paint objects representing drawings on the canvas */
    Paint gridPaint = new Paint();
    Paint legalPaint = new Paint();
    Paint yellow = new Paint();
    Paint red = new Paint();
    Paint green = new Paint();
    Paint blue = new Paint();
    Paint textPaint = new Paint();

    /* Instance variables for the game state this will have access to and the pieces it needs to draw */
    protected BlokusGameState blokusState;
    private BlokusBlock pieces = new BlokusBlock();

    /**
     * default ctor for DrawBoard method
     *
     * @param context
     */
    public DrawBoard(Context context) {
        super(context);
        initialize();
    }

    /**
     * ctor for DrawBoard method that uses an AttributeSet
     *
     * @param context
     * @param attrib
     */
    public DrawBoard(Context context, AttributeSet attrib) {
        super(context, attrib);
        initialize();
    } //DrawBoard

    /**
     * Initializes SurfaceView being drawn on.
     */
    public void initialize() {
        setWillNotDraw(false);
        this.blokusState = new BlokusGameState();
        this.setBackgroundColor(Color.WHITE);
    } //initialize

    /**
     * Helper method for onDraw method: Creates the 20x20 grid for Blokus.
     *
     * @param c canvas to draw on
     */
    public void drawGrid(Canvas c) {
        for(int i = 0; i < 20; i++) //Scans the board to draw tiles based off their current state
        {
            for (int j = 0; j < 20; j++)
            {
                drawGridSquare(c,j,i,getPaint(blokusState.getBoard()[i][j]));
            }
        }
        for(int i = 0; i < 20; i++)
        {
            for (int j = 0; j < 20; j++)
            {
                if(blokusState.getBoard()[i][j] == BlokusGameState.tileState.LEGAL)
                {
                    drawGridSquare(c,j,i,legalPaint); //Redraws the legalPaint so the entire tile is highlighted
                }
            }
        }
    } //drawGrid

    /**
     * Helper method for drawGrid based on the board to the appropriate square
     *
     * @param c canvas to draw on
     * @param x given x coord
     * @param y given y coord
     */
    public void drawGridSquare(Canvas c, int x, int y, Paint myPaint)
    {
        c.drawRect(GRIDBOX_SIZE*x + BOARD_START_WIDTH, GRIDBOX_SIZE*y + BOARD_START_HEIGHT,
                GRIDBOX_SIZE*x + GRIDBOX_SIZE + BOARD_START_WIDTH,
                GRIDBOX_SIZE*y + GRIDBOX_SIZE + BOARD_START_HEIGHT, myPaint);
    }

    /**
     * Method to return the appropriate paint object based off the state of the tile in the board
     *
     * @param currState current tile
     *
     * @return paint object
     */
    public Paint getPaint(BlokusGameState.tileState currState)
    {
        switch (currState)
        {
            case EMPTY:
                return gridPaint;

            case RED:
                return red;

            case BLUE:
                return blue;

            case GREEN:
                return green;

            case YELLOW:
                return yellow;

        }
        return gridPaint;
    }


    /**
     * setState
     *
     * Sets the Blokus Game State for the SurfaceView.
     *
     * @param initBlokusState
     */
    public void setState(BlokusGameState initBlokusState) {
        this.blokusState = initBlokusState;
    } //setState

    /**
     * onDraw
     *
     * Draws the grid, player boxes, and pieces for all players
     *
     * @param c
     */
    @Override
    public void onDraw(Canvas c) {
        //Initialize paints
        gridPaint.setColor(Color.BLACK);
        gridPaint.setStyle(Paint.Style.STROKE);
        legalPaint.setColor(Color.CYAN);
        legalPaint.setStyle(Paint.Style.STROKE);
        yellow.setColor(Color.YELLOW);
        yellow.setStyle(Paint.Style.FILL);
        red.setColor(Color.RED);
        red.setStyle(Paint.Style.FILL);
        green.setColor(Color.GREEN);
        green.setStyle(Paint.Style.FILL);
        blue.setColor(Color.BLUE);
        blue.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(48.0f);

        //Draws grid for game
        this.drawGrid(c);

        /** Player boxes themselves */
        //Top left box
        c.drawRect(LEFT_BOXES, TOP_BOXES, LEFT_BOXES + PBOX_WIDTH,
                TOP_BOXES + PBOX_HEIGHT, gridPaint);
        //Bottom left box
        c.drawRect(LEFT_BOXES, BOTTOM_BOXES, LEFT_BOXES + PBOX_WIDTH,
                BOTTOM_BOXES + PBOX_HEIGHT, gridPaint);
        //Top right box
        c.drawRect(RIGHT_BOXES, TOP_BOXES, RIGHT_BOXES + PBOX_WIDTH,
                TOP_BOXES + PBOX_HEIGHT, gridPaint);
        //Bottom right box
        c.drawRect(RIGHT_BOXES, BOTTOM_BOXES, RIGHT_BOXES + PBOX_WIDTH,
                BOTTOM_BOXES + PBOX_HEIGHT, gridPaint);

        /** PLAYER ONE BOX -- RED */
        //Red 4 piece - 1st piece
        c.drawPath(pieces.block4(0, false, 0, 0), red);

        //Red 4 piece - 2nd piece
        c.drawPath(pieces.block4(0, false, 0, 1), red);

        //Red 4 piece - 3rd piece
        c.drawPath(pieces.block4(0, false, 0, 2), red);

        //Red 4 piece - 4th piece
        c.drawPath(pieces.block4(0, false, 0, 3), red);

        //Red 4 piece - 5th piece
        c.drawPath(pieces.block4(0, false, 0, 4), red);

        //Red 4 piece - 6th piece
        c.drawPath(pieces.block4(0, false, 0, 5), red);

        //Red 4 piece - 7th piece
        c.drawPath(pieces.block4(0, false, 1, 0), red);

        //Red 4 piece - 8th piece
        c.drawPath(pieces.block4(0, false, 1, 1), red);

        //Red 4 piece - 9th piece
        c.drawPath(pieces.block4(0, false, 1, 2), red);

        //Red 4 piece - 10th piece
        c.drawPath(pieces.block4(0, false, 1, 3), red);

        //Red 4 piece - 11th piece
        c.drawPath(pieces.block4(0, false, 1, 4), red);

        //Red 4 piece - 12th piece
        c.drawPath(pieces.block4(0, false, 1, 5), red);

        //Red 4 piece - 13th piece
        c.drawPath(pieces.block4(0, false, 2, 0), red);

        //Red 4 piece - 14th piece
        c.drawPath(pieces.block4(0, false, 2, 1), red);

        //Red 4 piece - 15th piece
        c.drawPath(pieces.block4(0, false, 2, 2), red);

        //Red 4 piece - 16th piece
        c.drawPath(pieces.block4(0, false, 2, 3), red);

        //Red 4 piece - 17th piece
        c.drawPath(pieces.block4(0, false, 2, 4), red);

        //Red 4 piece - 18th piece
        c.drawPath(pieces.block4(0, false, 2, 5), red);

        //Red 4 piece - 19th piece
        c.drawPath(pieces.block4(0, false, 3, 0), red);

        //Red 4 piece - 20st piece
        c.drawPath(pieces.block4(0, false, 3, 1), red);

        //Red 4 piece - 21st piece
        c.drawPath(pieces.block4(0, false, 3, 2), red);


        /** PLAYER TWO BOX -- GREEN */
        //Green 4 piece - 1st piece
        c.drawPath(pieces.block4(1, false, 0, 0), green);

        //Green 4 piece - 2nd piece
        c.drawPath(pieces.block4(1, false, 0, 1), green);

        //Green 4 piece - 3rd piece
        c.drawPath(pieces.block4(1, false, 0, 2), green);

        //Green 4 piece - 4th piece
        c.drawPath(pieces.block4(1, false, 0, 3), green);

        //Green 4 piece - 5th piece
        c.drawPath(pieces.block4(1, false, 0, 4), green);

        //Green 4 piece - 6th piece
        c.drawPath(pieces.block4(1, false, 0, 5), green);

        //Green 4 piece - 7th piece
        c.drawPath(pieces.block4(1, false, 1, 0), green);

        //Green 4 piece - 8th piece
        c.drawPath(pieces.block4(1, false, 1, 1), green);

        //Green 4 piece - 9th piece
        c.drawPath(pieces.block4(1, false, 1, 2), green);

        //Green 4 piece - 10th piece
        c.drawPath(pieces.block4(1, false, 1, 3), green);

        //Green 4 piece - 11th piece
        c.drawPath(pieces.block4(1, false, 1, 4), green);

        //Green 4 piece - 12th piece
        c.drawPath(pieces.block4(1, false, 1, 5), green);

        //Green 4 piece - 13th piece
        c.drawPath(pieces.block4(1, false, 2, 0), green);

        //Green 4 piece - 14th piece
        c.drawPath(pieces.block4(1, false, 2, 1), green);

        //Green 4 piece - 15th piece
        c.drawPath(pieces.block4(1, false, 2, 2), green);

        //Green 4 piece - 16th piece
        c.drawPath(pieces.block4(1, false, 2, 3), green);

        //Green 4 piece - 17th piece
        c.drawPath(pieces.block4(1, false, 2, 4), green);

        //Green 4 piece - 18th piece
        c.drawPath(pieces.block4(1, false, 2, 5), green);

        //Green 4 piece - 19th piece
        c.drawPath(pieces.block4(1, false, 3, 0), green);

        //Green 4 piece - 20st piece
        c.drawPath(pieces.block4(1, false, 3, 1), green);

        //Green 4 piece - 21st piece
        c.drawPath(pieces.block4(1, false, 3, 2), green);


        /** PLAYER THREE BOX -- BLUE */
        //Blue 4 piece - 1st piece
        c.drawPath(pieces.block4(2, false, 0, 0), blue);

        //Blue 4 piece - 2nd piece
        c.drawPath(pieces.block4(2, false, 0, 1), blue);

        //Blue 4 piece - 3rd piece
        c.drawPath(pieces.block4(2, false, 0, 2), blue);

        //Blue 4 piece - 4th piece
        c.drawPath(pieces.block4(2, false, 0, 3), blue);

        //Blue 4 piece - 5th piece
        c.drawPath(pieces.block4(2, false, 0, 4), blue);

        //Blue 4 piece - 6th piece
        c.drawPath(pieces.block4(2, false, 0, 5), blue);

        //Green 4 piece - 7th piece
        c.drawPath(pieces.block4(2, false, 1, 0), blue);

        //Green 4 piece - 8th piece
        c.drawPath(pieces.block4(2, false, 1, 1), blue);

        //Green 4 piece - 9th piece
        c.drawPath(pieces.block4(2, false, 1, 2), blue);

        //Green 4 piece - 10th piece
        c.drawPath(pieces.block4(2, false, 1, 3), blue);

        //Green 4 piece - 11th piece
        c.drawPath(pieces.block4(2, false, 1, 4), blue);

        //Green 4 piece - 12th piece
        c.drawPath(pieces.block4(2, false, 1, 5), blue);

        //Green 4 piece - 13th piece
        c.drawPath(pieces.block4(2, false, 2, 0), blue);

        //Green 4 piece - 14th piece
        c.drawPath(pieces.block4(2, false, 2, 1), blue);

        //Green 4 piece - 15th piece
        c.drawPath(pieces.block4(2, false, 2, 2), blue);

        //Green 4 piece - 16th piece
        c.drawPath(pieces.block4(2, false, 2, 3), blue);

        //Green 4 piece - 17th piece
        c.drawPath(pieces.block4(2, false, 2, 4), blue);

        //Green 4 piece - 18th piece
        c.drawPath(pieces.block4(2, false, 2, 5), blue);

        //Green 4 piece - 19th piece
        c.drawPath(pieces.block4(2, false, 3, 0), blue);

        //Green 4 piece - 20st piece
        c.drawPath(pieces.block4(3, false, 3, 1), blue);

        //Green 4 piece - 21st piece
        c.drawPath(pieces.block4(3, false, 3, 2), blue);


        /** PLAYER ONE BOX -- Yellow */
        //Yellow 4 piece - 1st piece
        c.drawPath(pieces.block4(3, false, 0, 0), yellow);

        //Yellow 4 piece - 2nd piece
        c.drawPath(pieces.block4(3, false, 0, 1), yellow);

        //Yellow 4 piece - 3rd piece
        c.drawPath(pieces.block4(3, false, 0, 2), yellow);

        //Yellow 4 piece - 4th piece
        c.drawPath(pieces.block4(3, false, 0, 3), yellow);

        //Yellow 4 piece - 5th piece
        c.drawPath(pieces.block4(3, false, 0, 4), yellow);

        //Yellow 4 piece - 6th piece
        c.drawPath(pieces.block4(3, false, 0, 5), yellow);

        //Yellow 4 piece - 7th piece
        c.drawPath(pieces.block4(3, false, 1, 0), yellow);

        //Yellow 4 piece - 8th piece
        c.drawPath(pieces.block4(3, false, 1, 1), yellow);

        //Yellow 4 piece - 9th piece
        c.drawPath(pieces.block4(3, false, 1, 2), yellow);

        //Yellow 4 piece - 10th piece
        c.drawPath(pieces.block4(3, false, 1, 3), yellow);

        //Yellow 4 piece - 11th piece
        c.drawPath(pieces.block4(3, false, 1, 4), yellow);

        //Yellow 4 piece - 12th piece
        c.drawPath(pieces.block4(3, false, 1, 5), yellow);

        //Yellow 4 piece - 13th piece
        c.drawPath(pieces.block4(3, false, 2, 0), yellow);

        //Yellow 4 piece - 14th piece
        c.drawPath(pieces.block4(3, false, 2, 1), yellow);

        //Yellow 4 piece - 15th piece
        c.drawPath(pieces.block4(3, false, 2, 2), yellow);

        //Yellow 4 piece - 16th piece
        c.drawPath(pieces.block4(3, false, 2, 3), yellow);

        //Yellow 4 piece - 17th piece
        c.drawPath(pieces.block4(3, false, 2, 4), yellow);

        //Yellow 4 piece - 18th piece
        c.drawPath(pieces.block4(3, false, 2, 5), yellow);

        //Yellow 4 piece - 19th piece
        c.drawPath(pieces.block4(3, false, 3, 0), yellow);

        //Yellow 4 piece - 20st piece
        c.drawPath(pieces.block4(3, false, 3, 1), yellow);

        //Yellow 4 piece - 21st piece
        c.drawPath(pieces.block4(3, false, 3, 2), yellow);


        //Player & Score
        this.drawPlayerInfo(c, blokusState.getPlayerScore(blokusState.getPlayerTurn()),
                blokusState.getPlayerColor(blokusState.getPlayerTurn()));
    } //onDraw



    /**
     * This method will convert the coordinated of a touch event to a certain grid square
     *
     * @param x given x coord
     * @param y given y coord
     *
     * @return Point
     */
    public Point mapPixelToGridSquare(int x, int y)
    {
    /**
     * External Citation
     * Date: 31 March 2022
     * Problem: Could not map the pixels of a touch event to the board
     * Resource:
     * https://github.com/cs301up/TicTacToeSpr22
     * Solution: I used the mapPixelToSquare method as a guide for the this method
     * and the other method below
     */
     /* For loop to iterate through the possible locations for each grid square */
        for(int i = 0; i<20; i++)
        {
            for(int j = 0; j<20; j++)
            {
                float left = GRIDBOX_SIZE*j + BOARD_START_WIDTH;
                float right = GRIDBOX_SIZE*j + GRIDBOX_SIZE + BOARD_START_WIDTH;
                float top = GRIDBOX_SIZE*i + BOARD_START_HEIGHT;
                float bottom = GRIDBOX_SIZE*i + GRIDBOX_SIZE + BOARD_START_HEIGHT;
                if((x > left) != (x> right) && (y > top) != (y> bottom)) //If it is within bounds, return the point
                {
                    return new Point(i,j);
                }
            }
        }
        return null;
    }

    /**
     * This method will map a touch event to a certain BlokusPiece so the type is set appropriately
     *
     * @param x given x coord
     * @param y given y coord
     *
     * @return the translated point
     */
    public Point mapPixelToBlokusPiece(int x, int y)
    {
    /* For loop to account for the number of pieces to draw within the player box */
    for(int i = 0; i<6; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            float left = 10 + LEFT_BOXES + ((GRIDBOX_SIZE * 3)*i);
            float right = 10 + LEFT_BOXES + ((GRIDBOX_SIZE * 3)*i) + (GRIDBOX_SIZE*2);
            float top = 10 + TOP_BOXES + ((GRIDBOX_SIZE * 3)*j);
            float bottom = 10 + TOP_BOXES + ((GRIDBOX_SIZE * 3)*j) + (GRIDBOX_SIZE*2);
            if((x > left) != (x> right) && (y > top) != (y> bottom)) //If it is within bounds, return the point
            {
                return new Point(i,j);
            }
        }
    }

    //Nothing has been matched
    return null;
    }

    /**
     * drawPlayerInfo
     *
     * Draws player's turn as well as given player's score.
     *
     * @param canvas the canvas to draw on
     * @param initPlayerPoints the initial player points
     * @param initPlayerTurn string representation of the player turn
     */
    public void drawPlayerInfo(Canvas canvas, int initPlayerPoints, String initPlayerTurn) {
        String playerTurn = initPlayerTurn;
        int playerPoints = initPlayerPoints;

        canvas.drawText("Player Turn: " + playerTurn, 800.0f, 700.0f, textPaint);
        canvas.drawText(playerTurn + "'s points: " + playerPoints, 800.0f, 750.0f, textPaint);

    }
}