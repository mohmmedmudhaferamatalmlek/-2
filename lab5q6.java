public class lab5q6 {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class CircularlyLinkedList {
        private Node head;

        public CircularlyLinkedList() {
            this.head = null;
        }

        public void append(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                newNode.next = head;
            } else {
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = newNode;
                newNode.next = head;
            }
        }

        public CircularlyLinkedList clone() {
            if (head == null) {
                return new CircularlyLinkedList(); // Return an empty list if the original is empty.
            }

            CircularlyLinkedList cloneList = new CircularlyLinkedList();
            Node current = head;

            // First copy the head node
            cloneList.append(current.data);
            current = current.next;

            // Copy the rest of the nodes
            while (current != head) {
                cloneList.append(current.data);
                current = current.next;
            }

            return cloneList;
        }

        public String display() {
            if (head == null) {
                return "Empty list";
            }
            StringBuilder result = new StringBuilder();
            Node current = head;
            do {
                result.append(current.data).append(" -> ");
                current = current.next;
            } while (current != head);
            result.append("(back to head)");
            return result.toString();
        }

        public void main(String[] args) {
            CircularlyLinkedList cll = new CircularlyLinkedList();
            cll.append(1);
            cll.append(2);
            cll.append(3);

            System.out.println("Original list: " + cll.display());

            CircularlyLinkedList clonedCll = cll.clone();
            System.out.println("Cloned list: " + clonedCll.display());
        }
    }



}
