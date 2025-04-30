public class MyStack<T> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void push(T value) {
        list.addLast(value);
    }

    public T pop() {
        T top = list.getLast();
        list.removeLast();
        return top;
    }

    public T peek() {
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
