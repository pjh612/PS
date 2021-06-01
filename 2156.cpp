#include <iostream>
#include<vector>
#include<algorithm>
#include<math.h>
#include<queue>
using namespace std;

int d[10001][3];
int arr[10001];
int main() {
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	int n;
	cin >> n;
	
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
	
	int ans = 0;
	d[0][1] = arr[0];
	d[1][0] = arr[0];
	d[1][1] = arr[1];
	d[1][2] = arr[0] + arr[1];
	ans = d[1][2];
	
	for (int i = 2; i < n; i++)
	{
		d[i][0] = max(d[i][0], d[i - 1][2]);
		d[i][0] = max(d[i][0],max(d[i - 1][0], d[i - 1][1]));
		d[i][1] = max(d[i][1],d[i-1][0]+arr[i]);
		d[i][2] = d[i - 1][1] + arr[i];
		ans = max(ans, d[i][0]);
		ans = max(ans, d[i][1]);
		ans = max(ans, d[i][2]);
	}

	cout << ans;
}

