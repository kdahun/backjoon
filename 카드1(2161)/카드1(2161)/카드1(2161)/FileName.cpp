#include <iostream>
#include <queue>

using namespace std;

int main()
{
	queue<int> q;
	int N;
	cin >> N;

	

	for (int i = 1; i <= N; i++) {
		q.push(i);
	}

	for (int i = 0; i < N-1; i++) {
		cout << q.front() << " ";
		q.pop();
		q.push(q.front());
		q.pop();
	}
	cout << q.front();
	return 0;
}