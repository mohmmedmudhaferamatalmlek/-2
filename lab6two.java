public class lab6two {class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

    class DoublyLinkedList {
        Node header;
        Node trailer;

        public DoublyLinkedList() {
            header = new Node(0);
            trailer = new Node(0);
            header.next = trailer;
            trailer.prev = header;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            newNode.prev = trailer.prev;
            newNode.next = trailer;
            trailer.prev.next = newNode;
            trailer.prev = newNode;
        }

        public Node findMiddleNode() {
            Node slow = header;
            Node fast = header;

            while (fast != trailer && fast.next != trailer) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        // 1. Implementation of size() method
        public int size() {
            int count = 0;
            Node current = header.next;
            while (current != trailer) {
                count++;
                current = current.next;
            }
            return count;
        }

        // 2. Implementation of equals() method
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            DoublyLinkedList other = (DoublyLinkedList) obj;

            Node current1 = this.header.next;
            Node current2 = other.header.next;

            while (current1 != this.trailer && current2 != other.trailer) {
                if (current1.data != current2.data) {
                    return false;
                }
                current1 = current1.next;
                current2 = current2.next;
            }

            // Check if both lists have the same number of nodes
            return current1 == this.trailer && current2 == other.trailer;
        }
    }
}
