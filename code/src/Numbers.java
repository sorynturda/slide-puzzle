public class Numbers {
    private short number;
    private short x;
    private short y;

    //allowed moves
    public Numbers(short number, short x, short y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public String getXY() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public void setXY(short x, short y){
        this.x = x;
        this.y = y;
    }

    public short getNumber(){
        return this.number;
    }

}
