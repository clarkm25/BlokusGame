package edu.up.cs301.Blokus.BlokusViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

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
public class DrawBoard extends FlashSurfaceView {

    //Instance variables
    public static final int ROWS_AND_COLS = 20;
    public static final int GRIDBOX_SIZE = 30;
    public static final int BOARD_START_HEIGHT = 50;
    public static final int BOARD_START_WIDTH = 700;
    public static final int LEFT_BOXES = 50;
    public static final int RIGHT_BOXES = 1350;
    public static final int TOP_BOXES = 10;
    public static final int BOTTOM_BOXES = 465;
    public static final int PBOX_HEIGHT = 450;
    public static final int PBOX_WIDTH = 600;

    Paint gridPaint = new Paint();
    Paint yellow = new Paint();
    Paint red = new Paint();
    Paint green = new Paint();
    Paint blue = new Paint();
    Paint textPaint = new Paint();

    protected BlokusGameState blokusState;
    private BlokusBlock pieces = new BlokusBlock();

    /**
     * DrawBoard
     *
     * default ctor for DrawBoard method
     *
     * @param context
     */
    public DrawBoard(Context context) {
        super(context);
        initialize();
    } //DrawBoard

    /**
     * DrawBoard
     *
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
     * initialize
     *
     * Initializes SurfaceView being drawn on.
     */
    public void initialize() {
        setWillNotDraw(false);

        this.setBackgroundColor(Color.WHITE);
    } //initialize

    /**
     * drawGrid
     *
     * Help Method for onDraw method: Creates the 20x20 grid for Blokus.
     *
     * @param c
     */
    public void drawGrid(Canvas c) {
        for(int i = 0; i < ROWS_AND_COLS; i++) {
            for (int j = 0; j < ROWS_AND_COLS; j++) {
                c.drawRect((GRIDBOX_SIZE * j) + BOARD_START_WIDTH, (GRIDBOX_SIZE * i) + BOARD_START_HEIGHT,
                        ((GRIDBOX_SIZE * j) + GRIDBOX_SIZE) + BOARD_START_WIDTH,
                        ((GRIDBOX_SIZE * i) + GRIDBOX_SIZE) + BOARD_START_HEIGHT, gridPaint);
            }
        }
    } //drawGrid

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
        c.drawPath(pieces.block4(1, false, 0, 0), red);

        //Red 4 piece - 2nd piece
        c.drawPath(pieces.block4(1, false, 0, 1), red);

        //Red 4 piece - 3rd piece
        c.drawPath(pieces.block4(1, false, 0, 2), red);

        //Red 4 piece - 4th piece
        c.drawPath(pieces.block4(1, false, 0, 3), red);

        //Red 4 piece - 5th piece
        c.drawPath(pieces.block4(1, false, 0, 4), red);

        //Red 4 piece - 6th piece
        c.drawPath(pieces.block4(1, false, 0, 5), red);

        //Red 4 piece - 7th piece
        c.drawPath(pieces.block4(1, false, 1, 0), red);

        //Red 4 piece - 8th piece
        c.drawPath(pieces.block4(1, false, 1, 1), red);

        //Red 4 piece - 9th piece
        c.drawPath(pieces.block4(1, false, 1, 2), red);

        //Red 4 piece - 10th piece
        c.drawPath(pieces.block4(1, false, 1, 3), red);

        //Red 4 piece - 11th piece
        c.drawPath(pieces.block4(1, false, 1, 4), red);

        //Red 4 piece - 12th piece
        c.drawPath(pieces.block4(1, false, 1, 5), red);

        //Red 4 piece - 13th piece
        c.drawPath(pieces.block4(1, false, 2, 0), red);

        //Red 4 piece - 14th piece
        c.drawPath(pieces.block4(1, false, 2, 1), red);

        //Red 4 piece - 15th piece
        c.drawPath(pieces.block4(1, false, 2, 2), red);

        //Red 4 piece - 16th piece
        c.drawPath(pieces.block4(1, false, 2, 3), red);

        //Red 4 piece - 17th piece
        c.drawPath(pieces.block4(1, false, 2, 4), red);

