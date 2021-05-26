#include <string>
#include <vector>
#include<iostream>
#include<memory.h>
#include<map>
#include<algorithm>
#include<queue>
#include<set>
using namespace std;
int arr[11][11];
int d[11][11];
int n, k;
int visit[11];
int ans = 987654321;
void solution(int cur, int cnt, int max, int val);
int main()
{
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);

	cin >> n >> k;
	vector<pair<int, int>> v[11];
	/*for (int i = 0; i < n; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		v[a].push_back({ b,c });
		v[b].push_back({ a,c });
	}*/
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
			cin >> arr[i][j];
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			d[i][j] = arr[i][j];
		}
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			for (int k = 0; k < n; k++)
			{
				if (d[j][k] > d[j][i] + d[i][k])
					d[j][k] = d[j][i] + d[i][k];
			}
		}
	}

	//for (int i = 0; i < n; i++)
	//{
	//	for (int j = 0; j < n; j++)
	//		cout << d[i][j] << ' ';
	//	cout << '\n';
	//}
	solution(k, 0, n, 0);
	cout << ans;
}

void solution(int cur, int cnt, int max, int val)
{
	if (cnt == max)
	{
		ans = min(ans, val);
	}
	for (int i = 0; i < n; i++)
	{
		if (visit[i] == 1)
			continue;
		visit[i] = 1;
		solution(i, cnt + 1, max, val + d[cur][i]);
		visit[i] = 0;
	}
}

