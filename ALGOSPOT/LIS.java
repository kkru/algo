import java.util.Scanner;

public class LIS {
	
	static int N;
	static int[] list;
	static int[] cache;
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        while (cases-- > 0) {
        	N = sc.nextInt();
        	list = new int[N];
        	cache = new int[N+1];
        	cache[N] = -1;
        	
        	int answer = 0;
        	
        	for(int i=0; i<N; i++) {
        		list[i] = sc.nextInt();
        		cache[i] = -1;
        	}
        	answer = getLIS(-1)-1;
        	System.out.println(answer);
        	
        }
    }
    
    public static int getLIS(int start) {
    	if(cache[start+1] != -1)
    		return cache[start+1];
    	cache[start+1] = 1;
    	
    	for(int next = start+1 ; next < N; next++) {
    		if(start == -1 || list[start] < list[next])
    			cache[start+1] = Math.max(cache[start+1], getLIS(next)+1);
    	}
    	
    	return cache[start+1];
    }
}