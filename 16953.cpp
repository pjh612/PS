#include <iostream>
#include<vector>
#include<algorithm>
#include<math.h>
#include<queue>

using namespace std;

int main() {
	
	long long a, b;
	cin >> a >> b;
	queue<pair<int,int>> q;
	int cnt = 0;
	q.push({ a,0 });
	while (!q.empty())
	{
		long long x = q.front().first;
		int cnt = q.front().second;
		q.pop();
		if (x == b)
		{
			cout<<cnt+ 1;
			return 0;
		}
		if(x*10 + 1 <=b)
		q.push({ x * 10 + 1,cnt + 1 });
		if (x * 2 <= b)
		q.push({ x * 2,cnt + 1});
	}
	cout << -1;
}