        //Red 4 piece - 18th piece
        c.drawPath(pieces.block4(1, false, 2, 5), red);

        //Red 4 piece - 19th piece
        c.drawPath(pieces.block4(1, false, 3, 0), red);

        //Red 4 piece - 20st piece
        c.drawPath(pieces.block4(1, false, 3, 1), red);

        //Red 4 piece - 21st piece
        c.drawPath(pieces.block4(1, false, 3, 2), red);


        /** PLAYER ONE BOX -- BLUE */
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

        //Blue 4 piece - 7th piece
        c.drawPath(pieces.block4(2, false, 1, 0), blue);

        //Blue 4 piece - 8th piece
        c.drawPath(pieces.block4(2, false, 1, 1), blue);

        //Blue 4 piece - 9th piece
        c.drawPath(pieces.block4(2, false, 1, 2), blue);

        //Blue 4 piece - 10th piece
        c.drawPath(pieces.block4(2, false, 1, 3), blue);

        //Blue 4 piece - 11th piece
        c.drawPath(pieces.block4(2, false, 1, 4), blue);

        //Blue 4 piece - 12th piece
        c.drawPath(pieces.block4(2, false, 1, 5), blue);

        //Blue 4 piece - 13th piece
        c.drawPath(pieces.block4(2, false, 2, 0), blue);

        //Blue 4 piece - 14th piece
        c.drawPath(pieces.block4(2, false, 2, 1), blue);

        //Blue 4 piece - 15th piece
        c.drawPath(pieces.block4(2, false, 2, 2), blue);

        //Blue 4 piece - 16th piece
        c.drawPath(pieces.block4(2, false, 2, 3), blue);

        //Blue 4 piece - 17th piece
        c.drawPath(pieces.block4(2, false, 2, 4), blue);

        //Blue 4 piece - 18th piece
        c.drawPath(pieces.block4(2, false, 2, 5), blue);

        //Blue 4 piece - 19th piece
        c.drawPath(pieces.block4(2, false, 3, 0), blue);

        //Blue 4 piece - 20st piece
        c.drawPath(pieces.block4(2, false, 3, 1), blue);

        //Blue 4 piece - 21st piece
        c.drawPath(pieces.block4(2, false, 3, 2), blue);


        /** PLAYER ONE BOX -- GREEN */
        //Green 4 piece - 1st piece
        c.drawPath(pieces.block4(3, false, 0, 0), green);

        //Green 4 piece - 2nd piece
        c.drawPath(pieces.block4(3, false, 0, 1), green);

        //Green 4 piece - 3rd piece
        c.drawPath(pieces.block4(3, false, 0, 2), green);

        //Green 4 piece - 4th piece
        c.drawPath(pieces.block4(3, false, 0, 3), green);

        //Green 4 piece - 5th piece
        c.drawPath(pieces.block4(3, false, 0, 4), green);

        //Green 4 piece - 6th piece
        c.drawPath(pieces.block4(3, false, 0, 5), green);

        //Green 4 piece - 7th piece
        c.drawPath(pieces.block4(3, false, 1, 0), green);

        //Green 4 piece - 8th piece
        c.drawPath(pieces.block4(3, false, 1, 1), green);

        //Green 4 piece - 9th piece
        c.drawPath(pieces.block4(3, false, 1, 2), green);

        //Green 4 piece - 10th piece
        c.drawPath(pieces.block4(3, false, 1, 3), green);

        //Green 4 piece - 11th piece
        c.drawPath(pieces.block4(3, false, 1, 4), green);

        //Green 4 piece - 12th piece
        c.drawPath(pieces.block4(3, false, 1, 5), green);

        //Green 4 piece - 13th piece
        c.drawPath(pieces.block4(3, false, 2, 0), green);

        //Green 4 piece - 14th piece
        c.drawPath(pieces.block4(3, false, 2, 1), green);

        //Green 4 piece - 15th piece
        c.drawPath(pieces.block4(3, false, 2, 2), green);

        //Green 4 piece - 16th piece
        c.drawPath(pieces.block4(3, false, 2, 3), green);

        //Green 4 piece - 17th piece
        c.drawPath(pieces.block4(3, false, 2, 4), green);

