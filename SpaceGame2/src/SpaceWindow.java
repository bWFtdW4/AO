import javax.swing.*;
import java.awt.*;

public class SpaceWindow extends JFrame {
    private int width = 800, height = 800;
    public SpaceWindow(Image spaceshipImage) {
        super("I believe...");
        setSize(width, height);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        /*
        getInsets() Insets represent the additional space or
        padding around the content of a component or window,
        such as the title bar, borders, or margins.
         */
        int titleHeight = getInsets().top;
        int borderRight = getInsets().right;
        int borderLeft = getInsets().left;
        int borderBottom = getInsets().bottom;

        //add SpaceGame to the JFrame
        //add(new SpaceGame(spaceshipImage, width - borderLeft - borderRight,
        //        height - titleHeight - borderBottom));

        //add SpaceGame to the JFrame
        add(new GameVersion1c(spaceshipImage, width - borderLeft - borderRight,
                height - titleHeight - borderBottom));



    }
}
