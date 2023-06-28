import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        // 리터럴 스트링 비교 (true)
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(4);
        list.add(7);
        int size = list.size();

        System.out.println(list.toString());

        for (int j = 0; j < size / 2; j++) {
            if (list.get(j) != list.get(size - j - 1)) {
                System.out.println("not");
            }
        }

    }
}
