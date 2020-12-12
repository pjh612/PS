#define _CRT_SECURE_NO_WARNINGS
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

int arr[1001][1001];
int dp[1001][1001];

int main(void) {


	
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++) {
			scanf("%1d", &arr[i][j]);
			if (arr[i][j] == 1)
				dp[i][j] = 1;
		}
	}
	

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (arr[i][j] == 1)
			{
				if (i - 1 >= 0 && j - 1 >= 0)
				{
					if (dp[i - 1][j] && dp[i][j - 1] && dp[i - 1][j - 1]) {
						int _min = min(dp[i - 1][j], min(dp[i][j - 1], dp[i - 1][j - 1]));
						dp[i][j] = _min + 1;
					}
					else
						dp[i][j] = 1;
				}
				else
				{
					if (arr[i][j] == 1)
						dp[i][j] = 1;

				}
			}
		}
	}
	int ans = 0;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			
			ans = max(dp[i][j], ans);
		}
		
	}
	cout << ans*ans;
}