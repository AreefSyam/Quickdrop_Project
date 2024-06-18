# Job Scheduling for Maximum Profit
**QuickDrop Drone Delivery Service**

**Course**
CSC4202 - Design & Analysis Of Algorithm

**Group Name**
Super Saiyan

**Team Members & Roles:**
1. **MUHAMMAD ARIF AIMAN BIN MOHD HISAM** (Leader)
2. **NURDIYANA ATHIRAH BINTI MOHD ASMAN** (Designer)
3. **MUHAMAD ZUL AIMAN BIN MOHD AMRAN** (Developer)

---

## 1. Problem Scenario
In a bustling metropolitan area, a drone delivery service company, "QuickDrop," operates to ensure packages are delivered promptly and efficiently. Each delivery job has a deadline (by when it must be completed) and a profit associated with it. The company aims to maximize its total profit by optimally scheduling deliveries within their respective deadlines.

**Geographical Setting:** The city is divided into several zones, each with varying traffic conditions and distances. The scheduling must account for these factors to ensure timely deliveries. 

**Type of Disaster:** Not applicable in this scenario.

**Damage Impact:** Delays in deliveries can lead to customer dissatisfaction, loss of future business, and reduced profits.

**Importance:** Finding an optimal solution for this scenario is crucial because it maximizes the company's revenue, ensures timely deliveries, enhances customer satisfaction, and improves operational efficiency.

**Goal and Expected Output:** The goal is to develop an algorithm that schedules jobs to maximize total profit while meeting all deadlines. The expected output is a schedule that lists the jobs to be completed within their deadlines and the total profit achieved.

---

## 2. Development of a Model
### Data Types:
- **Jobs:** Represented as an array of Job objects, each containing (jobId, deadline, profit). For example:
  - Job 1: ('A001', 2, 100)
  - Job 2: ('B002', 1, 50)
  - Job 3: ('C003', 2, 150)

### Objective Function:
- **Maximize Total Profit:** Tp maximize the total profit by selecting jobs that can be completed within their deadlines.

### Constraints:
- **Each job must be completed by its deadline:** This constraint ensures that every job scheduled by the algorithm is finished on or before its specified deadline. The deadline represents the latest time by which the job must be completed to earn the associated profit. For example, if a job has a deadline of 2, it means it can only be scheduled in time slots 1 or 2. If the job is scheduled after its deadline, it will not contribute to the total profit, as it is considered late.
- **No two jobs can be scheduled at the same time slot:** This constraint ensures that the scheduling is non-overlapping, meaning that only one job can be assigned to any given time slot. This prevents conflicts where multiple jobs vie for the same time slot, which would be infeasible in a real-world scenario where only one delivery can occur at a time.

### Examples:
Jobs: [(A, 2, 100), (B, 1, 19), (C, 2, 27), (D, 1, 25), (E, 3, 15)]

### Other Requirements:
   **A.Space Constraint:** The algorithm should use space proportional to the number of jobs and the maximum deadline. This ensures that the solution is scalable and can handle a large number of jobs efficiently. Specifically, the space complexity should be \( O(n + d) \), where \( n \) is the number of jobs and \( d \) is the maximum deadline. This involves:
   - An array to store the jobs.
   - An additional array to keep track of the scheduled jobs (result array).

   **B.Time Constraint:** The algorithm should run in polynomial time to ensure it is efficient and practical for real-world applications. The time complexity should ideally be:
   - \( O(n log n) \) for sorting the jobs based on profit in descending order.
   - \( O(n . d) \) for scheduling the jobs, where \( n \) is the number of jobs and \( d \) is the maximum deadline. This includes:
      - Iterating through the sorted jobs.
      - Finding the latest available time slot for each job up to its deadline.

   **C.Value Constraint:** The profit values and deadlines should be positive integers to ensure meaningful job scheduling and profit maximization. This includes:
   - Ensuring all job profits are positive integers, representing the earnings from completing the jobs.
   - Ensuring all deadlines are positive integers, representing the latest time slot by which the job must be completed.

---

## 3. Specification of an Algorithm
### Comparison with Other Algorithms:**

**1. Divide and Conquer (DAC):**
- Strengths: DAC is highly effective for problems that can be broken down into smaller subproblems, solved independently, and then combined to form the solution for the original problem. Examples include sorting algorithms like QuickSort and MergeSort.
- Weaknesses: DAC may not be the best choice for problems requiring global optimization, like job scheduling, where the solution to a subproblem depends on the solutions to other subproblems. It can fail to consider dependencies between subproblems, leading to suboptimal solutions.

