import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int size = in.nextInt();
        Table a = new Table(n, size);
        Table.sleep(1);
        a.shuffle((int)(Math.random() * 1e3));
    }
}
