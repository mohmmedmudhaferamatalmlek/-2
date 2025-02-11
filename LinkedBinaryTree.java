import java.util.Iterator;

public class LinkedBinaryTree <E>extends AbstractBinaryTree<E>{
    protected static class Node<E>implements Position<E>
    {

        E element;
        Node<E>parent;
        Node<E>left;
        Node<E>right;

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public E getElement() {
            return element;
        }
    }
    private Node<E>root=null;
    private int size=0;
    private Node<E>createNode(E e, Node<E>p,Node<E>l,Node<E>r)
    {
        return new Node<E>(e,p,l,r);
    }

    private Node<E>validate(Position<E>p)
    {
        if(! (p instanceof Node))
            throw new IllegalArgumentException("invalid position");
        Node<E>n= (Node<E>) p;
        if (n.parent==n)
            throw new IllegalArgumentException(" This pos is not exist");
        return n;

    }
    public Position<E> left(Position<E> p) {
        Node<E>n=validate(p);
        return n.left;
    }

    public Position<E> right(Position<E> p) {
        Node<E>n=validate(p);
        return n.right;
    }

    public Position<E> root() {
        return root;
    }

    public Position<E> parent(Position<E> p) {
        Node<E>n=validate(p);
        return n.parent;
    }

    public int size() {
        return size;
    }

    public Position<E>addRoot(E e)
    {
        if (!isEmpty())
            throw new IllegalStateException(" there is already root");
        root=createNode(e,null,null,null);
        size=1;
        return root;
    }

    public Position<E>addLeft(Position<E>p,E e)
    {
        Node<E>n= validate(p);
        if (n.left!=null)throw new IllegalStateException("There is already left child");
        Node<E>child= createNode(e,n,null,null);
        n.left=child;
        size++;
        return child;

    }
    public Position<E>addRight(Position<E>p,E e)
    {
        Node<E>n= validate(p);
        if (n.right!=null)throw new IllegalStateException("There is already right child");
        Node<E>child= createNode(e,n,null,null);
        n.right=child;
        size++;
        return child;

    }
    public E set(Position<E>p, E e)
    {
        Node<E>n=validate(p);
        E temp= n.element;
        n.element=e;
        return temp;
    }

    public E remove(Position<E>p)
    {
        Node<E>n= validate(p);
        if (numChildren(p)==2)
            throw new IllegalStateException(" there are tow children");
        Node<E>child=(n.left!=null?n.left: n.right);
        if (child!=null)
            child.parent=n.parent;
        if (n==root)
            root=child;
        else {
            Node<E>par=n.parent;
            if (n==par.left)
                par.left=child;
            else par.right=child;
        }
        size--;
        E temp=n.element;
        n.element=null;
        n.right=null;
        n.left=null;
        n.parent= n;
        return temp;
    }


    public Iterable<Position<E>> positions(Position<E> p) {
        return null;
    }

    public Iterator<E> iterator() {
        return null;
    }
}

