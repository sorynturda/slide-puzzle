import java.util.Scanner;
//import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Table a = new Table();
        a.shuffle((int)(Math.random() * 1e3));
        //a.showTable();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        while (!s.equalsIgnoreCase("exit")) {
            while (s.isEmpty() || s.charAt(0) == ' ')
                s = in.nextLine();
            a.move(s.toLowerCase());
            //a.showTable();
            s = in.nextLine();
        }
    }
}
