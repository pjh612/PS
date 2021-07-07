#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<stack>
#include<map>
#include<queue>
using namespace std;

int GCD(int a, int b) {
	if (a % b == 0)
		return b;

	return GCD(b, a % b);
}

int main(void)
{
	int n, m;
	cin >> n >> m;
		cout<<m-GCD(n, m)
}
