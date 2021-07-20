#include <iostream>
#include <string>
#include <vector>
#include <map>
#include<algorithm>
#include<memory.h>
using namespace std;

int arr[301][301];
int dp[301][301];

int n, m, k;
int solution(int idx, int cnt);
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m >> k;
	for (int i = 0; i < k; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		if (arr[a][b] <= c)
			arr[a][b] = c;
	}
	int ans = 0;
	memset(dp, -1, sizeof(dp));

	ans = solution(n, m);
	cout << ans;

}
int solution(int idx, int cnt)
{
	if (idx != 1 && cnt == 1)
	{
		return -987654321;
	}
	if (idx == 1)
	{
		return 0;
	}
	if (dp[idx][cnt] != -1)
		return  dp[idx][cnt];
	dp[idx][cnt] = -987654321;
	for (int i = 1; i < idx; i++)
	{
		if (arr[i][idx])
			dp[idx][cnt] = max(dp[idx][cnt], solution(i, cnt - 1) + arr[i][idx]);
	}
	return dp[idx][cnt];
}
