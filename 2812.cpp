#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<stack>
using namespace std;


int main(void)
{
	int n, k;
	cin >> n >> k;
	string s;
	cin >> s;
	stack<char> stk;
	stk.push(s[0]);
	for (int i = 1; i < s.size(); i++)
	{

		if (s[i] <= stk.top())
		{
			stk.push(s[i]);
		}
		else if (s[i] > stk.top())
		{
			while (k && !stk.empty() && stk.top() < s[i])
			{
				stk.pop();
				k--;
			}	
			stk.push(s[i]);
		}
	}
	while (k && !stk.empty())
	{
		stk.pop();
		k--;
	}
	vector<char> v;
	
	while (!stk.empty())
	{
		v.push_back(stk.top());
		stk.pop();
	}
	if (v.empty())
	{
		cout << 0;
	}
	else {
		for (int i = v.size() - 1; i >= 0; i--)
			cout << v[i];
	}
}
