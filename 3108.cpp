#include <string>
#include <vector>
#include<iostream>
#include<memory.h>
#include<map>
#include<algorithm>
#include<queue>
#include<set>
using namespace std;

struct Rec
{
	int x1, y1, x2, y2;
}typedef Rec;
int parent[1001];
int m[1010][1010];
set<int> s;
int getParent(int a)
{

	if (parent[a] == a)
		return a;
	return parent[a] = getParent(parent[a]);
}
void Union(int a, int b)
{
	int x = getParent(a);
	int y = getParent(b);
	if (x == y)
		return;
	if (x < y)
	{
		parent[y] = x;
	}
	else
		parent[x] = y;
}
int main()
{
	int n;
	cin >> n;
	vector<Rec> v;
	bool flag = 0;
	memset(m, -1, sizeof(m));
	for (int i = 0; i < n; i++)
	{
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		Rec r = { a,b,c,d };
		parent[i] = i;
		v.push_back(r);
	}
	for (int i = 0; i < v.size(); i++)
	{
		for (int j = v[i].x1; j <= v[i].x2; j++)
		{
			if (m[v[i].y1 + 500][j + 500] != -1)
				Union(m[v[i].y1 + 500][j + 500], i);
			else
				m[v[i].y1 + 500][j + 500] = i;

			if (m[v[i].y2 + 500][j + 500] != -1)
				Union(m[v[i].y2 + 500][j + 500], i);
			else
				m[v[i].y2 + 500][j + 500] = i;
		}
		for (int k = v[i].y1; k <= v[i].y2; k++)
		{
			if (m[k + 500][v[i].x1 + 500] != -1)
				Union(m[k + 500][v[i].x1 + 500], i);
			else
				m[k + 500][v[i].x1 + 500] = i;

			if (m[k + 500][v[i].x2 + 500] != -1)
				Union(m[k + 500][v[i].x2 + 500], i);
			else
				m[k + 500][v[i].x2 + 500] = i;
		}
	}
	for (int i = 0; i < v.size(); i++)
	{
		s.insert(getParent(parent[i]));
	}
	if (m[500][500] != -1)
		cout << s.size() - 1;
	else
		cout << s.size();

}

