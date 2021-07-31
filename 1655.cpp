#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<stack>
#include<map>
#include<memory.h>
#include<queue>
using namespace std;

priority_queue<int> pq;
priority_queue<int, vector<int>, greater<int>> pq2;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	int n;
	cin >> n;


	for (int i = 0; i < n; i++)
	{
		int a;
		cin >> a;

		if (i == 0)
		{
			pq.push(a);
			cout << a << '\n';
		}
		else
		{
			if (a >= pq.top())
			{
				pq2.push(a);
			}
			else
			{
				pq.push(a);
			}
			if ((int)pq.size() - (int)pq2.size() == 2)
			{
				pq2.push(pq.top());
				pq.pop();
			}
			else if ((int)pq2.size() - (int)pq.size() == 1)
			{
				pq.push(pq2.top());
				pq2.pop();
			}
			cout << min(pq.top(), pq2.top()) << '\n';

		}
	}
}