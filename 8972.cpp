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


char arr[101][101];
int rc[101][101];
int dx[9] = { 1,1,1,0,0,0,-1,-1 ,-1 };
int dy[9] = { -1,0,1,-1,0,1,-1,0,1 };
queue<pair<int, int >> q;
queue<pair<int, int >> q2;
int main(void) {

	int nowx = -1;
	int nowy = -1;
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int r, c;
	cin >> r >> c;
	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == 'I')
			{
				nowx = i;
				nowy = j;
			}
			else if (arr[i][j] == 'R') {
				q.push({ i,j });
				
			}
		}
	}
	string s;
	cin >> s;
	for (int l = 0; l < s.size(); l++) {
/*
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				cout << arr[i][j];

			}
			cout << '\n';
		}
		cout << '\n';*/

		arr[nowx][nowy] = '.';
		nowx +=dx[s[l] - '0'-1];
		nowy += dy[s[l] - '0'-1];
		if (arr[nowx][nowy] == 'R') {
		
			cout << "kraj " << l + 1;
			return 0;
		}
		else
		arr[nowx][nowy] = 'I';
		
;		while (!q.empty())
		{
			int x = q.front().first;
			int y = q.front().second;
			int dir = -1;
			int mindis = 987654321;
			q.pop();
			for (int j = 0; j < 9; j++)
			{
				if (j == 4)
					continue;
				int nx = x + dx[j];
				int ny = y + dy[j];

				if (mindis > abs(nowx - nx) + abs(nowy - ny))
				{
					mindis = abs(nowx - nx) + abs(nowy - ny);
					dir = j;

				}
				

			}
			if (arr[x + dx[dir]][y + dy[dir]] == 'I')
			{
				cout << "kraj " << l + 1;
				return 0;
			}
			
			
			arr[x][y] = '.';
			//cout << x << ',' << y << "->" << x + dx[dir] << ',' << y + dy[dir] << '\n';
			q2.push({ x + dx[dir],y + dy[dir] });
			
			
		}

while (!q2.empty())
{
	
	//cout << q2.front().first << ',' << q2.front().second << '\n';
		arr[q2.front().first][q2.front().second] = 'R';
		rc[q2.front().first][q2.front().second]++;
		q2.pop();
	
	
}

for (int i = 0; i < r; i++)
{
	for (int j = 0; j < c; j++)
	{
		if (rc[i][j] >= 2)
		{
			rc[i][j] = 0;
			arr[i][j] = '.';
		}
		else { rc[i][j] = 0; }
	}
}
//for (int i = 0; i < r; i++)
//{
//	for (int j = 0; j < c; j++)
//	{
//		cout << arr[i][j];
//
//	}
//	cout << '\n';
//}
//cout << '\n';


		/*for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				if (rc[i][j] >= 2 && arr[i][j] == 'R')
				{
					rc[i][j] = 0;
					arr[i][j] = '.';
				}
			}
		}*/

		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				if (arr[i][j]=='R')
				{
					q.push({ i,j });
				}
			}
		}
		
	}

	for (int i = 0; i < r; i++)
	{
		for (int j = 0; j < c; j++)
		{
			cout << arr[i][j];

		}
		cout << '\n';
	}
}
