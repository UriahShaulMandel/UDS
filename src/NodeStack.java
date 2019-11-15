import java.util.Iterator;

public class NodeStack<T> extends Stack<T> {
    private Node<T> head;
    private int size;

    @Override
    public void push(T t) {
        if (size == 0) {
            head = new Node<>(t);
        } else {
            head = new Node<>(t, head);
        }
        size++;
    }

    @Override
    public T pop() {
        final T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public T top() {
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * @return not thread safe Iterator.
     * unexpected behavior may occur when using multiple threads.
     */
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
                final T value = runner.value;
                runner = runner.next;
                return value;
            }
        };
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof NodeStack) {
            if (((NodeStack) obj).size == size) {
                Node<T> thisRunner = head;
                Node itsRunner = ((NodeStack) obj).head;
                while (thisRunner.value.equals(itsRunner.value)) {
                    if (!thisRunner.hasNext()) {//same size
                        return true;
                    }
                    itsRunner = itsRunner.next;
                    thisRunner = thisRunner.next;
                }
            }
        }
        return false;
    }
}