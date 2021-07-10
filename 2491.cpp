#include<iostream>
#include<algorithm>
using namespace std;


int arr[100001];
int d[100001];
int d2[100001];
int main()
{
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	for (int i = 0; i < n; i++)
	{
		d[i] = 1;
		d2[i] = 1;
	}
	int ans = 1;
	for (int i = 1; i < n; i++)
	{
		if (arr[i] >= arr[i - 1])
		{
			d[i] = d[i - 1] + 1;
			ans = max(ans, d[i]);
		}
	}
	for (int i = 1; i < n; i++)
	{
		if (arr[i] <= arr[i - 1])
		{
			
			d2[i] = d2[i - 1] + 1;
			ans = max(ans, d2[i]);
		}
	}

	cout << ans;
}