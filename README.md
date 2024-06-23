# Job Scheduling for Maximum Profit
**QuickDrop Drone Delivery Service**

**Course**
CSC4202 - Design & Analysis Of Algorithm

**Group Name:** Super Saiyan

**Team Members & Roles:**
1. **MUHAMMAD ARIF AIMAN BIN MOHD HISAM** (Leader)
2. **NURDIYANA ATHIRAH BINTI MOHD ASMAN** (Designer)
3. **MUHAMAD ZUL AIMAN BIN MOHD AMRAN** (Developer)

---

## 1.0 Problem Scenario 

![Flowchart](image/scenario.png)

In a bustling metropolitan area, a drone delivery service company, "QuickDrop," operates to ensure packages are delivered promptly and efficiently. Each delivery job has a deadline (by when it must be completed) and a profit associated with it. The company aims to maximize its total profit by optimally scheduling deliveries within their respective deadlines.

**Geographical Setting:** The city is divided into several zones, each with varying traffic conditions and distances. The scheduling must account for these factors to ensure timely deliveries. 

**Type of Disaster:** Not applicable in this scenario.

**Damage Impact:** Delays in deliveries can lead to customer dissatisfaction, loss of future business, and reduced profits.

**Importance:** Finding an optimal solution for this scenario is crucial because it maximizes the company's revenue, ensures timely deliveries, enhances customer satisfaction, and improves operational efficiency.

**Goal and Expected Output:** The goal is to develop an algorithm that schedules jobs to maximize total profit while meeting all deadlines. The expected output is a schedule that lists the jobs to be completed within their deadlines and the total profit achieved.

---

## 2.0 Development of a Model 
### 2.1 Data Types:
- Jobs: Represented as an array of Job objects, each containing (jobId, deadline, profit). For example:
    - jobId (String)
    - deadline (int)
    - profit (int)
 - Example:
   - Job 1: ('A001', 2, 100)
   - Job 2: ('B002', 1, 50)
   - Job 3: ('C003', 2, 150)

### 2.2 Objective Function:
- **Maximize Total Profit:** Tp maximize the total profit by selecting jobs that can be completed within their deadlines.

### 2.3 Constraints:
- **Deadline Constraint**: Each job must be completed by its deadline.
    - Example: If a job has a deadline of 2, it can only be scheduled in time slots 1 or 2.
- **Non-Overlapping Constraint**: No two jobs can be scheduled at the same time slot.
    - Ensures that only one job is assigned per time slot.

### 2.4 Other Requirements:
   - **Space Constraint:**
       - Use space proportional to the number of jobs and the maximum deadline O(n + d).
       - Includes arrays to store jobs and scheduled jobs.

   - **Time Constraint:**
       - Sorting: O(n log n) for sorting jobs by profit.
       - Scheduling: O(n * d) for scheduling jobs up to their deadlines.

   - **Value Constraint:**
       - Profits and deadlines must be positive integers.

Example:
- Profit Values: All job profits are positive integers.
- Deadlines: All deadlines are positive integers.

---

### 2.5 Simple Example 
![Flowchart](image/simple_example.png)

---

## 3.0 Specification of an Algorithm 

### 3.1 Comparison with Other Algorithms:
![Flowchart](image/table.png)

**3.1.1 Divide and Conquer (DAC):**
- Strengths: DAC is highly effective for problems that can be broken down into smaller subproblems, solved independently, and then combined to form the solution for the original problem. Examples include sorting algorithms like QuickSort and MergeSort.
- Weaknesses: DAC may not be the best choice for problems requiring global optimization, like job scheduling, where the solution to a subproblem depends on the solutions to other subproblems. It can fail to consider dependencies between subproblems, leading to suboptimal solutions.

**3.1.2 Dynamic Programming (DP):**
- Strengths: DP systematically explores all possible solutions by storing the results of subproblems, ensuring that the optimal solution is found. It is effective for optimization problems where overlapping subproblems and optimal substructure are present.
- Weaknesses: DP often requires significant memory to store the results of subproblems, which can be problematic for large-scale problems.

