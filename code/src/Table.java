import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Thread;

public class Table {
    private static int n;
    private static int size;
    private static final int di[] = new int[] { -1, 0, 1, 0};
    private static final int dj[] = new int[] {0, 1, 0, -1};
    private static Numbers[][] a;
    private static int zeroX;
    private static int zeroY;
    private static final JFrame window = new JFrame("slide puzzle");
    private static JPanel panel;

    public Table(int n, int size) {
        this.n = n;
        this.size = size;
        zeroX = n - 1;
        zeroY = n - 1;
        this.a = new Numbers[n][n];
        window.setSize(n * size, n * size + 30); //30 de pixeli fura bara de sus pe linux
        window.setLocation(0, 0); // location on screen
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(null);
        window.add(panel, BorderLayout.CENTER);
        int number = 1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) {
                    Numbers zero = new Numbers(0, zeroX, zeroY, n, size);
                    zero.setMoves();
                    a[i][j] = zero;
                } else {
                    a[i][j] = new Numbers(number, i, j, n, size);
                    number++;

                }
                panel.add(a[i][j].getButton());
            }
        window.setVisible(true);
    }

    public static void sleep(double time) {
        try {
            Thread.sleep((int)(time * 1000));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void showTable() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j].getNumber() + " ");
            System.out.println();
        }
    }

    public void showPositions() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j].getXY() + " ");
            System.out.println();
        }
    }

    public void showMoves() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                System.out.println(a[i][j].getMoves());
    }

    public void move(String s) {
        int dir = 0;
        if (s.charAt(0) == 'a')
            dir = 1;
        else if (s.charAt(0) == 'w')
            dir = 2;
        else if (s.charAt(0) == 'd')
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

    public static void buttonClicked(int x, int y) {
        int dir = nextToZero(x, y);
        switch (dir) {
        case 0: swap(2);
            break;
        case 1: swap(3);
            break;
        case 2: swap(0);
            break;
        case 3: swap(1);
            break;
        default: break;
        }
        if (a[x][y].getX() == zeroX && a[x][y].getY() == zeroY)
            checkGameOver();
    }

    private static int nextToZero(int x, int y) {
        for (int k = 0; k < 4; k++) {
            int ii = di[k] + x;
            int jj = dj[k] + y;
            if (ii < n && ii >= 0 && jj >= 0 && jj < n && a[ii][jj].getNumber() == 0)
                return k;
        }
        return -1;
    }

    private static void swap(int dir) {
        a[zeroX][zeroY].setMoves();
        int newZeroX = a[di[dir] + zeroX][dj[dir] + zeroY].getX();
        int newZeroY = a[di[dir] + zeroX][dj[dir] + zeroY].getY();
        Rectangle r1 = a[zeroX][zeroY].getButton().getBounds();
        Rectangle r2 = a[newZeroX][newZeroY].getButton().getBounds();
        Numbers zero = a[zeroX][zeroY];
        zero.setXY(newZeroX, newZeroY);
        Numbers nextNumber = a[newZeroX][newZeroY];
        nextNumber.setButtonBounds(r1);
        zero.setButtonBounds(r2);
        nextNumber.setXY(zeroX, zeroY);
        a[newZeroX][newZeroY] = zero;
        a[zeroX][zeroY] = nextNumber;
        setZero(newZeroX, newZeroY);
        a[zeroX][zeroY].setMoves();
    }

    public static void checkGameOver() {
        int number = 0;
        boolean gameOver = true;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                number++;
                int nmbr = a[i][j].getNumber();
                if (nmbr != 0 && nmbr != number)
                    gameOver = false;
            }
        if (gameOver)
            JOptionPane.showMessageDialog(null, "Puzzle Solved!", "", JOptionPane.INFORMATION_MESSAGE);
    }

    public int getN() {
        return n;
    }

    public void shuffle(int t) {
        for (int i = 0; i < t; i++) {
            int dir = (int) (Math.random() * 10) % 4;
            while (a[zeroX][zeroY].checkMove(dir) == false) {
                dir = (int) (Math.random() * 10) % 4;
            }
            sleep(0.003);
            swap(dir);
        }
    }
}
