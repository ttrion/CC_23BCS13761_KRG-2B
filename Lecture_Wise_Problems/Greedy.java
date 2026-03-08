import java.util.*;
public class Greedy {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[][] jobs=new int[0][0];
        System.out.println("Enter number of jobs:");
        int n=sc.nextInt();
        jobs=new int[n][3];
        for(int i=0;i<n;i++){
            System.out.println("Enter job id, deadline and profit:");
            int id=sc.nextInt();
            int deadline=sc.nextInt();
            int profit=sc.nextInt();
            jobs[i]=new int[]{id, deadline, profit};
        }
        int[] result=jobScheduling(jobs);
        System.out.println("Maximum profit: "+result[0]);
        System.out.println("Number of jobs done: "+result[1]);
        sc.close();
    }
    public static int[] jobScheduling(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);
        int maxDeadline = 0;
        for (int[] job : jobs) {
            maxDeadline = Math.max(maxDeadline, job[1]);
        }
        int[] timeSlots = new int[maxDeadline + 1];
        Arrays.fill(timeSlots, -1);
        int totalProfit = 0;
        int countJobs = 0;
        for (int[] job : jobs) {
            for (int j = job[1]; j > 0; j--) {
                if (timeSlots[j] == -1) {
                    timeSlots[j] = job[0];
                    totalProfit += job[2];
                    countJobs++;
                    break;
                }
            }
        }
        return new int[]{totalProfit, countJobs};
    }
}