// ���α׷��ӽ�, Ž���, ū �� �����
/*
 ���ڰ� �� �ε��� ���� �� �ε����� ���� ���� �� ���ٴ� ���� �����Ͽ�
 ū ���ڸ� ã�� �ε����� Ȯ���ϴ� �޼��带 Ȱ���Ͽ���
 index�� ��������� ã�� �� first�� index�� ��� �ٶ��� ��� ��ĩ������
 ��ø ������ ���� number�� index�� ã�� �� �־���
 */

package programmers;

public class Solution_3 {
    public String solution(String number, int k) {
		String answer = "";
		int len = number.length()-k;
		int tmp = 1;
		
		String first = number.substring(0, number.length()-(len-tmp));
		answer += first.charAt(findBig(first));
		
		int index = 0;
		
		while (len - tmp > 0) {
			tmp++;
			index += (findBig(first)+1);
			first = number.substring(index, number.length()-(len-tmp));
			answer += first.charAt(findBig(first));
		}
		return answer;
    }
	
	
	public static int findBig(String str) {
		int max = 0;
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if ((int)str.charAt(i) > max) {
				max = (int)str.charAt(i);
				index = i;
			}
		}
		
		
		return index;
	}
}