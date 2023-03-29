package baekjoon;

import java.util.*;

public class 호텔2_1106 {
	public static void main(String args[]) {
		Scanner scan= new Scanner(System.in);
		int Client=scan.nextInt();
		int City=scan.nextInt();
		int Client_arr[]= new int [City+1];
		int Cost_arr[]=new int [City+1];
		
		int dp[]=new int [Client+101];
		for(int i=1;i<City+1;i++) {
			Cost_arr[i]=scan.nextInt();
			Client_arr[i]=scan.nextInt();
		}
		Arrays.fill(dp, 10000000);

		dp[0]=0;
		for(int i=1;i<City+1;i++) {
			for(int j=1;j<Client+100;j++) {
				
				if(j>=Client_arr[i]) {
					
					if(dp[j-Client_arr[i]]+Cost_arr[i]<dp[j]) dp[j]=dp[j-Client_arr[i]]+Cost_arr[i];
						
					
					
				}
				
			}
		}
		
		int min=1000000000;
		for(int j=Client;j<Client+100;j++) {
			if(min>dp[j]) min=dp[j];
		}
		System.out.print(min);
	}
}
