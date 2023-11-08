public class Numbers {
    private int number;
    private int x;
    private int y;
    private static final int n = 4;
    private static final int m = 4;
    private boolean[] moves = new boolean[4];

    /*
     *   allowed moves     up - 0
     *                  right - 1
     *                   down - 2
     *                   left - 3
     */
    public Numbers(int number, int x, int y) {
        this.number = number;
        this.x = x;
        this.y = y;
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
