import java.util.*;
public class SubsetsUsingBitmasking {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(arr);
        System.out.println(subsets);
    }
    public static List<List<Integer>> generateSubsets(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = arr.length;
        int totalSubsets = 1 << n; 
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) { 
                    subset.add(arr[j]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }
}