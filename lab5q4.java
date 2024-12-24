public class lab5q4 {
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
        private final Node<E> tail = null; // Pointer to tail node
        private final int size = 0; // Number of nodes in the list

        // ... other methods of CircularlyLinkedList (addFirst, addLast, removeFirst, etc.) ...

        public boolean equals(CircularlyLinkedList<E> other) {
            if (this == other) {
                return true; // Reflexive: object is equal to itself
            }
            if (this.size() != other.size()) {
                return false; // Different sizes, cannot be equal
            }

            // Find a starting point in other list that matches this list
            Node<E> currentThis = this.tail.next;
            Node<E> currentOther = other.tail.next;
            boolean foundMatch = false;

            while (!foundMatch) {
                // Compare elements of both lists starting from currentOther
                Node<E> tempThis = currentThis;
                Node<E> tempOther = currentOther;
                boolean matchFound = true;

                if (matchFound) {
                    foundMatch = true;
                } else {
                    currentOther = currentOther.getNext();
                }
            }

            return true; // If a matching starting point is found, lists are equal
        }

        private boolean size() {
            return false;
        }

        // ... other methods of CircularlyLinkedList ...

        public void main(String[] args) {
            // Create two CircularlyLinkedList objects
            CircularlyLinkedList<Integer> list1 = new CircularlyLinkedList<>();
            list1.addLast(1);
            list1.addLast(2);
            list1.addLast(3);

            CircularlyLinkedList<Integer> list2 = new CircularlyLinkedList<>();
            list2.addLast(2);
            list2.addLast(3);
            list2.addLast(1);

            CircularlyLinkedList<Integer> list3 = new CircularlyLinkedList<>();
            list3.addLast(3);
            list3.addLast(1);
            list3.addLast(2);

            System.out.println("list1 equals list2: " + list1.equals(list2)); // Expected: true
            System.out.println("list1 equals list3: " + list1.equals(list3)); // Expected: true
        }

        private void addLast(E i) {
        }
    }


}
