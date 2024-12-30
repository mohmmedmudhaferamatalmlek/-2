public class lab6sesven {class Node {
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
        private Node head;

        // ... other methods

        public DoublyLinkedList clone() {
            if (head == null) {
                return null; // قائمة فارغة
            }

            // إنشاء رأس جديد للقائمة النسخة
            Node newHead = new Node(head.data);
            Node newTail = newHead;
            Node current = head.next;

            // نسخ العقد المتبقية
            while (current != head) {
                Node newNode = new Node(current.data);
                newTail.next = newNode;
                newNode.prev = newTail;
                newTail = newNode;
                current = current.next;
            }

            // إغلاق الدائرة في القائمة النسخة
            newTail.next = newHead;
            newHead.prev = newTail;

            // إنشاء قائمة جديدة وإرجاعها
            DoublyLinkedList clone = new DoublyLinkedList();
            clone.head = newHead;
            return clone;
        }
    }
}
