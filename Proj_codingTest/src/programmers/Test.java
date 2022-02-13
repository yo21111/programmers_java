// ���α׷��ӽ�, ����/ť, �ٸ��� ������ Ʈ��
/*
 ���������� �ִ� �ٸ��� ������ ������� ��� �Ǵ��� �ð��� ����ϴ� ����
 �������� ������ ���԰� �� ������ ������ que�� �ø��� ���� ������ 
 ������ ����Ͽ� ���԰� ���ɶ����� 0�� �ִ� ����� ���ʿ� �����Ͽ�����
 0�� ���� ��� �־������ ����� �Ǿ� Ǯ�� ���߾��� ����
 
 �ð��� ����ϴ� ��ſ� ��ȯ���� �ѹ� �ݺ��� �� push�� poll�� ���� �ѹ�
 ����ǵ��� �ϰ��Ͽ� �ð��� �����Ӱ� ���� ������ ������ �ڵ带 �ۼ��Ͽ���
 
 order++ �ӿ��� truck_weights[order]�� ���� �ۼ��Ͽ� 
 ArrayIndexOutOfBounds ���ܰ� �߻��Ͽ����� if������ ���� ����� �־ ó����
 
 que ���� �������� �ش� ���̰� �Ǹ� poll �ϴ� ������ ����Ͽ����µ�
 ��ȯ�� �ѹ��� push�� pop ���� �ѹ� ����ǵ��� �ϴ� ���� ��ü���� �ƶ���
 �̲���� �� ���� ������ ���� ������.
 */
package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		int[] arr = toMap(clothes);
		int answer = 1;
		for (int i : arr) {
			answer *= i;
		}
		
		answer -= 1;
	}
	public static int[] toMap(String[][] c) {
		Map<String, Integer> map = new HashMap<>();
		
		for (int  i = 0; i < c.length; i++) {
			if(map.containsKey(c[i][1])) {
				map.put(c[i][1], map.get(c[i][1])+1);
			} else {
				map.put(c[i][1], 1);
			}
		}
		
		int[] arr = new int[map.size()];
		int idx = 0;
		for(int i : map.values()) {
			arr[idx] = i+1;
			idx++;
		}
		
		return arr;
	}
}