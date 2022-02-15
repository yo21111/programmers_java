//프로그래머스, [1차] 뉴스 클러스터링
/*
 자카드 유사도를 사용하여 다중집합 간의 유사도를 확인하는 문제
 이전에 풀어보았으나 결국 풀지 못한 문제였음(아래 실수했던 부분-1 이 문제였던 듯)
 
 - 실수했던 부분
 1. 교집합을 찾는 부분에서 매개변수로 받은 list를 그대로 사용하였기 때문에
  	 다른 변수에 담은 list를 사용하고 return한다고 해도 기존에 인수로 넣은 list가 변함을
  	 간과하였음
 2. 교집합이 공집합일때라고 문제를 잘못 읽고 fail이 일어났음 해당 내용 수정 후 풀이완료
 */ 
package pack_Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//자카드 유사도 : 두집합의 교집합 크기 / 두집합 합집합 크기,  공집합일 때는 1
// 대소문자 차이는 무시함, 영문자로된 글자 쌍만 유효함

public class Solution3 {
    public int solution(String str1, String str2) {
		List<String> list1 = toList(str1);
		List<String> list2 = toList(str2);
		
		int size1 = list1.size();
		int size2 = list2.size();
		
		int gyo = findGyo(list1, list2);
		int hap = list1.size()+list2.size();
		// 이미 겹치는 부분 제거함
		
		double chk = 0;
		if(size1 == 0 && size2 ==0) {
			chk = 1;
		}else {
			chk = check(gyo, hap);
		}
		int answer = toAns(chk);
		return answer;
	}
	// 자카드 유사도 확인하기
	public static double check(int gyo, int hap) {
		//자카드 유사도 : 두집합의 교집합 크기 / 두집합 합집합 크기,  공집합일 때는 1
		double chk = gyo==0 ? 0 :(double)gyo/hap;
		return chk;
	}
	
	// 교집합 확인하기
	public static int findGyo(List<String> list1, List<String> list2) {
		List<String> lList = list1.size() >= list2.size() ? list1 : list2;
		List<String> sList = list1.size() < list2.size() ? list1 : list2;
		
		List<String> toReturn = new ArrayList<>();
		
		for (int i = 0; i < sList.size(); i++) {
			String s = sList.get(i);
			if(lList.contains(s)) {
				lList.remove(s);
				toReturn.add(s);
			}
		}
		
		return toReturn.size();
	}
	
    // 다중집합의 원소로 만들기
    public static List<String> toList(String str) {
    	List<String> list = new LinkedList<>();
    	str = str.toLowerCase();
    	
    	for (int i = 0; i < str.length()-1; i++) {
    		String target = "" + str.charAt(i) + str.charAt(i+1);
    		if(isRight(target)) list.add(target);
    	}
    	
    	return list;
    }
    
    // 영문자로된 글자 쌍인지 유효성 검사하기
    public static boolean isRight(String str) {
    	for (int i = 0; i < str.length(); i++) {
    		if (!('a' <= str.charAt(i) && str.charAt(i) <= 'z')) return false;
    	}
    	return true;
    }
    
    // return 방식에 맞게 변환하기
    public static int toAns(double d) {
    	int answer = (int)(d*65536);
    	return answer;
    }
}