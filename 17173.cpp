#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<string>
#include<math.h>
#include<fstream>
#include<memory.h>
#include <tuple>
#include<vector> 
using namespace std;

int arr[300001];
int arr2[300001];
int d[300001];
int main(void) {


	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int d, n;
	cin >> d >> n;
	for (int i = 0; i < d; i++)
	{
		cin >> arr[i];

	}
	for (int i = 0; i < n; i++)
	{
		cin >> arr2[i];
	}
	int min = arr[0];
	for (int i = 0; i < d; i++)
	{
		if (arr[i] < min)
			min = arr[i];
		d[i] = min;
		
	}
	for (int i = 0; i < d; i++)
	{
		cout << d[i] << '\n';
	}
}
