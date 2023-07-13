import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GameVersion1 extends JPanel implements ActionListener {


    private Image spaceShip;
    private int spaceWidth, spaceHeight;
    private int shipWidth = 100, shipHeight = 60;
    private int shipX, shipY;
    private int speed = 10;
    private boolean isLeftPressed, isRightPressed, isUpPressed, isDownPressed, isSpacePressed;
    private int delay = 10;
    private Timer timer = new Timer(delay, this);
    private Color starColor , squareColor;
    private int starWidth = 15, starHeight = 15;
    private int starX, starY, sqX, sqY;
    private int drawNewStarCounter, starOnScreen,drawNewSquareCounter, squareOnScreen;
    private boolean planetDiscovered = false, squarePlanetDiscovered = false;
    private int playerPoints, starCounter;
    private boolean gameOver = false;
    private int gameOverCondition;

    public GameVersion1(Image i, int w, int h) {

        spaceWidth = w;
        spaceHeight = h;
        spaceShip = i;
        shipX = 30;
        shipY = 30;
        setBackground(Color.black);

         starColor = Color.RED;
         squareColor = Color.BLUE;

        //Set focus to the panel
        requestFocusInWindow();
        // Set panel to be focusable rather than the JFrame
        setFocusable(true);

        //game settings
        drawNewStarCounter = 1;
        drawNewSquareCounter = 1;
        gameOverCondition = 100;

        // Start the timer
        timer.start();
        fly();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the spaceship with the image, x, y, width, and height
        g.drawImage(spaceShip, shipX, shipY, shipWidth, shipHeight, this);

        //draw the star
        g.setColor(starColor);
        g.fillOval(starX, starY, starWidth, starHeight);

        //draw a square
        g.setColor(squareColor);
        g.fillRect(sqX, sqY, starWidth, starHeight);


        //draw the points and stars
        g.setColor(Color.white);
        g.drawString("Points: " + playerPoints, 10, 20);
        g.drawString("Stars: " + starCounter, 100, 20);

        //draw the game over screen
        if (gameOver) {
            g.setColor(Color.BLUE);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.drawString("Mission completed!", spaceWidth/2 - 140, spaceHeight/2);
            g.drawString("Your Points: " + playerPoints + " out of " + gameOverCondition, spaceWidth/2 - 170, spaceHeight/2 + 50);

        }
    }

    private void fly() {

        //add a key listener to the panel + override the key listener methods + set the pressedkey booleans
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                int action = e.getKeyCode();
                switch (action) {
                    case KeyEvent.VK_RIGHT:
                        isRightPressed = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        isLeftPressed = true;
                        break;
                    case KeyEvent.VK_UP:
                        isUpPressed = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        isDownPressed = true;
                        break;
                    case KeyEvent.VK_D:
                        isRightPressed = true;
                        break;
                    case KeyEvent.VK_A:
                        isLeftPressed = true;
                        break;
                    case KeyEvent.VK_W:
                        isUpPressed = true;
                        break;
                    case KeyEvent.VK_S:
                        isDownPressed = true;
                        break;
                    //one key press space
                    case KeyEvent.VK_SPACE:
                        System.out.println("Space pressed");
                        break;
            }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                int action = e.getKeyCode();
                switch (action) {
                    case KeyEvent.VK_RIGHT:
                        isRightPressed = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        isLeftPressed = false;
                        break;
                    case KeyEvent.VK_UP:
                        isUpPressed = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        isDownPressed = false;
                        break;
                    case KeyEvent.VK_D:
                        isRightPressed = false;
                        break;
                    case KeyEvent.VK_A:
                        isLeftPressed = false;
                        break;
                    case KeyEvent.VK_W:
                        isUpPressed = false;
                        break;
                    case KeyEvent.VK_S:
                        isDownPressed = false;
                        break;
                }
            }

        });


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //draw a new star every 100 frames
        drawNewStarCounter -= 1;

        if (drawNewStarCounter < 1){
            planetDiscovered = false;
            starColor = Color.RED;
            starCounter++;
            // Create a random star
            Random randomStar = new Random();
            starX = randomStar.nextInt(spaceWidth - starWidth);
            starY = randomStar.nextInt(spaceHeight - starHeight);
            System.out.println("Star X: " + starX + " Star Y: " + starY);
            repaint();
            drawNewStarCounter = 100;
            starOnScreen++;
        }


        //draw a new square every 100 frames
        drawNewSquareCounter -= 1;
        if (drawNewSquareCounter < 1){
            squarePlanetDiscovered = false;
            squareColor = Color.orange;
            starCounter++;
            // Create a random square
            Random randomStar = new Random();
            sqX = randomStar.nextInt(spaceWidth - starWidth);
            sqY = randomStar.nextInt(spaceHeight - starHeight);
            System.out.println("Square X: " + sqX + " Square Y: " + sqY);
            repaint();
            drawNewSquareCounter = 100;
            squareOnScreen++;

        }

        timerUpdate();


    }

    private void timerUpdate() {

        // Move the ship
        if(isLeftPressed){
            shipX -= speed;
        }
        if(isRightPressed){
            shipX += speed;
        }
        if(isUpPressed){
            shipY -= speed;
        }
        if(isDownPressed){
            shipY += speed;
        }

        // Check if the ship is out of bounds and reset
        if (shipX > spaceWidth) {
            shipX = -shipWidth;
        }
        if (shipY > spaceHeight){
            shipY = -shipHeight;
        }
        if (shipX < -shipWidth){
            shipX = spaceWidth;
        }
        if (shipY < -shipHeight){
            shipY = spaceHeight;
        }
        //System.out.println("X: " + shipX + " Y: " + shipY);


        //collision detection
        if (collision() && !planetDiscovered){

            planetDiscovered = true;

            playerPoints++;
            System.out.println("Player points: " + playerPoints + " Star counter: " + starCounter);

            starColor = Color.GREEN;
            squareColor = Color.GREEN;

            /*
            if (drawNewStarCounter > 12 || drawNewSquareCounter > 12){
                drawNewStarCounter = 10;
                drawNewSquareCounter = 10;
            }
            */
        }

        gameOver();
        repaint();


    }


    private boolean collision(){

        return  shipX < starX + starWidth &&
                shipY < starY + starHeight &&
                starX < shipX + shipWidth &&
                starY < shipY + shipHeight ||
                shipX < sqX + starWidth &&
                shipY < sqY + starHeight &&
                sqX < shipX + shipWidth &&
                sqY < shipY + shipHeight
                ;

    }

    public void gameOver(){

        if (starCounter == gameOverCondition){
            gameOver = true;
            timer.stop();
            System.out.println("Game Over");

        }

    }
}
