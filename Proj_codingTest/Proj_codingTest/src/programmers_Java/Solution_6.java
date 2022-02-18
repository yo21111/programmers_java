//���α׷��ӽ�, [3��] ��� �װ�
/*
 -�Ǽ��ߴ� �κ�
 String m�� ���� �Ǻ��� �ش� ���� �ִ��� Ȯ���ϴ� ����
 C#�� ���� #�� �پ �α��ڰ� �Ǵ� ��쿡 ������ ������ �ȵǾ��µ�
 C# �� �ѱ��ڷ� ��ü ġȯ �ϰ� �� ����Ǯ�� �Ϸ���
 
 �ѱ��ڷ� ġȯ ���� ��ü������ #�� ����Ͽ� �ۼ��� �ڵ���� �����Ͽ��� �ߴµ�
 �ϳ� �ΰ� ��ġ�� �κ��� �־��� ������ �ð��� �ణ �ҿ�Ǿ���
 */

package programmers_Java;

import java.util.*;

public class Solution_6 {
    public String solution(String m, String[] musicinfos) {
		m = conversion(m);
		Map<String, String> map = toMap(musicinfos);
		List<String> list = find(map, m);
		String ans = filter(list);
		
		if(ans.equals("(None)")) {
			return "(None)";
		} else {
			return map.get(ans);
		}

	}
	
    //#�� ���� ���̸��� �ѱ��ڷ� ġȯ
	public static String conversion(String t) {
		String[] arr = {"C#", "D#", "F#", "G#", "A#"};
		for (int i = 0; i < arr.length; i++) {
			if(t.contains(arr[i])) {
				String newStr = "" + (char)(arr[i].charAt(0) + 8);
				t=t.replace(arr[i], newStr);
			}
		}
		return t;
	}
	
	// �������� �־��� ���ǿ� �°� ���� �� �� ��ȯ
	public static String filter(List<String> list) {
		String ans = "";
		
		if (list.size() == 0) {
			ans = "(None)";
		} else if(list.size() == 1) {
			ans = list.get(0);
		} else {
			Collections.sort(list, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() > o2.length()) {
						return -1;
					} else if (o1.length() < o2.length()) {
						return 1;
					} else {
						return 0;
					}
				}
			});
			
			ans = list.get(0);
		}
		
		return ans;
	}
	
	// keySet���� �ش� �뷡���� ������ �ִ��� Ȯ��
	public static List<String> find(Map<String, String> map, String m) {
		Set<String> set = map.keySet();
		List<String> list = new ArrayList<>();
		
		Iterator<String> ir = set.iterator();
		while(ir.hasNext()) {
			String str = ir.next();
			if(str.contains(m)) list.add(str);
		}
		return list;
	}
	
	// ������ HashMap���� Ǯ���� ������ ���� �غ� �۾�
	public static Map<String, String> toMap(String[] m) {
		Map<String, String> map = new HashMap<>();
		
		for (int i = 0; i < m.length; i++) {
			String[] arr = m[i].split(",");
			String title = conversion(arr[2]);
			int time = time(arr[0], arr[1]);
			String newM = song(time, conversion(arr[3]));
			map.put(newM, title);
		}
		
		return map;
	}
	
	
	// �뷡�� �ݺ��ǹǷ� ��������� ����� �뷡�� �Ǻ��� ��ȯ
	public static String song(int time, String a) {
		int aLen = a.length();
		int repeatCnt = time / aLen;
		int leftCnt = time % aLen;
		
		String realA = "";
		for(int i = 0; i < repeatCnt; i++) {
			realA += a;
		}
		for (int j = 0; j < leftCnt; j++) {
			realA += a.charAt(j);
		}
		
		return realA;
	}
	
	// �뷡 ���۽ð��� ���ð��� �������� �뷡�� �ð� ���
	public static int time(String s, String e) {
		String[] sArr = s.split(":");
		String[] eArr = e.split(":");
		
		int hour = (Integer.parseInt(eArr[0])-Integer.parseInt(sArr[0]))*60;
		int minute = (Integer.parseInt(eArr[1])-Integer.parseInt(sArr[1]));
		
		int time = hour + minute;
		return time;
	}
}