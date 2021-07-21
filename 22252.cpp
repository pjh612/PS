#include <iostream>
#include <string>
#include <vector>
#include <map>
#include<algorithm>
#include<memory.h>
#include<queue>
using namespace std;

priority_queue<long long> pq[100005];
map<string, int> m;
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	long long idx = 1;

	long long ans = 0;
	long long q;
	cin >> q;
	while (q--)
	{
		string name;
		int type;
		cin >> type;
		if (type == 1)
		{
			int n;
			cin >> name;
			if (!m[name])
				m[name] = idx++;
			cin >> n;
			for (int i = 0; i < n; i++)
			{
				long long val;
				cin >> val;
				pq[m[name]].push(val);
			}
		}
		else if (type == 2)
		{
			cin >> name;

			long long n;
			cin >> n;
			if (!m[name])
				continue;
			long long _idx = m[name];
			long long max = min(n, (long long)pq[_idx].size());
			while (max--)
			{
				ans += pq[_idx].top();
				pq[_idx].pop();
			}
		}
	}
	cout << ans;

}