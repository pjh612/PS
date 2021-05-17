#include <string>
#include <vector>
#include<iostream>
#include<memory.h>
#include<map>
#include<float.h>
using namespace std;
vector<string> tour;
map<string, int> cities_num;
double arr[101][101];
double arr2[101][101];
double d[101][101];
double d2[101][101];
int main()
{
	int n, r, m, k;
	cin >> n >> r;
	for (int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		cities_num[s] = i + 1;
	}
	for (int i = 1; i < 101; i++)
	{
		for (int j = 1; j < 101; j++)
		{
			if (i == j)
			{
				arr[i][j] = 0;
				arr2[i][j] = 0;
			}
			else
			{
				arr[i][j] = DBL_MAX;
				arr2[i][j] = DBL_MAX;
			}
		}
	}
	cin >> m;
	for (int i = 0; i < m; i++)
	{
		string s;
		cin >> s;
		tour.push_back(s);
	}
	cin >> k;
	for (int i = 0; i < k; i++)
	{
		string train, f, t;
		double c;
		cin >> train >> f >> t >> c;
		if (train == "Mugunghwa" || train == "ITX-Saemaeul" || train == "ITX-Cheongchun" || train == "S-Train" || train == "V-Train")
		{
			if (train == "S-Train" || train == "V-Train")
			{
				if (arr2[cities_num[f]][cities_num[t]] > c / 2.0)
					arr2[cities_num[f]][cities_num[t]] = c / 2.0;
				if (arr2[cities_num[t]][cities_num[f]] > c / 2.0)
					arr2[cities_num[t]][cities_num[f]] = c / 2.0;
			}
			else
			{
				arr2[cities_num[f]][cities_num[t]] = 0;
				arr2[cities_num[t]][cities_num[f]] = 0;
			}
		}
		else
		{
			if (arr2[cities_num[f]][cities_num[t]] > c)
				arr2[cities_num[f]][cities_num[t]] = c;
			if (arr2[cities_num[t]][cities_num[f]] > c)
				arr2[cities_num[t]][cities_num[f]] = c;
		}
		if (arr[cities_num[f]][cities_num[t]] > c)
			arr[cities_num[f]][cities_num[t]] = c;
		if (arr[cities_num[t]][cities_num[f]] > c)
			arr[cities_num[t]][cities_num[f]] = c;
	}
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			d[i][j] = arr[i][j];
			d2[i][j] = arr2[i][j];
		}
	}
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			for (int k = 1; k <= n; k++)
			{
				if (d[j][k] > d[j][i] + d[i][k])
					d[j][k] = d[j][i] + d[i][k];
				if (d2[j][k] > d2[j][i] + d2[i][k])
					d2[j][k] = d2[j][i] + d2[i][k];
			}
		}
	}

	/*for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
			cout << d[i][j] << "   ";
		cout << '\n';
	}*/
	double c1 = 0, c2 = 0;
	for (int i = 1; i < tour.size(); i++)
	{
		int from = cities_num[tour[i - 1]];
		int to = cities_num[tour[i]];
		c1 += d[from][to];
		c2 += d2[from][to];
	}
	//cout << c1 << ' ' << c2+r<<'\n';
	if (c2 + r < c1)
		cout << "Yes";
	else
		cout << "No";
}

