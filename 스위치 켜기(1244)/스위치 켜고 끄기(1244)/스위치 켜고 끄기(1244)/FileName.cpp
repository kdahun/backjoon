# include<iostream>

using namespace std;

int main()
{
	int sw[100] = { 0, };
	int se = 0;
	int num_index = 0;
	int num_num = 0;
	int num_person = 0;
	
	cin >> num_num;
	for (int i = 0; i < num_num; i++) {
		cin >> sw[i];
	}

	cin >> num_person;

	for (int i = 0; i < num_person; i++) {
		cin >> se >> num_index;
		if (se == 1) {
			int count = 1;
			for (int i = 0; i < num_num;i++) {
				if (i == num_index * count-1) {
					if (sw[i] == 0) {
						sw[i] = 1;
					}
					else if (sw[i] == 1) {
						sw[i] = 0;
					}
					count++;
				}

			}
		}
		else if (se == 2) {
			int count = 1;
			if (sw[num_index - 1] == 0) {
				sw[num_index - 1] = 1;
			}
			else if (sw[num_index - 1] == 1) {
				sw[num_index - 1] = 0;
			}
			while (count != 0) {
				if (num_index - count-1 >= 0 && num_index + count-1 < num_num) {
					if (sw[num_index - count-1] == sw[num_index + count-1]) {
						if (sw[num_index - count-1] == 0) {
							sw[num_index - count-1] = 1;
						}
						else if (sw[num_index - count-1] == 1) {
							sw[num_index - count-1] = 0;
						}
						if (sw[num_index + count-1] == 0) {
							sw[num_index + count-1] = 1;
						}
						else if (sw[num_index + count-1] == 1) {
							sw[num_index + count-1] = 0;
						}
						count++;
						
					}
					else {
						count = 0;
					}
				}
				else {
					count = 0;
				}

			}
		}
		
	}
	for (int i = 0; i < num_num; i++) {
		cout << sw[i]<<" ";

		if (i % 20==19) {
			cout << endl;
		}

	}

	return 0;
}