**3.1.3 Greedy Algorithm:**
- Strengths: Greedy algorithms are typically straightforward to design and implement, making them accessible for a wide range of problems.
- Weaknesses: Greedy algorithms make decisions based on local optimization, which can sometimes lead to suboptimal global solutions. They are not guaranteed to find the best solution for all problems.

**3.1.4 Graph Algorithms:**
- Strengths: Graph algorithms excel in solving problems related to network flow, shortest paths, and connectivity. They are powerful tools for a wide range of applications, from internet routing to social network analysis.
- Weaknesses: While graph algorithms can be used for scheduling problems by modeling jobs and dependencies as graphs, the implementation can be complex. It often involves sophisticated data structures and a deep understanding of graph theory.

---

### 3.2 Chosen Algorithm: Dynamic Algorithm

1. Suitability for Job Scheduling: Dynamic programming (DP) is particularly well-suited for job scheduling problems where jobs need to be selected based on specific criteria (e.g., profit) and fit within given constraints (e.g., deadlines).
2. Efficiency: The DP approach allows for systematic exploration of all possible solutions by storing the results of subproblems, ensuring that the optimal solution is found.
3. Implementation: The implementation of a DP algorithm requires careful definition of the state and transition functions, but it ensures finding the optimal solution.
4. Global Optimization: DP considers all possible solutions and stores results of subproblems, which helps in finding the globally optimal solution.

---

## 4.0 Designing an Algorithm ((plz modify if necessary))

---

### 4.1 Algorithm Paradigm Explanation
This paradigm involves breaking down the problem into smaller subproblems, solving each subproblem once, and storing their solutions.


#### 4.1.1 Key Components

**1. Sorting Jobs by Deadline:**
- Purpose: To prioritize jobs with the earliest deadlines.
- Process: Jobs are sorted in ascending order based on their deadlines.

**2. Dynamic Programming Table:**
- Purpose: To store the maximum profit achievable up to each job.
- Process: Create a DP table where 'dp[i]' represents the maximum profit achievable by considering jobs from 0 to i.

**3. State Transition:**
- Purpose: To update the DP table based on the inclusion or exclusion of each job.
- Process: For each job, update the DP table by considering whether to include the job or not.
    - If the job is included, find the last non-conflicting job and add its profit to the current job's profit.
    - If the job is not included, carry forward the previous profit.
      

#### 4.1.2 Recurrence and Optimization
- Recurrence: The recurrence relation for the DP table is based on whether the job is included or not.
    - If the job is included: 'dp[i] = max(dp[i], job.profit + dp[latestNonConflict(i)])'
    - If the job is not included: 'dp[i] = dp[i-1]'

  
- Optimization Function: The optimization function here is the maximum profit stored in the DP table, which is updated iteratively.

  

          for (int i = job.deadline; i >= 1; i--) {
            dp[i] = Math.max(dp[i], dp[i - 1] + job.profit);
        }

---

### 4.3 FLowchart
![Flowchart](image/flowchart.png)

---

## 5.0 Checking the Correctness of an Algorithm (Asymptotic , Recurrence) (modify)

### 5.1 Optimal Substructure (modify)
Optimal substructure means that an optimal solution to the problem contains optimal solutions to its subproblems. For the job scheduling problem, this implies that if we schedule the most profitable jobs first, the remaining jobs will still form an optimal schedule for the remaining slots.

### 5.3 Steps in the Code: (modify)
![Flowchart](image/ANALYSIS.png)
![Flowchart](image/ANALYSIS2.png)

### 5.4 Summary: (modify)
- **Asymptotic Time Complexity:** O(n log n) + O(n.d)
- **Recurrence Relation:** Since the algorithm is not recursive, we don't have a traditional recurrence relation. Instead, the time complexity is derived from the combination of sorting and scheduling steps.

---

## 6.0 Analysis of an Algorithm Growth of Function for Worst, Best, Average Analysis (modify)

### 6.1 Worst-Case Analysis (modify)

