#include<iostream>
#include<algorithm>
using namespace std;


int arr[101];
int d[101][1001];
int main()
{
	int n, s, m;
	cin >> n >> s >> m;
	for (int i = 1; i <= n; i++)
	{
		cin >> arr[i];
	}
	
	d[0][s] = 1;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 0; j <= m; j++)
		{
			if (d[i - 1][j])
			{
				if(j+arr[i]<=m)
				d[i][j + arr[i]] = 1;
				if(j-arr[i]>=0)
				d[i][j - arr[i]] = 1;
			}
		}
	}

	
	int ans = -1;
	for (int i = 0; i <= m; i++)
	{
		if (d[n][i])
			ans = i;
	}
	cout << ans;
}