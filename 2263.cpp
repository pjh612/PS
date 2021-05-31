#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<memory.h>
#include<math.h>

using namespace std;

int in[100001];
int post[100001];
int idx[100001];
void pre(int in_s, int in_e, int post_s, int post_e);

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> in[i];
		idx[in[i]] = i;
	}
	for (int i = 0; i < n; i++)
		cin >> post[i];
	pre(0, n - 1, 0, n - 1);

}
void pre(int in_s, int in_e, int post_s, int post_e)
{
	
	if (post_s > post_e ||in_s > in_e)
		return ;

	int i = idx[post[post_e]];
	cout << in[i] << ' ';
	int left = i - in_s;
	pre(in_s, i - 1, post_s, post_s + left - 1);
	pre(i + 1, in_e, post_s +  left, post_e - 1);


}


