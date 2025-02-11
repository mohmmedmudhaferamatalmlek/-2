import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private static class Node<T> {
        private T element;
        private Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public int size() {
        return size;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public T last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }


    public void addFirst(T e) {
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }

    public void addLast(T e)
    {
        Node<T>newest= new Node<>(e,null);
        if (size==0)
            head=newest;
        else
            tail.setNext(newest);
        tail= tail.next;
        size++;
}
public T removeFirst()
{
    if (isEmpty())return null;
    T deleted = head.element;
    head=head.next;
    size--;
    if (size==0)
        tail=null;
    return deleted;
}
public String getAll()
{
    String all="";
    Node<T>p=head;
    while (p!=null)
    {
        all=all+p.element+"   ";
        p=p.next;
    }
    return all;
}
    // 1.
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SinglyLinkedList<?> other = (SinglyLinkedList<?>) obj;
        if (size != other.size) {
            return false;
        }
        Node<T> current1 = head;
        Node<?> current2 = other.head;
        while (current1 != null) {
            if (!current1.getElement().equals(current2.getElement())) {
                return false;
            }
            current1 = current1.getNext();
            current2 = current2.getNext();
        }
        return true;
    }

    // 2.
    public T secondToLast() {
        if (size < 2) {
            throw new NoSuchElementException();
        }
        Node<T> current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        return current.getElement();
    }

    // 3.
    public int sizeWithoutInstanceVariable() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    // 4.
    public void rotate() {
        if (isEmpty()) {
            return;
        }
        Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(head);
        head = head.getNext();
        current.getNext().setNext(null);
        tail.setNext(current);
        tail=current;

    }

    // 5.
    public void concatenate(SinglyLinkedList<T> M) {
        if (M.isEmpty()) {
            return;
        } if (this.isEmpty()){
           this.head=M.head;
           this.tail=M.tail;
            }
        else{
            this.tail.setNext(M.head);
            this.tail=M.tail;
        }
          this.size +=M.size;
        }


    // 6.
    public void reverse() {
        if (isEmpty() || size == 1) {
            return;
        }
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }



}
