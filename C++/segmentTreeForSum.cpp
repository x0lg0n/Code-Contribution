#include <bits/stdc++.h>
using namespace std;
 
#define fastio() ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL)
#define MOD 1000000007
#define MOD1 998244353
#define INF 1e18
#define endl "\n"
#define pb push_back
#define ppb pop_back
#define mp make_pair
#define ff first
#define ss second
#define PI 3.141592653589793238462
#define set_bits __builtin_popcountll
#define sz(x) ((int)(x).size())
#define all(x) (x).begin(), (x).end()
#define mem(a, b) memset(a, b, sizeof(a))
#define int long long int
 
 
typedef long long ll;
typedef unsigned long long ull;
typedef long double lld;
 
// segmentTree

class segmentTree{
public:
    vector<int> tree; 
    int identity = 0; 
    int N; 

    int merge(int a, int b){
        return a + b;
    }
    segmentTree(int size, int identity){
        N = size; 
        this->identity = identity;  
        tree.assign(4 * N, identity);       
    }   


    // update query 

    void update(int qIdx, int val){
        

        // lambda function 
        function<void(int, int, int)> f = [&](int tIdx, int tL, int tR){

            // base case
            if(tL == tR){
                tree[tIdx] = val; 
                return;
            }

            int tM = tL + (tR - tL) / 2; 

            // conditions

            if(tL <= qIdx && qIdx <= tM){
                // go left
                f(2 * tIdx + 1, tL, tM);
            }
            else{
                // go right
                f(2 * tIdx + 2, tM + 1, tR);
            }

            tree[tIdx] = merge(tree[2 * tIdx + 1], tree[2 * tIdx + 2]);
        };

        f(0, 0, N - 1);
    }


    int query(int l, int r){

        function<int(int, int , int)> f = [&](int tIdx, int tL, int tR){

            // no overlap

            if(tR < l || r < tL){
                return identity;
            }

            // complete overlap

            if(l <= tL && tR <= r   ){
                return tree[tIdx];
            }

            // partial overlap
            int tM = tL + (tR - tL) / 2;
            return merge(f(2 * tIdx + 1, tL, tM), f(2 * tIdx + 2, tM + 1, tR));
        };

        return f(0, 0, N - 1);
    }
};
void solve() {
    int n, q; 
    cin >> n >> q; 
    
    segmentTree st(n, 0);

    for(int i = 0; i < n; i++){
        int x; cin >> x;
        st.update(i, x);
    }
    while(q--){
        int t, l, r;
        cin >> t >> l >> r; 
        if(t == 1){
            st.update(l, r);
        }
        else
            cout << st.query(l, r - 1) << endl;
    }
    

}
 
signed main() {
    fastio();
    int t = 1;
    while (t--) {
        solve();
    }
    return 0;
}
