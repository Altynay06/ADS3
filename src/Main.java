public class Main {
    public static void main(String[] args) {
        MyList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        System.out.println("ArrayList: " + arrayList.getFirst() + ", " + arrayList.getLast());

        MyStack<Integer> stack = new MyStack<>();
        stack.push(60);
        System.out.println("Stack peek: " + stack.peek());

        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(70);
        queue.enqueue(80);
        System.out.println("Queue peek: " + queue.peek());

        MyMinHeap heap = new MyMinHeap();
        heap.add(5);
        heap.add(2);
        heap.add(9);
        System.out.println("Min from heap: " + heap.removeMin());
    }
}
