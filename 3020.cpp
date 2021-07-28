#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<stack>
#include<map>
#include<memory.h>
#include<queue>
using namespace std;

int bot[500001];
int top[500001];
vector<int> even;
vector<int> odd;

int n, h;

int main()
{

	cin >> n >> h;
	for (int i = 0; i < n; i++)
	{
		int a;
		cin >> a;
		if (i % 2 == 0)
			even.push_back(a);
		else
			odd.push_back(a);
	}
	sort(even.begin(), even.end());
	sort(odd.begin(), odd.end());

	for (int i = 1; i <= h; i++)
	{
		int l = 0, r = even.size() - 1;
		while (l <= r)
		{
			int mid = (l + r) / 2;


			if (even[mid] < i)
			{
				l = mid + 1;
			}
			else
			{
				r = mid - 1;
			}

		}
		bot[i] = even.size() - (r + 1);

		l = 0, r = odd.size() - 1;
		while (l <= r)
		{
			int mid = (l + r) / 2;
			if (h - odd[mid] >= i)
			{
				l = mid + 1;
			}
			else
				r = mid - 1;
		}
		top[i] = odd.size() - l;

	}
	int m = 987654321;
	int c = 0;
	for (int i = 1; i <= h; i++)
	{
		int sum = top[i] + bot[i];
		if (sum < m)
		{
			m = sum;
			c = 1;
		}
		else if (sum == m)
		{
			c++;
		}
	}
	cout << m << ' ' << c;
}
