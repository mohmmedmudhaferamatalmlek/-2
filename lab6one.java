public class lab6one {class Node {
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
    }
}
