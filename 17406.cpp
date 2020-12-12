#define _CRT_SECURE_NO_WARNINGS
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

int arr[51][51];
int n, m, k;
int arr2[51][51];
void frotate(int r, int c, int s);
void C(int);
bool visit[6];
int ans = 98765421;
struct S {
	int r, c, s;
};
	vector<S> v;
	vector<S> vc;
int main(void) {

	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);


	cin >> n >> m >> k;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= m; j++) {
			cin >> arr[i][j];
			arr2[i][j] = arr[i][j];
		}
	}
	for (int i = 0; i < k; i++)
	{
		int r, c, s;
		cin >> r >> c >> s;
		S news;
		news.r = r;
		news.c = c;
		news.s = s;
		v.push_back(news);
	}
	C(v.size());

	cout << ans;
}

void C(int max) {

	if (vc.size() == max)
	{
		for (int i = 0; i < vc.size(); i++)
		{
	
			frotate(vc[i].r,vc[i].c,vc[i].s);
		}
	
		for (int i = 1; i <= n; i++)
		{
			int tmp = 0;
			for (int j = 1; j <= m; j++)
			{
				tmp += arr[i][j];

			}
			ans = min(tmp, ans);

		}
		for (int i = 1; i <= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				arr[i][j] = arr2[i][j];
			}
		}
		return;
	}
	for (int i =0; i < v.size(); i++)
	{
		if (visit[i] == 0) {
			visit[i] = 1;
			vc.push_back(v[i]);
			C(max);
			vc.pop_back();
			visit[i] = 0;
		}
	}
}


void frotate(int r, int c, int s)
{
	if (s == 0)
		return;
	int tmp = arr[r - s][c + s];
	for (int i = c +s; i>c-s; i--)
	{
		
		arr[r - s][i] = arr[r - s][i - 1];
	}

	for (int i = r - s; i < r + s; i++)
	{
	
		arr[i][c - s] = arr[i + 1][c - s];
	}
	for (int i = c - s; i < c + s; i++)
	{
	
		arr[r + s][i] = arr[r + s][i + 1];
	}
	for (int i = r + s; i > r - s; i--)
	{
	
		arr[i][c + s] = arr[i - 1][c + s];

	}

	arr[r - s + 1][c + s] = tmp;

	frotate(r, c, s - 1);
}
