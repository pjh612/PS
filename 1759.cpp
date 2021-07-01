#include <iostream>
#include<vector>
#include<algorithm>
#include<math.h>
#include<queue>
#include<memory.h>
using namespace std;

int l, c;
char arr[17];
vector<char> selected;
bool visit[17];
void solution(int idx, int cnt, int max);
int main() {
	cin >> l >> c;

	for (int i = 0; i < c; i++)
	{
		cin >> arr[i];
	}
	sort(arr, arr + c);
	solution(0, 0, l);
}

void solution(int idx, int cnt, int max)
{
	if (cnt == max)
	{

		//순서 체크
		for (int i = 0; i < max - 1; i++)
		{
			if (selected[i] > selected[i + 1])
				return;
		}
		int chk1 = 0, chk2 = 0;
		for (int i = 0; i < max; i++)
		{
			if (selected[i] == 'a' || selected[i] == 'e' || selected[i] == 'i' || selected[i] == 'o' || selected[i] == 'u')
				chk1++;
			else
				chk2++;
		}
		if (chk1 <= 0 || chk2 < 2)
			return;
		for (int i = 0; i < max; i++)
		{
			cout << selected[i];

		}
		cout << '\n';
		return;
	}

	for (int i = idx; i < c; i++)
	{
		if (visit[i] == 0)
		{
			visit[i] = 1;
			selected.push_back(arr[i]);
			solution(i + 1, cnt + 1, max);
			visit[i] = 0;
			selected.pop_back();
		}
	}
}