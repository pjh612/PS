#include <iostream>
#include <string>
#include <vector>
#include <map>
#include<algorithm>
using namespace std;

int arr[1500001][2];
int dp[1500002];
int main()
{
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++)
	{
		cin >> arr[i][0] >> arr[i][1];
	}

	for (int i = 1; i <= n; i++)
	{
		if (i + arr[i][0] <= n+1)
		{
			dp[i + arr[i][0]] = max(dp[i] + arr[i][1], dp[i + arr[i][0]]);
		}
		if (i <= n)
			dp[i + 1] = max(dp[i + 1], dp[i]);
	}
	cout << dp[n+1];
}

