package baekjoon;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 통계학_2108 {
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int [] arr=new int[N];
		int [] arr2=new int[N];
		int sum=0;
		for(int i=0;i<N;i++) {
			arr[i]=scan.nextInt();
			sum+=arr[i];
		}
		if(N>1) {
			Arrays.sort(arr);

			//1
			System.out.println(sum/N);
			//2
			System.out.println(arr[(N+1)/2]);
			//3

			int max=0;
			for(int i=0;i<N;i++) {
				int count=0;
				for(int j=i;j<N;j++) {
					if(arr[i]==arr[j]) {
						count++;
					}
				}
				arr2[i]=count;
				if(max<arr2[i]) {
					max=arr2[i];
				}
			}

			int [] arr3=new int[N];
			int count=0;
			for(int i=0;i<N;i++) {
				if(max==arr2[i]) {
					arr3[count]=arr[i];
					count++;
				}
			}
			Arrays.sort(arr3);

			System.out.println(arr3[1]);

			//4
			System.out.println(arr[N-1]-arr[0]);
		}
		else {
			System.out.println(arr[0]);
			System.out.println(arr[0]);
			System.out.println(arr[0]);
			System.out.println("0");
		}
	}
}
