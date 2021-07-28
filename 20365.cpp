#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<stack>
#include<map>
#include<memory.h>
#include<queue>
using namespace std;

int arr[500001];
int arr2[500001];
int main(void)
{
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);

	int n;
	cin >> n;
	string s;
	cin >> s;
	arr[0] = 1;
	char pre = s[0];
	if (s[0] == 'R')
		arr[0]++;
	for (int i = 1; i < s.size(); i++)
	{
		if (s[i] == 'B')
			arr[i] = arr[i - 1];
		else if (s[i] == 'R')
		{
			if (s[i] != pre) {
				arr[i] = arr[i - 1] + 1;

			}
			else
				arr[i] = arr[i - 1];
		}
		pre = s[i];
	}
	arr2[0] = 1;
	char pre2 = s[0];
	if (s[0] == 'B')
		arr2[0]++;
	for (int i = 1; i < s.size(); i++)
	{
		if (s[i] == 'R')
			arr2[i] = arr2[i - 1];
		else if (s[i] == 'B')
		{
			if (s[i] != pre2) {
				arr2[i] = arr2[i - 1] + 1;

			}
			else
				arr2[i] = arr2[i - 1];
		}
		pre2 = s[i];
	}
	/*for (int i = 0; i < n; i++)
	{
		cout << arr2[i] << ' ';
	}
	cout << '\n';
	cout << arr[n - 1] << ' ' << arr2[n - 1]<<'\n';*/
	cout << min(arr[n - 1], arr2[n - 1]);
}