public class q3 {
    class SinglyLinkedList<T> {
        // تعريف العقدة الداخلية
        private static class Node<T> {
            T data; // قيمة العقدة
            Node<T> next; // المؤشر إلى العقدة التالية

            Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node<T> head; // رأس القائمة

        // مُنشئ القائمة
        public SinglyLinkedList() {
            this.head = null;
        }

        // إضافة عنصر إلى نهاية القائمة
        public void add(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) { // إذا كانت القائمة فارغة
                head = newNode;
                return;
            }
            Node<T> current = head;
            while (current.next != null) { // الوصول إلى آخر عنصر
                current = current.next;
            }
            current.next = newNode; // ربط العقدة الجديدة بآخر عقدة
        }

        // حساب حجم القائمة (عدد العقد)
        public int size() {
            int count = 0; // متغير لحساب العقد
            Node<T> current = head; // ابدأ من رأس القائمة

            while (current != null) { // اجتياز القائمة حتى الوصول إلى null
                count++; // زيادة العداد عند كل عقدة
                current = current.next; // الانتقال إلى العقدة التالية
            }

            return count; // إرجاع عدد العقد
        }

        // طباعة عناصر القائمة
        public void printList() {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
            }
        }
    }
}