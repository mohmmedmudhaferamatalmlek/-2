public interface Tree<E> extends Iterable<E> {
    Position<E>root();
    Position<E> parent(Position<E>p);
    boolean isEmpty();
    boolean isRoot(Position<E>p);
    boolean isInternal(Position<E>p);
    boolean isExternal(Position<E>p);
    int size();
    int numChildren(Position<E>p);
    Iterable<Position<E>>children(Position<E>p);
    Iterable<Position<E>>positions(Position<E>p);


}

