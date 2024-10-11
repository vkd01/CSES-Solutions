/*
Author : Vimal Kumar Dubey
Cf handle : code_vkd_001
--------------------------------------------------------------------------------------

 Roses do not bloom hurriedly; for beauty, like any masterpiece, takes time to blossom */

import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {

    static int dp[][] = new int[2000000][20];

    public static void binary_lifting(int src, int par, ArrayList<ArrayList<Integer>> graph){
        dp[src][0] = par;
        for(int i = 0;i<20;i++){
            if(dp[src][i-1] != -1){
                dp[src][i] = dp[dp[src][i-1]][i-1];
            }
            else dp[src][i] = -1;
        }

        for (int child : graph.get(src)) {
            if(child != par) binary_lifting(child, src, graph);
        }

    }

    public static int query_dfs(int node, int level, ArrayList<ArrayList<Integer>> graph){

        if(node == -1 || level == 0) return node;

        for(int i = 19;i>=0;i--){
            if(level>=(1L<<i)){
                return query_dfs(dp[node][i], level - (1<<i), graph);
            }
        }

        return -1;
    }

    public static void jaiShreeRam__(FastScanner sc) {

        int n = sc.nextInt();
        int q = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1;i<n;i++){
            int u = sc.nextInt();
            int v = i;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        binary_lifting(1,1, graph);

        while(q-->0){

            int node, level;
            node = sc.nextInt();
            level = sc.nextInt();

            System.out.println(query_dfs(node, level, graph));



        }






    }





    public static void main(String[] args) {

        //                          Jai Shree Ram
        /*-------------------------CODE BEGINS----------------------------------------------------------*/

        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = 1;
        while(t-->0){

            // -------------TESTS STARTS-----------------------------

            jaiShreeRam__(sc);

            // -------------TESTS ENDS-----------------------------
        }


    }

    /*-------------------SOME TOOLS---------------------------------------------------------*/
    static long gcd1(long a, long b) {if (b == 0) return a;return gcd(b, a % b);}
    static long lcm1(long a, long b) {return (a / gcd(a, b)) * b;}
    /*-----------------BINARY SEARCH--------------------------------------------------------*/
    static int search(int a[], int b) {int start = 0, end = a.length - 1;if (a[0] <= a[end]) {while (start <= end) {
        int mid = start + ((end - start) / 2);if (a[mid] == b) return mid;else if (a[mid] > b) end = mid - 1;
        else if (a[mid] < b) start = mid + 1; }
    } else { while (start <= end) {int mid = start + ((end - start) / 2);if (a[mid] == b) return mid;
    else if (a[mid] < b) end = mid - 1;else if (a[mid] > b) start = mid + 1;}}return -1;}
    /*------------------------------------------------------------------------------------------*/
    static private void permutateAndSort(long[] a) {
        int n = a.length; Random R = new Random(System.currentTimeMillis());for(int i=0; i<n; i++) {
            int t = R.nextInt(n-i);long temp = a[n-1-i];a[n-1-i] = a[t];a[t] = temp;}Arrays.sort(a);}

    static boolean check(int start,int end ,char[]  arr, long k) {
        if(arr[start]=='0') return false;
        long rem = 0;
        for (int i=start;i<=end;i++)
            rem = ((rem * 10) + arr[i] - '0') %  k;
        return rem == 0;
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // ***************** TEMPLATES ********************//
    // static long gcd(long a, long b, long x, long y) {
    // if (b == 0) {
    // x = 1;
    // y = 0;
    // return a;
    // }
    // long x1 = 0, y1 = 0;
    // long d = gcd(b, a % b, x1, y1);
    // x = y1;
    // y = x1 - y1 * (a / b);
    // return d;
    // }

    static void swap(int i, int j, char[] xYz) {
        char temp = xYz[i];
        xYz[i] = xYz[j];
        xYz[j] = temp;
    }

    static long lcm(long a, long b) {
        if (a > b)
            return a / gcd(b, a) * b;
        return b / gcd(a, b) * a;
    }

    static List<Integer> sieveOfEratosthenes(int n)

    {
        List<Integer> list = new ArrayList<>();
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i < n; i++)
            prime[i] = true;
        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }
        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                list.add(i);
        }
        return list;
    }

    static int LowerBound(int a[], int x, int begin) { // x is the target value or key
        int l = begin - 1, r = a.length;
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (a[m] >= x)
                r = m;
            else
                l = m;
        }
        return r;
    }

    public static long bigpow(long a, long b) {
        long check = 1;
        while (b > 0) {
            long xx = b & 1;
            if (xx == 1) {
                check = check * a;
            }
            a = a * a;
            b >>= 1;
        }
        return check;
    }

    public static long bigpowmod(long a, long b, long mod) {
        a = a % mod;
        long check = 1;
        while (b > 0) {
            long xx = b & 1;
            if (xx == 1) {
                check = (check * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return check;
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    /*----------------------------------------------------------------------------------------------*/



    public static boolean vkd(){



        return true;
    }

    //-------------main ends--------------//



} //-----------Main Ends------------//

// ---------------------------------TOOLS=---------------------------------//
class FenwickTree{
    static int N;

    static int[] farr;
    public static void fenwick(int n){
        N = n;
        farr = new int[N+1];
        for(int i = 0;i<=N;i++) farr[i] = 0;
    }
    public static int query(int left, int right){
        return prefixS(right) - prefixS(left-1);
    }

    public static int prefixS(int ind){
        int sum = 0;

        while(ind>0){
            sum+=farr[ind];
            ind-=(ind & -ind);
        }

        return sum;
    }

    public static void update(int ind, int delta){
        while(ind<farr.length){
            farr[ind]+=delta;
            ind+=(ind &-ind);
        }
    }
}
class DSU {
    int[] parent;
    int[] size;

    DSU(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findpar(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findpar(parent[node]);
    }

    void union(int a, int b) {
        a = findpar(a);
        b = findpar(b);
        if (a != b) {
            if (size[a] < size[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            parent[b] = a;
            size[a] += size[b];
        }
    }
}
class FastScanner {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    String next() {
        while (!st.hasMoreTokens())
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    int[] readArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    long[] readLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextLong();
        }
        return a;
    }
}

/*
 * Arrays.sort(xYz, (a, b) -> {
 * if(a[0] == b[0]) {
 * return Integer.compare(b[1], a[1]);
 * }
 * return Integer.compare(a[0], b[0]);
 * });
 */

// lowerbound
/*
 * static int LowerBound(int a[], int x) { // x is the target value or key
 * int l=-1,r=a.length;
 * while(l+1<r) {
 * int m=(l+r)>>>1;
 * if(a[m]>=x) r=m;
 * else l=m;
 * }
 * return r;
 * }
 */

class Pair {
    long i;
    long j;

    public Pair(long i, long j) {
        this.i = i;
        this.j = j;
    }
}

class TreeMultiSet<T> implements Iterable<T>

{
    private final TreeMap<T, Integer> map;
    private int size;

    public TreeMultiSet() {
        map = new TreeMap<>();
        size = 0;
    }

    public TreeMultiSet(boolean reverse) {
        if (reverse)
            map = new TreeMap<>(Collections.reverseOrder());
        else
            map = new TreeMap<>();
        size = 0;
    }

    public void clear() {
        map.clear();
        size = 0;
    }

    public int size() {
        return size;
    }

    public int setSize() {
        return map.size();
    }

    public boolean contains(T a) {
        return map.containsKey(a);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer get(T a) {
        return map.getOrDefault(a, 0);
    }

    public void addOne(T a, int count) {
        int cur = get(a);
        map.put(a, cur + count);
        size += count;
        if (cur + count == 0)
            map.remove(a);
    }

    public void add(T a) {
        addOne(a, 1);
    }

    public void removeOne(T a, int count) {
        addOne(a, Math.max(-get(a), -count));
    }

    public void remove(T a) {
        removeOne(a, 1);
    }

    public void removeAll(T a) {
        removeOne(a, Integer.MAX_VALUE - 10);
    }

    public T ceiling(T a) {
        return map.ceilingKey(a);
    }

    public T floor(T a) {
        return map.floorKey(a);
    }

    public T first() {
        return map.firstKey();
    }

    public T last() {
        return map.lastKey();
    }

    public T higher(T a) {
        return map.higherKey(a);
    }

    public T lower(T a) {
        return map.lowerKey(a);
    }

    public T pollFirst() {
        T a = first();
        remove(a);
        return a;
    }

    public T pollLast() {
        T a = last();
        remove(a);
        return a;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private final Iterator<T> iter = map.keySet().iterator();
            private int count = 0;
            private T curElement;

            public boolean hasNext() {
                return iter.hasNext() || count > 0;
            }

            public T next() {
                if (count == 0) {
                    curElement = iter.next();
                    count = get(curElement);
                }
                count--;
                return curElement;
            }
        };
    }
}



class Comp implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        if (o1.i == o2.i) {
            if (o1.j < o2.j) {
                return -1;
            } else if (o1.j == o2.j) {
                return 0;
            } else {
                return 1;
            }
        }
        if (o1.i < o2.i) {
            return -1;
        } else if (o1.i == o2.i) {
            return 0;
        } else {
            return 1;
        }
    }
}