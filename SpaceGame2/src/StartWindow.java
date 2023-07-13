import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class StartWindow extends JFrame implements ActionListener {

    private int width, height;
    private JButton startGame, startMusic;

    private boolean gameStarted;
    public StartWindow() {
        super("Space Game 2");
        width = 600;
        height = 400;
        setSize(width, height);

        // Set the window to not be resizable
        setResizable(false);

        // Set the layout of the window to BorderLayout
        setLayout(new BorderLayout());

        // Set the window to be visible
        setVisible(true);

        // Set the window to close when the user clicks the X
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a panel for the center of the window
        setLocationRelativeTo(null);

        /*
        // Set the location of the window to the center of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width/2 - width/2, screenSize.height/2 - height/2);
        */

        // Create a panel for the north side of the window
        JPanel panelNorth = new JPanel();

        // Set the layout of the panel to FlowLayout
        panelNorth.setLayout(new FlowLayout());

        // Set the background color of the panel
        panelNorth.setBackground(Color.black);

        // Create a button for Start Game
        startGame = new JButton();
        startGame.setText("New Game");

        // Set the button to not be painted
        startGame.setBorderPainted(false);

        // Set the background color of the button
        startGame.setBackground(new Color(255, 182, 193));

        // Set opaque to true so the background color is visible
        startGame.setOpaque(true);


        // Create a button for Start Music
        startMusic = new JButton();
        startMusic.setText("Start Music");
        startMusic.setBorderPainted(false);

        // Add the buttons to the panel
        panelNorth.add(startGame);
        panelNorth.add(startMusic);

        // Add the panel to the window
        add(panelNorth, BorderLayout.NORTH);

        // Create JTextArea for game manual
        JTextArea gameManual = new JTextArea();

        //Add gameManual to the center of the window
        add(gameManual, BorderLayout.CENTER);

        // Set the background and foreground color of gameManual
        gameManual.setBackground(Color.black);
        gameManual.setForeground(Color.white);

        // Set the margin of gameManual
        gameManual.setMargin(new Insets(30, 30, 30, 30));

        // Set the font of gameManual
        gameManual.setFont(new Font("Arial", Font.ITALIC, 20));

        // Set the text of gameManual
        gameManual.setText("Der Weltraum, unendliche Weiten \r\n" +
                "wir schreiben das Jahr 2200\r\n" +
                "Dies sind die Abenteuer\r\n" +
                "des Raumschiffs Enterprise");



        gameStarted = false;

        startGame.addActionListener(this);
        startMusic.addActionListener(this);




    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startGame) {
            if (!gameStarted ){
                System.out.println("startGame clicked...");
                //add a new SpaceWindow + give it the image
                try {
                    new SpaceWindow(ImageIO.read(new File("spaceshipR.png")));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                gameStarted = true;
                //startGame.setText("Stop Game");

            }else {
                //TODO: stop the game
                //System.out.println("stopGame clicked...");
                gameStarted = false;
            }
        }
    }
}
