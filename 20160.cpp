#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<stack>
#include<map>
#include<memory.h>
#include<queue>
#include<climits>
using namespace std;

long long dij(int start, int dest);
int v, e;
vector<pair<int, int>> edge[10001];
int arr[11];
priority_queue<pair<long long, int>> pq;
int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	vector<int> can;
	cin >> v >> e;
	for (int i = 0; i < e; i++)
	{
		int u, v, w;
		cin >> u >> v >> w;
		edge[u].push_back({ w,v });
		edge[v].push_back({ w,u });
	}
	for (int i = 0; i < 10; i++)
	{
		cin >> arr[i];
	}
	int myStart;
	cin >> myStart;

	int yogurt_now = arr[0];
	long long yogurt_dis = 0;
	for (int i = 0; i < 10; i++)
	{
		long long now_dis = dij(yogurt_now, arr[i]);
		if (now_dis == LLONG_MAX)
			continue;
		yogurt_dis += now_dis;
		long long my_dis = dij(myStart, arr[i]);
		yogurt_now = arr[i];
		if (my_dis < 0)
			continue;
		if (yogurt_dis >= my_dis)
			can.push_back(arr[i]);
	}
	if (can.empty())
	{
		cout << "-1";
		return 0;
	}
	sort(can.begin(), can.end());

	cout << can.front();
}

long long dij(int start, int dest)
{
	long long dis[10001];
	for (int i = 1; i <= v; i++)
	{
		dis[i] = LLONG_MAX;
	}

	dis[start] = 0;

	pq.push({ 0,start });
	while (!pq.empty())
	{
		int cur = pq.top().second;
		long long cur_dis = -pq.top().first;
		pq.pop();
		if (dis[cur] < cur_dis)
			continue;
		for (int i = 0; i < edge[cur].size(); i++)
		{
			int next = edge[cur][i].second;
			long long next_dis = cur_dis + edge[cur][i].first;
			if (next_dis < dis[next])
			{
				dis[next] = next_dis;
				pq.push({ -next_dis,next });
			}
		}
	}
	return dis[dest];
}