import java.util.Iterator;

public class PositionalLinkedList<E>implements PositionalList<E>, Iterable<E> {
    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
    private class ElementIterator implements Iterator<E>
    {
       PositionIterator pos= new PositionIterator();

        @Override
        public boolean hasNext() {
            return pos.hasNext();
        }

        @Override
        public E next() {
           return pos.next().getElement();
        }
    }
    private class PositionIterator implements Iterator<Position<E>>
    {
        Position<E>recent=null;
        Position<E>cursor=first();

        @Override
        public boolean hasNext() {
            return cursor!=null;
        }

        @Override
        public Position<E> next() {
            if (cursor==null)
                throw new IllegalStateException(" no more element");
            recent=cursor;
            cursor=after(cursor);
            return recent;
        }
    }
    private static class Node<E> implements Position<E>
   {
E element;
Node<E>prev;
Node<E>next;

       public Node(E element, Node<E> prev, Node<E> next) {
           this.element = element;
           this.prev = prev;
           this.next = next;
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

       public E getElement() {
           return element;
       }
   }
   private Node<E>header;
   private Node<E>trailer;
   private int size=0;
   public PositionalLinkedList()
   {
       header= new Node<E>(null,null,null);
       trailer= new Node<E>(null,header,null);
       header.next=trailer;
   }

   private Node<E>validate(Position<E>p)
   {
       if (!(p instanceof  Node))
           throw new IllegalArgumentException("invalid position");
       Node<E>n=(Node<E>) p;
       if (n.next==null)
           throw new IllegalArgumentException(" p is not exisist anymore");
       return n;
   }
   private Position<E>position(Node<E> n)
   {
       if (n==header||n==trailer)
           return null;
       return n;
   }

    public Position<E> first() {
        return position(header.next);
    }

    public Position<E> last() {
        return position(trailer.prev);
    }

    public Position<E> after(Position<E> p) {
        Node<E>n=validate(p);
        return position(n.next);


    }

    public Position<E> before(Position<E> p) {
        Node<E>n=validate(p);
        return position(n.prev);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }
    private Position<E>addBetween(E e, Node<E>p, Node<E>n)
    {
        Node<E>newest= new Node<E>(e,p,n);
        p.next=newest;
        n.prev=newest;
        size++;
        return newest;
    }

    public Position<E> addFirst(E e) {
        return addBetween(e,header,header.next);
    }

    public Position<E> addLast(E e) {
        return addBetween(e, trailer.prev,trailer);
    }

    public Position<E> addBefore(Position<E> p, E e) {
       Node<E>n= validate(p);

        return addBetween(e,n.prev,n);
    }

    public Position<E> addAfter(Position<E> p, E e) {
        Node<E>n= validate(p);
        return addBetween(e,n,n.next);
    }

    public E set(Position<E> p, E e) {
       Node<E>n= validate(p);
       E temp=n.element;
       n.element=e;
        return temp;
    }

    public E remove(Position<E> p) {
       Node<E>n= validate(p);
       Node<E>pre=n.prev;
       Node<E>nx=n.next;
       pre.next=nx;
       nx.prev=pre;
       E temp= n.element;
       n.element=null;
       n.prev=null;
       n.next=null;
       size--;
        return temp;
    }
}
