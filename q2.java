public class q2 {
    static class SinglyLinkedList<T> {
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

        // العثور على العقدة قبل الأخيرة
        public Node<T> findSecondToLast() {
            // إذا كانت القائمة فارغة أو تحتوي على عقدة واحدة فقط
            if (head == null || head.next == null) {
                return null; // لا توجد عقدة قبل الأخيرة
            }

            Node<T> prev = null; // المؤشر إلى العقدة قبل الحالية
            Node<T> current = head; // المؤشر الحالي

            // اجتياز القائمة حتى نصل إلى آخر عقدة
            while (current.next != null) {
                prev = current; // تحديث المؤشر السابق
                current = current.next; // الانتقال إلى العقدة التالية
            }

            return prev; // العقدة قبل الأخيرة
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
            list.add(10);
            list.add(20);
            list.add(30);
            list.add(40);

            // طباعة القائمة
            System.out.println("القائمة الأصلية:");
            list.printList();

            // العثور على العقدة قبل الأخيرة
            Node<Integer> secondToLast = list.findSecondToLast();
            if (secondToLast != null) {
                System.out.println("العقدة قبل الأخيرة: " + secondToLast.data);
            } else {
                System.out.println("لا توجد عقدة قبل الأخيرة.");
            }

            // اختبار قائمة تحتوي على عقدة واحدة
            SinglyLinkedList<Integer> singleNodeList = new SinglyLinkedList<>();
            singleNodeList.add(10);
            System.out.println("\nقائمة تحتوي على عقدة واحدة فقط:");
            singleNodeList.printList();
            Node<Integer> singleTest = singleNodeList.findSecondToLast();
            if (singleTest != null) {
                System.out.println("العقدة قبل الأخيرة: " + singleTest.data);
            } else {
                System.out.println("لا توجد عقدة قبل الأخيرة.");
            }

            // اختبار قائمة فارغة
            SinglyLinkedList<Integer> emptyList = new SinglyLinkedList<>();
            System.out.println("\nقائمة فارغة:");
            emptyList.printList();
            Node<Integer> emptyTest = emptyList.findSecondToLast();
            if (emptyTest != null) {
                System.out.println("العقدة قبل الأخيرة: " + emptyTest.data);
            } else {
                System.out.println("لا توجد عقدة قبل الأخيرة.");
            }
        }
    }




}
