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
int pre[1001];
int in[1001];

void func(int l, int r, int n)
{
	if (l > r)
		return;
	if (l == r)
	{
		cout << pre[n]<<' ';
		return; 
	}
	int idx = in[pre[n]];
	func(l, idx - 1, n + 1);
	func(idx + 1, r, n + idx - l + 1);
	cout << pre[n]<<' ';
}
int main(void) {

	
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	int T;
	cin >> T;
	while(T--){
		int n;
		cin >> n;
		for (int i = 0; i < n; i++)
		{
			cin >> pre[i];
		}
		for (int i = 0; i < n; i++)
		{
			int tmp;
			cin >> tmp;
			in[tmp]=i;
		}
		func(0, n - 1, 0);
		cout << '\n';
	}
}