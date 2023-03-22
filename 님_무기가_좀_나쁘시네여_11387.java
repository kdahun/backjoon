package baekjoon;

import java.util.Scanner;

public class 님_무기가_좀_나쁘시네여_11387 {
	public static double Calculate2(double[] arr) {
		double a=0;
		if(arr[2]>100) {
			arr[2]=100;
		}
		a=arr[0]*(1+arr[1]/100)*((1-arr[2]/100)+arr[2]/100*arr[3]/100)*(1+arr[4]/100);

		return a;
	}
	public static int Calculate(double[] arr1,double[] arr2,double[] arr3) {
		double a=0;
		double c=0;
		int b=0;

		double [] arr4=new double[5];
		double [] arr5=new double[5];
		for(int i=0;i<5;i++) {
			arr4[i]=arr2[i]+arr1[i];
			arr5[i]=arr3[i]+arr1[i];
		}
		a=Calculate2(arr4);
		c=Calculate2(arr5);
		if(a>c) {
			System.out.println("-");
		}else if(a==c) {
			System.out.println("0");

		}else if(a<c) {
			System.out.println("+");
		}
		return b;
	}
	public static void main(String args[]) {

		double[] arr1=new double[5];
		double [] arr2=new double[5];
		double [] arr3=new double[5];
		double [] arr4=new double[5];
		Scanner scan = new Scanner(System.in);


		//1. 무기를 장착한 크리의 수치
		for(int i=0;i<5;i++) {
			arr1[i]=scan.nextInt();
		}
		//2. 무기를 장착한 파부의 수치
		for(int i=0;i<5;i++) {
			arr2[i]=scan.nextInt();
		}
		//3. 크리가 현재 장착하고 있는 무기가 올려주는 수치
		for(int i=0;i<5;i++) {
			arr3[i]=scan.nextInt();
		}
		//4. 파부가 현재 장착하고 있는 무기가 올려주는 수치
		for(int i=0;i<5;i++) {
			arr4[i]=scan.nextInt();
		}
		//공격력, 힘, 치확, 치피, 공속
		for(int i=0;i<5;i++) {
			arr1[i]-=arr3[i];
		}
		for(int i=0;i<5;i++) {
			arr2[i]-=arr4[i];
		}
		int a=0;
		a=Calculate(arr1,arr3,arr4);		
		a=Calculate(arr2,arr4,arr3);
		
	}
}
