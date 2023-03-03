# include<iostream>
using namespace std;


int main()
{
	int a = 0;
	int b = 0;
	int c = 0;
	int re = 0;
	int plus = 0;
	cin >> a >> b >> c;

	for (int i = 0; i <= c; i++) {
		re = a / b;
		a %= b;
		if (b > a) {
			a *= 10;
		}
	}
	cout << re;
}