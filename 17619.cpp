#include <string>
#include <vector>
#include<iostream>
#include<memory.h>
#include<map>
#include<algorithm>
#include<queue>
#include<set>
using namespace std;
vector<pair<int, int>> v;
int p[100001];
int m;
int getp(int x)
{
	if (p[x] == x)
		return x;
	return (p[x] = getp(p[x]));
}
void Union(int x, int y)
{
	x = getp(x);
	y = getp(y);

	if (x < y)
		p[y] = x;
	else
		p[x] = y;

}
int main()
{
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	int  n, q;
	cin >> n >> q;
	vector<pair<pair<int, int>,int>> v;
	for (int i = 0; i < n; i++)
	{
		p[i] = i;
	}
	for (int i = 0; i < n; i++)
	{
		int x1, x2, y;
		cin >> x1 >> x2 >> y;
		v.push_back({ { x1,x2 },i });
	}
	sort(v.begin(), v.end());
	priority_queue<pair<int,int>> pq;
	pq.push({-v[0].first.second,v[0].second });
	for (int i = 1; i < v.size(); i++)
	{
		while (!pq.empty() && v[i].first.first > -pq.top().first)
			pq.pop();
		if (!pq.empty() && v[i].first.first <= -pq.top().first)
			Union(v[i].second, pq.top().second);

		pq.push({ -v[i].first.second, v[i].second});
	}

	for (int i = 0; i < q; i++)
	{
		int a, b;
		cin >> a >> b;
		getp(a - 1) == getp(b - 1) ? cout << "1\n" : cout << "0\n";
	}
}

