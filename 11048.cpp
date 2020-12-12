#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<string>
#include<math.h>
#include<fstream>
#include<memory.h>
#include <tuple>
#include<vector> 
using namespace std;

int arr[1001][1001];
int d[1001][1001];
int dx[3] = { 0,1,1 };
int dy[3] = { 1,0,1 };
int main(void) {


	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	memset(d, -1, sizeof(d));
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> arr[i][j];
		}
	}
	d[0][0] = arr[0][0];
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			for (int k = 0; k < 3; k++)
			{
				int nx = i + dx[k];
				int ny = j + dy[k];
				if (nx < n && ny < m)
				{
					d[nx][ny] = max(d[nx][ny], d[i][j] + arr[nx][ny]);
				}
			}

		}
	}

	cout << d[n - 1][m - 1];

}