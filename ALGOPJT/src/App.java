public class App {
    public static void main(String[] args) throws Exception {
        // 리터럴 스트링 비교 (true)
        String s1 = "TEST";
        String s2 = "TEST";
        System.out.println(s1 == s2);

        // 오브젝트 스트링 비교 (false)
        String s3 = new String("test");
        String s4 = new String("test");
        System.out.println(s3 == s4);

    }
}
