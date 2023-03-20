package baekjoon;

import java.util.Scanner;

public class 터렛_1002 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();

		for(int i=0;i<num;i++) {
			int x1=scan.nextInt();
			int y1=scan.nextInt();
			int r1=scan.nextInt();
			int x2=scan.nextInt();
			int y2=scan.nextInt();
			int r2=scan.nextInt();
			if(x1==x2&&y1==y2) {
				if(r1==r2) {
					System.out.println("-1");}
				else {
					System.out.println("0");
				}
			}
			else {
				if((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)<(r1+r2)*(r1+r2)) {
					if((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)<r1*r1) {
						if((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)==(r1-r2)*(r1-r2)) {
							System.out.println("1");
						}
						else if((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)<(r1-r2)*(r1-r2)) {
							System.out.println("0");
						}
						else {
							System.out.println("2");
						}
					}
					else if((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)<r2*r2) {
						if((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)==(r2-r1)*(r2-r1)) {
							System.out.println("1");
						}
						else if((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)<(r2-r1)*(r2-r1)) {
							System.out.println("0");
						}
						else {
							System.out.println("2");
						}
					}
					else {
						System.out.println("2");
					}
				}
				else if((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)==(r1+r2)*(r1+r2)) {
					System.out.println("1");
				}

				else if((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)>(r1+r2)*(r1+r2)) {
					System.out.println("0");
				}

			}
		}
	}
}
