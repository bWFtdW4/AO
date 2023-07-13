import javax.swing.*;
import java.awt.*;

public class StarMakerPlus extends JPanel {

    private CoordinateManager coordinateManager;
    private int starWidth, starHeight, x, y;
    private int starCounter;

    public StarMakerPlus(int x, int y) {
    //public StarMaker() {

        starCounter = 0;
        this.starHeight = 15;
        this.starWidth = 15;
        this.x = x;
        this.y = y;

        System.out.println("-----StarMaker created" + " x: " + x + " y: " + y + "-----");

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);

        g.fillOval(x, y, starWidth, starHeight);
        repaint();

        System.out.println("+++ painting star at x: " + x + " y: " + y + " +++");

    }


}
