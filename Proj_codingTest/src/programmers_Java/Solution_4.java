// 프로그래머스, [3차] 파일명 정렬
/*
 파일명을 head, number, tail로 나누고 head부터 정렬의 기준으로 삼아
 파일명을 순서대로 정렬하는 문제
 
 - 배운 부분
 새로운 클래스를 만들어 comparator를 만드는 것
 if문을 잘못 설정하면 원하는 값을 얻을 수 없음, 항상 조건은 세밀하고 정확하게
 
 - 실수했던 부분
 1. tail이 아예 없다면 list로 만드는 부분에서 null이 발생하므로 잘못된 결과가 나왔었음
 	이에 따라 만약 index 변화가 없었다면 해당 부분은 "" 를 집어넣는 것으로 수정함
 2. comparator 에서 int 리턴에 실수하여 내림차순으로 나타남
 3. j - idx == 5이나 4라고 작성하는 바람에 number부분이 예상보다 1개 적게 포함되는
 	실수를 하였음 수정 후 문제 풀이 완료하였음  
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

	// List를 String[] 로 바꾸기
	public static String[] toAns(List<String[]> list) {
		String[] arr = new String[list.size()];

		for (int i = 0; i < arr.length; i++) {
			String target =  list.get(i)[0] + list.get(i)[1] + list.get(i)[2];
			arr[i] = target;
		}

		return arr;
	}

	// String[] 을 List로 바꾸기
	public static List<String[]> toList(String[] f) {
		List<String[]> list = new ArrayList<>();

		for (int i = 0; i < f.length; i++) {
			String[] arr = toArr(f[i]);
			list.add(arr);
		}

		return list;
	}

	// String을 head, number, tail로 나눠서 배열에 넣기
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

//comparator 생성
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