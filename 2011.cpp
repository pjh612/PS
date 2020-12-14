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


int d[5001];
int main(void) {


	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	string s;
	cin >> s;
	if (s[0] >= '1' && s[0] <= '9') {
		d[0] = 1;
	}
	if ((s[0]=='1' && s[1]>='0' && s[1]<='9' )|| (s[0]=='2' && s[1]>='0' && s[1]<='6'))
	{
		d[1] = 1;
	}
	if (d[0]==1 &&(s[1] >= '1' && s[1] <= '9'))
	{
		d[1] += 1;
	}
	for (int i = 2; i < s.size(); i++)
	{
		if ((s[i-1] == '1' && s[i] >= '0' && s[i] <= '9') || (s[i-1] == '2' && s[i] >= '0' && s[i] <= '6')) {
			d[i] += d[i - 2] % 1000000;
		}
		if(s[i]>='1' && s[i]<='9')
		d[i] += d[i - 1] % 1000000;
	}
	/*for (int i = 0; i < s.size(); i++)
	{
		cout << d[i] << '\n';

	}*/
	cout<<d[s.size() - 1]% 1000000;
}
