public class lab8Q1 {
    public static class ArrayQueue<E> {
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

        // The rotate method (efficient implementation)
        public void rotate() {
            if (size > 0) {
                front = (front + 1) % data.length;
            }
        }

        // Main method for testing
        public static void main(String[] args) {
            ArrayQueue<Integer> queue = new ArrayQueue<>(5);
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);

            System.out.println("Front element before rotate: " + queue.first()); // Output: 1
            queue.rotate();
            System.out.println("Front element after rotate: " + queue.first()); // Output: 2
        }
    }


}
