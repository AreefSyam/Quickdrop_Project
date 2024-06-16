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
Develop a scheduling algorithm that efficiently allocates drone delivery jobs to maximize total profit while adhering to job deadlines.

---

## 5. Development of a Model
- **Data Types:** List of tuples (job_id, deadline, profit).
- **Objective Function:** Maximize total profit by selecting jobs that can be completed within their deadlines.
- **Constraints:** 
  - Each job must be completed by its deadline.
  - No two jobs can be scheduled at the same time slot.

---

## 6. Potential Solutions
- Divide & Conquer
- Dynamic Programming
- Greedy Algorithm (Chosen for simplicity and efficiency)
- Graph Algorithm

---

## 7. Designing an Algorithm
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

## FLowchart
![Flowchart](image/flowchart.png)

## 9.0 Expected Output:
1. **Scheduled Jobs:** A list of job IDs that have been scheduled, maximizing the total profit.
   - Example: ['A', 'C', 'B']
2. **Total Profit:** The sum of the profits of the scheduled jobs.
   - Example: Total Profit: 146
3. **Scheduled Time Slots:** The time slots in which the jobs are scheduled.
   - Example: ['A' at Slot 1, 'C' at Slot 2, 'B' at Slot 3]