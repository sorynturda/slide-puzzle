import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Table extends JFrame {
    private static final int n = 4;
    private static final int m = 4;
    private static final int di[] = new int[] { -1, 0, 1, 0};
    private static final int dj[] = new int[] {0, 1, 0, -1};
    private static Numbers[][] a = new Numbers[n][m];
    private static int zeroX = n - 1;
    private static int zeroY = m - 1;
    private static final JFrame window = new JFrame();
    private JPanel panel;
    public Table() {
        window.setSize(600, 630);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new GridLayout(n, m));
        window.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        int number = 1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (i == n - 1 && j == m - 1) {
                    Numbers zero = new Numbers(0, zeroX, zeroY);
                    zero.setMoves();
                    a[i][j] = zero;
                } else {
                    a[i][j] = new Numbers(number, i, j);
                    number++;

                }
                panel.add(a[i][j].getButton());
            }
        window.setVisible(true);
    }

    public void showTable() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(a[i][j].getNumber() + " ");
            System.out.println();
        }
    }

    public void showPositions() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(a[i][j].getXY() + " ");
            System.out.println();
        }
    }

    public void showMoves() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                System.out.println(a[i][j].getMoves());
    }

    public void move(String s) {
        int dir = 0;
        if (s.charAt(0) == 'd')
            dir = 1;
        else if (s.charAt(0) == 's')
            dir = 2;
        else if (s.charAt(0) == 'a')
            dir = 3;
        if (a[zeroX][zeroY].checkMove(dir))
            swap(dir);
        else
            System.out.println("MISCARE NEPERMISA");
    }

    private static void setZero(int x, int y) {
        zeroX = x;
        zeroY = y;
    }

    private void swap(int dir) {
        a[zeroX][zeroY].setMoves();
        int newZeroX = a[di[dir] + zeroX][dj[dir] + zeroY].getX();
        int newZeroY = a[di[dir] + zeroX][dj[dir] + zeroY].getY();
        Numbers zero = a[zeroX][zeroY];
        zero.setXY(newZeroX, newZeroY);
        Numbers nextNumber = a[newZeroX][newZeroY];
        nextNumber.setXY(zeroX, zeroY);
        a[newZeroX][newZeroY] = zero;
        a[zeroX][zeroY] = nextNumber;
        setZero(newZeroX, newZeroY);
        a[zeroX][zeroY].setButtonBounds(zeroX,zeroY);
        // System.out.println(zeroX + " " + zeroY);
        a[zeroX][zeroY].setMoves();
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public void shuffle(int t) {
        for (int i = 0; i < t; i++) {
            int dir = (int) (Math.random() * 10) % 4;
            if (a[zeroX][zeroY].checkMove(dir))
                swap(dir);
        }
    }
}
