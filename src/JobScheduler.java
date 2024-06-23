// JobScheduler.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class JobScheduler {

    // Function to schedule jobs to maximize total profit using a dynamic programming approach
    public static void scheduleJobs(Job[] jobs) {
        // Sort jobs by their deadlines
        Arrays.sort(jobs, (a, b) -> a.deadline - b.deadline);

        int n = jobs.length;

        // Initialize DP array
        int[] dp = new int[n];
        Job[] schedule = new Job[n];
        boolean[] timeSlots = new boolean[n];
        Arrays.fill(schedule, null);
        Arrays.fill(timeSlots, false);

        // Initialize DP array with job profits
        for (int i = 0; i < n; i++) {
            dp[i] = jobs[i].profit;
        }

        // Fill DP array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (jobs[j].deadline < jobs[i].deadline && dp[i] < dp[j] + jobs[i].profit) {
                    dp[i] = dp[j] + jobs[i].profit;
                }
            }
        }

        // Find the maximum profit
        int maxProfit = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i] > maxProfit) {
                maxProfit = dp[i];
            }
        }

        // Backtrack to find the jobs included in the optimal schedule
        System.out.println("Scheduled Jobs:");
        int totalProfit = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == maxProfit && !timeSlots[jobs[i].deadline - 1]) {
                schedule[jobs[i].deadline - 1] = jobs[i];
                totalProfit += jobs[i].profit;
                maxProfit -= jobs[i].profit;
                timeSlots[jobs[i].deadline - 1] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (schedule[i] != null) {
                System.out.println("Job ID: " + schedule[i].jobId + ", Profit: " + schedule[i].profit + ", Deadline: " + schedule[i].deadline);
            }
        }

        // Print the total profit
        System.out.println("Total Profit: " + totalProfit);
    }

    public static Job[] readJobsFromCSV(String filePath) {
        Job[] jobs = new Job[50];
        String line;
        int index = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                jobs[index++] = new Job(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Arrays.copyOf(jobs, index); // Adjust size of array to actual number of jobs read
    }

    public static void main(String[] args) {
        String filePath = "data/jobs_dataset.csv"; // Update with the actual path to the CSV file
        Job[] jobs = readJobsFromCSV(filePath);
        scheduleJobs(jobs);
    }
}