public class lab6five {class Node {
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

        // ... other methods

        public boolean equals(Object obj) {
            if (this == obj) {
                return true; // نفس المرجع
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false; // ليس نفس النوع
            }

            DoublyLinkedList other = (DoublyLinkedList) obj;

            Node current1 = this.sentinel.next;
            Node current2 = other.sentinel.next;

            while (current1 != this.sentinel && current2 != other.sentinel) {
                if (current1.data != current2.data) {
                    return false; // البيانات لا تتطابق
                }
                current1 = current1.next;
                current2 = current2.next;
            }

            // التأكد من أن كلا القائمتين لهما نفس الطول
            return current1 == this.sentinel && current2 == other.sentinel;
        }
    }
}
