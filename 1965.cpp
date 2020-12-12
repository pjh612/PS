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

int arr[1001];


int main(void) {


	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int n;
	cin >>n;
	for(int i=0;i<n;i++)
		{
		cin >> arr[i];
	}
	vector<int> LIS;
	LIS.push_back(arr[0]);
	for (int i = 1; i < n; i++)
	{
		if (arr[i] > LIS.back())
		{
			LIS.push_back(arr[i]);

		}
		else
		{
			auto idx = lower_bound(LIS.begin(), LIS.end(),arr[i]);
			*idx = arr[i];
		}
	}
	cout << LIS.size();
}