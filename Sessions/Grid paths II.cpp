#include <bits/stdc++.h>
using namespace std;
#define int long long
const int MOD = 1e9 + 7;
const int MAX = 2000005;
int fact[MAX], invFact[MAX];
int modExp(int a, int b) {
    int res = 1;
    while (b) {
        if (b & 1) res = res * a % MOD;
        a = a * a % MOD;
        b >>= 1;
    }
    return res;
}
void precompute() {
    fact[0] = 1;
    for (int i = 1; i < MAX; i++)
        fact[i] = fact[i-1] * i % MOD;
    invFact[MAX-1] = modExp(fact[MAX-1], MOD-2);
    for (int i = MAX-2; i >= 0; i--)
        invFact[i] = invFact[i+1] * (i+1) % MOD;
}
int nCr(int n, int r) {
    if (r < 0 || r > n) return 0;
    return fact[n] * invFact[r] % MOD * invFact[n-r] % MOD;
}
int32_t main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int n, m;
    cin >> n >> m;
    vector<pair<int,int>> points(m+1);
    for (int i = 0; i < m; i++)
        cin >> points[i].first >> points[i].second;
    points[m] = {n, n};
    sort(points.begin(), points.end());
    precompute();
    vector<int> dp(m+1);
    for (int i = 0; i <= m; i++) {
        int y = points[i].first;
        int x = points[i].second;
        dp[i] = nCr(y + x - 2, y - 1);
        for (int j = 0; j < i; j++) {
            int y2 = points[j].first;
            int x2 = points[j].second;
            if (x2 <= x && y2 <= y) {
                int ways = nCr((y-y2)+(x-x2), (y-y2));
                dp[i] = (dp[i] - dp[j] * ways % MOD + MOD) % MOD;
            }
        }
    }
    cout << dp[m] << "\n";
}