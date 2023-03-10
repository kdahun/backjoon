# include<iostream>
# include<queue>


using namespace std;

int box[100][100][100] = { 0, };


typedef struct tomato {
	int z,y,x;
};

int M = 0;//x
int N = 0;//y
int H = 0;//z

queue<tomato> q;

void bfs() {
	while (!q.empty()) {
		int z = q.front().z;
		int y = q.front().y;
		int x = q.front().x;
		q.pop();
		if (z > 0) {
			if (box[z - 1][y][x] == 0) {
				box[z - 1][y][x] = box[z][y][x] + 1;
				q.push({ z - 1,y,x });
			}
		}
		if (z+1 < H) {
			if (box[z + 1][y][x] == 0) {
				box[z + 1][y][x] = box[z][y][x] + 1;
				q.push({ z + 1,y,x });
			}
		}

		if (y > 0) {
			if (box[z][y-1][x] == 0) {
				box[z][y-1][x] = box[z][y][x] + 1;
				q.push({ z,y-1,x });
			}
		}
		if (y+1 < N) {
			if (box[z][y+1][x] == 0) {
				box[z][y + 1][x] = box[z][y][x] + 1;
				q.push({ z,y + 1,x });
			}
		}
		if (x > 0) {
			if (box[z][y][x - 1] == 0) {
				box[z][y][x - 1] = box[z][y][x] + 1;
				q.push({ z,y,x - 1 });
			}
		}
		if (x+1 < M) {
			if (box[z][y][x + 1] == 0) {
				box[z][y][x + 1] = box[z][y][x] + 1;
				q.push({ z,y,x + 1 });
			}
		}

		
	}
}

int main()
{

	cin >> M >> N >> H;

	for (int i = 0; i < H; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				cin >> box[i][j][k];
				if (box[i][j][k] == 1) {
					q.push({ i, j, k });
				}
			}
		}
	}

	bfs();

	int result = 0;

	for (int i = 0; i < H; i++) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if (box[i][j][k] == 0) {
					cout << "-1";
					return 0;
				}
				if (box[i][j][k]>result) {
					result = box[i][j][k];
				}
			}
		}
	}
	cout << result - 1;
	return 0;
}