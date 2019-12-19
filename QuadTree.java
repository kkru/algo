
import java.util.Scanner;

public class QuadTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            String input = sc.next();
            System.out.println(reverse(input));
        }
    }

    public static String reverse(String input) {
        if (input.charAt(0) != 'x')
            return input.substring(0, 1);

        StringBuilder ret = new StringBuilder();
        String xcut = input.substring(1);
        String upLeft = reverse(xcut);
        String upRight = reverse(xcut.substring(upLeft.length()));
        String downLeft = reverse(xcut.substring(upLeft.length()+upRight.length()));
        String downRight = reverse(xcut.substring(upLeft.length()+upRight.length()+downLeft.length()));

        return ret.append("x").append(downLeft).append(downRight).append(upLeft).append(upRight).toString();
    }

}