**2. Dynamic Programming (DP):**
- Strengths: DP systematically explores all possible solutions by storing the results of subproblems, ensuring that the optimal solution is found. It is effective for optimization problems where overlapping subproblems and optimal substructure are present.
- Weaknesses: DP often requires significant memory to store the results of subproblems, which can be problematic for large-scale problems.

**3. Greedy Algorithm:**
- Strengths: Greedy algorithms are typically straightforward to design and implement, making them accessible for a wide range of problems.
- Weaknesses: Greedy algorithms make decisions based on local optimization, which can sometimes lead to suboptimal global solutions. They are not guaranteed to find the best solution for all problems.

**4. Graph Algorithms:**
- Strengths: Graph algorithms excel in solving problems related to network flow, shortest paths, and connectivity. They are powerful tools for a wide range of applications, from internet routing to social network analysis.
- Weaknesses: While graph algorithms can be used for scheduling problems by modeling jobs and dependencies as graphs, the implementation can be complex. It often involves sophisticated data structures and a deep understanding of graph theory.

---

### Chosen Algorithm:
Greedy Algorithm is selected because it efficiently provides a good solution for the job scheduling problem by focusing on maximizing profit.

### Suitability of Greedy Algorithm:
The greedy algorithm is chosen for its simplicity and efficiency, making it a suitable choice for the job scheduling problem, where the primary goal is to maximize profit by selecting jobs based on their profitability.

---

## 4. Designing an Algorithm
### Pseudocode
// Job Class
Class Job:
    Attributes:
        jobId
        deadline
        profit
    
    Constructor:
        Initialize jobId, deadline, profit

// JobScheduler Class
Class JobScheduler:
    
    // Function to schedule jobs to maximize total profit
    Function scheduleJobs(jobs):
        Sort jobs by profit in descending order

        Find the maximum deadline in jobs
        Initialize result array of size maxDeadline
        Initialize totalProfit to 0

        For each job in jobs:
            For slot from min(maxDeadline - 1, job.deadline - 1) to 0:
                If slot is empty in result:
                    Assign job to slot in result
                    Add job profit to totalProfit
                    Break out of loop

        Print scheduled jobs from result
        Print totalProfit

    // Function to read jobs from a CSV file
    Function readJobsFromCSV(filePath):
        Initialize jobs list
        Open file at filePath
        Skip header line
        For each line in file:
            Split line by comma
            Create Job with values from line
            Add Job to jobs list
        Close file
        Return jobs list

    // Main function
    Function main(args):
        Set filePath to path of CSV file
        Read jobs from CSV using readJobsFromCSV
        Schedule jobs using scheduleJobs

### FLowchart
![Flowchart](image/flowchart.png)

---

## 5. Checking the Correctness of an Algorithm
**Correctness:**
The algorithm schedules jobs based on the highest profit, ensuring that each job is completed within its deadline. The use of a greedy approach ensures that the most profitable jobs are prioritized, and each job is assigned to the latest possible free slot within its deadline.

**Recurrence:**
The recurrence relation is defined by the job selection and slot assignment process, ensuring that each job is placed in the optimal slot to maximize profit.

---

## 6. Analysis of an Algorithm
### Growth of Function:
- **Best Case:** \( O(n log n) \) for sorting, where \( n \) is the number of jobs.
- **Average Case:** \( O(n . d) \) where \( d \) is the maximum deadline.
- **Worst Case:** \( O(n . d) \).



## 7. Implementation of an Algorithm
// Job.java

   public class Job {
      String jobId;
      int deadline;
      int profit;

      public Job(String jobId, int deadline, int profit) {
         this.jobId = jobId;
         this.deadline = deadline;
         this.profit = profit;
      }
   }

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

         // Keep track of total profit
         int totalProfit = 0;

         // Iterate through all given jobs
         for (int i = 0; i < n; i++) {
               // Find a free time slot for this job (start from the last possible slot)
               for (int j = Math.min(maxDeadline - 1, jobs[i].deadline - 1); j >= 0; j--) {
                  // Free slot found
                  if (result[j] == null) {
                     result[j] = jobs[i];
                     totalProfit += jobs[i].profit;
                     break;
                  }
               }
         }

         // Print the scheduled jobs
         System.out.println("Scheduled Jobs:");
         for (Job job : result) {
               if (job != null) {
                  System.out.println("Job ID: " + job.jobId + ", Profit: " + job.profit);
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

         return jobs;
      }

      public static void main(String[] args) {
         String filePath = "data\\jobs_dataset.csv"; // Update with the actual path to the CSV file
         Job[] jobs = readJobsFromCSV(filePath);
         scheduleJobs(jobs);
      }
   }

## 8. Sample Output

Scheduled Jobs:
Job ID: A, Profit: 100
Job ID: C, Profit: 27
Job ID: E, Profit: 15
Total Profit: 142

