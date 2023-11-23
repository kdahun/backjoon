# include<stdio.h>
# include<stdlib.h>

int* insert_arr(int n) {
	int* arr = (int*)malloc(sizeof(int) * n);

	for (int i = 0; i < n; i++) {
		scanf_s("%d", &arr[i]);
	}
	return arr;
}

void sort(int*arr,int n) {
	
	for (int i = 0; i < n; i++) {
		for (int j = i; j < n; j++) {
			if (arr[i] > arr[j]) {
				int temp = 0;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
}

int compare(int* a, int* b) {
	return *(int*)a - *(int*)b;
}


void main() {
	int n = 0;
	scanf_s("%d", &n);

	int* arr= insert_arr(n);
	
	//sort(arr,n);

	qsort(arr, n, sizeof(int), compare);

	for (int i = 0; i < n; i++) {
		printf("%d\n", arr[i]);
	}
}