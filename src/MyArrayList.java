import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] arr;
    private int length;
    private final static int DEFAULT_CAPACITY = 5;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        arr = new Object[initialCapacity];
    }

    private void increaseCapacity() {
        Object[] newArr = new Object[2 * arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    @Override
    public void add(T item) {
        if (length >= arr.length) increaseCapacity();
        arr[length++] = item;
    }

    @Override
    public void set(int index, T item) {
        arr[index] = item;
    }

    @Override
    public void add(int index, T item) {
        for (int i = length; i > index; i--) arr[i] = arr[i - 1];
        arr[index] = item;
        length++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(length - 1);
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < length - 1; i++) arr[i] = arr[i + 1];
        length--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(length - 1);
    }

    @Override
    public void sort() {
        // bubble sort for demonstration
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) arr[j];
                if (a.compareTo((T) arr[j + 1]) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) if (arr[i].equals(object)) return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i--) if (arr[i].equals(object)) return i;
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] copy = new Object[length];
        System.arraycopy(arr, 0, copy, 0, length);
        return copy;
    }

    @Override
    public void clear() {
        arr = new Object[DEFAULT_CAPACITY];
        length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return (T) arr[index++];
            }
        };
    }
}
