import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class CircleDrawerApp extends JFrame {

    private List<Point> circles;

    public CircleDrawerApp() {
        circles = new ArrayList<>();
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

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                circles.add(e.getPoint());
                drawingPanel.repaint();
            }
        });

        JButton drawButton = new JButton("Draw Circle");
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                circles.add(new Point(50, 50));
                drawingPanel.repaint();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(drawButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(drawingPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }


}
