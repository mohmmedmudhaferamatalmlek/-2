public class q4 {
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
                tail.next = newNode; // ربط العقدة الجديدة بنهاية القائمة
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

        // تنفيذ عملية الدوران (rotate)
        public void rotate() {
            // التحقق من الحالات الخاصة: إذا كانت القائمة فارغة أو تحتوي على عقدة واحدة فقط
            if (head == null || head.next == null) {
                return; // لا داعي لإجراء أي تغييرات
            }

            // تحديد أول عقدة (head) والعقدة الثانية
            Node<T> first = head;   // أول عقدة
            head = head.next;       // تحديث الرأس ليصبح ثاني عقدة
            first.next = null;      // قطع الرابط من العقدة الأولى

            // ربط العقدة الأولى في نهاية القائمة
            tail.next = first;      // ربط tail الحالي بالعقدة الأولى
            tail = first;           // تحديث tail ليشير إلى العقدة الأولى
        }

        public static void main(String[] args) {
            // إنشاء قائمة جديدة
            SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

            // إضافة عناصر إلى القائمة
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(40);
            list.add(50);

            // طباعة القائمة قبل الدوران
            System.out.println("القائمة قبل الدوران:");
            list.printList();

            // تنفيذ عملية الدوران
            list.rotate();

            // طباعة القائمة بعد الدوران
            System.out.println("القائمة بعد الدوران:");
            list.printList();

            // تنفيذ عملية دوران أخرى
            list.rotate();
            System.out.println("القائمة بعد دوران آخر:");
            list.printList();
        }
    }




}
