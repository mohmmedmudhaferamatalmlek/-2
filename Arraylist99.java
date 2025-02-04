import java.util.Iterator;
public class Arraylist99 {

    static class MyArrayList<T> implements Iterable<T> {
        private Object[] array; // مصفوفة داخلية لتخزين البيانات
        private int size = 0; // عدد العناصر في القائمة
        private static final int INITIAL_CAPACITY = 10; // السعة الابتدائية

        // Constructor: إنشاء القائمة بسعة ابتدائية
        public MyArrayList() {
            array = new Object[INITIAL_CAPACITY];
        }

        // إضافة عنصر إلى القائمة
        public void add(T element) {
            ensureCapacity();
            array[size++] = element;
        }

        // حذف عنصر عند فهرس معين
        public void remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("الفهرس غير صحيح!");
            }
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1]; // إزاحة العناصر للخلف
            }
            array[--size] = null; // حذف آخر عنصر
        }

        // استرجاع عنصر عند فهرس معين
        @SuppressWarnings("unchecked")
        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("الفهرس غير صحيح!");
            }
            return (T) array[index];
        }

        // استرجاع حجم القائمة
        public int size() {
            return size;
        }

        // التحقق من الحاجة إلى توسيع السعة
        private void ensureCapacity() {
            if (size == array.length) {
                int newCapacity = array.length * 2; // مضاعفة الحجم
                Object[] newArray = new Object[newCapacity];
                System.arraycopy(array, 0, newArray, 0, size);
                array = newArray;
            }
        }

        // طباعة القائمة
        public void printList() {
            System.out.print("[");
            for (int i = 0; i < size; i++) {
                System.out.print(array[i]);
                if (i < size - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        // ✅ تنفيذ `Iterable<T>` للسماح باستخدام `for-each`
        @Override
        public Iterator<T> iterator() {
            return new MyIterator();
        }

        // ✅ كلاس داخلي لتنفيذ `Iterator<T>`
        private class MyIterator implements Iterator<T> {
            private int index = 0; // موقع التكرار الحالي

            @Override
            public boolean hasNext() {
                return index < size; // هل يوجد عنصر قادم؟
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                return (T) array[index++]; // إرجاع العنصر الحالي وزيادة الفهرس
            }
        }
    }

    // ✅ تجربة القائمة مع Iterator
    public class Main {
        public static void main(String[] args) {
            MyArrayList<String> list = new MyArrayList<>();
            list.add("🚀 أول عنصر");
            list.add("💡 ثاني عنصر");
            list.add("🔥 ثالث عنصر");

            System.out.println("📌 طباعة باستخدام Iterator:");
            for (String item : list) {
                System.out.println(item);
            }

            System.out.println("\n📌 طباعة باستخدام Iterator يدوي:");
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }




}
