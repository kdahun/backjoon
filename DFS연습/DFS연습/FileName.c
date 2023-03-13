# include<stdio.h>
# include<stdlib.h>

#define TRUE 1
#define FALSE 0
#define MAX_VERTICES 50

typedef struct GraphType {
	int n; // 정점의 개수
	int adj_mat[MAX_VERTICES][MAX_VERTICES];
}GraphType;

int visited[MAX_VERTICES];//정점에 왔었는지 확인

void init(GraphType* g) {
	int r, c;

	g->n = 0;//간선 초기화
	for (r = 0; r < MAX_VERTICES; r++) {
		for (c = 0; c < MAX_VERTICES; c++) {
			g->adj_mat[r][c] = 0;
		}
	}
}

void insert_vertex(GraphType* g, int v) {//정점 삽입 연산
	if (((g->n) + 1) > MAX_VERTICES) {//정점의 개수가 50개가 넘었는지 체크 만약 넘었으면 오류 메시지 출력
		fprintf(stderr, "그래프: 정점의 개수 초과");
		return 0;
	}
	g -> n++;
}

void insert_edge(GraphType* g, int start, int end) {// 간선 삽입 연산
	
	g->adj_mat[start][end] = 1;//간선 연결
	g->adj_mat[end][start] = 1;
}

void dfs_mat(GraphType* g, int v) {
	int w;
	visited[v] = TRUE;//정점 v의 방문 표시
	printf("정점 % d ->", v);
	for (w = 0; w < g->n; w++)
		if (g->adj_mat[v][w] && !visited[w])//2차원 배열이 1이고 방문 안했을때;
			dfs_mat(g, w);
}

int main(void)
{
	GraphType* g;
	g = (GraphType*)malloc(sizeof(GraphType));
	init(g);

	for (int i = 0; i < 4; i++)
		insert_vertex(g, i);
	insert_edge(g, 0, 1);
	insert_edge(g, 0, 2);
	insert_edge(g, 0, 3);
	insert_edge(g, 1, 2);
	insert_edge(g, 2, 3);

	printf("깊이 우선 탐색\n");
	dfs_mat(g, 0);
	free(g);
	return 0;
}
