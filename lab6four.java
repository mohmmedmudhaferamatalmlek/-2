public class lab6four {class Node {
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
        Node sentinel;

        public DoublyLinkedList() {
            sentinel = new Node(0);
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            newNode.prev = sentinel;
            newNode.next = sentinel.next;
            sentinel.next.prev = newNode;
            sentinel.next = newNode;
        }

        public Node findMiddleNode() {
            Node slow = sentinel.next;
            Node fast = sentinel.next;

            while (fast != sentinel && fast.next != sentinel) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        public int size() {
            int count = 0;
            Node current = sentinel.next;
            while (current != sentinel) {
                count++;
                current = current.next;
            }
            return count;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            DoublyLinkedList other = (DoublyLinkedList) obj;

            Node current1 = this.sentinel.next;
            Node current2 = other.sentinel.next;

            while (current1 != this.sentinel && current2 != other.sentinel) {
                if (current1.data != current2.data) {
                    return false;
                }
                current1 = current1.next;
                current2 = current2.next;
            }

            return current1 == this.sentinel && current2 == other.sentinel;
        }

        public DoublyLinkedList concatenate(DoublyLinkedList other) {
            this.sentinel.prev.next = other.sentinel.next;
            other.sentinel.next.prev = this.sentinel.prev;

            this.sentinel.prev = other.sentinel.prev;
            other.sentinel.prev.next = this.sentinel;

            return this;
        }
    }
}
