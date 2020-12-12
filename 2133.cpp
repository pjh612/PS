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

int d[31];
int main(void) {


	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int n;
	cin >> n;
	d[0] = 1;
	d[1] = 0;
	d[2] = 3;
	d[3] = 0;
	d[4] = 11;

	for (int i = 6; i <= 30; i++)
	{
		d[i] = d[i - 2] * 3;
		for (int j = 4; j <= i - 2; j += 2)
		{
			d[i] += d[i - j] * 2;
		}
		d[i] += 2;
	}
	if (n % 2)
	{
		cout << "0\n";
		return 0;
	}
	cout << d[n];
}