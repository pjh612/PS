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

vector< pair<int, int>> v;
int arr[2001][2001];
int visit[2001];
priority_queue<pair<int, int>> pq;
int ans = 0;
int main(void) {


	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int n, c;
	cin >> n >> c;
	for (int i = 0; i < n; i++)
	{
		int a, b;
		cin >> a >> b;
		v.push_back({ a,b });
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (i == j)
				continue;
			arr[i][j] = (v[i].first - v[j].first) * (v[i].first - v[j].first) + (v[i].second - v[j].second) * (v[i].second - v[j].second);
		}
	}


	for (int i = 0; i < n; i++)
	{
		if (i != 0)
			pq.push({ -arr[0][i],i });
	}
	visit[0] = 1;
	for (int i = 1; i < n; i++)
	{
		int now = -1, mindis = 987654321;
		while (!pq.empty())
		{

			if (!visit[pq.top().second] && -pq.top().first >= c) {
				now = pq.top().second;
				mindis = -pq.top().first;
				break;

			}

			pq.pop();
		}
		//cout << now << ',' << mindis << "¼±ÅÃ\n";
		if (mindis == 987654321)
		{
			cout << "-1";
			return 0;
		}
		visit[now] = 1;
		ans += mindis;
		//cout << mindis << '\n';
		for (int j = 0; j < n; j++)
		{
			pq.push({ -arr[now][j], j });
		}
	}
	cout << ans;
}
