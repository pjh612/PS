#include <string>
#include <vector>
#include<iostream>
#include<memory.h>
#include<map>
#include<algorithm>
#include<queue>
#include<set>
#include<math.h>
using namespace std;

vector<int> v;
int n, cnt;
int dfs(int idx, int max);
int main()
{
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	
	cin >> n;
	if (n >= 1023)
		cout << -1;
	else
	dfs(0, 1);
}
int dfs(int idx, int max)
{
	if (idx == max)
	{
			if (cnt == n) {
			for (int i = 0; i < v.size(); i++)
			{
				cout << v[i];
			}
			return (0);
		}
		cnt++;
		return 1;
	}
	if (max != 1 && idx == 0)
	{
		for (int i = 1; i <= 9; i++)
		{
			v.push_back(i);
			int ret = dfs(idx + 1, max);
			v.pop_back();
			if (ret == 0)
				return (0);
		}
		dfs(0, max + 1);
	}
	else if (max == 1 && idx == 0)
	{
		for (int i = 0; i <= 9; i++)
		{
			v.push_back(i);
			int ret = dfs(idx + 1, max);
			v.pop_back();
			if (ret == 0)
				return (0);
		}
		dfs(0, max + 1);
	}
	else if (idx != 0)
	{
		for (int i = 0; i <= 9; i++)
		{
			if (v.back() <= i)
				continue;
			v.push_back(i);
			int ret = dfs(idx + 1, max);
			v.pop_back();
			if (ret == 0)
				return (0);
		}
	}

	return (1);

}
