package baekjoon;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class 미로찾기_2178 {
	
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		int row=scan.nextInt();
		int col=scan.nextInt();

		int arr_num[][]=new int [row][col];

		String arr[]=new String[arr_num.length];

		for(int i=0;i<arr_num.length;i++) {
			arr[i]=scan.next();
			for(int j=0;j<arr_num[i].length;j++) {
				arr_num[i][j]=Integer.parseInt(arr[i].substring(j, j+1));
			}
		}
		
		Queue<Integer> que_y=new LinkedList<Integer>();
		Queue<Integer> que_x=new LinkedList<Integer>();

		arr_num[0][0]++;
		que_y.add(0);//y
		que_x.add(0);//x
		
		while(!que_x.isEmpty()) {
			int y=que_y.poll();
			int x=que_x.poll();
			
			
			if(x>0&&arr_num[y][x-1]==1){
				que_y.add(y);
				que_x.add(x-1);
				arr_num[y][x-1]=arr_num[y][x]+1;
			}
			if(x<col-1 && arr_num[y][x+1]==1) {
				que_y.add(y);
				que_x.add(x+1);
				arr_num[y][x+1]=arr_num[y][x]+1;	
			}
			if(y<row-1 && arr_num[y+1][x]==1) {
				que_y.add(y+1);
				que_x.add(x);
				arr_num[y+1][x]=arr_num[y][x]+1;	
			}

			if(y>0 && arr_num[y-1][x]==1) {
				que_y.add(y-1);
				que_x.add(x);
				arr_num[y-1][x]=arr_num[y][x]+1;	
			}
			
		}

		System.out.print(arr_num[row-1][col-1]-1);
	}
}
