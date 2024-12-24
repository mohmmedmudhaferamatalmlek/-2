
    public class CircularlyLinkedList<E> {

        public boolean isEmpty() {
            return extracted();
        }

        private static boolean extracted() {
            boolean empty = false;
            return empty;
        }

        public void setEmpty(int empty) {
            this.size = empty;
        }

        // Node class for the CircularlyLinkedList
        private static class Node<E> {
            private E element;
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

        public boolean equals(Object o) {
            if (this == o) {
                return true; // Reflexive: object is equal to itself
            }
            if (!(o instanceof CircularlyLinkedList)) {
                return false; // Not equal if o is not a CircularlyLinkedList
            }

            CircularlyLinkedList<E> other = (CircularlyLinkedList<E>) o;

            // Check if both lists are empty
            if (this.isEmpty() && other.isEmpty()) {
                return true;
            }

            // Check if one list is empty and the other is not
            if (this.isEmpty() || other.isEmpty()) {
                return false;
            }

            // Check if both lists have the same size
            if (this.size() != other.size()) {
                return false;
            }

            // Iterate through both lists and compare elements
            Node<E> walk1 = this.tail.next; // Start from the first node of this list
            Node<E> walk2 = other.tail.next; // Start from the first node of other list

            do {
                if (!walk1.getElement().equals(walk2.getElement())) {
                    return false; // Elements don't match
                }
                walk1 = walk1.getNext();
                walk2 = walk2.getNext();
            } while (walk1 != this.tail);

            return true; // All elements matched
        }

        private Object size() {
            return null;
        }

        // ... other methods of CircularlyLinkedList ...

        public static void main(String[] args) {
            // Create two CircularlyLinkedList objects
            CircularlyLinkedList<Integer> list1 = new CircularlyLinkedList<>();
            list1.addLast(1);
            list1.addLast(2);
            list1.addLast(3);

            CircularlyLinkedList<Integer> list2 = new CircularlyLinkedList<>();
            list2.addLast(1);
            list2.addLast(2);
            list2.addLast(3);

            // Create a third list with different elements
            CircularlyLinkedList<Integer> list3 = new CircularlyLinkedList<>();
            list3.addLast(3);
            list3.addLast(2);
            list3.addLast(1);

            // Create a fourth list with different size
            CircularlyLinkedList<Integer> list4 = new CircularlyLinkedList<>();
            list4.addLast(1);
            list4.addLast(2);

            System.out.println("list1 equals list2: " + list1.equals(list2)); // Expected: true
            System.out.println("list1 equals list3: " + list1.equals(list3)); // Expected: false
            System.out.println("list1 equals list4: " + list1.equals(list4)); // Expected: false
        }

        private void addLast(E i) {
        }
    }


