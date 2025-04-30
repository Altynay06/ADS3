import java.util.ArrayList;

public class MyMinHeap {
    private ArrayList<Integer> heap = new ArrayList<>();

    public void add(int val) {
        heap.add(val);
        int i = heap.size() - 1;
        while (i > 0 && heap.get((i - 1) / 2) > heap.get(i)) {
            int tmp = heap.get(i);
            heap.set(i, heap.get((i - 1) / 2));
            heap.set((i - 1) / 2, tmp);
            i = (i - 1) / 2;
        }
    }

    public int removeMin() {
        if (heap.size() == 0) return -1;
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (heap.size() == 0) return min;
        heap.set(0, last);
        int i = 0;
        while (2 * i + 1 < heap.size()) {
            int smallest = i;
            int left = 2 * i + 1, right = 2 * i + 2;
            if (heap.get(left) < heap.get(smallest)) smallest = left;
            if (right < heap.size() && heap.get(right) < heap.get(smallest)) smallest = right;
            if (smallest == i) break;
            int tmp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, tmp);
            i = smallest;
        }
        return min;
    }
}
