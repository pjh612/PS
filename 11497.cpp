#include <iostream>
#include<vector>
#include<algorithm>
#include<math.h>
#include<queue>
#include<memory.h>
#include<deque>
using namespace std;


int main() {
	int T;
	cin >> T;
	while (T--)
	{
		int n;
		cin >> n;
		deque<int> dq;
		vector<int> v;
		for (int i = 0; i < n; i++)
		{
			int a;
			cin >> a;
			v.push_back(a);
		}
		sort(v.begin(), v.end());
		int ans = 0;
		for (int i = 0; i < v.size(); i++)
		{
			if (i + 2 < v.size())
				ans = max(ans, v[i + 2] - v[i]);
		}
		cout << ans << '\n';
	}
}