//subset generation using bitmasking, take input from user and print all the subsets of the given array, 
// there is no need to print in any particular order, the output should be in the form of list of lists, 
// for example if the input is [1,2,3] then the output should be [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
import java.util.*;
public class Final_Practical_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(arr[j]);
                }
            }
            ans.add(subset);
        }
        System.out.println(ans);
    }
}