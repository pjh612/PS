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

int arr[52][52];
struct S
{
	int r;
	int c;
	int m;
	int s;
	int d;
};
queue<S> q;
int dx[8] = { -1,-1,0,1,1,1,0,-1 };
int dy[8] = { 0,1,1,1,0,-1,-1,-1 };

int main(void) {


	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int N, M, K;
	cin >> N >> M >> K;


	vector<pair<int, pair<int, int>>> v[52][52];
	for (int i = 0; i < M; i++)
	{
		int r, c, m, s, d;
		cin >> r >> c >> m >> s >> d;
		v[r][c].push_back({ m,{s,d} });


	}


	while (K--) {
		for (int i = 1; i <= N; i++)
		{
			for (int j = 1; j <= N; j++)
			{
				for (int k = 0; k < v[i][j].size(); k++)
				{
					S Fire;
					Fire.r = i;
					Fire.c = j;
					Fire.m = v[i][j][k].first;
					Fire.s = v[i][j][k].second.first;
					Fire.d = v[i][j][k].second.second;
					q.push(Fire);
				}
			}
		}
		for (int i = 1; i <= N; i++)
		{
			for (int j = 1; j <= N; j++)
				v[i][j].clear();
		}
		while (!q.empty())
		{
			int x = q.front().r;
			int y = q.front().c;
			int m = q.front().m;
			int s = q.front().s;
			int d = q.front().d;
			q.pop();
			int move = s % N;
			int nx = x + (dx[d] * move);
			int ny = y + (dy[d] * move);
			if (nx < 1)nx = N + nx;
			if (ny < 1)ny = N + ny;
			if (nx > N)nx = nx - N;
			if (ny > N)ny = ny - N;
			S Fire;
			Fire.r = nx;
			Fire.c = ny;
			Fire.m = m;
			Fire.s = s;
			Fire.d = d;
			v[nx][ny].push_back({ m,{s,d} });

		}

		for (int i = 1; i <= N; i++)
		{
			for (int j = 1; j <= N; j++)
			{
				if (v[i][j].size() >= 2)
				{
					int newm = 0;
					int news = 0;
					bool even = false;
					bool odd = false;

					for (int k = 0; k < v[i][j].size(); k++)
					{
						newm += v[i][j][k].first;
						news += v[i][j][k].second.first;
						if (v[i][j][k].second.second % 2 == 0)
						{
							even = true;
						}
						if (v[i][j][k].second.second % 2 == 1)
						{
							odd = true;
						}
					}
					newm = floor(newm / 5.0);

					news = floor((double)news / v[i][j].size());

					v[i][j].clear();
					if (newm != 0) {
						if (even && odd)
						{
							for (int l = 0; l < 4; l++)
							{

								v[i][j].push_back({ newm,{news,2 * l + 1} });
							}
						}
						else
						{
							for (int l = 0; l < 4; l++)
							{

								v[i][j].push_back({ newm,{news,2 * l} });
							}
						}
					}
				}
			}
		}

	}
	int ans = 0;
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			for (int k = 0; k < v[i][j].size(); k++)
			{
				ans += v[i][j][k].first;

			}
		}
	}
	cout << ans;
}