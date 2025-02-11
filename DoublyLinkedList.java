public class DoublyLinkedList<E> {
    private static class Node<E>{
        private E element;
        private Node<E>prev;
        private Node<E>next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    private Node<E>header;
    private Node<E>trailer;
    private int size=0;
    public DoublyLinkedList(){
        header= new Node<>(null,null,null);
        trailer= new Node<>(null,header,null);
        header.setNext(trailer);
    }

    public int size(){
        return size;
    }
    public boolean isEmpty()

    {
        return size==0;
    }
    public E first()
    {
        if (isEmpty())return null;
        return header.getNext().getElement();
    }
    public E last()
    {
        if (isEmpty())return null;
        return trailer.getPrev().getElement();
    }

    private void addBetween(E e,Node<E>p,Node<E>n)
    {
        Node<E>x= new Node<>(e,p,n);
        p.setNext(x);
        n.setPrev(x);
        size++;
    }
    public void addFirst(E e)
    {
        addBetween(e,header,header.next);
    }
    public void addLast(E e)
    {
        addBetween(e,trailer.prev,trailer);
    }
    private E remove(Node<E>x)
    {
        Node<E>p=x.prev;
        Node<E>n=x.next;
        p.setNext(n);
        n.setPrev(p);
        size--;
        return x.element;
    }

    public E removeFirst()
    {
        if (isEmpty())return null;
        return remove(header.next);
    }
    public E removeLast()
    {
        if (isEmpty())return null;
        return remove(trailer.prev);
    }
}

