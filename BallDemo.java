import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Jimmy Arais
* @version 2025.10.20
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Box box;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     * 
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        box=new Box (100,100,500,400, myCanvas);
        box.draw();
        
    }

    /**
     * boxBounce - simulate 5-30 balls bouncing within a box
     * 
     * @param numOfBalls number of balls to simulate bouncing, clamped between 5-50. 
     */
    public void boxBounce(int numOfBalls)
    {
        if (numOfBalls < 5 || numOfBalls > 30) {
            System.out.println("Please enter a number within 5 and 30");
            return;
        }// you must implement this
        
        myCanvas.setVisible(true);
        Random rand = new Random();
        BoxBall [] balls = new BoxBall [numOfBalls];
        
        for (int i = 0; i < numOfBalls; i++) {
            int diameter = 20;
            int xPos = rand.nextInt(box.getRightWall()- box.getLeftWall()- diameter) + box.getLeftWall();
            int yPos = rand.nextInt(box.getBottomWall()- box.getTopWall()- diameter) + box.getTopWall();
            Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            balls[i] = new BoxBall(xPos, yPos, diameter, color, box, myCanvas);
            balls[i].draw();
        }
        while (true)
        {
            myCanvas.wait(20);
            box.draw();        // Redraw missing parts of box each frame 
            for(BoxBall ball : balls) {
                ball.move();
            }
        }
    }
    
    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
