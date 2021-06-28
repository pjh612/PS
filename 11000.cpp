#include <iostream>
#include<vector>
#include<algorithm>
#include<math.h>
#include<queue>

using namespace std;

int main() {

	int n;
	cin >> n;
	priority_queue<int,vector<int>,greater<int>> pq;
	vector<pair<int, int>> v;
	for (int i = 0; i < n; i++)
	{
		int a, b;
		cin >> a >> b;
		v.push_back({ a,b });

	}
	sort(v.begin(), v.end());

	pq.push(v[0].second);
	
	int ans = 1;
	for (int i = 1; i < v.size(); i++)
	{
		while (!pq.empty() && pq.top() <= v[i].first)
			pq.pop();	
		pq.push(v[i].second);
		ans = max(ans, (int)pq.size());
	}
	cout << ans;
}
