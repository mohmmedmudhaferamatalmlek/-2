import java.util.Objects;
public class singly {
    static class SinglyLinkedList<T> {
        // تعريف عقدة القائمة
        private static class Node<T> {
            T data;
            Node<T> next;

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
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        // دالة equals للمقارنة بين قائمتين
        @Override
        public boolean equals(Object obj) {
            // إذا كانت المقارنة مع نفس الكائن
            if (this == obj) {
                return true;
            }
            // إذا كان الكائن null أو النوع مختلف
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            // تحويل الكائن المُقارن إلى SinglyLinkedList
            SinglyLinkedList<?> otherList = (SinglyLinkedList<?>) obj;

            // البدء من رأس كل قائمة
            Node<T> current1 = this.head;
            Node<?> current2 = otherList.head;

            // مقارنة كل عنصر في القائمتين
            while (current1 != null && current2 != null) {
                // مقارنة البيانات في العقدتين باستخدام Objects.equals
                if (!Objects.equals(current1.data, current2.data)) {
                    return false;
                }
                current1 = current1.next;
                current2 = current2.next;
            }

            // إذا كانت إحدى القائمتين لم تنتهِ بعد، فهما غير متساويتين
            return current1 == null && current2 == null;
        }

        // طباعة القائمة
        public void printList() {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }

        public static void main(String[] args) {
            // اختبار equals
            SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
            SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();

            list1.add(1);
            list1.add(2);
            list1.add(3);

            list2.add(1);
            list2.add(2);
            list2.add(3);

            System.out.println("List 1:");
            list1.printList();
            System.out.println("List 2:");
            list2.printList();

            System.out.println("Are the lists equal? " + list1.equals(list2));

            // قائمة ثالثة مختلفة
            SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();
            list3.add(1);
            list3.add(2);
            list3.add(4);

            System.out.println("List 3:");
            list3.printList();

            System.out.println("Are list1 and list3 equal? " + list1.equals(list3));
        }
    }




}
