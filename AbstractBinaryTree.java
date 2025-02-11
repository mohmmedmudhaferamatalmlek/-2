import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class AbstractBinaryTree <E> extends AbstractTree<E> implements BinaryTree<E>{
    public Position<E> sibling(Position<E> p) {
        Position<E>par=parent(p);
        if (left(par)==p)
            return right(par);
        else
            return left(par);
    }

    public int numChildren(Position<E> p) {
        int sum=0;
        if (left(p)!=null)
            sum++;
        if (right(p)!=null)
            sum++;
        return sum;
    }

    public Iterable<Position<E>> children(Position<E> p) {
        ArrayList<Position<E>>all= new ArrayList<Position<E>>();
        if (left(p)!=null)
            all.add(left(p));
        if (right(p)!=null)
            all.add(right(p));
        return all;
    }
}

