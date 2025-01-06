import java.util.Arrays;

public class lab7three {public class ArrayStack<E> implements Cloneable {
    private E[] data;
    private int top;

    // ... other methods

    public ArrayStack<E> clone() {
        try {
            @SuppressWarnings("unchecked")
            ArrayStack<E> clone = (ArrayStack<E>) super.clone();
            clone.data = Arrays.copyOf(data, data.length);
            return clone;
        } catch (CloneNotSupportedException e) {
            // Should not happen
            throw new AssertionError();
        }
    }
}
}
