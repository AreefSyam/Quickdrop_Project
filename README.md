# Quickdrop-project
Online portfolio for the QuickDrop drone delivery service project

## Group Name:
Super Saiyan

## Team Members & Roles:
1. MUHAMMAD ARIF AIMAN BIN MOHD HISAM	(LEADER)
2. NURDIYANA ATHIRAH BINTI MOHD ASMAN	(DESIGNER)
3. MUHAMAD ZUL AIMAN BIN MOHD AMRAN	(DEVELOPER)

## Problem Scenario:
In a bustling metropolitan area, QuickDrop, a drone delivery service, aims to maximize profits by optimally scheduling delivery jobs. Each delivery job has a deadline and associated profit. The company needs to ensure timely deliveries to enhance customer satisfaction and operational efficiency.

## Why It Is Important:
Efficient job scheduling is crucial for QuickDrop to maximize revenue, improve delivery times, and maintain high customer satisfaction levels.

## Problem Statement:
QuickDrop, a drone delivery service, faces the challenge of maximizing its total profit by optimally scheduling delivery jobs within their respective deadlines, ensuring timely deliveries and enhancing customer satisfaction.

## Objectives:
To develop a scheduling algorithm that efficiently allocates drone delivery jobs to maximize total profit while adhering to job deadlines and operational constraints, thus improving overall service efficiency and customer satisfaction.

## Expected Output:
1. Scheduled Jobs: A list of job IDs that have been scheduled, maximizing the total profit.
   - Example: ['A', 'C', 'B']
2. Total Profit: The sum of the profits of the scheduled jobs.
   - Example: Total Profit: 146
3. Scheduled Time Slots: The time slots in which the jobs are scheduled.
   - Example: ['A' at Slot 1, 'C' at Slot 2, 'B' at Slot 3]

## Problem Specification:
1. Data Types: Jobs represented as a list of tuples with (job_id, deadline, profit).
2. Objective Function: Maximize total profit by selecting jobs that can be completed within their deadlines.
3. Constraints: Each job must be completed by its deadline; no two jobs can be scheduled at the same time slot.

## Potential Solutions:
1. Greedy Algorithm
2. Dynamic Programming
3. Divide and Conquer
4. Graph Algorithms

## Sketch (Framework, Flow, Interface):
1. Framework: Python or Java for implementation.
2. Flow: Input jobs, sort by profit, schedule based on deadlines.
3. Interface: Command-line interface or simple graphical interface showing scheduled jobs and total profit.



