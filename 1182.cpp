#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<stack>
#include<map>
#include<queue>
using namespace std;

int arr[21];
bool visit[21];
int n,s;
int solution(int idx, int cnt, int max, int sum);
int main(void)
{
	cin >> n >> s;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
	int ans = 0;
	for (int i = 1; i <= n; i++)
	{
		ans += solution(0, 0, i, 0);
	}
	cout << ans;
}

int solution(int idx,int cnt, int max, int sum)
{
	int ret = 0;
	if (cnt == max)
	{
		if (sum == s)
			return (1);
		return (0);
	}
	for (int i = idx; i < n; i++)
	{
		if (visit[i] == 0)
		{
			visit[i] = 1;
			ret += solution(i + 1, cnt + 1, max, sum + arr[i]);
			visit[i] = 0;
		}
	}
	return (ret);
}
