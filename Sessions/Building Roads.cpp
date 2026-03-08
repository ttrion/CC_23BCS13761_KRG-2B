#include <bits/stdc++.h>
using namespace std;

vector<int> adj[100001];
bool visited[100001];

void dfs(int city) {
    visited[city] = true;

    for (int next : adj[city]) {
        if (!visited[next]) {
            dfs(next);
        }
    }
}

int main() {

    int n, m;
    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;

        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    vector<int> componentCity;

    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            componentCity.push_back(i);
            dfs(i);
        }
    }

    cout << componentCity.size() - 1 << endl;

    for (int i = 1; i < componentCity.size(); i++) {
        cout << componentCity[i-1] << " " << componentCity[i] << endl;
    }

    return 0;
}
