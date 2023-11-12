import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Numbers {
    private int number;
    private int x;
    private int y;
    private static final int n = 4;
    private static final int m = 4;
    private static final int bounds[] = new int[] {0, 150, 300, 450};
    private static final int size = 150;
    private boolean[] moves = new boolean[4];
    private JButton button;
    /*
     *   allowed moves     up - 0
     *                  right - 1
     *                   down - 2
     *                   left - 3
     */
    public Numbers(int number, int x, int y) {
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
        this.button.setBounds(bounds[y], bounds[x], size, size);
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = (int)(button.getY()/size);
                int y = (int)(button.getX()/size);
                Table.buttonClicked(x, y);
            }
        });
    }

    public String getXY() {
        return "(" + this.x + ", " + this.y + ")";
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

    public void setButton(JButton button) {
        this.button = button;
    }

    public void setButtonText(int number) {
        this.button.setText(String.valueOf(number));
    }

    public void setButtonBounds(int x, int y) {
        this.button.setBounds(bounds[x], bounds[y], size, size);
    }

    public void setButtonBounds(Rectangle v) {
        this.button.setBounds(v);
    }

    public void setButtonText() {
        this.button.setText("");
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getNumber() {
        return this.number;
    }

    public void setMoves() {
        for (int i = 0; i < n; i++)
            moves[i] = true;
        if (this.x == 0)
            this.moves[0] = false;
        if (this.x == n - 1)
            this.moves[2] = false;
        if (this.y == 0)
            this.moves[3] = false;
        if (this.y == m - 1)
            this.moves[1] = false;
    }

    public boolean checkMove(int index) {
        return moves[index];
    }

    public String getMoves() {
        String str = "";
        if (this.moves[0])
            str += "up ";
        if (this.moves[1])
            str += "right ";
        if (this.moves[2])
            str += "down ";
        if (this.moves[3])
            str += "left ";
        return str;
    }
}
