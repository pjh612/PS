#include <iostream>
#include <string>
#include <vector>
#include <map>
#include<algorithm>
using namespace std;

int dp[21][101];
int cost[21];
int joy[21];
int main()
{
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++)
	{
		cin >> cost[i];
	}
	for (int i = 1; i <= n; i++)
	{
		cin >> joy[i];
	}

	for (int i = 1; i <= n; i++)
	{
		for (int j = 0; j <= 100; j++)
		{
			if (j - cost[i] >= 0)
				dp[i][j] = max(dp[i - 1][j - cost[i]] + joy[i], dp[i - 1][j]);

			dp[i][j] = max(dp[i][j], dp[i - 1][j]);
		}
	}

	cout << dp[n][99];
}