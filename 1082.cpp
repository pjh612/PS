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

int arr[10];
vector<pair<int, int>> v;
int d[51];
string ds[51];
bool cmp(pair<int, int > a, pair<int, int > b)
{
	if (a.first > b.first)
		return true;
}
int main(void) {


	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n;
	cin >> n;
	int mc = 987654321;
	int mc_cost = 987654321;
	int mc2 = 987654321;
	int mc_cost2 = 987654321;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
		v.push_back({ i, arr[i]
			});
		if (mc_cost > arr[i] && i != 0) {
			mc_cost = arr[i];
			mc = i;
		}
		if (mc_cost2 > arr[i]) {
			mc_cost2 = arr[i];
			mc2 = i;
		}
	}
	sort(v.begin(), v.end());
	int k;
	cin >> k;
	//memset(d, -1, sizeof(d));

	for (int i = 1; i <= k; i++)
	{
		int tmp = i;
		int a = 1;
		if (tmp - mc_cost >= 0) {
			tmp -= mc_cost;
			ds[i] += '0' + mc;
		}
		for (int j = 0; j < tmp / mc_cost2; j++)
		{
			ds[i] += '0' + mc2;
		}

	}

	//	for (int i = 0; i <= k; i++)
	//{
	//	cout << i << "¿ø " << ds[i] << '\n';
	//}

	for (int i = 1; i <= k; i++)
	{
		int money = 0;
		for (int j = 0; j < ds[i].size(); j++)
		{
			money += arr[ds[i][j] - '0'];
		}

		int diff = i - money;

		for (int j = 0; j < ds[i].size(); j++)
		{
			for (int l = n - 1; l > 0; l--)
			{
				if (diff + arr[ds[i][j] - '0'] - arr[l] >= 0 && ds[i][j] - '0' < l)
				{
					diff = diff + arr[ds[i][j] - '0'] - arr[l];
					ds[i][j] = '0' + l;
					break;
				}
			}
		}
	}
	/*for (int i = 0; i <= k; i++)
	{
		cout << i << "¿ø " << ds[i] << '\n';
	}*/
	if (ds[k][0] == '0')
		cout << "0";
	else
		cout << ds[k];
}
