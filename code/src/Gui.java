import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame {
    private JFrame window = new JFrame();
    private JButton but[] = new JButton[16];

    public Gui() {
        window.setSize(600, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel( new GridLayout(4, 4) );
        window.add(panel, BorderLayout.CENTER);

        for (int i = 0; i < 15; i++) {
            but[i] = new JButton(String.valueOf(i + 1));
            but[i].setFont(new Font("Comic Sans", Font.BOLD, 60));
            panel.add(but[i]);
        }
        but[15] = new JButton();
        but[15].setFont(new Font("Comic Sans", Font.BOLD, 60));
        panel.add(but[15]);
        window.setVisible(true);

    }

    public static void main(String args[]) throws Exception {
        new Gui();
    }

}