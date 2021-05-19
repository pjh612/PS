#include <string>
#include <vector>
#include<iostream>
#include<memory.h>
#include<map>
#include<algorithm>
#include<queue>
#include<limits.h>
#include<set>
using namespace std;
void solution(int n);
vector<pair<int, int>> v[100001];
priority_queue<pair<long long, int >> pq;
int n, m, k;
int arr[100001];
long long ans = 0;
int ans_idx = 0;
int main()
{
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	long long d[100001];
	cin >> n >> m >> k;

	for (int i = 1; i <= n; i++)
	{
		d[i] = LLONG_MAX;
	}
	for (int i = 0; i < m; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		v[b].push_back({ c,a });
	}
	for (int i = 0; i < k; i++)
	{
		cin >> arr[i];
		d[arr[i]] = 0;
		pq.push({ 0,arr[i] });

	}
	while (!pq.empty())
	{
		long long dis = -pq.top().first;
		int cur = pq.top().second;
		pq.pop();
		if (dis > d[cur])
			continue;
		for (int i = 0; i < v[cur].size(); i++)
		{
			int next = v[cur][i].second;
			long long nextdis = dis + v[cur][i].first;
			if (d[next] > nextdis) {
				d[next] = nextdis;
				pq.push({ -nextdis, next });
			}
		}
	}
	for (int i = 1; i <= n; i++)
	{
		if (ans < d[i])
		{
			ans_idx = i;
			ans = d[i];
		}
	}
	cout << ans_idx << '\n' << ans;


}

