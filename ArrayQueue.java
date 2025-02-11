public class ArrayQueue<E>implements Queue<E> {
    private E[]data;
    private int f=0;
    private int sz=0;
    public ArrayQueue(int cap)
    {
        data= (E[])new Object[cap];
    }

    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean isEmpty() {
        return sz==0;
    }

    @Override
    public E first() {
       if (isEmpty())return null;
       return data[f];
    }

    @Override
    public void enqueue(E e) {
        if (sz==data.length)
            throw new IllegalStateException("Queue is full");
        int x= (f+sz)%data.length;
        data[x]=e;
        sz++;

    }

    @Override
    public E dequeue() {
        if (isEmpty())return null;
        E temp=data[f];
        data[f]=null;
        f=(f+1)%data.length;
        sz--;
        return temp;
    }
}
