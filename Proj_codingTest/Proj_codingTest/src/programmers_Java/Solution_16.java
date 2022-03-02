package programmers_Java;

public class Solution_16 {
	public int solution(String name) {
		int[] arr = toArr(name);
		int answer = sum(arr) + move(arr);
		return answer;
	}

	public static int sum(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}

	public static int[] toArr(String name) {
		int[] arr = new int[name.length()];
		for (int i = 0; i < name.length(); i++) {
			arr[i] = upDownChk(i, name);
		}
		return arr;
	}

	public static int move(int[] arr) {
		int index;
		int move = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {

			index = i + 1;
			// 연속되는 A 갯수 확인
			while (index < arr.length && arr[index] == 0) {
				index++;
			}

			// 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
			move = Math.min(move, i * 2 + arr.length - index);
			// BBBBAAAAAAAB 와 같이, 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려하려면 아래의 코드가 필요합니다.
			move = Math.min(move, (arr.length - index) * 2 + i);
		}
		return move;
	}

	public static int upDownChk(int idx, String name) {
		int order = (int) (name.charAt(idx) - 'A');
		int revOrder = (int) ('Z' - name.charAt(idx) + 1);
		return Math.min(order, revOrder);
	}
}