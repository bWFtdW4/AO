import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GameVersion5 extends JPanel implements ActionListener {


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

    public GameVersion5(Image i, int w, int h) {

        spaceWidth = w;
        spaceHeight = h;
        spaceShip = i;
        shipX = 30;
        shipY = 30;
        setBackground(Color.black);

        //Set focus to the panel
        requestFocusInWindow();
        // Set panel to be focusable rather than the JFrame
        setFocusable(true);

        //game settings
        drawNewStarCounter = 1;
        gameOverCondition = 10;

        // Start the timer
        timer.start();
        fly();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the spaceship with the image, x, y, width, and height
        g.drawImage(spaceShip, shipX, shipY, shipWidth, shipHeight, this);

        //draw the points and stars
        g.setColor(Color.white);
        g.drawString("Points: " + playerPoints, 10, 20);
        g.drawString("Stars: " + starCounter, 100, 20);

    }

    private void drawAStar(Graphics g) {
        System.out.println("drawAStar() called");

        Random randomCoords = new Random();
        this.starX = randomCoords.nextInt(spaceWidth - starWidth);
        this.starY = randomCoords.nextInt(spaceHeight - starHeight);
        System.out.println("starX: " + starX + " starY: " + starY);

        g.setColor(starColor);
        g.fillOval(starX, starY, starWidth, starHeight);

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
                    //one key press p
                    case KeyEvent.VK_P:
                        System.out.println("p pressed");
                        drawAStar(getGraphics());
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

        repaint();
    }



}
