package baekjoon;

import java.util.Scanner;

public class 평범한배낭_12865 {
	public static void main(String [] args) {
		Scanner scan=new Scanner(System.in);

		int k=scan.nextInt();
		int n=scan.nextInt();
		int wi[]=new int [n+1];
		int vi[]=new int [n+1];
		int dp[][]=new int [n+1][k*100];

		for(int i=1;i<=n;i++) {
			wi[i]=scan.nextInt();
			vi[i]=scan.nextInt();
		}

		for(int i=1;i<=n;i++) {
			for(int j=1;j<dp[i].length;j++) {
				if(wi[i]>j)dp[i][j]=dp[i-1][j];
				else {
					if(dp[i-1][j]>(dp[i-1][j-wi[i]]+vi[i])) dp[i][j]=dp[i-1][j];
					else if(dp[i-1][j]<=dp[i][j-wi[i]]+vi[i]) dp[i][j]=dp[i][j-wi[i]]+vi[i];
					else if(dp[i-1][j]>dp[i][j-wi[i]]+vi[i]) dp[i][j]=dp[i-1][j];
					else dp[i][j]=(dp[i-1][j-wi[i]]+vi[i]);
				}

			}
		}
		if(k==0) {
			System.out.print("0");
		}
			
		else {
			for(int i=1;i<dp[n].length;i++) {
				if(dp[n][i]>=k) {
					System.out.print(i);
					break;
				}
			}
			
		}
	}
}
