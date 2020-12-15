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


int arr[13][13];
struct S
{
	int x;
	int y; 
	int dir;
	bool floor;
};

int dx[5] = {0, 0,0,-1,1 };
int dy[5] = {0, 1,-1,0,0 };
vector<int > v[13][13];
S h[11];

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int n, k;
	cin >> n >> k;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
			cin >> arr[i][j];
	}

	for (int i = 0; i < k; i++)
	{
		int a, b, c ;
		cin >> a >> b >> c;
		S s;

		s.dir = c;
		s.x = a;
		s.y = b;
		s.floor = true;
		v[a][b].push_back(i);
		h[i] = s;
	}
	int turn = 0;
	//순서대로 이동시킨다
	while (1) {

		for (int i = 0; i < k; i++)
		{
			if (v[h[i].x][h[i].y].size() >= 4)
			{
				cout << turn;
				return 0;
			}
		}
		turn++;
		if (turn > 1000)
		{
			cout << "-1";
			return 0;
		}
		for (int i = 0; i < k; i++)
		{
			if (h[i].floor == true)
			{
				int x = h[i].x;
				int y = h[i].y;
				int dir = h[i].dir;
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx >= 1 && ny >= 1 && nx <= n && ny <= n && arr[nx][ny] != 2)
				{
					if (arr[nx][ny] == 0)
					{
						h[v[x][y].front()].floor = false;
						for (int j  = 0;j < v[x][y].size(); j++)
						{
							h[v[x][y][j]].x = nx;
							h[v[x][y][j]].y = ny;
							v[nx][ny].push_back(v[x][y][j]);
						}
						h[v[nx][ny].front()].floor = true;
						v[x][y].clear();
					}
					else if (arr[nx][ny] == 1)
					{
						h[v[x][y].front()].floor = false;
						h[v[x][y].back()].floor = true;
						reverse(v[x][y].begin(), v[x][y].end());
						
						for (int j = 0; j < v[x][y].size(); j++)
						{
							h[v[x][y][j]].x = nx;
							h[v[x][y][j]].y = ny;
						
							v[nx][ny].push_back(v[x][y][j]);
						}
						for (int j = 1; j < v[nx][ny].size(); j++)
						{
							h[v[nx][ny][j]].floor = false;
						}
						v[x][y].clear();
					}
				
				}
				else if (nx <= 0 || ny <= 0 || nx > n || ny > n || arr[nx][ny] == 2)
				{
					
					int ndir;
					if (dir == 1)
						ndir = 2;
					else if (dir == 2)
						ndir = 1;
					else if (dir == 3)
						ndir = 4;
					else if (dir == 4)
						ndir = 3;
					
					int nnx = x + dx[ndir];
					int nny = y + dy[ndir];
					if (nnx <= 0 || nny <= 0 || nnx > n || nny > n)
						continue;
					h[v[x][y].front()].dir = ndir;
				
					if (arr[nnx][nny] == 0)
					{
						h[v[x][y].front()].floor = false;
						for (int j = 0; j < v[x][y].size(); j++)
						{
							h[v[x][y][j]].x = nnx;
							h[v[x][y][j]].y = nny;
							v[nnx][nny].push_back(v[x][y][j]);
						}
						h[v[nnx][nny].front()].floor = true;
						v[x][y].clear();
					}
					else if (arr[nnx][nny] == 1)
					{
						h[v[x][y].front()].floor = false;
						h[v[x][y].back()].floor = true;
						reverse(v[x][y].begin(), v[x][y].end());
						
						for (int j = 0; j < v[x][y].size(); j++)
						{
							h[v[x][y][j]].x = nnx;
							h[v[x][y][j]].y = nny;
							v[nnx][nny].push_back(v[x][y][j]);
							
						}
						for (int j = 1; j < v[nnx][nny].size(); j++)
						{
							h[v[nnx][nny][j]].floor = false;
						}
						
					
						v[x][y].clear();
					}
					
				}
			}
		}

		
	/*	for (int j = 0; j < k; j++)
		{
			cout << j << "번말 위치:" << h[j].x << ',' << h[j].y << " 방향:" << h[j].dir << ", " << "바닥:" << h[j].floor << '\n';
		}
		cout << '\n';*/

	}

}
