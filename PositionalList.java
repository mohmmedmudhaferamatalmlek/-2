public interface PositionalList<E> {
    Position<E>first();
    Position<E>last();
    Position<E>after(Position<E>p);
    Position<E>before(Position<E>p);
    int size();
    boolean isEmpty();
    Position<E>addFirst(E e);
    Position<E>addLast(E e);
    Position<E>addBefore(Position<E>p,E e);
    Position<E>addAfter(Position<E>p,E e);
    E set(Position<E>p , E e);
    E remove(Position<E>p);




}
