#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<stack>
#include<map>
#include<queue>
using namespace std;

int d[10001][4];
int main(void)
{
	int T;
	cin >> T;

	d[1][1] = 1;
	d[2][1] = 1;
	d[2][2] = 1;
	d[3][1] = 1;
	d[3][2] = 1;
	d[3][3] = 1;

	for (int i = 4; i <= 10000; i++)
	{
		d[i][1] = d[i - 1][1];
		d[i][2] = d[i - 2][1] + d[i - 2][2];
		d[i][3] = d[i - 3][1] + d[i - 3][2] + d[i - 3][3];
	}
	while (T--)
	{
		int n;
		cin >> n;
		cout << d[n][1] + d[n][2] + d[n][3] << '\n';
	}
}
