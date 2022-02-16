// ���α׷��ӽ�, [3��] ���ϸ� ����
/*
 ���ϸ��� head, number, tail�� ������ head���� ������ �������� ���
 ���ϸ��� ������� �����ϴ� ����
 
 - ��� �κ�
 ���ο� Ŭ������ ����� comparator�� ����� ��
 if���� �߸� �����ϸ� ���ϴ� ���� ���� �� ����, �׻� ������ �����ϰ� ��Ȯ�ϰ�
 
 - �Ǽ��ߴ� �κ�
 1. tail�� �ƿ� ���ٸ� list�� ����� �κп��� null�� �߻��ϹǷ� �߸��� ����� ���Ծ���
 	�̿� ���� ���� index ��ȭ�� �����ٸ� �ش� �κ��� "" �� ����ִ� ������ ������
 2. comparator ���� int ���Ͽ� �Ǽ��Ͽ� ������������ ��Ÿ��
 3. j - idx == 5�̳� 4��� �ۼ��ϴ� �ٶ��� number�κ��� ���󺸴� 1�� ���� ���ԵǴ�
 	�Ǽ��� �Ͽ��� ���� �� ���� Ǯ�� �Ϸ��Ͽ���  
 */
package programmers_Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_4 {
	public String[] solution(String[] files) {
		List<String[]> list = toList(files);
		FileComparator fc = new FileComparator();
		Collections.sort(list, fc);
		String tmp = "";
		String[] answer = toAns(list);
		return answer;
	}

	// List�� String[] �� �ٲٱ�
	public static String[] toAns(List<String[]> list) {
		String[] arr = new String[list.size()];

		for (int i = 0; i < arr.length; i++) {
			String target =  list.get(i)[0] + list.get(i)[1] + list.get(i)[2];
			arr[i] = target;
		}

		return arr;
	}

	// String[] �� List�� �ٲٱ�
	public static List<String[]> toList(String[] f) {
		List<String[]> list = new ArrayList<>();

		for (int i = 0; i < f.length; i++) {
			String[] arr = toArr(f[i]);
			list.add(arr);
		}

		return list;
	}

	// String�� head, number, tail�� ������ �迭�� �ֱ�
	public static String[] toArr(String str) {
		String[] arr = new String[3];

		int idx1 = 0;
		for (int i = 0; i < str.length(); i++) {
			if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
				idx1 = i;
				break;
			}
		}
		int idx2 = 0;
		for (int j = idx1; j < str.length(); j++) {
			if ( ( j - idx1) == 5 || !('0' <= str.charAt(j) && str.charAt(j) <= '9')) {
				idx2 = j;
				break;
			}
		}
		arr[0] = str.substring(0, idx1);
		if (idx2 == 0) {
			arr[1] = str.substring(idx1);
			arr[2] = "";
		} else {
			arr[1] = str.substring(idx1, idx2);
			arr[2] = str.substring(idx2);
		}

		return arr;
	}
}

//comparator ����
class FileComparator implements Comparator<String[]> {

	@Override
	public int compare(String[] f1, String[] f2) {
		String[] arr = { f1[0].toLowerCase(), f2[0].toLowerCase() };
		Arrays.sort(arr);

		if (f1[0].toLowerCase().equals(f2[0].toLowerCase())) {
			if (Integer.parseInt(f1[1]) > Integer.parseInt(f2[1])) {
				return 1;
			} else if (Integer.parseInt(f1[1]) < Integer.parseInt(f2[1])) {
				return -1;
			} else {
				return 0;
			}
		} else if (arr[0].equals(f1[0].toLowerCase())) {
			return -1;
		} else if (arr[0].equals(f2[0].toLowerCase())) {
			return 1;
		}
		return 0;
	}
}