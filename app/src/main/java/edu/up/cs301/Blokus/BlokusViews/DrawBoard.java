package edu.up.cs301.Blokus.BlokusViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

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
        c.drawRect(LEFT_BOXES, TOP_BOXES, LEFT_BOXES + PBOX_WIDTH, TOP_BOXES + PBOX_HEIGHT, gridPaint);
        //Bottom left box
        c.drawRect(LEFT_BOXES, BOTTOM_BOXES, LEFT_BOXES + PBOX_WIDTH, BOTTOM_BOXES + PBOX_HEIGHT, gridPaint);
        //Top right box
        c.drawRect(RIGHT_BOXES, TOP_BOXES, RIGHT_BOXES + PBOX_WIDTH, TOP_BOXES + PBOX_HEIGHT, gridPaint);
        //Bottom right box
        c.drawRect(RIGHT_BOXES, BOTTOM_BOXES, RIGHT_BOXES + PBOX_WIDTH, BOTTOM_BOXES + PBOX_HEIGHT, gridPaint);

        //Yellow - Four block piece (Bottom Left Corner) - First Piece
        Path piecePath = new Path();
        piecePath.reset();
        piecePath.moveTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 17), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 18));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 20), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 18));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 20), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 20));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 19), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 20));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 19), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 19));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 17), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 19));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 17), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 18));
        c.drawPath(piecePath, yellow);

        //Yellow - Five block piece (Upper Left from first piece)
        c.drawRect(BOARD_START_WIDTH + (GRIDBOX_SIZE * 16), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 13),
                BOARD_START_WIDTH + (GRIDBOX_SIZE * 17), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 18), yellow);

        //Yellow - Four block piece (Left from first piece)
        c.drawRect(BOARD_START_WIDTH + (GRIDBOX_SIZE * 12), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 18),
                BOARD_START_WIDTH + (GRIDBOX_SIZE * 16), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 19), yellow);


        //Red - Four block piece
        piecePath.reset();
        piecePath.moveTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 5), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 1));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 8), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 1));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 8), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 3));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 7), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 3));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 7), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 2));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 5), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 2));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 5), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 1));
        c.drawPath(piecePath, red);
        piecePath.reset();

        //Red - Five block piece
        c.drawRect(BOARD_START_WIDTH, BOARD_START_HEIGHT, BOARD_START_WIDTH + (GRIDBOX_SIZE * 5),
                BOARD_START_HEIGHT + GRIDBOX_SIZE, red);

        //Red - Four block piece
        c.drawRect(BOARD_START_WIDTH + (GRIDBOX_SIZE * 8), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 3),
                BOARD_START_WIDTH + (GRIDBOX_SIZE * 9),
                BOARD_START_HEIGHT + (GRIDBOX_SIZE * 3) + (GRIDBOX_SIZE * 4), red);


        //Green - 5 block piece
        c.drawRect(BOARD_START_WIDTH + (GRIDBOX_SIZE * 19), BOARD_START_HEIGHT,
                BOARD_START_WIDTH + (GRIDBOX_SIZE * 20),
                BOARD_START_HEIGHT + (GRIDBOX_SIZE * 5), green);

        //Green - 4 block piece
        c.drawRect(BOARD_START_WIDTH + (GRIDBOX_SIZE * 18), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 5),
                BOARD_START_WIDTH + (GRIDBOX_SIZE * 19),
                BOARD_START_HEIGHT + (GRIDBOX_SIZE * 5) + (GRIDBOX_SIZE * 4), green);

        //Green - 4 block piece
        piecePath.reset();
        piecePath.moveTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 15), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 9));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 18), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 9));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 18), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 11));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 17), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 11));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 17), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 10));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 15), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 10));
        piecePath.lineTo(BOARD_START_WIDTH + (GRIDBOX_SIZE * 15), BOARD_START_HEIGHT + (GRIDBOX_SIZE * 9));
        c.drawPath(piecePath, green);


        //Blue - 4 block pieces
        c.drawRect(BOARD_START_WIDTH, BOARD_START_HEIGHT + (GRIDBOX_SIZE * 16),
                BOARD_START_WIDTH + GRIDBOX_SIZE,
                BOARD_START_HEIGHT + (GRIDBOX_SIZE * 16) + (GRIDBOX_SIZE * 4), blue);

        //Blue - 5 block pieces
        c.drawRect(BOARD_START_WIDTH + GRIDBOX_SIZE, BOARD_START_HEIGHT + (GRIDBOX_SIZE * 15),
                BOARD_START_WIDTH + GRIDBOX_SIZE + (GRIDBOX_SIZE * 4),
                BOARD_START_HEIGHT + (GRIDBOX_SIZE * 16), blue);


        /**
         * PLAYER ONE BOX -- RED
         */
        //Red 1 piece (1st row 1st piece)
        c.drawRect(10 + LEFT_BOXES, 30 + TOP_BOXES, 40 + LEFT_BOXES, 60 + TOP_BOXES, red);

        //Red 3 piece (1st row 2nd piece)
        c.drawRect(60 + LEFT_BOXES, 30 + TOP_BOXES, 150 + LEFT_BOXES, 60 + TOP_BOXES, red);

        //Red 5 piece (1st row 3rd piece)
        piecePath.reset();
        piecePath.moveTo(170 + LEFT_BOXES,30 + TOP_BOXES);
        piecePath.lineTo(260 + LEFT_BOXES,30 + TOP_BOXES);
        piecePath.lineTo(260 + LEFT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(200 + LEFT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(200 + LEFT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(170 + LEFT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(170 + LEFT_BOXES,30 + TOP_BOXES);
        c.drawPath(piecePath, red);

        //Red 4 piece (1st row 4rd piece)
        c.drawRect(300 + LEFT_BOXES, 30 + TOP_BOXES, 360 + LEFT_BOXES, 90 + TOP_BOXES, red);

        //Red 3 piece (1st row 5th piece)
        piecePath.reset();
        piecePath.moveTo(380 + LEFT_BOXES,30 + TOP_BOXES);
        piecePath.lineTo(440 + LEFT_BOXES,30 + TOP_BOXES);
        piecePath.lineTo(440 + LEFT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(410 + LEFT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(410 + LEFT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(380 + LEFT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(380 + LEFT_BOXES,30 + TOP_BOXES);
        c.drawPath(piecePath, red);

        //Red five pieces (1st row 6th piece)
        piecePath.reset();
        piecePath.moveTo(490 + LEFT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(520 + LEFT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(520 + LEFT_BOXES,30 + TOP_BOXES);
        piecePath.lineTo(550 + LEFT_BOXES,30 + TOP_BOXES);
        piecePath.lineTo(550 + LEFT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(580 + LEFT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(580 + LEFT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(550 + LEFT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(550 + LEFT_BOXES,120 + TOP_BOXES);
        piecePath.lineTo(520 + LEFT_BOXES,120 + TOP_BOXES);
        piecePath.lineTo(520 + LEFT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(490 + LEFT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(490 + LEFT_BOXES,60 + TOP_BOXES);
        c.drawPath(piecePath, red);

        //Red two piece (2nd row 1st piece) - 7th piece
        c.drawRect(10 + LEFT_BOXES,100 + TOP_BOXES,70 + LEFT_BOXES,130 + TOP_BOXES, red);

        //Red four piece (2nd row 2nd piece) - 8th piece
        piecePath.reset();
        piecePath.moveTo(80 + LEFT_BOXES,100 + TOP_BOXES);
        piecePath.lineTo(140 + LEFT_BOXES,100 + TOP_BOXES);
        piecePath.lineTo(140 + LEFT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(170 + LEFT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(170 + LEFT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(110 + LEFT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(110 + LEFT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(80 + LEFT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(80 + LEFT_BOXES,100 + TOP_BOXES);
        c.drawPath(piecePath, red);

        //Red four piece (2nd row 3rd piece) - 9th piece
        piecePath.reset();
        piecePath.moveTo(180 + LEFT_BOXES,200 + TOP_BOXES);
        piecePath.lineTo(270 + LEFT_BOXES,200 + TOP_BOXES);
        piecePath.lineTo(270 + LEFT_BOXES,170 + TOP_BOXES);
        piecePath.lineTo(240 + LEFT_BOXES,170 + TOP_BOXES);
        piecePath.lineTo(240 + LEFT_BOXES,140 + TOP_BOXES);
        piecePath.lineTo(210 + LEFT_BOXES,140 + TOP_BOXES);
        piecePath.lineTo(210 + LEFT_BOXES,170 + TOP_BOXES);
        piecePath.lineTo(180 + LEFT_BOXES,170 + TOP_BOXES);
        piecePath.lineTo(180 + LEFT_BOXES,200 + TOP_BOXES);
        c.drawPath(piecePath, red);

        //Red five piece (2nd row 4th piece) - 10th piece
        piecePath.reset();
        piecePath.moveTo(310 + LEFT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(370 + LEFT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(370 + LEFT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(430 + LEFT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(430 + LEFT_BOXES,190 + TOP_BOXES);
        piecePath.lineTo(340 + LEFT_BOXES,190 + TOP_BOXES);
        piecePath.lineTo(340 + LEFT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(310 + LEFT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(310 + LEFT_BOXES,130 + TOP_BOXES);
        c.drawPath(piecePath, red);

        //Red five piece (2nd row 5th piece)
        piecePath.reset();
        piecePath.moveTo(450 + LEFT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(480 + LEFT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(480 + LEFT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(540 + LEFT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(540 + LEFT_BOXES,220 + TOP_BOXES);
        piecePath.lineTo(510 + LEFT_BOXES,220 + TOP_BOXES);
        piecePath.lineTo(510 + LEFT_BOXES,190 + TOP_BOXES);
        piecePath.lineTo(450 + LEFT_BOXES,190 + TOP_BOXES);
        piecePath.lineTo(450 + LEFT_BOXES,130 + TOP_BOXES);
        c.drawPath(piecePath, red);

        //Red five piece (3rd row 1st piece)
        piecePath.reset();
        piecePath.moveTo(10 + LEFT_BOXES,220 + TOP_BOXES);
        piecePath.lineTo(130 + LEFT_BOXES,220 + TOP_BOXES);
        piecePath.lineTo(130 + LEFT_BOXES,280 + TOP_BOXES);
        piecePath.lineTo(100 + LEFT_BOXES,280 + TOP_BOXES);
        piecePath.lineTo(100 + LEFT_BOXES,250 + TOP_BOXES);
        piecePath.lineTo(10 + LEFT_BOXES,250 + TOP_BOXES);
        piecePath.lineTo(10 + LEFT_BOXES,220 + TOP_BOXES);
        c.drawPath(piecePath, red);

        //Red five piece (3rd row 2nd piece)
        piecePath.reset();
        piecePath.moveTo(240 + LEFT_BOXES,250 + TOP_BOXES);
        piecePath.lineTo(270 + LEFT_BOXES,250 + TOP_BOXES);
        piecePath.lineTo(270 + LEFT_BOXES,220 + TOP_BOXES);
        piecePath.lineTo(300 + LEFT_BOXES,220 + TOP_BOXES);
        piecePath.lineTo(300 + LEFT_BOXES,250 + TOP_BOXES);
        piecePath.lineTo(360 + LEFT_BOXES,250 + TOP_BOXES);
        piecePath.lineTo(360 + LEFT_BOXES,280 + TOP_BOXES);
        piecePath.lineTo(240 + LEFT_BOXES,280 + TOP_BOXES);
        piecePath.lineTo(240 + LEFT_BOXES,280 + TOP_BOXES);
        c.drawPath(piecePath, red);

        //Red five piece (3rd row 3rd piece)
        piecePath.reset();
        piecePath.moveTo(400 + LEFT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(400 + LEFT_BOXES,260 + TOP_BOXES);
        piecePath.lineTo(430 + LEFT_BOXES,260 + TOP_BOXES);
        piecePath.lineTo(430 + LEFT_BOXES,230 + TOP_BOXES);
        piecePath.lineTo(490 + LEFT_BOXES,230 + TOP_BOXES);
        piecePath.lineTo(490 + LEFT_BOXES,260 + TOP_BOXES);
        piecePath.lineTo(460 + LEFT_BOXES,260 + TOP_BOXES);
        piecePath.lineTo(460 + LEFT_BOXES,290 + TOP_BOXES);
        piecePath.lineTo(430 + LEFT_BOXES,290 + TOP_BOXES);
        piecePath.lineTo(430 + LEFT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(400 + LEFT_BOXES,320 + TOP_BOXES);
        c.drawPath(piecePath, red);

        //Red five piece (3rd row 4th piece)
        piecePath.reset();
        piecePath.moveTo(500 + LEFT_BOXES,290 + TOP_BOXES);
        piecePath.lineTo(530 + LEFT_BOXES,290 + TOP_BOXES);
        piecePath.lineTo(530 + LEFT_BOXES,230 + TOP_BOXES);
        piecePath.lineTo(560 + LEFT_BOXES,230 + TOP_BOXES);
        piecePath.lineTo(560 + LEFT_BOXES,260 + TOP_BOXES);
        piecePath.lineTo(590 + LEFT_BOXES,260 + TOP_BOXES);
        piecePath.lineTo(590 + LEFT_BOXES,290 + TOP_BOXES);
        piecePath.lineTo(560 + LEFT_BOXES,290 + TOP_BOXES);
        piecePath.lineTo(560 + LEFT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(500 + LEFT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(500 + LEFT_BOXES,290 + TOP_BOXES);
        c.drawPath(piecePath, red);

        //Red five piece (4th row 1st piece)
        piecePath.reset();
        piecePath.moveTo(40 + LEFT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(40 + LEFT_BOXES,410 + TOP_BOXES);
        piecePath.lineTo(100 + LEFT_BOXES,410 + TOP_BOXES);
        piecePath.lineTo(100 + LEFT_BOXES,380 + TOP_BOXES);
        piecePath.lineTo(70 + LEFT_BOXES,380 + TOP_BOXES);
        piecePath.lineTo(70 + LEFT_BOXES,350 + TOP_BOXES);
        piecePath.lineTo(100 + LEFT_BOXES,350 + TOP_BOXES);
        piecePath.lineTo(100 + LEFT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(40 + LEFT_BOXES,320 + TOP_BOXES);
        c.drawPath(piecePath, red);

        //Red five piece (4th row 2nd piece)
        piecePath.reset();
        piecePath.moveTo(140 + LEFT_BOXES,350 + TOP_BOXES);
        piecePath.lineTo(200 + LEFT_BOXES,350 + TOP_BOXES);
        piecePath.lineTo(200 + LEFT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(230 + LEFT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(230 + LEFT_BOXES,410 + TOP_BOXES);
        piecePath.lineTo(200 + LEFT_BOXES,410 + TOP_BOXES);
        piecePath.lineTo(200 + LEFT_BOXES,380 + TOP_BOXES);
        piecePath.lineTo(140 + LEFT_BOXES,380 + TOP_BOXES);
        piecePath.lineTo(140 + LEFT_BOXES,350 + TOP_BOXES);
        c.drawPath(piecePath, red);

        /**
         * PLAYER TWO BOX -- BLUE
         */
        //Blue 1 piece (1st row 1st piece)
        c.drawRect(10 + LEFT_BOXES, 30 + BOTTOM_BOXES, 40 + LEFT_BOXES, 60 + BOTTOM_BOXES, blue);

        //Blue 3 piece (1st row 2nd piece)
        c.drawRect(60 + LEFT_BOXES, 30 + BOTTOM_BOXES, 150 + LEFT_BOXES, 60 + BOTTOM_BOXES, blue);

        //Blue 5 piece (1st row 3rd piece)
        piecePath.reset();
        piecePath.moveTo(170 + LEFT_BOXES,30 + BOTTOM_BOXES);
        piecePath.lineTo(260 + LEFT_BOXES,30 + BOTTOM_BOXES);
        piecePath.lineTo(260 + LEFT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(200 + LEFT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(200 + LEFT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(170 + LEFT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(170 + LEFT_BOXES,30 + BOTTOM_BOXES);
        c.drawPath(piecePath, blue);

        //Blue 4 piece (1st row 4rd piece)
        c.drawRect(300 + LEFT_BOXES, 30 + BOTTOM_BOXES, 360 + LEFT_BOXES, 90 + BOTTOM_BOXES, blue);

        //Blue 3 piece (1st row 5th piece)
        piecePath.reset();
        piecePath.moveTo(380 + LEFT_BOXES,30 + BOTTOM_BOXES);
        piecePath.lineTo(440 + LEFT_BOXES,30 + BOTTOM_BOXES);
        piecePath.lineTo(440 + LEFT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(410 + LEFT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(410 + LEFT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(380 + LEFT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(380 + LEFT_BOXES,30 + BOTTOM_BOXES);
        c.drawPath(piecePath, blue);

        //Blue five pieces (1st row 6th piece)
        piecePath.reset();
        piecePath.moveTo(490 + LEFT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(520 + LEFT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(520 + LEFT_BOXES,30 + BOTTOM_BOXES);
        piecePath.lineTo(550 + LEFT_BOXES,30 + BOTTOM_BOXES);
        piecePath.lineTo(550 + LEFT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(580 + LEFT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(580 + LEFT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(550 + LEFT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(550 + LEFT_BOXES,120 + BOTTOM_BOXES);
        piecePath.lineTo(520 + LEFT_BOXES,120 + BOTTOM_BOXES);
        piecePath.lineTo(520 + LEFT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(490 + LEFT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(490 + LEFT_BOXES,60 + BOTTOM_BOXES);
        c.drawPath(piecePath, blue);

        //Blue two piece (2nd row 1st piece)
        c.drawRect(10 + LEFT_BOXES,100 + BOTTOM_BOXES,70 + LEFT_BOXES,130 + BOTTOM_BOXES, blue);

        //Blue four piece (2nd row 2nd piece)
        piecePath.reset();
        piecePath.moveTo(80 + LEFT_BOXES,100 + BOTTOM_BOXES);
        piecePath.lineTo(140 + LEFT_BOXES,100 + BOTTOM_BOXES);
        piecePath.lineTo(140 + LEFT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(170 + LEFT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(170 + LEFT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(110 + LEFT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(110 + LEFT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(80 + LEFT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(80 + LEFT_BOXES,100 + BOTTOM_BOXES);
        c.drawPath(piecePath, blue);

        //Blue four piece (2nd row 3rd piece)
        piecePath.reset();
        piecePath.moveTo(180 + LEFT_BOXES,200 + BOTTOM_BOXES);
        piecePath.lineTo(270 + LEFT_BOXES,200 + BOTTOM_BOXES);
        piecePath.lineTo(270 + LEFT_BOXES,170 + BOTTOM_BOXES);
        piecePath.lineTo(240 + LEFT_BOXES,170 + BOTTOM_BOXES);
        piecePath.lineTo(240 + LEFT_BOXES,140 + BOTTOM_BOXES);
        piecePath.lineTo(210 + LEFT_BOXES,140 + BOTTOM_BOXES);
        piecePath.lineTo(210 + LEFT_BOXES,170 + BOTTOM_BOXES);
        piecePath.lineTo(180 + LEFT_BOXES,170 + BOTTOM_BOXES);
        piecePath.lineTo(180 + LEFT_BOXES,200 + BOTTOM_BOXES);
        c.drawPath(piecePath, blue);

        //Blue five piece (2nd row 4th piece)
        piecePath.reset();
        piecePath.moveTo(310 + LEFT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(370 + LEFT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(370 + LEFT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(430 + LEFT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(430 + LEFT_BOXES,190 + BOTTOM_BOXES);
        piecePath.lineTo(340 + LEFT_BOXES,190 + BOTTOM_BOXES);
        piecePath.lineTo(340 + LEFT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(310 + LEFT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(310 + LEFT_BOXES,130 + BOTTOM_BOXES);
        c.drawPath(piecePath, blue);

        //Blue five piece (2nd row 5th piece)
        piecePath.reset();
        piecePath.moveTo(450 + LEFT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(480 + LEFT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(480 + LEFT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(540 + LEFT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(540 + LEFT_BOXES,220 + BOTTOM_BOXES);
        piecePath.lineTo(510 + LEFT_BOXES,220 + BOTTOM_BOXES);
        piecePath.lineTo(510 + LEFT_BOXES,190 + BOTTOM_BOXES);
        piecePath.lineTo(450 + LEFT_BOXES,190 + BOTTOM_BOXES);
        piecePath.lineTo(450 + LEFT_BOXES,130 + BOTTOM_BOXES);
        c.drawPath(piecePath, blue);

        //Blue five piece (3rd row 1st piece)
        piecePath.reset();
        piecePath.moveTo(10 + LEFT_BOXES,220 + BOTTOM_BOXES);
        piecePath.lineTo(130 + LEFT_BOXES,220 + BOTTOM_BOXES);
        piecePath.lineTo(130 + LEFT_BOXES,280 + BOTTOM_BOXES);
        piecePath.lineTo(100 + LEFT_BOXES,280 + BOTTOM_BOXES);
        piecePath.lineTo(100 + LEFT_BOXES,250 + BOTTOM_BOXES);
        piecePath.lineTo(10 + LEFT_BOXES,250 + BOTTOM_BOXES);
        piecePath.lineTo(10 + LEFT_BOXES,220 + BOTTOM_BOXES);
        c.drawPath(piecePath, blue);

        //Blue five piece (3rd row 2nd piece)
        piecePath.reset();
        piecePath.moveTo(240 + LEFT_BOXES,250 + BOTTOM_BOXES);
        piecePath.lineTo(270 + LEFT_BOXES,250 + BOTTOM_BOXES);
        piecePath.lineTo(270 + LEFT_BOXES,220 + BOTTOM_BOXES);
        piecePath.lineTo(300 + LEFT_BOXES,220 + BOTTOM_BOXES);
        piecePath.lineTo(300 + LEFT_BOXES,250 + BOTTOM_BOXES);
        piecePath.lineTo(360 + LEFT_BOXES,250 + BOTTOM_BOXES);
        piecePath.lineTo(360 + LEFT_BOXES,280 + BOTTOM_BOXES);
        piecePath.lineTo(240 + LEFT_BOXES,280 + BOTTOM_BOXES);
        piecePath.lineTo(240 + LEFT_BOXES,280 + BOTTOM_BOXES);
        c.drawPath(piecePath, blue);

        //Blue five piece (3rd row 3rd piece)
        piecePath.reset();
        piecePath.moveTo(400 + LEFT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(400 + LEFT_BOXES,260 + BOTTOM_BOXES);
        piecePath.lineTo(430 + LEFT_BOXES,260 + BOTTOM_BOXES);
        piecePath.lineTo(430 + LEFT_BOXES,230 + BOTTOM_BOXES);
        piecePath.lineTo(490 + LEFT_BOXES,230 + BOTTOM_BOXES);
        piecePath.lineTo(490 + LEFT_BOXES,260 + BOTTOM_BOXES);
        piecePath.lineTo(460 + LEFT_BOXES,260 + BOTTOM_BOXES);
        piecePath.lineTo(460 + LEFT_BOXES,290 + BOTTOM_BOXES);
        piecePath.lineTo(430 + LEFT_BOXES,290 + BOTTOM_BOXES);
        piecePath.lineTo(430 + LEFT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(400 + LEFT_BOXES,320 + BOTTOM_BOXES);
        c.drawPath(piecePath, blue);

        //Blue five piece (3rd row 4th piece)
        piecePath.reset();
        piecePath.moveTo(500 + LEFT_BOXES,290 + BOTTOM_BOXES);
        piecePath.lineTo(530 + LEFT_BOXES,290 + BOTTOM_BOXES);
        piecePath.lineTo(530 + LEFT_BOXES,230 + BOTTOM_BOXES);
        piecePath.lineTo(560 + LEFT_BOXES,230 + BOTTOM_BOXES);
        piecePath.lineTo(560 + LEFT_BOXES,260 + BOTTOM_BOXES);
        piecePath.lineTo(590 + LEFT_BOXES,260 + BOTTOM_BOXES);
        piecePath.lineTo(590 + LEFT_BOXES,290 + BOTTOM_BOXES);
        piecePath.lineTo(560 + LEFT_BOXES,290 + BOTTOM_BOXES);
        piecePath.lineTo(560 + LEFT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(500 + LEFT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(500 + LEFT_BOXES,290 + BOTTOM_BOXES);
        c.drawPath(piecePath, blue);

        //Blue five piece (4th row 1st piece)
        piecePath.reset();
        piecePath.moveTo(40 + LEFT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(40 + LEFT_BOXES,410 + BOTTOM_BOXES);
        piecePath.lineTo(100 + LEFT_BOXES,410 + BOTTOM_BOXES);
        piecePath.lineTo(100 + LEFT_BOXES,380 + BOTTOM_BOXES);
        piecePath.lineTo(70 + LEFT_BOXES,380 + BOTTOM_BOXES);
        piecePath.lineTo(70 + LEFT_BOXES,350 + BOTTOM_BOXES);
        piecePath.lineTo(100 + LEFT_BOXES,350 + BOTTOM_BOXES);
        piecePath.lineTo(100 + LEFT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(40 + LEFT_BOXES,320 + BOTTOM_BOXES);
        c.drawPath(piecePath, blue);

        //Blue five piece (4th row 2nd piece)
        piecePath.reset();
        piecePath.moveTo(140 + LEFT_BOXES,350 + BOTTOM_BOXES);
        piecePath.lineTo(200 + LEFT_BOXES,350 + BOTTOM_BOXES);
        piecePath.lineTo(200 + LEFT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(230 + LEFT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(230 + LEFT_BOXES,410 + BOTTOM_BOXES);
        piecePath.lineTo(200 + LEFT_BOXES,410 + BOTTOM_BOXES);
        piecePath.lineTo(200 + LEFT_BOXES,380 + BOTTOM_BOXES);
        piecePath.lineTo(140 + LEFT_BOXES,380 + BOTTOM_BOXES);
        piecePath.lineTo(140 + LEFT_BOXES,350 + BOTTOM_BOXES);
        c.drawPath(piecePath, blue);

        /**
         * PLAYER THREE BOX -- GREEN
         */
        //Green 1 piece (1st row 1st piece)
        c.drawRect(10 + RIGHT_BOXES, 30 + TOP_BOXES, 40 + RIGHT_BOXES, 60 + TOP_BOXES, green);

        //Green 3 piece (1st row 2nd piece)
        c.drawRect(60 + RIGHT_BOXES, 30 + TOP_BOXES, 150 + RIGHT_BOXES, 60 + TOP_BOXES, green);

        //Green 5 piece (1st row 3rd piece)
        piecePath.reset();
        piecePath.moveTo(170 + RIGHT_BOXES,30 + TOP_BOXES);
        piecePath.lineTo(260 + RIGHT_BOXES,30 + TOP_BOXES);
        piecePath.lineTo(260 + RIGHT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(200 + RIGHT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(200 + RIGHT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(170 + RIGHT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(170 + RIGHT_BOXES,30 + TOP_BOXES);
        c.drawPath(piecePath, green);

        //Green 4 piece (1st row 4rd piece)
        c.drawRect(300 + RIGHT_BOXES, 30 + TOP_BOXES, 360 + RIGHT_BOXES, 90 + TOP_BOXES, green);

        //Green 3 piece (1st row 5th piece)
        piecePath.reset();
        piecePath.moveTo(380 + RIGHT_BOXES,30 + TOP_BOXES);
        piecePath.lineTo(440 + RIGHT_BOXES,30 + TOP_BOXES);
        piecePath.lineTo(440 + RIGHT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(410 + RIGHT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(410 + RIGHT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(380 + RIGHT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(380 + RIGHT_BOXES,30 + TOP_BOXES);
        c.drawPath(piecePath, green);

        //Green five pieces (1st row 6th piece)
        piecePath.reset();
        piecePath.moveTo(490 + RIGHT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(520 + RIGHT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(520 + RIGHT_BOXES,30 + TOP_BOXES);
        piecePath.lineTo(550 + RIGHT_BOXES,30 + TOP_BOXES);
        piecePath.lineTo(550 + RIGHT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(580 + RIGHT_BOXES,60 + TOP_BOXES);
        piecePath.lineTo(580 + RIGHT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(550 + RIGHT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(550 + RIGHT_BOXES,120 + TOP_BOXES);
        piecePath.lineTo(520 + RIGHT_BOXES,120 + TOP_BOXES);
        piecePath.lineTo(520 + RIGHT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(490 + RIGHT_BOXES,90 + TOP_BOXES);
        piecePath.lineTo(490 + RIGHT_BOXES,60 + TOP_BOXES);
        c.drawPath(piecePath, green);

        //Green two piece (2nd row 1st piece)
        c.drawRect(10 + RIGHT_BOXES,100 + TOP_BOXES,70 + RIGHT_BOXES,130 + TOP_BOXES, green);

        //Green four piece (2nd row 2nd piece)
        piecePath.reset();
        piecePath.moveTo(80 + RIGHT_BOXES,100 + TOP_BOXES);
        piecePath.lineTo(140 + RIGHT_BOXES,100 + TOP_BOXES);
        piecePath.lineTo(140 + RIGHT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(170 + RIGHT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(170 + RIGHT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(110 + RIGHT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(110 + RIGHT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(80 + RIGHT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(80 + RIGHT_BOXES,100 + TOP_BOXES);
        c.drawPath(piecePath, green);

        //Green four piece (2nd row 3rd piece)
        piecePath.reset();
        piecePath.moveTo(180 + RIGHT_BOXES,200 + TOP_BOXES);
        piecePath.lineTo(270 + RIGHT_BOXES,200 + TOP_BOXES);
        piecePath.lineTo(270 + RIGHT_BOXES,170 + TOP_BOXES);
        piecePath.lineTo(240 + RIGHT_BOXES,170 + TOP_BOXES);
        piecePath.lineTo(240 + RIGHT_BOXES,140 + TOP_BOXES);
        piecePath.lineTo(210 + RIGHT_BOXES,140 + TOP_BOXES);
        piecePath.lineTo(210 + RIGHT_BOXES,170 + TOP_BOXES);
        piecePath.lineTo(180 + RIGHT_BOXES,170 + TOP_BOXES);
        piecePath.lineTo(180 + RIGHT_BOXES,200 + TOP_BOXES);
        c.drawPath(piecePath, green);

        //Green five piece (2nd row 4th piece)
        piecePath.reset();
        piecePath.moveTo(310 + RIGHT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(370 + RIGHT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(370 + RIGHT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(430 + RIGHT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(430 + RIGHT_BOXES,190 + TOP_BOXES);
        piecePath.lineTo(340 + RIGHT_BOXES,190 + TOP_BOXES);
        piecePath.lineTo(340 + RIGHT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(310 + RIGHT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(310 + RIGHT_BOXES,130 + TOP_BOXES);
        c.drawPath(piecePath, green);

        //Green five piece (2nd row 5th piece)
        piecePath.reset();
        piecePath.moveTo(450 + RIGHT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(480 + RIGHT_BOXES,130 + TOP_BOXES);
        piecePath.lineTo(480 + RIGHT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(540 + RIGHT_BOXES,160 + TOP_BOXES);
        piecePath.lineTo(540 + RIGHT_BOXES,220 + TOP_BOXES);
        piecePath.lineTo(510 + RIGHT_BOXES,220 + TOP_BOXES);
        piecePath.lineTo(510 + RIGHT_BOXES,190 + TOP_BOXES);
        piecePath.lineTo(450 + RIGHT_BOXES,190 + TOP_BOXES);
        piecePath.lineTo(450 + RIGHT_BOXES,130 + TOP_BOXES);
        c.drawPath(piecePath, green);

        //Green five piece (3rd row 1st piece)
        piecePath.reset();
        piecePath.moveTo(10 + RIGHT_BOXES,220 + TOP_BOXES);
        piecePath.lineTo(130 + RIGHT_BOXES,220 + TOP_BOXES);
        piecePath.lineTo(130 + RIGHT_BOXES,280 + TOP_BOXES);
        piecePath.lineTo(100 + RIGHT_BOXES,280 + TOP_BOXES);
        piecePath.lineTo(100 + RIGHT_BOXES,250 + TOP_BOXES);
        piecePath.lineTo(10 + RIGHT_BOXES,250 + TOP_BOXES);
        piecePath.lineTo(10 + RIGHT_BOXES,220 + TOP_BOXES);
        c.drawPath(piecePath, green);

        //Green five piece (3rd row 2nd piece)
        piecePath.reset();
        piecePath.moveTo(240 + RIGHT_BOXES,250 + TOP_BOXES);
        piecePath.lineTo(270 + RIGHT_BOXES,250 + TOP_BOXES);
        piecePath.lineTo(270 + RIGHT_BOXES,220 + TOP_BOXES);
        piecePath.lineTo(300 + RIGHT_BOXES,220 + TOP_BOXES);
        piecePath.lineTo(300 + RIGHT_BOXES,250 + TOP_BOXES);
        piecePath.lineTo(360 + RIGHT_BOXES,250 + TOP_BOXES);
        piecePath.lineTo(360 + RIGHT_BOXES,280 + TOP_BOXES);
        piecePath.lineTo(240 + RIGHT_BOXES,280 + TOP_BOXES);
        piecePath.lineTo(240 + RIGHT_BOXES,280 + TOP_BOXES);
        c.drawPath(piecePath, green);

        //Green five piece (3rd row 3rd piece)
        piecePath.reset();
        piecePath.moveTo(400 + RIGHT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(400 + RIGHT_BOXES,260 + TOP_BOXES);
        piecePath.lineTo(430 + RIGHT_BOXES,260 + TOP_BOXES);
        piecePath.lineTo(430 + RIGHT_BOXES,230 + TOP_BOXES);
        piecePath.lineTo(490 + RIGHT_BOXES,230 + TOP_BOXES);
        piecePath.lineTo(490 + RIGHT_BOXES,260 + TOP_BOXES);
        piecePath.lineTo(460 + RIGHT_BOXES,260 + TOP_BOXES);
        piecePath.lineTo(460 + RIGHT_BOXES,290 + TOP_BOXES);
        piecePath.lineTo(430 + RIGHT_BOXES,290 + TOP_BOXES);
        piecePath.lineTo(430 + RIGHT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(400 + RIGHT_BOXES,320 + TOP_BOXES);
        c.drawPath(piecePath, green);

        //Green five piece (3rd row 4th piece)
        piecePath.reset();
        piecePath.moveTo(500 + RIGHT_BOXES,290 + TOP_BOXES);
        piecePath.lineTo(530 + RIGHT_BOXES,290 + TOP_BOXES);
        piecePath.lineTo(530 + RIGHT_BOXES,230 + TOP_BOXES);
        piecePath.lineTo(560 + RIGHT_BOXES,230 + TOP_BOXES);
        piecePath.lineTo(560 + RIGHT_BOXES,260 + TOP_BOXES);
        piecePath.lineTo(590 + RIGHT_BOXES,260 + TOP_BOXES);
        piecePath.lineTo(590 + RIGHT_BOXES,290 + TOP_BOXES);
        piecePath.lineTo(560 + RIGHT_BOXES,290 + TOP_BOXES);
        piecePath.lineTo(560 + RIGHT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(500 + RIGHT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(500 + RIGHT_BOXES,290 + TOP_BOXES);
        c.drawPath(piecePath, green);

        //Green five piece (4th row 1st piece)
        piecePath.reset();
        piecePath.moveTo(40 + RIGHT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(40 + RIGHT_BOXES,410 + TOP_BOXES);
        piecePath.lineTo(100 + RIGHT_BOXES,410 + TOP_BOXES);
        piecePath.lineTo(100 + RIGHT_BOXES,380 + TOP_BOXES);
        piecePath.lineTo(70 + RIGHT_BOXES,380 + TOP_BOXES);
        piecePath.lineTo(70 + RIGHT_BOXES,350 + TOP_BOXES);
        piecePath.lineTo(100 + RIGHT_BOXES,350 + TOP_BOXES);
        piecePath.lineTo(100 + RIGHT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(40 + RIGHT_BOXES,320 + TOP_BOXES);
        c.drawPath(piecePath, green);

        //Green five piece (4th row 2nd piece)
        piecePath.reset();
        piecePath.moveTo(140 + RIGHT_BOXES,350 + TOP_BOXES);
        piecePath.lineTo(200 + RIGHT_BOXES,350 + TOP_BOXES);
        piecePath.lineTo(200 + RIGHT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(230 + RIGHT_BOXES,320 + TOP_BOXES);
        piecePath.lineTo(230 + RIGHT_BOXES,410 + TOP_BOXES);
        piecePath.lineTo(200 + RIGHT_BOXES,410 + TOP_BOXES);
        piecePath.lineTo(200 + RIGHT_BOXES,380 + TOP_BOXES);
        piecePath.lineTo(140 + RIGHT_BOXES,380 + TOP_BOXES);
        piecePath.lineTo(140 + RIGHT_BOXES,350 + TOP_BOXES);
        c.drawPath(piecePath, green);


        /**
         * PLAYER FOUR BOX -- YELLOW
         */
        //Yellow 1 piece (1st row 1st piece)
        c.drawRect(10 + RIGHT_BOXES, 30 + BOTTOM_BOXES, 40 + RIGHT_BOXES, 60 + BOTTOM_BOXES, yellow);

        //Yellow 3 piece (1st row 2nd piece)
        c.drawRect(60 + RIGHT_BOXES, 30 + BOTTOM_BOXES, 150 + RIGHT_BOXES, 60 + BOTTOM_BOXES, yellow);

        //Yellow 5 piece (1st row 3rd piece)
        piecePath.reset();
        piecePath.moveTo(170 + RIGHT_BOXES,30 + BOTTOM_BOXES);
        piecePath.lineTo(260 + RIGHT_BOXES,30 + BOTTOM_BOXES);
        piecePath.lineTo(260 + RIGHT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(200 + RIGHT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(200 + RIGHT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(170 + RIGHT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(170 + RIGHT_BOXES,30 + BOTTOM_BOXES);
        c.drawPath(piecePath, yellow);

        //Yellow 4 piece (1st row 4rd piece)
        c.drawRect(300 + RIGHT_BOXES, 30 + BOTTOM_BOXES, 360 + RIGHT_BOXES, 90 + BOTTOM_BOXES, yellow);

        //Yellow 3 piece (1st row 5th piece)
        piecePath.reset();
        piecePath.moveTo(380 + RIGHT_BOXES,30 + BOTTOM_BOXES);
        piecePath.lineTo(440 + RIGHT_BOXES,30 + BOTTOM_BOXES);
        piecePath.lineTo(440 + RIGHT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(410 + RIGHT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(410 + RIGHT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(380 + RIGHT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(380 + RIGHT_BOXES,30 + BOTTOM_BOXES);
        c.drawPath(piecePath, yellow);

        //Yellow five pieces (1st row 6th piece)
        piecePath.reset();
        piecePath.moveTo(490 + RIGHT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(520 + RIGHT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(520 + RIGHT_BOXES,30 + BOTTOM_BOXES);
        piecePath.lineTo(550 + RIGHT_BOXES,30 + BOTTOM_BOXES);
        piecePath.lineTo(550 + RIGHT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(580 + RIGHT_BOXES,60 + BOTTOM_BOXES);
        piecePath.lineTo(580 + RIGHT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(550 + RIGHT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(550 + RIGHT_BOXES,120 + BOTTOM_BOXES);
        piecePath.lineTo(520 + RIGHT_BOXES,120 + BOTTOM_BOXES);
        piecePath.lineTo(520 + RIGHT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(490 + RIGHT_BOXES,90 + BOTTOM_BOXES);
        piecePath.lineTo(490 + RIGHT_BOXES,60 + BOTTOM_BOXES);
        c.drawPath(piecePath, yellow);

        //Yellow two piece (2nd row 1st piece)
        c.drawRect(10 + RIGHT_BOXES,100 + BOTTOM_BOXES,70 + RIGHT_BOXES,130 + BOTTOM_BOXES, yellow);

        //Yellow four piece (2nd row 2nd piece)
        piecePath.reset();
        piecePath.moveTo(80 + RIGHT_BOXES,100 + BOTTOM_BOXES);
        piecePath.lineTo(140 + RIGHT_BOXES,100 + BOTTOM_BOXES);
        piecePath.lineTo(140 + RIGHT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(170 + RIGHT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(170 + RIGHT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(110 + RIGHT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(110 + RIGHT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(80 + RIGHT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(80 + RIGHT_BOXES,100 + BOTTOM_BOXES);
        c.drawPath(piecePath, yellow);

        //Yellow four piece (2nd row 3rd piece)
        piecePath.reset();
        piecePath.moveTo(180 + RIGHT_BOXES,200 + BOTTOM_BOXES);
        piecePath.lineTo(270 + RIGHT_BOXES,200 + BOTTOM_BOXES);
        piecePath.lineTo(270 + RIGHT_BOXES,170 + BOTTOM_BOXES);
        piecePath.lineTo(240 + RIGHT_BOXES,170 + BOTTOM_BOXES);
        piecePath.lineTo(240 + RIGHT_BOXES,140 + BOTTOM_BOXES);
        piecePath.lineTo(210 + RIGHT_BOXES,140 + BOTTOM_BOXES);
        piecePath.lineTo(210 + RIGHT_BOXES,170 + BOTTOM_BOXES);
        piecePath.lineTo(180 + RIGHT_BOXES,170 + BOTTOM_BOXES);
        piecePath.lineTo(180 + RIGHT_BOXES,200 + BOTTOM_BOXES);
        c.drawPath(piecePath, yellow);

        //Yellow five piece (2nd row 4th piece)
        piecePath.reset();
        piecePath.moveTo(310 + RIGHT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(370 + RIGHT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(370 + RIGHT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(430 + RIGHT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(430 + RIGHT_BOXES,190 + BOTTOM_BOXES);
        piecePath.lineTo(340 + RIGHT_BOXES,190 + BOTTOM_BOXES);
        piecePath.lineTo(340 + RIGHT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(310 + RIGHT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(310 + RIGHT_BOXES,130 + BOTTOM_BOXES);
        c.drawPath(piecePath, yellow);

        //Yellow five piece (2nd row 5th piece)
        piecePath.reset();
        piecePath.moveTo(450 + RIGHT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(480 + RIGHT_BOXES,130 + BOTTOM_BOXES);
        piecePath.lineTo(480 + RIGHT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(540 + RIGHT_BOXES,160 + BOTTOM_BOXES);
        piecePath.lineTo(540 + RIGHT_BOXES,220 + BOTTOM_BOXES);
        piecePath.lineTo(510 + RIGHT_BOXES,220 + BOTTOM_BOXES);
        piecePath.lineTo(510 + RIGHT_BOXES,190 + BOTTOM_BOXES);
        piecePath.lineTo(450 + RIGHT_BOXES,190 + BOTTOM_BOXES);
        piecePath.lineTo(450 + RIGHT_BOXES,130 + BOTTOM_BOXES);
        c.drawPath(piecePath, yellow);

        //Yellow five piece (3rd row 1st piece)
        piecePath.reset();
        piecePath.moveTo(10 + RIGHT_BOXES,220 + BOTTOM_BOXES);
        piecePath.lineTo(130 + RIGHT_BOXES,220 + BOTTOM_BOXES);
        piecePath.lineTo(130 + RIGHT_BOXES,280 + BOTTOM_BOXES);
        piecePath.lineTo(100 + RIGHT_BOXES,280 + BOTTOM_BOXES);
        piecePath.lineTo(100 + RIGHT_BOXES,250 + BOTTOM_BOXES);
        piecePath.lineTo(10 + RIGHT_BOXES,250 + BOTTOM_BOXES);
        piecePath.lineTo(10 + RIGHT_BOXES,220 + BOTTOM_BOXES);
        c.drawPath(piecePath, yellow);

        //Yellow five piece (3rd row 2nd piece)
        piecePath.reset();
        piecePath.moveTo(240 + RIGHT_BOXES,250 + BOTTOM_BOXES);
        piecePath.lineTo(270 + RIGHT_BOXES,250 + BOTTOM_BOXES);
        piecePath.lineTo(270 + RIGHT_BOXES,220 + BOTTOM_BOXES);
        piecePath.lineTo(300 + RIGHT_BOXES,220 + BOTTOM_BOXES);
        piecePath.lineTo(300 + RIGHT_BOXES,250 + BOTTOM_BOXES);
        piecePath.lineTo(360 + RIGHT_BOXES,250 + BOTTOM_BOXES);
        piecePath.lineTo(360 + RIGHT_BOXES,280 + BOTTOM_BOXES);
        piecePath.lineTo(240 + RIGHT_BOXES,280 + BOTTOM_BOXES);
        piecePath.lineTo(240 + RIGHT_BOXES,280 + BOTTOM_BOXES);
        c.drawPath(piecePath, yellow);

        //Yellow five piece (3rd row 3rd piece)
        piecePath.reset();
        piecePath.moveTo(400 + RIGHT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(400 + RIGHT_BOXES,260 + BOTTOM_BOXES);
        piecePath.lineTo(430 + RIGHT_BOXES,260 + BOTTOM_BOXES);
        piecePath.lineTo(430 + RIGHT_BOXES,230 + BOTTOM_BOXES);
        piecePath.lineTo(490 + RIGHT_BOXES,230 + BOTTOM_BOXES);
        piecePath.lineTo(490 + RIGHT_BOXES,260 + BOTTOM_BOXES);
        piecePath.lineTo(460 + RIGHT_BOXES,260 + BOTTOM_BOXES);
        piecePath.lineTo(460 + RIGHT_BOXES,290 + BOTTOM_BOXES);
        piecePath.lineTo(430 + RIGHT_BOXES,290 + BOTTOM_BOXES);
        piecePath.lineTo(430 + RIGHT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(400 + RIGHT_BOXES,320 + BOTTOM_BOXES);
        c.drawPath(piecePath, yellow);

        //Yellow five piece (3rd row 4th piece)
        piecePath.reset();
        piecePath.moveTo(500 + RIGHT_BOXES,290 + BOTTOM_BOXES);
        piecePath.lineTo(530 + RIGHT_BOXES,290 + BOTTOM_BOXES);
        piecePath.lineTo(530 + RIGHT_BOXES,230 + BOTTOM_BOXES);
        piecePath.lineTo(560 + RIGHT_BOXES,230 + BOTTOM_BOXES);
        piecePath.lineTo(560 + RIGHT_BOXES,260 + BOTTOM_BOXES);
        piecePath.lineTo(590 + RIGHT_BOXES,260 + BOTTOM_BOXES);
        piecePath.lineTo(590 + RIGHT_BOXES,290 + BOTTOM_BOXES);
        piecePath.lineTo(560 + RIGHT_BOXES,290 + BOTTOM_BOXES);
        piecePath.lineTo(560 + RIGHT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(500 + RIGHT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(500 + RIGHT_BOXES,290 + BOTTOM_BOXES);
        c.drawPath(piecePath, yellow);

        //Yellow five piece (4th row 1st piece)
        piecePath.reset();
        piecePath.moveTo(40 + RIGHT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(40 + RIGHT_BOXES,410 + BOTTOM_BOXES);
        piecePath.lineTo(100 + RIGHT_BOXES,410 + BOTTOM_BOXES);
        piecePath.lineTo(100 + RIGHT_BOXES,380 + BOTTOM_BOXES);
        piecePath.lineTo(70 + RIGHT_BOXES,380 + BOTTOM_BOXES);
        piecePath.lineTo(70 + RIGHT_BOXES,350 + BOTTOM_BOXES);
        piecePath.lineTo(100 + RIGHT_BOXES,350 + BOTTOM_BOXES);
        piecePath.lineTo(100 + RIGHT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(40 + RIGHT_BOXES,320 + BOTTOM_BOXES);
        c.drawPath(piecePath, yellow);

        //Yellow five piece (4th row 2nd piece)
        piecePath.reset();
        piecePath.moveTo(140 + RIGHT_BOXES,350 + BOTTOM_BOXES);
        piecePath.lineTo(200 + RIGHT_BOXES,350 + BOTTOM_BOXES);
        piecePath.lineTo(200 + RIGHT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(230 + RIGHT_BOXES,320 + BOTTOM_BOXES);
        piecePath.lineTo(230 + RIGHT_BOXES,410 + BOTTOM_BOXES);
        piecePath.lineTo(200 + RIGHT_BOXES,410 + BOTTOM_BOXES);
        piecePath.lineTo(200 + RIGHT_BOXES,380 + BOTTOM_BOXES);
        piecePath.lineTo(140 + RIGHT_BOXES,380 + BOTTOM_BOXES);
        piecePath.lineTo(140 + RIGHT_BOXES,350 + BOTTOM_BOXES);
        c.drawPath(piecePath, yellow);

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