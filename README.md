# GROUP PROJECT: JOB SCHEDULING FOR MAXIMUM PROFIT
**QuickDrop Drone Delivery Service**

## Course
CSC4202 - Design & Analysis Of Algorithm

## Group Name
Super Saiyan

## Team Members & Roles:
1. **MUHAMMAD ARIF AIMAN BIN MOHD HISAM** (Leader)
2. **NURDIYANA ATHIRAH BINTI MOHD ASMAN** (Designer)
3. **MUHAMAD ZUL AIMAN BIN MOHD AMRAN** (Developer)

---

## 1. Problem Scenario
### QuickDrop, a drone delivery service in a bustling metropolitan area, aims to maximize profits by optimally scheduling delivery jobs. Frequent traffic congestions and delivery delays impact economic activities.

**Goal:** Develop a scheduling algorithm to maximize profits by ensuring timely deliveries.  
**Expected Output:** A list of scheduled jobs with their respective time slots and the total profit achieved.

---

## 2. Importance
Efficient job scheduling maximizes revenue, improves delivery times, and maintains high customer satisfaction for QuickDrop.

---

## 3. Problem Statement
QuickDrop needs to maximize its total profit by optimally scheduling delivery jobs within their respective deadlines.

---

## 4. Objectives
To develop a scheduling algorithm that efficiently allocates drone delivery jobs to maximize total profit while adhering to job deadlines.

---
## 5. Development of a Model
### Data Types
- **Jobs:** Each job is represented as a tuple containing three values: (job_id, deadline, profit). For example:
  - Job 1: ('A001', 2, 100)
  - Job 2: ('B002', 1, 50)
  - Job 3: ('C003', 2, 150)

### Objective Function
- **Maximize Total Profit:** The goal is to maximize the total profit by selecting jobs that can be completed within their deadlines. Mathematically, this can be represented as:
  - Maximize: \( \sum_{i=1}^{n} p_i \cdot x_i \)
  - Where \( p_i \) is the profit of job \( i \) and \( x_i \) is a binary variable that is 1 if job \( i \) is selected, and 0 otherwise.

### Constraints
- **Deadline Constraint:** Each job must be completed by its deadline. This means that job \( i \) can only be scheduled if there is an available time slot before its deadline.
  - For job \( i \) with deadline \( d_i \), it can be scheduled in any slot \( j \) where \( j \leq d_i \).
- **Non-overlapping Jobs:** No two jobs can be scheduled at the same time slot.
  - If job \( i \) is scheduled at time slot \( t \), then no other job can be scheduled at the same time slot \( t \).

### Examples
- **Example 1:**
  - Jobs: [('A', 2, 100), ('B', 1, 50), ('C', 2, 150)]
  - Maximum Deadline: 2
  - Scheduled Jobs: ['C', 'A']
  - Total Profit: 250
- **Example 2:**
  - Jobs: [('A', 1, 20), ('B', 2, 40), ('C', 1, 30), ('D', 3, 10)]
  - Maximum Deadline: 3
  - Scheduled Jobs: ['C', 'B', 'D']
  - Total Profit: 80

### Other Requirements
- **Objective Constraints:**
  - **Space Constraint:** The algorithm should use space proportional to the number of jobs and the maximum deadline. This ensures that the solution is scalable.
  - **Time Constraint:** The algorithm should run in polynomial time, ideally \( O(n \log n) \) due to sorting and \( O(n \cdot d) \) for scheduling, where \( n \) is the number of jobs and \( d \) is the maximum deadline.
  - **Value Constraint:** The profit values and deadlines should be positive integers to ensure meaningful job scheduling and profit maximization.

### Framework
- **Programming Language:** Java
- **Libraries:** CSV (for reading job data), and standard libraries for sorting and data manipulation.

---



## 6. Development of a Model
- **Data Types:** List of tuples (job_id, deadline, profit).
- **Objective Function:** Maximize total profit by selecting jobs that can be completed within their deadlines.
- **Constraints:** 
  - Each job must be completed by its deadline.
  - No two jobs can be scheduled at the same time slot.

---

## 7. Potential Solutions
- Divide & Conquer
- Dynamic Programming
- Greedy Algorithm (Chosen for simplicity and efficiency)
- Graph Algorithm

---

## 8. Designing an Algorithm
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

