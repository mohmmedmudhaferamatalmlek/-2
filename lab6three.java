public class lab6three {class Node {
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

        // Concatenation method
        public DoublyLinkedList concatenate(DoublyLinkedList other) {
            // Connect the trailer of L to the header of M
            this.trailer.prev.next = other.header.next;
            other.header.next.prev = this.trailer.prev;

            // Connect the header of L to the trailer of M
            this.trailer = other.trailer;
            this.trailer.prev = this.header.prev;
            this.header.prev.next = this.trailer;

            // Return the concatenated list (L)
            return this;
        }
    }
}
