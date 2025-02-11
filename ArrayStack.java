public class ArrayStack <E> implements Stack<E>{
   private E[]data;
   private int t=-1;

   public ArrayStack(int cap)
   {
     data=(E[])new Object[cap];
   }
    @Override
    public int size() {
        return t+1;
    }

    @Override
    public boolean isEmpty() {
        return t==-1;
    }

    @Override
    public E top() {
       if (isEmpty())return null;
       return data[t];
    }

    @Override
    public void push(E e) {
        if (t==data.length-1)
            throw new IllegalStateException("Stack is Full");
        data[++t]=e;

    }

    @Override
    public E pop() {
       if (isEmpty())return null;
       E temp=data[t];
       data[t]=null;
       t--;
       return temp;
    }
}
