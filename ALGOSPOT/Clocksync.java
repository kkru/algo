import java.util.Scanner;

public class Clocksync {

    static int INF = 9999, SWITCHES = 10, CLOCKS = 16;
    static String[] linked = {
        "xxx.............",
        "...x...x.x.x....",
        "....x.....x...xx",
        "x...xxxx........",
        "......xxx.x.x...",
        "x.x...........xx",
        "...x..........xx",
        "....xx.x......xx",
        ".xxxxx..........",
        "...xxx...x...x.."
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            int[] list = new int[16];
            for(int i=0; i<CLOCKS; i++){
                list[i] = sc.nextInt();
            }
            int answer = solve(list, 0);
            if(answer == INF)
                answer = -1;
            System.out.println(answer);
        }
    }

    static boolean areAligned(int[] list){
        boolean ok = true;

        for(int i=0; i<CLOCKS; i++){
            if(list[i] != 12){
                ok = false;
                break;
            }
        }

        return ok;
    }

    static void push(int[] list, int swtch){
        for(int clock = 0; clock < CLOCKS; clock++){
            if(linked[swtch].charAt(clock) == 'x'){
                list[clock] += 3;
                if(list[clock] == 15) list[clock] = 3;
            }
        }
    }

    static int solve(int[] list, int swtch){
        if(swtch == SWITCHES)
            return areAligned(list) ? 0 : INF;
        int ret = INF;
        for(int cnt = 0; cnt < 4; cnt++){
            ret = Math.min(ret, cnt + solve(list, swtch+1));
            push(list, swtch);
        }
        return ret;
    }

}