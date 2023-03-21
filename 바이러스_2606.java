package baekjoon;

import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList; //import
import java.util.Queue; //import
import java.util.Iterator;
import java.util.Collections;

public class 바이러스_2606 {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		
		int com=scan.nextInt();//정점
		int num=scan.nextInt();//간선
		
		boolean visited[] = new boolean[com+1]; // 방문 여부를 검사할 배열
		
		
		LinkedList<Integer>[] adjList=new LinkedList[com+1];
		
		for (int i = 0; i <= com; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		for(int i=0;i<num;i++) {
			int v1=scan.nextInt();
			int v2=scan.nextInt();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		
		
		for (int i = 1; i <= com; i++) { 
			Collections.sort(adjList[i]); // 방문 순서를 위해 오름차순 정렬 
		}
		int v=1;
		int count=0;
		Queue<Integer> que=new LinkedList<Integer>();
		visited[v]=true;
		que.add(v);
		count++;
		while(que.size()!=0) {
			v=que.poll();
			Iterator<Integer> iter=adjList[v].listIterator();
			while(iter.hasNext()) {
				int w=iter.next();
				if(!visited[w]) {
					visited[w]=true;
					que.add(w);
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
