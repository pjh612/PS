#include <iostream>
#include<vector>
#include<algorithm>
#include<math.h>
#include<queue>

using namespace std;

int main() {
	int n, a, b;
	cin >> n >> a >> b;
	int cnt = 0;
	while (a != b)
	{
		if (a % 2)
		{
			a /= 2;
			a += 1;
		}
		else
		{
			a /= 2;
		}
		if (b % 2)
		{
			b /= 2;
			b += 1;
		}
		else
			b /= 2;
		cnt++;
	}
	cout << cnt;
}
