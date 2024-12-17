public class q6 {
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

        // مُنشئ القائمة
        public SinglyLinkedList() {
            this.head = null;
        }

        // إضافة عنصر إلى نهاية القائمة
        public void add(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) { // إذا كانت القائمة فارغة
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode; // إضافة العقدة الجديدة في النهاية
            }
        }

        // عكس القائمة المرتبطة
        public void reverse() {
            Node<T> prev = null;       // المؤشر إلى العقدة السابقة
            Node<T> current = head;    // المؤشر إلى العقدة الحالية
            Node<T> next = null;       // المؤشر إلى العقدة التالية

            while (current != null) {
                next = current.next;   // حفظ العقدة التالية
                current.next = prev;   // عكس المؤشر: العقدة الحالية تشير إلى العقدة السابقة
                prev = current;        // تحريك prev إلى العقدة الحالية
                current = next;        // تحريك current إلى العقدة التالية
            }
            head = prev; // تحديث الرأس ليصبح العقدة الأخيرة (بعد الانتهاء)
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

        public static void main(String[] args) {
            // إنشاء قائمة جديدة
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

            // إضافة عناصر إلى القائمة
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);

            // طباعة القائمة قبل العكس
            System.out.println("القائمة الأصلية:");
            list.printList();

            // عكس القائمة
            list.reverse();

            // طباعة القائمة بعد العكس
            System.out.println("القائمة بعد العكس:");
            list.printList();
        }
    }



















}
