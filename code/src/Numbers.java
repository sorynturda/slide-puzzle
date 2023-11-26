import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Numbers {
    private final int number;
    private int x;
    private int y;
    private static int n;
    private final boolean[] moves = new boolean[4];
    private final JButton button;

    /*
     *   allowed moves     up - 0
     *                  right - 1
     *                   down - 2
     *                   left - 3
     */
    public Numbers(int number, int x, int y, int n, int size) {
        Numbers.n = n;
        /*
         * x - line or y axis!!!!!!!
         * y - column or x axis!!!!!
         */
        this.number = number;
        this.x = x;
        this.y = y;
        if (number != 0)
            this.button = new JButton(String.valueOf(number));
        else
            this.button = new JButton();
        this.button.setFont(new Font("Comic Sans", Font.BOLD, 72));
        this.button.setBounds(y * size, x * size, size, size);
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = (int) (button.getY() / size);
                int y = (int) (button.getX() / size);
                Table.buttonClicked(x, y);
            }
        });
    }


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public JButton getButton() {
        return this.button;
    }

    public void setButtonBounds(Rectangle v) {
        this.button.setBounds(v);
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getNumber() {
        return this.number;
    }

    public void setMoves() {
        for (int i = 0; i < 4; i++)
            moves[i] = true;
        if (this.x == 0)
            this.moves[0] = false;
        if (this.x == n - 1)
            this.moves[2] = false;
        if (this.y == 0)
            this.moves[3] = false;
        if (this.y == n - 1)
            this.moves[1] = false;
    }

    public boolean checkMove(int index) {
        return moves[index];
    }
}