- The worst-case scenario occurs when the algorithm has to perform the maximum number of operations.
    - For the job scheduling algorithm, this happens when:
        - Sorting Jobs by Profit: This is always 𝑂(𝑛 log 𝑛) because sorting needs to be done irrespective of the job deadlines or profits.
        - Finding the Maximum Deadline: This is 𝑂(𝑛) as it requires scanning through all jobs.
        - Scheduling Jobs: In the worst case, each job needs to be checked against all deadlines to find an available slot. This involves nested loops where the outer loop runs 𝑛 times (for each job) and the inner loop runs up to 𝑑 times (the maximum deadline).
- Thus, the worst-case time complexity is: 𝑇(𝑤𝑜𝑟𝑠𝑡)(𝑛) = 𝑂(𝑛log⁡𝑛) + 𝑂(𝑛) + 𝑂(𝑛⋅𝑑) = 𝑂(𝑛log𝑛 + 𝑛⋅𝑑)

### 6.2 Best-Case Analysis (modify)

- The best-case scenario happens when each job can be placed in its slot immediately without needing to check multiple slots.
    - However, since the algorithm always sorts the jobs, the best-case time complexity is still influenced by the sorting step:
        - Sorting Jobs by Profit: This is 𝑂(𝑛log𝑛)
        - Finding the Maximum Deadline: This is 𝑂(𝑛).
        - Scheduling Jobs: Each job is placed in its slot without conflicts. This is still 𝑂(𝑛⋅𝑑) as it needs to check each slot to confirm it's free, even if it's optimal.
- Thus, the best-case time complexity is: 𝑇(𝑏𝑒𝑠𝑡)(𝑛) = 𝑂(𝑛log⁡𝑛) + 𝑂(𝑛) + 𝑂(𝑛⋅𝑑) = 𝑂(𝑛log𝑛 + 𝑛⋅𝑑)

### 6.3 Average-Case Analysis (modify)

- The average-case scenario is typically more complex to analyze theoretically because it involves the expected number of operations over all possible inputs
    - However, for this algorithm, it also involves sorting and scheduling which are influenced similarly to the worst and best cases:
        - Sorting Jobs by Profit: This is 𝑂(𝑛log𝑛)
        - Finding the Maximum Deadline: This is 𝑂(𝑛).
        - Scheduling Jobs: On average, we still need to check multiple slots for each job, but this number is generally around half the maximum deadline.
- Thus, the best-case time complexity is: 𝑇(𝑎𝑣𝑒𝑟𝑎𝑔𝑒)(𝑛) = 𝑂(𝑛log⁡𝑛) + 𝑂(𝑛) + 𝑂(𝑛⋅𝑑) = 𝑂(𝑛log𝑛 + 𝑛⋅𝑑)

---

