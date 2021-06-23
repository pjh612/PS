#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<map>
using namespace std;

int chk[26];
int main(void)
{
	int n;
	int ans = 0;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		reverse(s.begin(),s.end());
		int size = 1;
		for (int j = 0; j < s.size(); j++)
		{
			chk[s[j] - 'A'] += size;
			size *= 10;
		}
		
	}
	sort(chk, chk + 26);
	int k = 9;
	for (int j = 25; j >= 0; j--)
	{
		if (chk[j] == 0)
			break;
		ans += chk[j] * k;
		k--;
	}
	cout << ans;
}
