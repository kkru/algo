package Algorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HashTable {

	static final int HASH_SIZE = 1000;
	static final int HASH_LEN = 400;
	static final int HASH_VAL = 17;

	static int[][] data;
	static int[] length;
	static String[][] s_data;

	static String str;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		data = new int[HASH_SIZE][HASH_LEN];
		s_data = new String[HASH_SIZE][HASH_LEN];
		length = new int[HASH_SIZE];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			str = br.readLine();
			
			//�ؽ� ���� ��´�
			int key = getHashKey(str);
			
			//�ش� ���� �־��� üũ, ������ -1, ������ ���� ���Դ� Ƚ��
			int cnt = checking(key);
			
			// �ߺ� key�� ����
			if(cnt != -1 ) {
				sb.append(str).append(cnt).append("\n");
			}
			//�ߺ� key�� ����
			else sb.append("OK").append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}

	public static int getHashKey(String str) {
		int key = 0;

		for (int i = 0; i < str.length(); i++) {
			key = (key * HASH_VAL) + str.charAt(i);
		}

		if (key < 0)
			key = -key;

		return key % HASH_SIZE;
	}

	public static int checking(int key) {

		int len = length[key];

		if (len != 0) {
			for (int i = 0; i < len; i++) {
				if (str.equals(s_data[key][i])) {
					data[key][i]++;
					return data[key][i];
				}
			}
		}

		s_data[key][length[key]++] = str;

		return -1;

	}

}