## 7.0 Implementation of an Algorithm (finalized)
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
    
      // Function to schedule jobs to maximize total profit using dynamic programming
      public static void scheduleJobs(Job[] jobs) {
        // Sort jobs by deadline in ascending order
        Arrays.sort(jobs, (a, b) -> a.deadline - b.deadline);
    
        int n = jobs.length;
    
        // Find the maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
          if (job.deadline > maxDeadline) {
            maxDeadline = job.deadline;
          }
        }
    
        // Create a DP table to store the maximum profit up to each time slot
        int[] dp = new int[maxDeadline + 1];
    
        // Array to keep track of the jobs included in the optimal solution
        Job[] result = new Job[maxDeadline + 1];
    
        // Iterate through all given jobs and update the DP table
        for (Job job : jobs) {
          for (int j = maxDeadline; j >= job.deadline; j--) {
            if (dp[j - job.deadline] + job.profit > dp[j]) {
              dp[j] = dp[j - job.deadline] + job.profit;
              result[j] = job;
            }
          }
        }
    
        // Print the scheduled jobs and the total profit
        System.out.println("Scheduled Jobs:");
        int totalProfit = 0;
        for (int i = 1; i <= maxDeadline; i++) {
          if (result[i] != null) {
            totalProfit += result[i].profit;
            System.out.println("Job ID: " + result[i].jobId + ", Profit: " + result[i].profit + ", Scheduled Time Slot: " + i);
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

---

### 7.1 Code Breakdown
- Reading Jobs from CSV: The readJobsFromCSV function reads job data from a CSV file and returns an array of Job objects.
    - Time Complexity: O(n), where n is the number of jobs.
- Sorting Jobs by Deadline: The jobs are sorted in ascending order based on their deadlines.
    - Time Complexity: O(n log n), where n is the number of jobs.
- Dynamic Programming Table Initialization: An array dp is created to store the maximum profit up to each time slot.
    - Time Complexity: O(d), where d is the maximum deadline.
- Scheduling Jobs: Iterate through each job and update the DP table based on job inclusion or exclusion.
    - For each job:

          for (int j = maxDeadline; j >= job.deadline; j--) {
                  if (dp[j - job.deadline] + job.profit > dp[j]) {
                    dp[j] = dp[j - job.deadline] + job.profit;
                    result[j] = job;
                  }
          }
    - Time Complexity: O(n * d), where n is the number of jobs and d is the maximum deadline.
- Printing Scheduled Jobs and Total Profit: Iterate through the result array to print the scheduled jobs and calculate the total profit.
    - Time Complexity: O(d), where d is the maximum deadline.

---

## 8.0 Sample Output (modify)
![Flowchart](image/sample_output.png)

### 8.1 Output Explanation:

- **Job ID: E056, Profit: 50, Scheduled Time Slot: 1**
  - This job with a profit of 50 is scheduled at the earliest available slot, which is slot 1.
  
- **Job ID: R090, Profit: 55, Scheduled Time Slot: 2**
  - This job with a profit of 55 is scheduled in slot 2.

- **Job ID: X056, Profit: 55, Scheduled Time Slot: 3**
  - This job with a profit of 55 is scheduled in slot 3.

- **Job ID: O060, Profit: 60, Scheduled Time Slot: 4**
  - This job with a profit of 60 is scheduled in slot 4.

- **Job ID: Y078, Profit: 65, Scheduled Time Slot: 5**
  - This job with a profit of 65 is scheduled in slot 5.

- **Job ID: X600, Profit: 60, Scheduled Time Slot: 6**
  - This job with a profit of 60 is scheduled in slot 6.

- **Job ID: T056, Profit: 60, Scheduled Time Slot: 7**
  - This job with a profit of 60 is scheduled in slot 7.

- **Job ID: B200, Profit: 70, Scheduled Time Slot: 8**
  - This job with a profit of 70 is scheduled in slot 8.

**Total Profit: 475**
- The sum of the profits of the scheduled jobs: \(50 + 55 + 55 + 60 + 65 + 60 + 60 + 70 = 475\).

--

### 8.2 Explanation of Scheduling:

The algorithm follows these steps:

1. **Sort Jobs by Profit in Descending Order:**
   - Jobs are sorted based on their profit, with the highest profit job considered first. This is why the job with the highest profit (B200, profit 70) is considered before others.

2. **Schedule Jobs:**
   - The algorithm schedules each job in the latest possible slot before its deadline. It starts from the highest profit job and tries to place it in the nearest available slot to its deadline, moving backward if needed.

For example, let's take a closer look at the first few jobs in the sorted order and how they were scheduled:

- **Job B200** with a profit of 70 is scheduled in slot 8.
- **Job Y078** with a profit of 65 is scheduled in slot 5.
- **Job T056** with a profit of 60 is scheduled in slot 7.
- **Job X600** with a profit of 60 is scheduled in slot 6.
- **Job O060** with a profit of 60 is scheduled in slot 4.
- **Job R090** with a profit of 55 is scheduled in slot 2.
- **Job X056** with a profit of 55 is scheduled in slot 3.
- **Job E056** with a profit of 50 is scheduled in slot 1.

Each job is placed in the latest available time slot before its deadline to maximize the profit without conflicting with other jobs.

--

### 8.3 Summary: (modify)

The output shows that the algorithm successfully schedules jobs to maximize the total profit while adhering to their respective deadlines. The total profit of 475 is the sum of the profits of the scheduled jobs, and each job is placed in a time slot that allows it to be completed on time.

