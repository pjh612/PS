#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<memory.h>
#include<math.h>

using namespace std;

vector<int> v;
int arr[1000001];
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int N;
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
	}
	v.push_back(arr[0]);
	for (int i = 1; i < N; i++)
	{
		if (v.back() < arr[i])
			v.push_back(arr[i]);
		else if (v.back() > arr[i])
		{
			auto idx = lower_bound(v.begin(), v.end(), arr[i]);
			*idx = arr[i];
		}
	}
	cout << v.size();
}
