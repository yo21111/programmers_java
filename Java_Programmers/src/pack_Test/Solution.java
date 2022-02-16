// 프로그래머스 2단계 : 수식 최대화
/*
 String 형태로 수식을 받았을때 연산자의 우선순위에 따라
 최대 값(절대값일때의)을 구하는 문제
 
 3가지 연산자(*+-)를 사용하기 때문에 3!(6)가지 경우의 수가 나타나므로
 해당 우선순위를 String[] 로 활용하였음
 
 수식을 풀어나가는 과정속에서 LinkedList와 StringBuilder를 사용하였으며
 테스트 코드에서 int를 초과하는 범위가 있었기 때문에 long 타입을 return하도록 하였음
 
 1번째 실수 : solution()의 반복문에서 List를 새로 선언하지 않으므로 재사용하는 문제가 있었음
 List를 반복문 안에 선언함으로써 문제 해결함
 
 2번째 실수 : String[] 에 오타가 있어 정확한 결과가 나오지 않았음 일부 테스트 케이스에서만
 발생하였기에 String[]의 문제로 판단 후 수정하였음
*/

package pack_Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public long solution(String expression) {
		String[] order = { "+-*", "+*-", "*-+", "*+-", "*+-", "*-+" };
		
		List<Long> ansList = new ArrayList<>();
		
		for(int i = 0; i < order.length; i++) {
			List<Object> forCalc = toList(expression);
			for(int j = 0; j < order[i].length(); j++) {
				forCalc = calcProc(Character.valueOf(order[i].charAt(j)), forCalc);
			}
			ansList.add((Long)forCalc.get(0));
		}
		long answer = findBig(ansList);
		return answer;
	}
	
	public static long findBig(List<Long> intList) {
		Long res = 0L;
		
		for (Long i : intList) {
			if (Math.abs(i) > res) {
				res = Math.abs(i);
			}
		}
		
		return res;
	}

	public static List<Object> calcProc(Character mark, List<Object> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == mark) {
				Long res = calc(mark, (Long)list.get(i-1), (Long)list.get(i+1));
				list.remove(i+1);
				list.remove(i);
				list.remove(i-1);
				list.add(i - 1, res);
				i=0;
			}
		}
		return list;
	}

	public static Long calc(Character mark, Long i1, Long i2) {
		Long toReturn = 0L;
		
		switch (mark) {
		case '+':
			toReturn = i1 + i2;
			break;
		case '*':
			toReturn = i1 * i2;
			break;
		case '-':
			toReturn = i1 - i2;
			break;
		}
		
		return toReturn;
	}

	public static List<Object> toList(String e) {
		List<Object> list = new LinkedList<>();
		StringBuilder sb = new StringBuilder(e);

		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '+' || sb.charAt(i) == '*' || sb.charAt(i) == '-') {
				String slice = sb.substring(0, i);
				list.add(Long.parseLong(slice));
				list.add(sb.charAt(i));
				sb.delete(0, i + 1);
				i = -1;
			}
		}

		list.add(Long.parseLong(sb.toString()));

		return list;
	}
}