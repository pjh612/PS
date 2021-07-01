#include <iostream>
#include<vector>
#include<algorithm>
#include<math.h>
#include<queue>
#include<memory.h>
using namespace std;

int n, m;
int arr[301][301];
int arr2[301][301];
bool visit[301][301];
int dx[4] = { 0,1,0,-1 };
int dy[4] = { 1,0,-1,0 };
void dfs(int x, int y);
int main() {

	cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
			cin >> arr[i][j];
	}
	int year = 0;
	while (1)
	{
		int divide = 0;
		memset(arr2, 0, sizeof(arr2));
		memset(visit, 0, sizeof(visit));
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (visit[i][j] == 0 && arr[i][j] >= 1)
				{
					divide++;
					dfs(j, i);
				}
			}
		}
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (arr[i][j] - arr2[i][j] >= 0)
					arr[i][j] -= arr2[i][j];
				else
					arr[i][j] = 0;
			}
		}
		if (divide == 0)
		{
			cout << 0;
			return 0;
		}
		if (divide >= 2)
		{
			cout << year;
			return 0;
		}
		year++;
	}
}

void dfs(int x, int y)
{
	visit[y][x] = 1;
	int cnt = 0;
	
	for (int i = 0; i < 4; i++)
	{
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx >= 0 && ny >= 0 && ny < n && nx < m && arr[ny][nx] == 0)
			cnt++;
	}
	arr2[y][x] = cnt;
	for (int i = 0; i < 4; i++)
	{
		int nx = x + dx[i];
		int ny = y + dy[i];
		if(nx>=0 && ny>=0 && ny<n && nx< m && visit[ny][nx] == 0 && arr[ny][nx] != 0)
			dfs(nx, ny);
	}
}