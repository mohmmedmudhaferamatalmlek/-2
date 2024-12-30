public class lab6six {class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

    class CircularDoublyLinkedList {
        private Node head;

        public CircularDoublyLinkedList() {
            head = null;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void addFirst(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                newNode.next = newNode;
                newNode.prev = newNode;
            } else {
                newNode.next = head;
                newNode.prev = head.prev;
                head.prev.next = newNode;
                head.prev = newNode;
                head = newNode;
            }
        }

        public void addLast(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                newNode.next = newNode;
                newNode.prev = newNode;
            } else {
                newNode.next = head;
                newNode.prev = head.prev;
                head.prev.next = newNode;
                head.prev = newNode;
            }
        }

        public void removeFirst() {
            if (head == null) {
                return;
            }
            if (head.next == head) {
                head = null;
            } else {
                head.next.prev = head.prev;
                head.prev.next = head.next;
                head = head.next;
            }
        }

        public void removeLast() {
            if (head == null) {
                return;
            }
            if (head.next == head) {
                head = null;
            } else {
                head.prev.prev.next = head;
                head.prev = head.prev.prev;
            }
        }

        public void rotate() {
            if (head != null) {
                head = head.next;
            }
        }

        public void rotateBackward() {
            if (head != null) {
                head = head.prev;
            }
        }

        // ... other methods like size(), contains(), etc.
    }
}
