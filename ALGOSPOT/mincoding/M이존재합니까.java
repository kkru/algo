package mincoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class M�������մϱ� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean isThereM = false;
		
		for (int i = 0; i < 3; i++) {
			String s = br.readLine();
			if (s.indexOf('M') >= 0) {
				isThereM = true;
				break;
			}
		}
		
		if(isThereM) {
			System.out.println("M�� �����մϴ�");
		}else {
			System.out.println("M�� �������� �ʽ��ϴ�");
		}

	}

}
