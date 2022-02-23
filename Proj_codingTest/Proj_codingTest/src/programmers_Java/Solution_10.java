// ���α׷��ӽ�, ���ڿ� ����
/*
 �ݺ��Ǵ� ���ڿ��� Ƚ���� üũ�Ͽ� ��ս� ������ �ϴ� ����
 �Ǽ��ߴ� �κ�
 1. queue���� Ƚ����ŭ �̾Ƴ����� list�� �ִ� �κп���
 	contains�� ���� Ȯ���Ͽ��⿡ �̾����� ���� �ƴ϶�
 	�ߺ� üũ �Ǿ����� �ٷ� ���� list�� ��ҿ� Ȯ���ϴ� ������ ����
 2. �ݺ� Ƚ���� �־��ִ� findLen()���� for���� �������� count�� �߰�������
 	���� ���ϴ� ������ �־��� ������ �κ��� �� count�� 1�� �ƴϸ�
 	String�� ��ø �������ִ� �ڵ� �߰� �ۼ��Ͽ���.
 */
package programmers_Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_10 {
	public int solution(String s) {
		int len = s.length();
		int min = len;
		for (int i = 1; i <= len; i++) {
			int chk = check(s, i);
			if (chk < min)
				min = chk;
		}
		return min;
	}

	public static int check(String s, int t) {
		Queue<String> que = toQueue(s);
		List<String> list = new ArrayList<>();

		while (!que.isEmpty()) {
			String tmp = "";
			for (int i = 0; i < t; i++) {
				if (que.isEmpty()) {
					break;
				} else {
					tmp += que.poll();
				}
			}
			list.add(tmp);
		}
		int len = findLen(list);
		return len;
	}

	public static int findLen(List<String> list) {
		int count = 1;
		String tmp = list.get(0);
		
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i-1).equals(list.get(i))) {
				count++;
			} else {
				if(count == 1) {
					tmp += list.get(i);
				} else {
					tmp += count + list.get(i);
					count = 1;
				}
			}
			
			if(i == list.size()-1) {
				if(count != 1) tmp += count;
			}
		}
		return tmp.length();
	}

	public static Queue<String> toQueue(String s) {
		Queue<String> que = new LinkedList<>();

		for (int i = 0; i < s.length(); i++) {
			que.add(s.charAt(i) + "");
		}

		return que;
	}
}