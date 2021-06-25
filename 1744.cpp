#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<map>
using namespace std;

vector<int> p;
vector<int> neg;
int zero;
int main(void)
{
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int a;
		cin >> a;
		if (a > 0)
			p.push_back(a);
		else if (a == 0)
			zero++;
		else
			neg.push_back(a);
	}
	
	sort(neg.begin(), neg.end(),greater<int>());
	sort(p.begin(), p.end());
	int ans = 0;

	for (int i = p.size() - 1; i >= 1; i -= 2)
	{
		if(p[i] + p[i-1] > p[i] * p[i-1])
			ans += p[i] + p[i - 1];
		else
			ans += p[i] * p[i - 1];
	}
	if (p.size() % 2 == 1)
		ans += p[0];
	for (int i = neg.size() -1; i >=1; i -= 2)
	{
		ans += neg[i] * neg[i-1];
		neg.pop_back();
		neg.pop_back();
	}
	if (!neg.empty() && zero)
		neg.pop_back();
	else if (!neg.empty() && !zero)
		ans += neg[0];
	cout << ans;
}
