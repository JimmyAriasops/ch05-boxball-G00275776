import java.awt.Dimension;

/**
 * Box creates a box from four lines on a Canvas
 * The box is defined by the point in the upper left and
 * the point in the lower right of the box.
 *
 * @author Crosbie
 * @version 2025-10-13
 */
public class Box
{
    // instance variables - replace the example below with your own
    private Canvas myCanvas;
    private int upperLeftX,
                upperLeftY,
                lowerRightX,
                lowerRightY;
                
    private final int defaultOffset = 10; //10 pixels from the border
    

    /**
     * Constructor for objects of class Box
     * @param c the Canvas the box will be drawn on
     */
    public Box(Canvas c)
    {
        myCanvas = c;
        Dimension dim = c.getSize(); 
        int width = (int) dim.getWidth();
        int height = (int) dim.getHeight();
        upperLeftX = defaultOffset;
        upperLeftY = defaultOffset;
        lowerRightX = width-defaultOffset;
        lowerRightY = height-defaultOffset;

    }
    
    
    /**
     * Makes a Box at the given upper left and lower right coordinates
     * if the parameters are outside the bounds of a side of the canvas, 
     * that side of the box is drawn at the default offset
     * from that edge of the canvas
     * 
     * @param ul_X the upper left X coordinate of the box
     * @param ul_Y the upper left Y coordinate of the box
     * @param lr_X the lower right X coordinate of the box
     * @param lr_Y the lower right Y coordinate of the box
     * @param c the Canvas the box will be drawn on
     */
    public Box(int ul_X, int ul_Y, int lr_X, int lr_Y, Canvas c)
    {
        myCanvas = c;
        Dimension dim = c.getSize(); 
        int width = (int) dim.getWidth();
        int height = (int) dim.getHeight();
        
        if(ul_X < 0) 
            upperLeftX=defaultOffset; 
            else upperLeftX = ul_X;
        if(ul_Y < 0) 
            upperLeftY=defaultOffset; 
            else upperLeftY = ul_Y;
        if(lr_X > width) 
            lowerRightX=width-defaultOffset; 
            else lowerRightX = lr_X;
        if(lr_Y > height) 
            lowerRightY=height-defaultOffset; 
            else lowerRightY = lr_Y;
    }

    /**
     * draws the box at the specified location on the Canvas
     */
    public void draw()
    {
        myCanvas.drawLine(upperLeftX, upperLeftY, lowerRightX, upperLeftY);
        myCanvas.drawLine(lowerRightX, upperLeftY, lowerRightX, lowerRightY);
        myCanvas.drawLine(lowerRightX, lowerRightY, upperLeftX, lowerRightY);
        myCanvas.drawLine(upperLeftX, lowerRightY, upperLeftX, upperLeftY);   
    }
    
    /**
     * returns the x coordinate of the left wall
     * 
     * @return the x value in pixel location of left wall
     */
    public int getLeftWall(){
        return upperLeftX;
    }
    
    /**
     * returns the y coordinate of the top wall
     * 
     * @return the y value in pixel location of top wall
     */
    public int getTopWall(){
        return upperLeftY;
    }
    
    /**
     * returns the x coordinate of the right wall
     * 
     * @return the x value in pixel location of right wall
     */
    public int getRightWall(){
        return lowerRightX;
    }
    
    /**
     * returns the y coordinate of the bottom wall
     * 
     * @return the y value in pixel location of bottom wall
     */
    public int getBottomWall(){
        return lowerRightY;
    }
}