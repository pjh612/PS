#include<iostream>
#include<algorithm>
using namespace std;


long long dp[31];
long long dp2[31];

long long a, b;
long long solution(int day)
{
	if (day == 1)
	{
		dp[1] = 1;
		return dp[1];
	}
	if (day == 2)
	{
		dp[2] = 0;
		return dp[2];
	}
	if (day == 3)
	{
		dp[3] = 1;
		return dp[3];
	}
	if (dp[day])
		return dp[day];
	return dp[day] = solution(day - 1) + solution(day - 2);
}

long long solution2(int day)
{
	if (day == 1)
	{
		dp2[1] = 0;
		return dp2[1];
	}
	if (day == 2)
	{
		dp[2] = 1;
		return dp[2];
	}
	if (day == 3)
	{
		dp[3] = 1;
		return dp[3];
	}
	if (dp2[day])
		return dp2[day];
	return dp2[day] = solution2(day - 1) + solution2(day - 2);
}
int main()
{
	int d, k;
	cin >> d >> k;
	long long a= solution(d);
	long long b= solution2(d);
	for (int i = 1; i <= k; i++)
	{
		for (int j = 1; j <= k; j++)
		{
			if (a * i + j * b == k) {
				cout << i << '\n' << j;
				return 0;
			}
		}
	}
}
