import java.util.LinkedList;
import java.util.Queue;
public class lab8q4 {

    public class JosephusProblem {

        // Method to solve Josephus problem using a queue
        public static int solveJosephus(int n, int k) {
            Queue<Integer> queue = new LinkedList<>();

            // Enqueue all people from 1 to n
            for (int i = 1; i <= n; i++) {
                queue.add(i);
            }

            // Process the queue until one person remains
            while (queue.size() > 1) {
                // Skip k-1 people
                for (int i = 1; i < k; i++) {
                    queue.add(queue.remove());
                }

                // Remove the k-th person
                queue.remove();
            }

            // The last remaining person is the survivor
            return queue.peek();
        }

        // Main method to test the solution
        public static void main(String[] args) {
            int n = 7;  // Number of people
            int k = 3;  // Step count
            int survivor = solveJosephus(n, k);

            System.out.println("The survivor is person number: " + survivor);
        }
    }

}
