// 프로그래머스, 탐욕법, 큰 수 만들기
/*
 숫자가 앞 인덱스 보다 뒤 인덱스가 먼저 나올 수 없다는 점에 집중하여
 큰 숫자를 찾고 인덱스를 확인하는 메서드를 활용하였음
 index를 재귀적으로 찾을 때 first의 index를 뱉는 바람에 잠깐 멈칫했지만
 중첩 덧셈을 통해 number의 index를 찾을 수 있었음
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