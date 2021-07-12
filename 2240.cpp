#include <iostream>
#include<vector>
#include<algorithm>
#include<math.h>
#include<queue>
#include<memory.h>
using namespace std;

int d[1001][32][3];
int arr[1001];
int main() {
	int T, W;
	cin >> T >> W;
	for (int i = 1; i <= T; i++)
	{
		cin >> arr[i];
	}
	
	for (int i = 1; i <= T; i++)
	{
		for (int j = 0; j <= W; j++)
		{
			if (arr[i] == 1)
			{
				if (j == 0)
					d[i][0][1] = d[i - 1][0][1] + 1;
				else
				{
					d[i][j][1] = max(d[i - 1][j][1] + 1, d[i - 1][j - 1][2] + 1);
					d[i][j][2] = max(d[i - 1][j][2], d[i - 1][j - 1][1]);
				}
			}
			else
			{
				if (j == 0)
					d[i][0][1] = d[i - 1][0][1];
				else {
					d[i][j][1] = max(d[i - 1][j][1], d[i - 1][j - 1][2]);
					d[i][j][2] = max(d[i - 1][j][2] + 1, d[i - 1][j - 1][1] + 1);
				}
			}
		}
	}
	int ans = 0;
	for (int i = 0; i <= W; i++)
	{
		ans = max(d[T][i][1], d[T][i][2]);
	}
	cout << ans;
}

