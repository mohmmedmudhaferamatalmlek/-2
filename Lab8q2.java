public class Lab8q2 {

    public static class ArrayQueue<E> implements Cloneable {
        private E[] data;
        private int front = 0;
        private int size = 0;
        private static final int DEFAULT_CAPACITY = 10;

        // Constructor
        public ArrayQueue() {
            this(DEFAULT_CAPACITY);
        }

        public ArrayQueue(int capacity) {
            data = (E[]) new Object[capacity];
        }

        // Returns the number of elements in the queue
        public int size() {
            return size;
        }

        // Checks if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Adds an element to the back of the queue
        public void enqueue(E element) {
            if (size == data.length) {
                throw new IllegalStateException("Queue is full");
            }
            int availableIndex = (front + size) % data.length;
            data[availableIndex] = element;
            size++;
        }

        // Removes and returns the front element of the queue
        public E dequeue() {
            if (isEmpty()) {
                return null;
            }
            E element = data[front];
            data[front] = null;
            front = (front + 1) % data.length;
            size--;
            return element;
        }

        // Returns the front element without removing it
        public E first() {
            if (isEmpty()) {
                return null;
            }
            return data[front];
        }

        // Clone method for deep copy
        @Override
        public ArrayQueue<E> clone() {
            try {
                // Clone the basic object
                ArrayQueue<E> cloned = (ArrayQueue<E>) super.clone();

                // Create a new array for the cloned object
                cloned.data = (E[]) new Object[data.length];

                // Copy the elements from the original array to the new array
                for (int i = 0; i < size; i++) {
                    cloned.data[i] = data[(front + i) % data.length];
                }

                return cloned;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(); // Shouldn't happen
            }
        }

        // Main method for testing
        public static void main(String[] args) {
            ArrayQueue<Integer> queue = new ArrayQueue<>(5);
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);

            // Cloning the queue
            ArrayQueue<Integer> clonedQueue = queue.clone();

            // Checking the original and cloned queues
            System.out.println("Original queue first element: " + queue.first()); // Output: 1
            System.out.println("Cloned queue first element: " + clonedQueue.first()); // Output: 1

            // Modifying the original queue
            queue.dequeue();
            System.out.println("After dequeue, original queue first element: " + queue.first()); // Output: 2
            System.out.println("Cloned queue first element: " + clonedQueue.first()); // Output: 1
        }
    }


}
