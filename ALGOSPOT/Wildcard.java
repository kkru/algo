import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Wildcard {

    static String W;
    static int N;
    static String[] list;
    static int[][] cache;

    static char[] wc;
    static char[] fc;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
            W = sc.next();
            N = sc.nextInt();
            wc = W.toCharArray();
            cache = new int[101][101];
            ArrayList<String> answer = new ArrayList<>();
            list = new String[N];
            for(int i=0; i<N; i++){
                list[i] = sc.next();
            }
            for(int i=0; i<N; i++){
                for(int[] arr : cache){
                    Arrays.fill(arr, -1);
                }
                fc = list[i].toCharArray();
                if(match(0,0) == 1)
                    answer.add(list[i]);
            }
            Collections.sort(answer);
            for(String str : answer)
                System.out.println(str);
        }
    }

    public static int match(int w, int s){

        if(cache[w][s] != -1){
            return cache[w][s];
        }
        
        if(w < wc.length && s < fc.length ){
            if(wc[w] == '?' || wc[w] == fc[s]){
                return cache[w][s] = match(w+1, s+1);
            }
        }
        if(w == wc.length)
            return cache[w][s] = (s == fc.length) ? 1 : 0;

        if(wc[w] == '*'){
            if(match(w + 1, s) == 1 ||
            (s < fc.length && match(w, s+1) == 1))
                return cache[w][s] = 1;
        }
        return cache[w][s] = 0;
    }

}