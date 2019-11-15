import java.util.Iterator;


public class NodeQueue<T> extends Queue<T> {
    private int size;
    private Node<T> head, last;

    @Override
    public void insert(T t) {
        if (size == 0)
            last = head = new Node<>(t);
        else {
            Node<T> oldLast = last;
            last = new Node<>(t);
            oldLast.next = last;
        }
        size++;
    }

    @Override
    public T remove() {
        final T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public T head() {
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        last = head = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> runner = head;

            @Override
            public boolean hasNext() {
                return runner != null;
            }

            @Override
            public T next() {
                T value = runner.value;
                runner = runner.next;
                return value;
            }
        };
    }
}
