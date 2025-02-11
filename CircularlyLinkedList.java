public class CircularlyLinkedList<E>  {

    private static class Node<E> {
        private E element;
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

    private Node<E> tail = null;

    public CircularlyLinkedList() {
    }

    public int size() {
        if (tail == null) {
            return 0;
        }
        int count = 1;
        Node<E> current = tail.getNext();
        while (current != tail) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    public void addFirst(E e) {
        if (tail == null) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            tail.setNext(new Node<>(e, tail.getNext()));
        }
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> head = tail.getNext();
        if (head == tail) {
            tail = null;
        } else {
            tail.setNext(head.getNext());
        }
        return head.getElement();
    }


    public static void main(String[] args) {
        CircularlyLinkedList<Integer> list1 = new CircularlyLinkedList<>();

        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);

        System.out.println("Original list size: " + list1.size());
    }
}

