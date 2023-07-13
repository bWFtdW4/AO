import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class GameVersion3 extends JPanel implements ActionListener {


    private Image spaceShip;
    private int spaceWidth, spaceHeight;
    private int shipWidth = 100, shipHeight = 60;
    private int shipX, shipY;
    private int speed = 10;
    private boolean isLeftPressed, isRightPressed, isUpPressed, isDownPressed, isSpacePressed;
    private int delay = 10;
    private Timer timer = new Timer(delay, this);
    private Color starColor = Color.RED;
    private int starWidth = 15, starHeight = 15;
    private int starX, starY;
    private int drawNewStarCounter, starOnScreen;
    private boolean planetDiscovered = false;
    private int playerPoints, starCounter;
    private boolean gameOver = false;
    private int gameOverCondition;

    //add CoordinateManager object
    private CoordinateManager coordinateManager = new CoordinateManager();
    private int coordId = 0;

    public GameVersion3(Image i, int w, int h) {

        spaceWidth = w;
        spaceHeight = h;
        spaceShip = i;
        shipX = 30;
        shipY = 30;
        setBackground(Color.DARK_GRAY);

        //Set focus to the panel
        requestFocusInWindow();
        // Set panel to be focusable rather than the JFrame
        setFocusable(true);

        //game settings
        drawNewStarCounter = 1;
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
                        generateCoordinates();
                        break;
                    //one key press "p"
                    case KeyEvent.VK_P:
                        System.out.println(" p pressed");
                        drawStars();
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

            if (drawNewStarCounter > 12){
                drawNewStarCounter = 10;
            }
        }

        gameOver();
        repaint();


    }


    private boolean collision(){

        return  shipX < starX + starWidth &&
                shipY < starY + starHeight &&
                starX < shipX + shipWidth &&
                starY < shipY + shipHeight;

    }

    public void gameOver(){

        if (starCounter == gameOverCondition){
            gameOver = true;
            timer.stop();
            System.out.println("Game Over");

        }
    }

    //generate random coordinates with id add to CoordinateManager activated by spacebar
    public void generateCoordinates(){
        System.out.println("Generating coordinates nr. " + (coordId + 1));

        //generate random coordinates
        Random randomCoords = new Random();
        int x = randomCoords.nextInt(spaceWidth - starWidth);
        int y = randomCoords.nextInt(spaceHeight - starHeight);

        //add coordinates to CoordinateManager
        coordinateManager.addCoordinate(coordId, x, y);

        //increase the coordId
        coordId++;

    }

    //draw all the stars from the coordinateManager activated by "p"
    public void drawStars() {

        try {
            System.out.println("Drawing stars + coorId:" + coordId + " + starCounter " + starCounter);

            //reset the star color
            starColor = Color.RED;

            //reset the planetDiscovered
            planetDiscovered = false;

            starX = coordinateManager.getCoordinate(starCounter).getCoordinateX();
            starY = coordinateManager.getCoordinate(starCounter).getCoordinateY();
            System.out.println("Drawing Star X: " + starX + " Star Y: " + starY);


            //increase the star counter
            starCounter++;
            System.out.println("Star counter: " + starCounter);

            //increase the drawNewStarCounter
            drawNewStarCounter++;

            repaint();

            starOnScreen++;
            System.out.println("Star on screen: " + starOnScreen + " Stars in coordinateManager: " + coordId);

        } catch (Exception e) {
            System.out.println("No more stars to draw");
        }


    }


}
