import java.util.*;
public class Main {
    public static int opera(int[] nums, int[] non) {
        int j = 1;
        int count = 0;
        int n = nums.length;
        while (true) {
            boolean allSatisfied = true;
            for (int i = 0; i < n; i++) {
                if (non[i] < nums[i]) {
                    non[i] += i * j; 
                    allSatisfied = false;
                }
            }
            count++;
            j++;
            if (allSatisfied) {
                break; 
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] non = new int[n];
        System.out.println("Enter nums array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int operations = opera(nums, non);
        System.out.println("Operations: " + operations);
        System.out.println("Final non array: " + Arrays.toString(non));
    }
}