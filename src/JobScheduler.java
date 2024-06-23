import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class JobScheduler {

    public static class Job {
        String jobId;
        int deadline;
        int profit;

        public Job(String jobId, int deadline, int profit) {
            this.jobId = jobId;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    // Function to find the latest job (in sorted array) that doesn't conflict with the job[i]
    private static int latestNonConflict(Job[] jobs, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (jobs[j].deadline <= jobs[i].deadline - 1) {
                return j;
            }
        }
        return -1;
    }

    // Function to schedule jobs to maximize total profit using dynamic programming
    public static int scheduleJobs(Job[] jobs) {
        // Sort jobs by deadline, and by profit in descending order if deadlines are equal
        Arrays.sort(jobs, (a, b) -> {
            if (a.deadline != b.deadline) {
                return a.deadline - b.deadline;
            } else {
                return b.profit - a.profit;
            }
        });

        int n = jobs.length;

        // DP array to store the maximum profit up to each job
        int[] dp = new int[n];

        // Base case: The maximum profit with the first job
        dp[0] = jobs[0].profit;

        // Fill the dp array in bottom-up manner
        for (int i = 1; i < n; i++) {
            // Include profit of the current job
            int includeProfit = jobs[i].profit;
            int l = latestNonConflict(jobs, i);
            if (l != -1) {
                includeProfit += dp[l];
            }

            // Store the maximum of including and excluding the current job
            dp[i] = Math.max(includeProfit, dp[i - 1]);
        }

        // The maximum profit is at the last index of dp array
        return dp[n - 1];
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
            System.err.println("Error reading file: " + e.getMessage());
        }

        return Arrays.copyOf(jobs, index); // Adjust size of array to actual number of jobs read
    }

    public static void main(String[] args) {
        String filePath = "data/jobs_dataset.csv"; // Update with the actual path to the CSV file
        Job[] jobs = readJobsFromCSV(filePath);
        int maxProfit = scheduleJobs(jobs);
        System.out.println("Total Profit: " + maxProfit);
    }
}
