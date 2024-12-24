public class lab5Q2 {
    public class CircularlyLinkedList<E> {
        // العقدة الداخلية
        private static class Node<E> {
            private E element;       // العنصر المخزن في العقدة
            private Node<E> next;    // الإشارة إلى العقدة التالية

            public Node(E element, Node<E> next) {
                this.element = element;
                this.next = next;
            }

            public E getElement() {
                return element;
            }

            public Node<E> getNext() {
                return next;
            }

            public void setNext(Node<E> next) {
                this.next = next;
            }
        }

        private Node<E> tail = null; // إشارة إلى آخر عقدة في القائمة

        // طريقة لإضافة عنصر في نهاية القائمة


    }
}
