#include <string>
#include <vector>
#include<iostream>
#include<memory.h>
#include<map>
#include<algorithm>
#include<queue>
#include<set>
using namespace std;

long long d[31][31];
int main()
{
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	string s;
	cin >> s;
	int len = s.size();
	for (int i = 0; i < len; i++)
	{
		d[i][i] = 1;
		if (i+1<len && s[i] == s[i + 1])
			d[i][i + 1] = 3;
		else if(i+1<len)
			d[i][i + 1] = 2;
	}
	for (int i = 2; i < len; i++)
	{
		for (int j = 0; j < len; j++)
		{
			int k = j + i;
			if (k >= len)
				break;
			if (s[j] == s[k])
				d[j][k] = d[j+1][k] + d[j][k-1]  + 1;
			else
				d[j][k] = d[j + 1][k] + d[j][k - 1] - d[j + 1][k - 1];
		}
	}
	cout << d[0][len - 1];
}

