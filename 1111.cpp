#include <string>
#include <vector>
#include<iostream>
#include<memory.h>
#include<map>
#include<algorithm>
#include<queue>
#include<set>
#include<math.h>
using namespace std;
int arr[51];
int main()
{
	ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
	if (n <= 2)
	{
		if (n == 1)
			cout << "A";
		else if (n == 2)
		{
			if (arr[0] == arr[1])
				cout << arr[0];
			else
				cout << "A";
		}
		return (0);
	}
	int tmp = arr[1] - arr[0];
	int tmp2 = arr[2] - arr[1];
	int a;
	if (tmp != 0)
		a = tmp2 / tmp;
	else
		a = 0;
	int b = arr[1] - a *arr[0];
	for (int i = 2; i < n; i++)
	{
		if (arr[i] != arr[i-1] *a +b)
		{
			cout << "B";
			return (0);
		}
	}
	cout << arr[n - 1] *a +b;
	
}

