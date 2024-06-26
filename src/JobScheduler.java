// JobScheduler.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class JobScheduler {

    // Function to schedule jobs to maximize total profit
    public static void scheduleJobs(Job[] jobs) {
        // Sort jobs by profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int n = jobs.length;

        // Find the maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // Create an array to keep track of free time slots
        Job[] result = new Job[maxDeadline];
        int[] timeSlots = new int[maxDeadline];

        // Keep track of total profit
        int totalProfit = 0;

        // Iterate through all given jobs
        for (int i = 0; i < n; i++) {
            // Find a free time slot for this job (start from the last possible slot)
            for (int j = Math.min(maxDeadline - 1, jobs[i].deadline - 1); j >= 0; j--) {
                // Free slot found
                if (result[j] == null) {
                    result[j] = jobs[i];
                    timeSlots[j] = j + 1; // record the slot (1-based index)
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }

        // Print the scheduled jobs
        System.out.println("Scheduled Jobs:");
        for (int i = 0; i < maxDeadline; i++) {
            if (result[i] != null) {
                System.out.println("Job ID: " + result[i].jobId + ", Profit: " + result[i].profit + ", Scheduled Time Slot: " + timeSlots[i]);
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
        String filePath = "data\\jobs_dataset.csv"; // Update with the actual path to the CSV file
        Job[] jobs = readJobsFromCSV(filePath);
        scheduleJobs(jobs);
    }
}