class Node
{
public:
    
};
 
 
Node merge(Node a, Node b)
{
   
}
 
// 0 based indexing
template<typename T>
class SegmentTree
{
public:
    v<T> tree;
    T identity;
    int N; // size of the given array
 
    SegmentTree(int n, T identity)
    {
        N = n;
        this->identity = identity;
        tree.assign(4 * N, identity);
    }
 
    // update a[qIdx] = val
    void update(int qIdx, T val)
    {
        function<void(int, int, int)> f = [&](int tIdx, int tL, int tR)
        {
            if(tL == tR)
            {
                tree[tIdx] = val;
                return;
            }
 
            int tM = (tL + tR) / 2;
            if(tL <= qIdx and qIdx <= tM)
            {
                f(2*tIdx + 1, tL, tM);
            }
            else
            {
                f(2*tIdx + 2, tM + 1, tR);
            }
 
            // leftChild: 2*tIdx + 1, tL, tM
            // rightChild: 2*tIdx + 2, tM + 1, tR
            tree[tIdx] = merge(tree[2*tIdx + 1], tree[2*tIdx + 2]);
        };
        f(0, 0, N - 1);
    }
 
    T query(int l, int r)
    {
        function<T(int, int, int)> f = [&](int tIdx, int tL, int tR)
        {
            // no overlap
            if(l > tR or r < tL)
            {
                return identity;
            }
            // complete overlap
            if(l <= tL and tR <= r)
            {
                return tree[tIdx];
            }
 
            // partial overlap
            int tM = (tL + tR) / 2;
            return merge(f(2*tIdx+1, tL, tM), f(2*tIdx+2, tM+1, tR));
        };
        return f(0, 0, N - 1);
    }
};