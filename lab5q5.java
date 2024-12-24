public class lab5q5 {
    public static class CircularlyLinkedList<E> {

        // Node class for the CircularlyLinkedList
        private static class Node<E> {
            private final E element;
            private Node<E> next;

            public Node(E e, Node<E> n) {
                element = e;
                next = n;
            }

            public E getElement() {
                return element;
            }

            public Node<E> getNext() {
                return next;
            }

            public void setNext(Node<E> n) {
                next = n;
            }
        }

        // Fields of the CircularlyLinkedList
        private Node<E> tail = null; // Pointer to tail node
        private int size = 0; // Number of nodes in the list

        // ... other methods of CircularlyLinkedList (addFirst, addLast, removeFirst, etc.) ...

        public void split(CircularlyLinkedList<E> other) {
            if (this.size() % 2 != 0) {
                throw new IllegalArgumentException("List size must be even");
            }

            if (this.size() == 0) {
                return; // Both lists are empty
            }

            // Find the middle node
            Node<E> slow = this.tail.next;
            Node<E> fast = this.tail.next;
            for (int i = 0; i < this.size() / 2; i++) {
                fast = fast.getNext().getNext();
                slow = slow.getNext();
            }

            // Split the list
            other.tail = this.tail;
            this.tail = slow;
            other.tail.next = fast;
            this.tail.next = slow;

            // Update sizes
            this.size /= 2;
            other.size = this.size;
        }

        private int size() {
            return 0;
        }

        // ... other methods of CircularlyLinkedList ...

        public static void main(String[] args) {
            // Create a CircularlyLinkedList
            CircularlyLinkedList<Integer> list1 = new CircularlyLinkedList<>();
            list1.addLast(1);
            list1.addLast(2);
            list1.addLast(3);
            list1.addLast(4);

            // Create a second CircularlyLinkedList to store the split portion
            CircularlyLinkedList<Integer> list2 = new CircularlyLinkedList<>();

            // Split the list
            list1.split(list2);

            // Print the elements of both lists
            System.out.print("List 1: ");
            Node<Integer> current = list1.tail.next;
            do {
                System.out.print(current.getElement() + " ");
                current = current.getNext();
            } while (current != list1.tail);
            System.out.println();

            System.out.print("List 2: ");
            current = list2.tail.next;
            do {
                System.out.print(current.getElement() + " ");
                current = current.getNext();
            } while (current != list2.tail);
            System.out.println();
        }

        private void addLast(E i) {
        }
    }
}
