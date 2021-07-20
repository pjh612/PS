#include <iostream>
#include <string>
#include <vector>
#include <map>
#include<algorithm>
#include<memory.h>
using namespace std;


long long dp[31][61];

long long solution(int idx, int cnt);
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);


	while (1)
	{
		memset(dp, -1, sizeof(dp));
		int n;
		cin >> n;
		if (n == 0)
			break;
		cout << solution(n, 0) << '\n';
	}


}
long long solution(int w, int h)
{
	if (w == 0)
		return 1;
	if (dp[w][h] != -1)
		return dp[w][h];
	dp[w][h] = 0;
	dp[w][h] += solution(w - 1, h + 1);
	if (h >= 1)
		dp[w][h] += solution(w, h - 1);
	return dp[w][h];
}
