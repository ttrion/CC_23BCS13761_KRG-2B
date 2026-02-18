public class Solve {
    public int four(int[] A) {
        long m = 1000000007;
        int n = A.length;
        long sum = 0;

        for (int i = 0; i < 31; i++) {
            long count1 = 0;

            for (int j = 0; j < n; j++) {
                if ((A[j] & (1 << i)) != 0) {
                    count1++;
                }
            }

            long count0 = n - count1;
            sum = (sum + (2 * count1 * count0) % m) % m;
        }

        return (int) sum;
    }
}