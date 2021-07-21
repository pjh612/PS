#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<stack>
#include<map>
#include<memory.h>
#include<queue>
using namespace std;

long long dp[101][21];
int arr[101];
int n;
long long solve(int idx, int val);
int main(void)
{

	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
	memset(dp, -1, sizeof(dp));

	cout << solve(0, arr[0]);

}

long long solve(int idx, int val)
{

	if (val > 20 || val < 0)
		return 0;
	if (idx == n - 2)
		return (arr[n - 1] == val);
	if (dp[idx][val] != -1)
		return dp[idx][val];
	dp[idx][val] = 0;
	dp[idx][val] += solve(idx + 1, val + arr[idx + 1]) + solve(idx + 1, val - arr[idx + 1]);
	return dp[idx][val];
}