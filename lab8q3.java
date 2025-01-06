public class lab8q3 {

    public static class LinkedQueue<E> {
        // Node class for the linked list
        private static class Node<E> {
            private E element;
            private Node<E> next;

            public Node(E element, Node<E> next) {
                this.element = element;
                this.next = next;
            }

            public E getElement() {
                return element;
            }

            public Node<E> getNext() {
                return next;
            }

            public void setNext(Node<E> next) {
                this.next = next;
            }
        }

        private Node<E> head = null;  // Front of the queue
        private Node<E> tail = null;  // End of the queue
        private int size = 0;         // Size of the queue

        // Constructor
        public LinkedQueue() {}

        // Returns the size of the queue
        public int size() {
            return size;
        }

        // Checks if the queue is empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Enqueues a new element
        public void enqueue(E element) {
            Node<E> newNode = new Node<>(element, null);
            if (isEmpty()) {
                head = newNode;
            } else {
                tail.setNext(newNode);
            }
            tail = newNode;
            size++;
        }

        // Dequeues an element
        public E dequeue() {
            if (isEmpty()) return null;
            E element = head.getElement();
            head = head.getNext();
            size--;
            if (isEmpty()) {
                tail = null;
            }
            return element;
        }

        // Returns the first element without removing it
        public E first() {
            if (isEmpty()) return null;
            return head.getElement();
        }

        // Method to concatenate two LinkedQueue objects
        public void concatenate(LinkedQueue<E> Q2) {
            if (Q2.isEmpty()) {
                return;
            }

            if (this.isEmpty()) {
                // If the current queue is empty, just point to Q2's head and tail
                this.head = Q2.head;
            } else {
                // Otherwise, link the tail of the current queue to Q2's head
                this.tail.setNext(Q2.head);
            }

            // Update the tail to Q2's tail
            this.tail = Q2.tail;

            // Update the size
            this.size += Q2.size;

            // Clear Q2
            Q2.head = null;
            Q2.tail = null;
            Q2.size = 0;
        }

        // Main method for testing
        public static void main(String[] args) {
            LinkedQueue<Integer> Q1 = new LinkedQueue<>();
            Q1.enqueue(1);
            Q1.enqueue(2);
            Q1.enqueue(3);

            LinkedQueue<Integer> Q2 = new LinkedQueue<>();
            Q2.enqueue(4);
            Q2.enqueue(5);
            Q2.enqueue(6);

            System.out.println("Before concatenation:");
            System.out.println("Q1 size: " + Q1.size()); // Output: 3
            System.out.println("Q2 size: " + Q2.size()); // Output: 3

            Q1.concatenate(Q2);

            System.out.println("\nAfter concatenation:");
            System.out.println("Q1 size: " + Q1.size()); // Output: 6
            System.out.println("Q2 size: " + Q2.size()); // Output: 0
        }
    }



}