        //Green 4 piece - 18th piece
        c.drawPath(pieces.block4(3, false, 2, 5), green);

        //Green 4 piece - 19th piece
        c.drawPath(pieces.block4(3, false, 3, 0), green);

        //Green 4 piece - 20st piece
        c.drawPath(pieces.block4(3, false, 3, 1), green);

        //Green 4 piece - 21st piece
        c.drawPath(pieces.block4(3, false, 3, 2), green);


        /** PLAYER ONE BOX -- Yellow */
        //Yellow 4 piece - 1st piece
        c.drawPath(pieces.block4(4, false, 0, 0), yellow);

        //Yellow 4 piece - 2nd piece
        c.drawPath(pieces.block4(4, false, 0, 1), yellow);

        //Yellow 4 piece - 3rd piece
        c.drawPath(pieces.block4(4, false, 0, 2), yellow);

        //Yellow 4 piece - 4th piece
        c.drawPath(pieces.block4(4, false, 0, 3), yellow);

        //Yellow 4 piece - 5th piece
        c.drawPath(pieces.block4(4, false, 0, 4), yellow);

        //Yellow 4 piece - 6th piece
        c.drawPath(pieces.block4(4, false, 0, 5), yellow);

        //Yellow 4 piece - 7th piece
        c.drawPath(pieces.block4(4, false, 1, 0), yellow);

        //Yellow 4 piece - 8th piece
        c.drawPath(pieces.block4(4, false, 1, 1), yellow);

        //Yellow 4 piece - 9th piece
        c.drawPath(pieces.block4(4, false, 1, 2), yellow);

        //Yellow 4 piece - 10th piece
        c.drawPath(pieces.block4(4, false, 1, 3), yellow);

        //Yellow 4 piece - 11th piece
        c.drawPath(pieces.block4(4, false, 1, 4), yellow);

        //Yellow 4 piece - 12th piece
        c.drawPath(pieces.block4(4, false, 1, 5), yellow);

        //Yellow 4 piece - 13th piece
        c.drawPath(pieces.block4(4, false, 2, 0), yellow);

        //Yellow 4 piece - 14th piece
        c.drawPath(pieces.block4(4, false, 2, 1), yellow);

        //Yellow 4 piece - 15th piece
        c.drawPath(pieces.block4(4, false, 2, 2), yellow);

        //Yellow 4 piece - 16th piece
        c.drawPath(pieces.block4(4, false, 2, 3), yellow);

        //Yellow 4 piece - 17th piece
        c.drawPath(pieces.block4(4, false, 2, 4), yellow);

        //Yellow 4 piece - 18th piece
        c.drawPath(pieces.block4(4, false, 2, 5), yellow);

        //Yellow 4 piece - 19th piece
        c.drawPath(pieces.block4(4, false, 3, 0), yellow);

        //Yellow 4 piece - 20st piece
        c.drawPath(pieces.block4(4, false, 3, 1), yellow);

        //Yellow 4 piece - 21st piece
        c.drawPath(pieces.block4(4, false, 3, 2), yellow);


