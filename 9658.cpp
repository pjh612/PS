#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<stack>
#include<map>
#include<queue>
using namespace std;

int d[1001];
int main(void)
{
	int n;
	cin >> n;
	d[1] = 0;
	d[2] = 1;
	d[3] = 0;
	d[4] = 1;
	d[5] = 1;
	for (int i = 6; i <= n; i++)
	{
		if (d[i - 1] == 0)
			d[i] = 1;
		if (d[i - 3] == 0)
			d[i] = 1;
		if (d[i - 4] == 0)
			d[i] = 1;
	}
	if (d[n] == 1)
		cout << "SK";
	else
		cout << "CY";
}
