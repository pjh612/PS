#include <iostream>
#include <string>
#include <vector>
#include <map>
#include<algorithm>
#include<memory.h>
#include<queue>
using namespace std;

int arr[100001];
int n, x;
bool check(int mid)
{
	priority_queue<int,vector<int>, greater<int>> pq;
	
	for (int i = 0; i < mid; i++)
	{
		pq.push(0);
	}

	for (int i = 0; i < n; i++)
	{
		int use = pq.top();
		pq.pop();
		if (use + arr[i] > x)
			return false;
		pq.push(use + arr[i]);
	}
	return true;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> x;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	int l=1, r=n;
	while (l <= r)
	{
		int mid = (l + r) / 2;

		if (check(mid))
		{
			r = mid - 1;
		}
		else
			l = mid + 1;
	}
	cout << r + 1;

}