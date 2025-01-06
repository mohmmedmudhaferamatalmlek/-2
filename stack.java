import java.util.EmptyStackException;
public class stack<T> {
    private Node<T> top;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void clear() {
        if (!isEmpty()) {
            pop(); // Remove the top element
            clear(); // Recursively clear the remaining stack
        }
    }
}
