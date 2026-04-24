import java.util.*;

public class CountSmallerNumbers {

    static class Pair {
        int value, index;

        Pair(int v, int i) {
            value = v;
            index = i;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, counts, 0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int c : counts) result.add(c);
        return result;
    }

    private void mergeSort(Pair[] arr, int[] counts, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, counts, left, mid);
        mergeSort(arr, counts, mid + 1, right);

        merge(arr, counts, left, mid, right);
    }

    private void merge(Pair[] arr, int[] counts, int left, int mid, int right) {
        List<Pair> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i].value > arr[j].value) {
                temp.add(arr[j]);
                rightCount++;
                j++;
            } else {
                counts[arr[i].index] += rightCount;
                temp.add(arr[i]);
                i++;
            }
        }

        while (i <= mid) {
            counts[arr[i].index] += rightCount;
            temp.add(arr[i]);
            i++;
        }

        while (j <= right) {
            temp.add(arr[j]);
            j++;
        }

        for (int k = left; k <= right; k++) {
            arr[k] = temp.get(k - left);
        }
    }

    public static void main(String[] args) {
        CountSmallerNumbers obj = new CountSmallerNumbers();

        int[] nums = {5, 2, 6, 1};
        System.out.println(obj.countSmaller(nums)); // [2,1,1,0]
    }
}