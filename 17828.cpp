#include <string>
#include <vector>
#include<iostream>
#include<memory.h>
#include<map>
#include<float.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	vector<char> v;
	int n, x, cur;
	cin >> n >> x;

	for (int i = 0; i < n; i++)
		v.push_back('A');
	cur = n;
	int idx = n - 1;
	if (n * 26 < x || n > x)
	{
		cout << "!";
		return (0);
	}
	while (idx >= 0)
	{
		if (x - (idx + 1) - 26 >= 0)
		{
			v[idx] = 'Z';
			idx--;
			x -= 26;
		}
		else
		{
			v[idx] = 'A' + x - (idx + 1);
			cur += x - (idx + 1);
			break;
		}
	}

	for (int i = 0; i < v.size(); i++)
		cout << v[i];
}

