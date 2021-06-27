#include <iostream>
#include<vector>
#include<algorithm>
#include<math.h>
#include<queue>

using namespace std;

long long d[1000001];
int main() {
	int T;
	cin >> T;

	d[1] = 1;
	d[2] = 2;
	d[3] = 4;
	d[4] = 7;
	for (int i = 5; i <= 1000000; i++)
	{
		d[i] = (d[i - 1] + d[i - 2] + d[i - 3])%1000000009;
	}
	while (T--)
	{
		int n;
		cin >> n;
		cout << d[n]<<'\n';
	}
}
