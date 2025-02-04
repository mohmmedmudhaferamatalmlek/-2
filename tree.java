public class tree {
    // تنفيذ شجرة ثنائية باستخدام مصفوفة
    static class ArrayBinaryTree<T> {
        private Object[] tree; // المصفوفة الداخلية لتخزين العناصر
        private int size; // عدد العقد الحالية
        private static final int DEFAULT_CAPACITY = 10; // السعة الافتراضية

        // ✅ Constructor: إنشاء شجرة جديدة
        public ArrayBinaryTree() {
            tree = new Object[DEFAULT_CAPACITY];
            size = 0;
        }

        // ✅ إضافة عنصر إلى الشجرة (يُضاف بشكل متسلسل)
        public void add(T element) {
            if (size == tree.length) {
                expandCapacity();
            }
            tree[size++] = element;
        }

        // ✅ استرجاع العنصر عند موقع معين
        @SuppressWarnings("unchecked")
        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("الفهرس غير صحيح!");
            }
            return (T) tree[index];
        }

        // ✅ استرجاع العنصر الأب لعقدة معينة
        public T getParent(int index) {
            if (index <= 0 || index >= size) {
                return null;
            }
            return get((index - 1) / 2);
        }

        // ✅ استرجاع الابن الأيسر
        public T getLeftChild(int index) {
            int leftIndex = 2 * index + 1;
            if (leftIndex >= size) {
                return null;
            }
            return get(leftIndex);
        }

        // ✅ استرجاع الابن الأيمن
        public T getRightChild(int index) {
            int rightIndex = 2 * index + 2;
            if (rightIndex >= size) {
                return null;
            }
            return get(rightIndex);
        }

        // ✅ طباعة الشجرة
        public void printTree() {
            System.out.print("[");
            for (int i = 0; i < size; i++) {
                System.out.print(tree[i]);
                if (i < size - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        // ✅ توسيع سعة المصفوفة عند الحاجة
        private void expandCapacity() {
            int newCapacity = tree.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(tree, 0, newArray, 0, size);
            tree = newArray;
        }
    }

    // ✅ تجربة الشجرة الثنائية
    public class Main {
        public static void main(String[] args) {
            ArrayBinaryTree<Integer> tree = new ArrayBinaryTree<>();

            // إضافة عناصر إلى الشجرة
            tree.add(10); // Root
            tree.add(20);
            tree.add(30);
            tree.add(40);
            tree.add(50);
            tree.add(60);
            tree.add(70);

            // طباعة الشجرة
            System.out.println("📌 الشجرة الثنائية:");
            tree.printTree(); // [10, 20, 30, 40, 50, 60, 70]

            // استرجاع العلاقات بين العقد
            System.out.println("👑 الجذر: " + tree.get(0)); // 10
            System.out.println("🌿 ابن 10 الأيسر: " + tree.getLeftChild(0)); // 20
            System.out.println("🌿 ابن 10 الأيمن: " + tree.getRightChild(0)); // 30
            System.out.println("🌿 ابن 20 الأيسر: " + tree.getLeftChild(1)); // 40
            System.out.println("🌿 ابن 20 الأيمن: " + tree.getRightChild(1)); // 50
            System.out.println("🌳 الأب لـ 50: " + tree.getParent(4)); // 20
        }
    }




}
