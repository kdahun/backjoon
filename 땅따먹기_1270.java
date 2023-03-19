package baekjoon;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 땅따먹기_1270 {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		Map<Integer, Integer> map1 = new HashMap<>();
		
		int num=scan.nextInt();//몇번 반복할껀지
		
		
		for(int i=0;i<num;i++) {
			int max=0;
			int max_index=0;
			int s_num=scan.nextInt();
			
			
			for(int j=0;j<s_num;j++) {
				int Ti=scan.nextInt();
				if(!map1.containsKey(Ti)) {
					map1.put(Ti,1);
				}
				else {
					int change=0;
					change=map1.get(Ti)+1;
					map1.put(Ti, change);
					if(max<change) {
						max=change;//빈도
						max_index=Ti;//key값
					}
				}
			}
			int sw=0;
			
			Set<Integer> keySet = map1.keySet();
			for (Integer key : keySet) {
	            if(!key.equals(max_index) && map1.get(key).equals(max)) {
	            	System.out.println("SYJKGW");
	            	sw=1;

	    			map1.clear();
	            	break;
	            }
	        }
			
			if(sw==0) {
				if(s_num/2<max) {
					System.out.println(max_index);
				}
				else {
					System.out.println("SYJKGW");
				}
			}

			map1.clear();
		}
	}
}
