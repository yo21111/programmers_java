package programmers_Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_8 {
    public boolean solution(String[] phone_book) {
		List<Integer> list = toList(phone_book);
		System.out.println(list);
		for(int i = 0; i < list.size(); i++) {
			boolean chk = check(phone_book, list.get(i));
			if(!chk) return false;
		}
		return true;
	}
	
	public static boolean check(String[] p, int t) {
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		
		int count = 0;
		
		for(int i = 0; i < p.length; i++) {
			if(p[i].length() < t) {
				continue;
			} else {
				if(set.contains(p[i].substring(0,t))) {
					list.add(p[i].substring(0,t));
				}
				set.add(p[i].substring(0, t));
				count++;
			}
		}

		if(set.size() == count) {
			return true;
		} else {
			for(String str : p) {
				for(String s : list) {
					if(s.equals(str)) return false;
				}
			}
			return true;
		}
	}
	
	public static List<Integer> toList(String[] p) {
		Set<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < p.length; i++) {
			set.add(p[i].length());
		}
		
		for(Integer i : set) {
			list.add(i);
		}
		
		Collections.sort(list);
		
		return list;
	}
}