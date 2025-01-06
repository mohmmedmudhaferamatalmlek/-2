
import java.util.LinkedList;
import java.util.Queue;

public class lab8q5 {

    public class RoundRobinScheduling {

        // Method to simulate Round Robin Scheduling
        public static void roundRobin(int[] processes, int[] burstTime, int timeQuantum) {
            Queue<Integer> queue = new LinkedList<>();

            // Enqueue all process IDs
            for (int i = 0; i < processes.length; i++) {
                queue.add(i);
            }

            int[] remainingTime = burstTime.clone();  // Copy of burst times to track remaining time

            System.out.println("Process execution order:");

            while (!queue.isEmpty()) {
                // Dequeue the next process
                int currentProcess = queue.poll();

                // Execute the process for the time quantum or remaining time, whichever is smaller
                int executionTime = Math.min(timeQuantum, remainingTime[currentProcess]);
                remainingTime[currentProcess] -= executionTime;

                // Print the execution step
                System.out.println("Process " + processes[currentProcess] + " executed for " + executionTime + " units.");

                // If the process still has remaining time, enqueue it again
                if (remainingTime[currentProcess] > 0) {
                    queue.add(currentProcess);
                }
            }

            System.out.println("All processes completed.");
        }

        // Main method to test the Round Robin Scheduling simulation
        public static void main(String[] args) {
            int[] processes = {1, 2, 3, 4};        // Process IDs
            int[] burstTime = {5, 15, 7, 10};       // Burst times for each process
            int timeQuantum = 4;                    // Time quantum

            roundRobin(processes, burstTime, timeQuantum);
        }
    }

}
