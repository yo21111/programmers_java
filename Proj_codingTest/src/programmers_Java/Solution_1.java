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

package programmers_Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> que = new LinkedList<>();
		for (int i = 0; i < bridge_length; i++) {
			que.add(0);
		}
		
		List<Integer> list = new ArrayList<>();
		int order = 0;
		int truck = 0;
		
		while (!que.isEmpty()) {
			if (order < truck_weights.length) {
				truck = truck_weights[order];
			}
			
			int bye = que.poll();
			weight += bye;
			list.add(bye);
			
			if (order < truck_weights.length && weight >= truck) {
				weight -= truck;
				que.add(truck);
				order++;
			} else if (order < truck_weights.length && weight < truck) {
				que.add(0);
			}
			
		}
		
		return list.size();
	}
}