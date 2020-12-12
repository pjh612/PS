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

int arr[501][501];
int d[501][501];
int visit[501][501];
int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };
int dp(int x, int y);
int n, m;
int main(void) {


	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
			cin >> arr[i][j];
	
	}
	memset(d, -1, sizeof(d));
	d[0][0] = 1;
	
	int ans = dp(n - 1, m - 1);
	
	cout << (ans==-1?0:ans)<<'\n';
	/*for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
			cout << d[i][j] << ' ';
		cout << '\n';
	}*/
}


int dp(int x, int y)
{
	//cout << "x=" << x << ", y=" << y << " =" << d[x][y] << '\n';
	if (x == 0 && y == 0)
		return 1;
	if (d[x][y]!=-1)
		return d[x][y];
	else {
		int w = 0;
		d[x][y] = 0;
		for (int i = 0; i < 4; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[x][y]<arr[nx][ny])
			{
			
				w += dp(nx, ny);
				
			}
		}
		d[x][y] = w;
		return w;
	}

}