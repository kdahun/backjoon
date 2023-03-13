#include<stdio.h>
#include<stdlib.h>

#define TRUE 1
#define FALSE 0
#define MAX_QUEUE_SIZE 10

typedef int element;

typedef struct { //큐 구조체
	element queue[MAX_QUEUE_SIZE]; //데이터 저장
	int front, rear; //head?
}QueueType;

void queue_init(QueueType* q) {//큐 초기화
	q->front = q->rear = 0;
}

int is_empty(QueueType* q) {
	return (q->front == q->rear);
}

int is_full(QueueType* q) {//포화 상태 검출 함수(삽입 시)
	return((q->rear + 1) % MAX_QUEUE_SIZE == q->front);
}

void enqueue(QueueType *q,element item) {//삽입함수	
	q->rear = (q->rear + 1) % MAX_QUEUE_SIZE;
	q->queue[q->rear] = item;
}

element dequeue(QueueType* q) {//삭제 함수
	q->front = (q->front + 1) % MAX_QUEUE_SIZE;
	return q->queue[q->front];
}

#define MAX_VERTICES 50

typedef struct GreaphType {
	int n;// 정점의 개수
	int adj_mat[MAX_VERTICES][MAX_VERTICES];
}GraphType;

int visited[MAX_VERTICES];

void graph_init(GraphType* g)//그래프 초기화 작업
{
	int r, c;
	g->n=0;
	for (r = 0; r < MAX_VERTICES; r++) {
		for (c = 0; c < MAX_VERTICES; c++)
			g->adj_mat[r][c] = 0;
	}
}

void  insert_vertex(GraphType* g, int v) {// 정점 삽입 연산
	if (((g->n) + 1) > MAX_VERTICES) {
		fprintf(stderr, "그래프 : 점점의 개수 초과");
		return;
	}
	g->n++;
}

void insert_edge(GraphType* g, int start, int end) {
	if (start >= g->n || end >= g->n) {
		fprintf(stderr, "그래프 : 정점 번호 오류");
		return;
	}
	g->adj_mat[start][end] = 1;
	g->adj_mat[end][start] = 1;
}

void bfs_mat(GraphType* g, int v) {
	int w;
	QueueType q;

	queue_init(&q);// 큐 초기화
	visited[v] = TRUE;//정점 v 방문 표시
	printf("%d방문 ->", v);
	enqueue(&q, v);// 큐에 삽입
	while (!is_empty(&q)) {
		v = dequeue(&q);
		for (w = 0; w < g->n; w++) {
			if (g->adj_mat[v][w] && !visited[w]) {
				visited[w] = TRUE;
				printf("%d 방문 -> ", w);
				enqueue(&q, w);
			}
		}
	}
}

void bfs_list(GraphType* g, int v) {
	
}

int main(void) {
	GraphType* g;
	g = (GraphType*)malloc(sizeof(GraphType));
	graph_init(g);
	for (int i = 0; i < 6; i++)
		insert_vertex(g, i);
	insert_edge(g, 0, 2);
	insert_edge(g, 2, 1);
	insert_edge(g, 2, 3);
	insert_edge(g, 0, 4);
	insert_edge(g, 4, 5);
	insert_edge(g, 1, 5);

	printf("너비 우선 탐색\n");
	bfs_mat(g, 0);
	free(g);
	return 0;
}