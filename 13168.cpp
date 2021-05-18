#include <string>
#include <vector>
#include<iostream>
#include<memory.h>
#include<map>
#include<float.h>
using namespace std;

int main()
{
	vector<char> v;
	int n,x, cur;
	cin >> n>> x;

	for(int i=0;i<n;i++)
		v.push_back('A');
	cur = n;
	int idx = n - 1;
	while (idx >=0 && cur != x)
	{
		if (cur < x)
		{
			v[idx]++;
			cur++;
			if (v[idx] == 'Z')
				idx--;
		}
	}
	for (int i = 0; i < v.size(); i++)
		cout << v[i];
}

