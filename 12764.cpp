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
int arr[100001];
int m;
int main()
{
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int p, q;
		cin >> p >> q;
		v.push_back({ p,q });
	}
	sort(v.begin(), v.end());
	priority_queue<pair<int, int>> pq;
	priority_queue<int, vector<int>, greater<int>> pq2;
	pq.push({ -v[0].second,0 });
	arr[0]++;
	for (int i = 1; i < n; i++)
	{
		pq2.push(i);
	}
	for (int i = 1; i < v.size(); i++)
	{

		while (!pq.empty() && -pq.top().first < v[i].first)
		{
			pq2.push(-pq.top().second);
			pq.pop();
		}
		pq.push({ -v[i].second , -pq2.top() });
		arr[pq2.top()]++;
		pq2.pop();
		m = max(m, (int)pq.size());

	}
	cout << m << '\n';
	for (int i = 0; i < m; i++)
		cout << arr[i] << ' ';
}

