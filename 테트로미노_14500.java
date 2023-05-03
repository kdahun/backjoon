package baekjoon;

import java.util.Scanner;


public class 테트로미노_14500 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int arr_Tetris_X[][]= {{0,1,2,3},{0,0,1,1},{0,0,0,1},{0,1,1,1},{0,0,1,1},{0,0,1,1},{0,1,1,2}};
		int arr_Tetris_Y[][]= {{0,0,0,0},{0,1,0,1},{0,1,2,2},{2,0,1,2},{0,1,1,2},{1,2,0,1},{0,0,1,0}};
		
		int n=scan.nextInt();
		int m=scan.nextInt();
		int arr_num[][]=new int [n][m];
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr_num[i][j]=scan.nextInt();
			}
		}
		
		int max=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int k=0;k<7;k++) {
					int sum1=0;
					int sum2=0;
					int sum3=0;
					int sum4=0;

					for(int l=0;l<4;l++) {
						try {
							sum1+=arr_num[i+arr_Tetris_Y[k][l]][j+arr_Tetris_X[k][l]];
						}catch (Exception e) {
						}
						try {
							sum2+=arr_num[i+arr_Tetris_X[k][l]][j+arr_Tetris_Y[k][l]];
						}catch (Exception e) {
						}
						try {
							sum3+=arr_num[i-arr_Tetris_Y[k][l]][j-arr_Tetris_X[k][l]];
						}catch (Exception e) {
						}
						try {
							sum4+=arr_num[i-arr_Tetris_X[k][l]][j-arr_Tetris_Y[k][l]];
						}catch (Exception e) {
						}
					}
					if(max<sum1)max=sum1;
					if(max<sum2)max=sum2;
					if(max<sum3)max=sum3;
					if(max<sum4)max=sum4;
					
				}
			}
		}
		System.out.print(max);
	}
}
