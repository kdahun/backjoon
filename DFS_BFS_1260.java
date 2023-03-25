package baekjoon;

import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS_BFS_1260 {
	
	public static void main(String args[]) {
		Scanner scan =new Scanner(System.in);
		
		int N=scan.nextInt();
		int M=scan.nextInt();
		int V=scan.nextInt();

		boolean visited_s[]=new boolean [N+1];
		boolean visited_q[]=new boolean [N+1];
		
		LinkedList <Integer> [] arr=new LinkedList[N+1];
		LinkedList <Integer> [] arr2=new LinkedList[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=new LinkedList<Integer>();
			arr2[i]=new LinkedList<Integer>();
		}
		
		
		for(int i=0;i<M;i++) {
			int v1=scan.nextInt();
			int v2=scan.nextInt();
			arr[v1].add(v2);
			arr[v2].add(v1);
			arr2[v1].add(v2);
			arr2[v2].add(v1);
		}
		
		for (int i = 1; i <= N; i++) { 
			Collections.sort(arr2[i]); // 방문 순서를 위해 오름차순 정렬
			Collections.sort(arr[i],Collections.reverseOrder());
		}
		int V2=V;
		Stack<Integer> sta=new Stack<Integer>();
		visited_s[V]=true;
		sta.add(V);
		System.out.print(V+" ");
		while(sta.size()!=0) {
			V=sta.pop();
			if(!visited_s[V]) {
				visited_s[V]=true;
				System.out.print(V+" ");
			}
			Iterator<Integer> iter=arr[V].listIterator();
			while(iter.hasNext()) {
				int w=iter.next();
				if(!visited_s[w]) {
					sta.add(w);
				}
			}
			
		}
		System.out.println();
		
		Queue<Integer> que=new LinkedList<Integer>();
		visited_q[V2]=true;
		que.add(V2);
		System.out.print(V2+" ");
		while(que.size()!=0) {
			V2=que.poll();
			Iterator<Integer> iter=arr2[V2].listIterator();
			while(iter.hasNext()) {
				int w2=iter.next();
				if(!visited_q[w2]) {
					visited_q[w2]=true;
					que.add(w2);
					System.out.print(w2+" ");
				}
			}
		}
	}
}
