public class lab5q1 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class CircularlyLinkedList {
        private Node head;

        public CircularlyLinkedList() {
            this.head = null;
        }

        public void addFirst(int data) {
            // إذا كانت القائمة فارغة
            if (head == null) {
                head = new Node(data);
                head.next = head; // تشير العقدة إلى نفسها
            } else {
                // إضافة العقدة الجديدة مباشرة دون استخدام متغير محلي
                Node newNode = new Node(data);
                newNode.next = head; // تشير إلى الرأس القديم

                // العثور على آخر عقدة لتحديث الرابط
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = newNode; // تحديث الرابط للآخر ليشير إلى العقدة الجديدة
                head = newNode; // تحديث الرأس ليشير إلى العقدة الجديدة
            }
        }

        public void display() {
            if (head == null) {
                System.out.println("Empty list");
                return;
            }
            Node current = head;
            do {
                System.out.print(current.data + " -> ");
                current = current.next;
            } while (current != head);
            System.out.println("(back to head)");
        }

        public void main(String[] args) {
            CircularlyLinkedList cll = new CircularlyLinkedList();
            cll.addFirst(1);
            cll.addFirst(2);
            cll.addFirst(3);

            cll.display();
        }
    }

}
