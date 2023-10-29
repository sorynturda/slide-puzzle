public class Table {
    private static short n = 4;
    private static short m = 4;
    private static Numbers[][] a = new Numbers[n][m];
    private static Numbers zero = new Numbers((short) 0, (short) 3, (short) 3);

    public Table() {
        short number = 1;
        for (short i = 0; i < n; i++)
            for (short j = 0; j < m; j++) {
                if (i == n -1 && j == m - 1)
                    a[i][j] = zero;
                else {
                    a[i][j] = new Numbers(number, i, j);
                    number++;
                }
            }

    }

    public void showTable() {
        for (short i = 0; i < n; i++) {
            for (short j = 0; j < m; j++)
                System.out.print(a[i][j].getNumber() + " ");
            System.out.println();
        }
    }
    public void showPositions(){
        for (short i = 0; i < n; i++) {
            for (short j = 0; j < m; j++)
                System.out.print(a[i][j].getXY() + " ");
            System.out.println();
        }
    }
    public short getN(){
        return this.n;
    }
    public short getM(){
        return this.m;
    }
}
