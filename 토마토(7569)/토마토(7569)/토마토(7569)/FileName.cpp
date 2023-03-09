# include<iostream>

using namespace std;

int main()
{
	int box[102][102][102] = { 0, };
	int X = 0;
	int Y = 0;
	int Z = 0;

	cin >> X >> Y >> Z;

	for (int i = 0; i < Z + 2; i++) {
		for (int j = 0; j < Y + 2; j++) {
			for (int k = 0; k < X + 2; k++) {
				box[i][j][k] = -1;
			}
		}
	}
	int one_count = 0;
	for (int i = 1; i < Z + 1; i++) {
		for (int j = 1; j < Y + 1; j++) {
			for (int k = 1; k < X + 1; k++) {
				cin >> box[i][j][k];
				if (box[i][j][k] == 1) {
					box[i][j][k]++;
					one_count++;
				}
				if (box[i][j][k] == -1) {
					one_count++;
				}
			}
		}
	}
	int out = 0;
	int count = 0;
	int toma = 3;
	int toma_count = 0;
	while (out==0) {
		int z_count = 0;
		
		for (int i = 1; i < Z + 1; i++) {
			if (out == -1) {
				break;
			}
			for (int j = 1; j < Y + 1; j++) {
				for (int k = 1; k < X + 1; k++) {
					if (out == -1) {
						break;
					}
					if (box[i][j][k] == 0) {
						z_count++;
						if (box[i - 1][j][k] == -1 && box[i + 1][j][k] == -1 && box[i][j - 1][k] == -1 && box[i][j + 1][k] == -1 && box[i][j][k - 1] == -1 && box[i][j][k + 1] == -1) {
							count = -2;
							out = -1;
						}
					}
					else if (box[i][j][k] == toma - 1) {
						if (box[i - 1][j][k] == 0) {
							box[i - 1][j][k] = toma;
							toma_count++;
						}
						if (box[i + 1][j][k] == 0) {
							box[i + 1][j][k] = toma;
							toma_count++;
						}
						if (box[i][j - 1][k] == 0) {
							box[i][j - 1][k] = toma;
							toma_count++;
						}
						if (box[i][j + 1][k] == 0) {
							box[i][j + 1][k] = toma;
							toma_count++;
						}
						if (box[i][j][k - 1] == 0) {
							box[i][j][k - 1] = toma;
							toma_count++;
						}
						if (box[i][j][k + 1] == 0) {
							box[i][j][k + 1] = toma;
							toma_count++;
						}
					}
				}
			}
		}
		
		
		toma++;
		count++; 
		if (z_count == 0) {
			out = -1;
			break;
		}
		if (toma_count + one_count == X * Y * Z) {
			break;
		}

	}
	cout << count;
	return 0;
}