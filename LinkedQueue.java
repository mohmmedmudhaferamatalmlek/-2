public class LinkedQueue <E>implements Queue<E>{

    DoublyLinkedList<E>l= new DoublyLinkedList<>();

    @Override
    public int size() {
        return l.size();
    }

    @Override
    public boolean isEmpty() {
        return l.isEmpty();
    }

    @Override
    public E first() {
        return l.last();
    }

    @Override
    public void enqueue(E e) {
        l.addFirst(e);
    }

    @Override
    public E dequeue() {
        return l.removeLast();
    }
}

