import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui extends JFrame {
    private JFrame window = new JFrame();
    private JButton but[] = new JButton[16];
    public Gui() {
        window.setSize(600, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel( new GridLayout(4, 4));
        window.add(panel, BorderLayout.CENTER);

        // for (int i = 0; i < 15; i++) {
        //     but[i] = new JButton(String.valueOf(i + 1));
        //     but[i].
        //     panel.add(but[i]);
        // }
        // but[15] = new JButton();
        // but[15].setFont(new Font("Comic Sans", Font.BOLD, 72));
        // panel.add(but[15]);
        panel.setLayout(null);
        JButton but = new JButton("asdf");
        but.setFont(new Font("Comic Sans", Font.BOLD, 72));
        but.setBounds(0,0,150,150);
        panel.add(but);
        window.setVisible(true);
        but.setBounds(0,50,150,150);

    }

    public static void main(String args[]) throws Exception {
        new Gui();
    }

}