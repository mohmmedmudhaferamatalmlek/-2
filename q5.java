public class q5 {
    static class SinglyLinkedList<T> {
        // تعريف العقدة الداخلية
        private static class Node<T> {
            T data;        // قيمة العقدة
            Node<T> next;  // المؤشر إلى العقدة التالية

            Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node<T> head; // رأس القائمة
        private Node<T> tail; // نهاية القائمة

        // مُنشئ القائمة
        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        // إضافة عنصر إلى نهاية القائمة
        public void add(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) { // إذا كانت القائمة فارغة
                head = tail = newNode; // العقدة الجديدة هي الرأس والذيل
            } else {
                tail.next = newNode; // ربط العقدة الجديدة بآخر عقدة
                tail = newNode;      // تحديث المؤشر tail
            }
        }

        // طباعة عناصر القائمة
        public void printList() {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }

        // دمج قائمتين L و M في قائمة جديدة L'
        public static <T> SinglyLinkedList<T> concatenate(SinglyLinkedList<T> L, SinglyLinkedList<T> M) {
            // إنشاء قائمة جديدة لاحتواء العناصر المدمجة
            SinglyLinkedList<T> result = new SinglyLinkedList<>();

            // إضافة جميع عناصر القائمة L إلى القائمة الجديدة
            Node<T> current = L.head;
            while (current != null) {
                result.add(current.data);
                current = current.next;
            }

            // إضافة جميع عناصر القائمة M إلى القائمة الجديدة
            current = M.head;
            while (current != null) {
                result.add(current.data);
                current = current.next;
            }

            return result; // إرجاع القائمة الجديدة
        }

        public static void main(String[] args) {
            // إنشاء القائمة الأولى L
            SinglyLinkedList<Integer> L = new SinglyLinkedList<>();
            L.add(1);
            L.add(2);
            L.add(3);

            // إنشاء القائمة الثانية M
            SinglyLinkedList<Integer> M = new SinglyLinkedList<>();
            M.add(4);
            M.add(5);
            M.add(6);

            // طباعة القائمتين
            System.out.println("القائمة L:");
            L.printList();

            System.out.println("القائمة M:");
            M.printList();

            // دمج القائمتين في قائمة جديدة
            SinglyLinkedList<Integer> concatenatedList = SinglyLinkedList.concatenate(L, M);

            // طباعة القائمة المدمجة
            System.out.println("القائمة المدمجة L':");
            concatenatedList.printList();
        }
    }




}
