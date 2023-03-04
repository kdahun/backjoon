#include<stdio.h>
int main(void)
{
	int k, n, m, dam;
	scanf_s("%d", &k);
	for (int z = 0; z < k; z++)
	{
		dam = 1;
		scanf_s("%d %d", &n, &m);
		for (int i = 0; i < n; i++)
		{
			dam *= m - i;
			dam /= 1 + i;
		}
		printf("%d\n", dam);
	}
}