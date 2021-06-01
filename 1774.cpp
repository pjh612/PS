#include <iostream>
#include<vector>
#include<algorithm>
#include<math.h>
#include<queue>
using namespace std;
int p[1001];
vector<pair<int, int>> v;
struct Edge
{
	int v1, v2;
	double dis;
};
struct cmp
{
	bool operator()(const Edge& s1, const Edge& s2) {
		return s1.dis > s2.dis;
	}
};
int getParent(int x)
{
	if (p[x] == x)
		return x;
	return x = getParent(p[x]);
}

void Union(int a, int b)
{
	a = getParent(a);
	b = getParent(b);
	if (a == b)
		return;
	if (a < b)
		p[b] = a;
	else
		p[a] = b;
}
priority_queue<Edge, vector<Edge>, cmp> pq;

int main() {
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++)

	{
		p[i] = i;
		int x, y;
		cin >> x >> y;
		v.push_back({ x,y });
	}
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (i == j)
				continue;
			Edge e;
			e.v1 = i + 1;
			e.v2 = j + 1;
			e.dis = sqrt(pow(v[i].first - v[j].first, 2) + pow(v[i].second - v[j].second, 2));
			pq.push(e);
		}
	}
	int edges = n - 1;
	for (int j = 0; j < m; j++)
	{
		int a, b;
		cin >> a >> b;
		if (getParent(a) != getParent(b))
		{
			Union(a, b);
			edges--;
		}
	}
	long double ans = 0;

	while (edges)
	{
		Edge e = pq.top();
		if (getParent(e.v1) != getParent(e.v2))
		{
			edges--;
			Union(e.v1, e.v2);
			ans += e.dis;
		}
		pq.pop();
	}
	cout.precision(2);
	cout << fixed;
	cout << ans;
}

