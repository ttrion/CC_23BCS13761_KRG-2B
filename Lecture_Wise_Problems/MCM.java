public class MatrixChainMultiplication {
    public static int matrixChainOrder(int[] p) {
        int n = p.length - 1; 
        int[][] m = new int[n][n]; 
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1; 
                m[i][j] = Integer.MAX_VALUE; 
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (q < m[i][j]) {
                        m[i][j] = q; 
                    }
                }
            }
        }

        return m[0][n - 1]; 
    }

    public static void main(String[] args) {
        int[] dimensions = {40, 20, 30, 10, 30}; 
        int result = matrixChainOrder(dimensions);
        System.out.println("Minimum number of multiplications is " + result);
    }
}