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


int main()
{
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	string s1, s2;
	cin >> s1 >> s2;

	if (s1.length() > s2.length())
	{
		swap(s1, s2);
	}
	int ans = s1.length()+s2.length();
	for (int i = 0; i < s1.length(); i++)
	{
		int s1_len = s1.length();
		bool flag = false;
		for (int j = 0; j <= i; j++)
		{
			if (s2[j] =='2' && s1[s1_len - 1 - i+ j] == '2')
			{
				flag = true;
				break;
			}
		}
		if (!flag)
			ans = min(ans, (int)s1.length() + (int)s2.length() - 1 - i);
	}
	for (int i = 0; i < s1.length(); i++)
	{

		int s2_len = s2.length();
		bool flag = false;
		for (int j = 0;j<=i;j++)
		{
			if (s2[s2_len -1 -i+j] == '2' &&  s1[j]=='2')
			{
				flag = true;
				break;
			}
		}
		if (!flag)
			ans = min(ans, (int)s1.length() + (int)s2.length() - 1 - i);
	}

	for (int i = 0; i<s2.length()- s1.length(); i++)
	{
		bool flag = false;
		for (int j = 0; j < s1.length(); j++)
		{
			if (s1[j]=='2' && s2[i+j] == '2')
			{
				flag = true;
				break;
			}
		}
		if (!flag)
			ans = min(ans,(int)s2.length());
	}
	cout << ans;
}

