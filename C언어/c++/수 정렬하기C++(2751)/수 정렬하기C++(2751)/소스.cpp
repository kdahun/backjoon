# include<iostream>

using namespace std;

void switchNum(int* a, int* b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

void printArray(int* arr,int n) {
	for (int i = 0; i < n; i++) {
		cout << arr[i] << "\n";
	}
}

void bubbleSort(int* arr,int n) {
	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			if (arr[i] > arr[j]) {
				switchNum(&arr[i], &arr[j]);
			}
		}
	}

}

void selectSort(int* arr, int n) {
	
	for (int i = 0; i < n-1; i++) {
		int index = i;
		int min = arr[i];
		for (int j = i + 1; j < n; j++) {
			if (min > arr[j]) {
				min = arr[j];
				index = j;
			}
		}
		switchNum(&arr[i], &arr[index]);
	}
}

void insertSort(int* arr, int n) {

	for (int i = 1; i < n; i++) {
		int temp = arr[i];
		int j = i-1;
		while (temp < arr[j] && j >= 0) {
			arr[j + 1] = arr[j];
			j -= 1;
		}
		arr[j+1] = temp;
	}
}

int divide(int* arr, int start, int end) {
	int pivot = arr[end];
	int index = start;

	for (int i = start; i < end; i++){
		if (arr[i] < pivot) {
			switchNum(&arr[i], &arr[index]);
			index++;
		}
	}
	switchNum(&arr[end], &arr[index]);

	return index;
}

void quickSort(int* arr, int start, int end) {
	if (start < end) {
		int d = divide(arr, start, end);
		quickSort(arr, start, (d - 1));
		quickSort(arr, d + 1, end);
	}
}



int main() {
	int i;
	int* arr;
	int n;

	cin >> n;

	arr = (int*)malloc(sizeof(int) * n);
	
	for (i = 0; i < n; i++) {
		cin >> arr[i];
	}

	//bubbleSort(arr,n);
	//selectSort(arr, n);
	//insertSort(arr, n);

	//quickSort(arr, 0, n - 1);

	printArray(arr, n);

	return 0;
}