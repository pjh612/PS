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
int dp[300001];
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
		dp[i] = min;

	}
	
	reverse(dp, dp + d);
	/*for (int i = 0; i < d; i++)
	{
		cout << dp[i] << '\n';
	}
	cout << '\n';*/
	int idx2 = 0;
	for (int i = 0; i < n; i++) {
	auto idx =	lower_bound(dp+idx2+1, dp + d, arr2[i]);
	idx2= idx - dp;
	//cout << idx2 << '\n';
	}
	cout << d - idx2;
}
