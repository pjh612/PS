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

int arr[101];
int d[100001];
int main(void) {


	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int n, k;

	cin >> n >> k;
	for (int i = 0; i <= k; i++)
	{
		d[i] = 987654321;
	}
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
		d[arr[i]] = 1;
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = arr[i]; j <= k; j++)
		{
			d[j] = min(d[j], d[j - arr[i]] + 1);

		}
	}
	/*for (int i = 0; i < k; i++)
		cout << d[i] << '\n';*/
	if (d[k] == 987654321)
		cout << "-1";
	else
		cout << d[k];

}