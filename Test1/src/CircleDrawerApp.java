import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CircleDrawerApp extends JFrame {

    private List<Point> circles;
    private Random random;

    public CircleDrawerApp() {
        circles = new ArrayList<>();
        random = new Random();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Circle Drawer");

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Point point : circles) {
                    int x = point.x;
                    int y = point.y;
                    g.drawOval(x - 25, y - 25, 50, 50);
                }
            }
        };

        drawingPanel.setPreferredSize(new Dimension(400, 400));

        drawingPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int x = evt.getX();
                int y = evt.getY();
                circles.add(new Point(x, y));
                drawingPanel.repaint();
            }
        });

        JButton drawButton = new JButton("Draw Circle");
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = random.nextInt(drawingPanel.getWidth());
                int y = random.nextInt(drawingPanel.getHeight());
                circles.add(new Point(x, y));
                drawingPanel.repaint();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(drawButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(drawingPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setSize(400, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CircleDrawerApp().setVisible(true);
            }
        });
    }
}
