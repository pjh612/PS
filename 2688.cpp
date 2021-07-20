#include <iostream>
#include <string>
#include <vector>
#include <map>
#include<algorithm>
#include<memory.h>
using namespace std;


long long dp[65][10];


long long solution(int, int);
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	int T;
	cin >> T;
	while (T--)
	{
		memset(dp, -1, sizeof(dp));
		int n;
		cin >> n;
		long long ans = 0;
		for (int i = 0; i <= 9; i++)
		{
			ans +=solution(n,i);
		}
		cout << ans << '\n';
	}

	
}
long long solution(int idx, int num)
{
	if (idx == 1)
		return 1;
	if (dp[idx][num] != -1)
		return dp[idx][num];

	dp[idx][num] = 0;
	for (int i = 0; i <= num; i++)
	{
		dp[idx][num] += solution(idx - 1, i);
	}
	return dp[idx][num];
}
