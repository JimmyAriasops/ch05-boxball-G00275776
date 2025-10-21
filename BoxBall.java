import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Class BoxBall - a graphical ball that moves similar to the ball in PONG.
 * It bounces around the confines of a box as defined by the Box class.
 * Details of movement are determined by the ball itself. It will move to
 * the right when xspeed is positive and to the left when xspeed is negative.
 * Due to the way computer graphics are drawn using awt, the ball moves
 * DOWN when yspeed is positive and UP when yspeed is negative.
 * 
 * It is the ball's responsibility to determine if it has hit a wall and 
 * to reverse direction
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael Kölling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 * @author William Crosbie
 * @author Jimmy Arias
 *
 * @version 2025.10.20
 */

public class BoxBall
{
    private Box myBox;
    private Ellipse2D.Double circle;    // represents the ball
    private Color color;        // color of the ball (can be rgb value)
    private int diameter;       // width of ball in number of pixels
    private int xPosition;      // horizontal position of bounding square
    private int yPosition;      // vertical position of bounding square
    private Canvas canvas;
    private int ySpeed;         // vertical speed
    private int xSpeed;         // horizontal speed

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param box  the bounding box (where the ball will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        Box box, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        myBox = box;
        canvas = drawingCanvas;
        
        Random rand = new Random();
    
        do{
            xSpeed = rand.nextInt(7)-3;
            ySpeed = rand.nextInt(7)-3;
        }while (xSpeed ==0 || ySpeed == 0);
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
        
        // compute new position   
        xPosition += xSpeed;
        yPosition += ySpeed;
        
        // figure out if it has hit the left or right wall
        if (xPosition <= myBox.getLeftWall() || xPosition >= myBox.getRightWall() -diameter) 
        {
            xSpeed = -xSpeed;
        }
        
        // figure out if it has hit the top or bottom wall
        if (yPosition <= myBox.getTopWall() || yPosition >= myBox.getBottomWall() -diameter) 
        {
            ySpeed = -ySpeed;
        }
        
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
