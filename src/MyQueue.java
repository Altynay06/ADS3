public class MyQueue<T> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void enqueue(T value) {
        list.addLast(value);
    }

    public T dequeue() {
        T front = list.getFirst();
        list.removeFirst();
        return front;
    }

    public T peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
