package programmers;


public class Test {
	public static void main(String[] args) {
		String number = "4177252841";
		int k= 4;
		
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
		System.out.println(answer);
	}
	
	
	public static int findBig(String str) {
		int max = 0;
		int index = 0;
		int[] arr = new int[2];
		for (int i = 0; i < str.length(); i++) {
			if ((int)str.charAt(i) > max) {
				max = (int)str.charAt(i);
				index = i;
			}
		}
		
		
		return index;
	}
}