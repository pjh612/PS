#include <string>
#include <vector>
#include<iostream>
#include<limits.h>
#include <bitset>
#include<queue>
#include<map>
#include<memory.h>
#include<math.h>
using namespace std;
void solution(int s, int e);
vector<pair<int,int>> v[1001];
int d[1001];
int pre[1001];
int n, m;
void back(int n);
vector<pair<int,int>> route;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	for (int i = 0; i < m; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		v[a].push_back({ c,b });
		v[b].push_back({ c,a });
	}
	solution(0,0);
	int no = d[n];
	int ans = 0;
	back(n);
	for (int i = 0; i < route.size(); i++)
	{
		
		int v1 = route[i].first;
		int v2 = route[i].second;	
		solution(v1,v2);
		if (d[n] == 987654321)
		{
			cout << -1;
			return (0);
		}
		ans = max(ans, abs(no - d[n]));
	}
	cout << ans;
}
void back(int idx)
{
	if (pre[idx] == 0)
		return;
	route.push_back({ idx,pre[idx] });
	back(pre[idx]);
}
void solution(int s, int e)
{
	for (int i = 1; i <= n; i++)
		d[i] = 987654321;
	priority_queue<pair<int, int>> pq;
	pq.push({ 0,1 });
	d[1] = 0;
	while (!pq.empty())
	{
		int dis = -pq.top().first;
		int cur = pq.top().second;
		pq.pop();
		if (d[cur] < dis)
			continue;
		for (int i =0; i < v[cur].size(); i++)
		{
			int next = v[cur][i].second;
			int next_dis = v[cur][i].first + dis;
			if (s == cur && e == next || e == cur && s == next)
				continue;
			if (next_dis < d[next])
			{
				d[next] = next_dis;
				pq.push({ -next_dis,next });
				pre[next] = cur;
			}
		}
	}
}