        /**
         * USED LATER FOR FINAL GAME
         *
        //PLAYER ONE BOX -- RED
        //Red 1 piece (1st row 1st piece) - 1st piece
        c.drawPath(pieces.block1(1, false), red);

        //Red 3 piece (1st row 2nd piece) - 2nd piece
        c.drawPath(pieces.block2(1, false), red);

        //Red 5 piece (1st row 3rd piece) - 3rd piece
        c.drawPath(pieces.block3(1, false), red);

        //Red 4 piece (1st row 4rd piece) - 4th piece
        c.drawPath(pieces.block4(1, false), red);

        //Red 3 piece (1st row 5th piece) - 5th piece
        c.drawPath(pieces.block5(1, false), red);

        //Red five pieces (1st row 6th piece) - 6th piece
        c.drawPath(pieces.block6(1, false), red);

        //Red two piece (2nd row 1st piece) - 7th piece
        c.drawPath(pieces.block7(1, false), red);

        //Red four piece (2nd row 2nd piece) - 8th piece
        c.drawPath(pieces.block8(1, false), red);

        //Red four piece (2nd row 3rd piece) - 9th piece
        c.drawPath(pieces.block9(1, false), red);

        //Red five piece (2nd row 4th piece) - 10th piece
        c.drawPath(pieces.block10(1, false), red);

        //Red five piece (2nd row 5th piece) - 11th piece
        c.drawPath(pieces.block11(1, false), red);

        //Red five piece (3rd row 1st piece) - 12th piece
        c.drawPath(pieces.block12(1, false), red);

        //Red five piece (3rd row 2nd piece) - 13th piece
        c.drawPath(pieces.block13(1, false), red);

        //Red five piece (3rd row 3rd piece) - 14th piece
        c.drawPath(pieces.block14(1, false), red);

        //Red five piece (3rd row 4th piece) - 15th piece
        c.drawPath(pieces.block15(1, false), red);

        //Red five piece (4th row 1st piece) - 16th piece
        c.drawPath(pieces.block16(1, false), red);

        //Red five piece (4th row 2nd piece) - 17th piece
        c.drawPath(pieces.block18(1, false), red);


        //PLAYER TWO BOX -- BLUE
        //Blue 1 piece (1st row 1st piece) - 1st piece
        c.drawPath(pieces.block1(2, false), blue);

        //Blue 3 piece (1st row 2nd piece) - 2nd piece
        c.drawPath(pieces.block2(2, false), blue);

        //Blue 5 piece (1st row 3rd piece) - 3rd piece
        c.drawPath(pieces.block3(2, false), blue);

        //Blue 4 piece (1st row 4rd piece) - 4th piece
        c.drawPath(pieces.block4(2, false), blue);

        //Blue 3 piece (1st row 5th piece) - 5th piece
        c.drawPath(pieces.block5(2, false), blue);

        //Blue five pieces (1st row 6th piece) - 6th piece
        c.drawPath(pieces.block6(2, false), blue);

        //Blue two piece (2nd row 1st piece) - 7th piece
        c.drawPath(pieces.block7(2, false), blue);

        //Blue four piece (2nd row 2nd piece) - 8th piece
        c.drawPath(pieces.block8(2, false), blue);

        //Blue four piece (2nd row 3rd piece) - 9th piece
        c.drawPath(pieces.block9(2, false), blue);

        //Blue five piece (2nd row 4th piece) - 10th piece
        c.drawPath(pieces.block10(2, false), blue);

        //Blue five piece (2nd row 5th piece) - 11th piece
        c.drawPath(pieces.block11(2, false), blue);

        //Blue five piece (3rd row 1st piece) - 12th piece
        c.drawPath(pieces.block12(2, false), blue);

        //Blue five piece (3rd row 2nd piece) - 13th piece
        c.drawPath(pieces.block13(2, false), blue);

        //Blue five piece (3rd row 3rd piece) - 14th piece
        c.drawPath(pieces.block14(2, false), blue);

        //Blue five piece (3rd row 4th piece) - 15th piece
        c.drawPath(pieces.block15(2, false), blue);

        //Blue five piece (4th row 1st piece) - 16th piece
        c.drawPath(pieces.block16(2, false), blue);

        //Blue five piece (4th row 2nd piece) - 17th piece
        c.drawPath(pieces.block17(2, false), blue);


        //PLAYER THREE BOX -- GREEN
        //Green 1 piece (1st row 1st piece) - 1st piece
        c.drawPath(pieces.block1(3, false), green);

        //Green 3 piece (1st row 2nd piece) - 2nd piece
        c.drawPath(pieces.block2(3, false), green);

        //Green 5 piece (1st row 3rd piece) - 3rd piece
        c.drawPath(pieces.block3(3, false), green);

        //Green 4 piece (1st row 4rd piece) - 4th piece
        c.drawPath(pieces.block4(3, false), green);

        //Green 3 piece (1st row 5th piece) - 5th piece
        c.drawPath(pieces.block5(3, false), green);

        //Green five pieces (1st row 6th piece) - 6th piece
        c.drawPath(pieces.block6(3, false), green);

        //Green two piece (2nd row 1st piece) - 7th piece
        c.drawPath(pieces.block7(3, false), green);

        //Green four piece (2nd row 2nd piece) - 8th piece
        c.drawPath(pieces.block8(3, false), green);

        //Green four piece (2nd row 3rd piece) - 9th piece
        c.drawPath(pieces.block9(3, false), green);

        //Green five piece (2nd row 4th piece) - 10th piece
        c.drawPath(pieces.block10(3, false), green);

        //Green five piece (2nd row 5th piece) - 11th piece
        c.drawPath(pieces.block11(3, false), green);

        //Green five piece (3rd row 1st piece) - 12th piece
        c.drawPath(pieces.block12(3, false), green);

        //Green five piece (3rd row 2nd piece) - 13th piece
        c.drawPath(pieces.block13(3, false), green);

        //Green five piece (3rd row 3rd piece) - 14th piece
        c.drawPath(pieces.block14(3, false), green);

        //Green five piece (3rd row 4th piece) - 15th piece
        c.drawPath(pieces.block15(3, false), green);

        //Green five piece (4th row 1st piece) - 16th piece
        c.drawPath(pieces.block16(3, false), green);

        //Green five piece (4th row 2nd piece) - 17th piece
        c.drawPath(pieces.block17(3, false), green);


        //PLAYER FOUR BOX -- YELLOW
        //Yellow 1 piece (1st row 1st piece) - 1th piece
        c.drawPath(pieces.block1(4, false), yellow);

        //Yellow 3 piece (1st row 2nd piece) - 2th piece
        c.drawPath(pieces.block2(4, false), yellow);

        //Yellow 5 piece (1st row 3rd piece) - 3th piece
        c.drawPath(pieces.block3(4, false), yellow);

        //Yellow 4 piece (1st row 4rd piece) - 4th piece
        c.drawPath(pieces.block4(4, false), yellow);

        //Yellow 3 piece (1st row 5th piece) - 5th piece
        c.drawPath(pieces.block5(4, false), yellow);

        //Yellow five pieces (1st row 6th piece) - 6th piece
        c.drawPath(pieces.block6(4, false), yellow);

        //Yellow two piece (2nd row 1st piece) - 7th piece
        c.drawPath(pieces.block7(4, false), yellow);

        //Yellow four piece (2nd row 2nd piece) - 8th piece
        c.drawPath(pieces.block8(4, false), yellow);

        //Yellow four piece (2nd row 3rd piece) - 9th piece
        c.drawPath(pieces.block9(4, false), yellow);

        //Yellow five piece (2nd row 4th piece) - 10th piece
        c.drawPath(pieces.block10(4, false), yellow);

        //Yellow five piece (2nd row 5th piece) - 11th piece
        c.drawPath(pieces.block11(4, false), yellow);

        //Yellow five piece (3rd row 1st piece) - 12th piece
        c.drawPath(pieces.block12(4, false), yellow);

        //Yellow five piece (3rd row 2nd piece) - 13th piece
        c.drawPath(pieces.block13(4, false), yellow);

        //Yellow five piece (3rd row 3rd piece) - 14th piece
        c.drawPath(pieces.block14(4, false), yellow);

        //Yellow five piece (3rd row 4th piece) - 15th piece
        c.drawPath(pieces.block15(4, false), yellow);

        //Yellow five piece (4th row 1st piece) - 16th piece
        c.drawPath(pieces.block16(4, false), yellow);

        //Yellow five piece (4th row 2nd piece) - 17th piece
        c.drawPath(pieces.block17(4, false), yellow);
        */

        //Player & Score
        this.drawPlayerInfo(c, 10, "Blue");
    } //onDraw

    /**
     * drawPlayerInfo
     *
     * Draws player's turn as well as given player's score.
     *
     * @param canvas
     * @param initPlayerPoints
     * @param initPlayerTurn
     */
    public void drawPlayerInfo(Canvas canvas, int initPlayerPoints, String initPlayerTurn) {
        String playerTurn = initPlayerTurn;
        int playerPoints = initPlayerPoints;

        canvas.drawText("Player Turn: " + playerTurn, 800.0f, 700.0f, textPaint);
        canvas.drawText(playerTurn + "'s points: " + playerPoints, 800.0f, 750.0f, textPaint);

    }
}