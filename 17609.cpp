#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<stack>
#include<map>
#include<memory.h>
#include<queue>
using namespace std;
bool isPalin(string s, int,int);
int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int T;
	cin >> T;
	while (T--)
	{
		string s;
		cin >> s;
		int l = 0, r = s.size() - 1;
		int cnt = 0;
		bool flag = false;
		while (l <= r)
		{
			if (s[l] != s[r])
			{
				if (isPalin(s, l+1,r))
				{
					l++;
					cnt++;
				}
				else if (isPalin(s, l,r-1))
				{
					r--;
					cnt++;
				}
				if (cnt == 0)
				{
					cout << "2\n";
					flag = true;
					break;
				}
			}
			else
			{
				l++;
				r--;
			}
			if (cnt >= 2)
			{
				cout << "2\n";
				break;
			}
		}
		if (flag)
			continue;
		if (cnt == 1)
			cout << "1\n";
		else if(cnt== 0)
			cout << "0\n";
	}
}

bool isPalin(string s, int l, int r)
{
	while (l < r)
	{
		if (s[l] != s[r])
			return false;
		l++;
		r--;
	}
	return true;
}