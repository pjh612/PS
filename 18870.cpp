#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<stack>
#include<map>
using namespace std;

vector<int> v;
int arr2[1000001];
map<int, int> m;
int main(void)
{
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int a;
		cin >> a;
		v.push_back(a);
		arr2[i] = v[i];
	}
	sort(v.begin(), v.end());
	v.erase(unique(v.begin(), v.end()), v.end());

	
	for (int i = 0; i < n; i++)
	{
		cout << lower_bound(v.begin(), v.end(), arr2[i]) - v.begin()<<' ';
	}
}
