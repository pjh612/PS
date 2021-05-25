#include <string>
#include <vector>
#include<iostream>
#include<memory.h>
#include<map>
#include<algorithm>
#include<queue>
#include<set>
using namespace std;
struct cmp
{
	bool operator()(pair<pair<int, int>, int> a, pair<pair<int, int>, int> b)
	{
		if (a.first.first == b.first.first)
		{
			if (a.first.second == b.first.second)
				return a.second < b.second;
			else
				return a.first.second < b.first.second;
		}
		else
			return a.first.first > b.first.first;
	}
};

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	int n,k;
	cin >> n >> k;
	vector<pair<int, int>> v;
	for (int i = 0; i < n; i++)
	{
		int a, b;
		cin >> a >> b;
		v.push_back({a , b});
	}

	priority_queue<pair<pair<int, int>,int>,vector<pair<pair<int, int>, int>>,cmp> pq;
	// 끝나는 시간, 계산대번호, 회원번호
	priority_queue<pair<int,int>,vector<pair<int, int>>,greater<pair<int,int>>> pq2;
	// 시작시간 계산대번호
	int i = 0;
	long long j = 1;
	for (i = 0; i < k; i++)
	{
		if (i >= n)
			break;
		pq.push({ {v[i].second, i}, v[i].first });
	}
	long long ans = 0;
	int now = 0;
	for (; i < n; i++)
	{
		
		while (!pq.empty() && pq.top().first.first <= now || pq.size() >= k)
		{
			now = pq.top().first.first;
			pq2.push({ pq.top().first.first,pq.top().first.second });
			ans += j * pq.top().second;
			j++;
			pq.pop();
		}
		
		pq.push({ {(pq2.top().first + v[i].second),pq2.top().second},v[i].first });
		pq2.pop();
	}
	while (!pq.empty())
	{
		ans += j * pq.top().second;
		j++;
		pq.pop();
	}
	cout << ans;
}

