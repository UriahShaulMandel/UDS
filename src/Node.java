public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(Node<T> other) {
        this.value = other.value;
        this.next = other.next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public int size() throws StackOverflowError {
        return hasNext() ? next.size() + 1 : 1;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) throws StackOverflowError {
        if (this == obj)
            return true;
        if (obj instanceof Node) {
            if (((Node) obj).value.equals(value)) {
                if (((Node) obj).hasNext() && hasNext())
                    return ((Node) obj).next.equals(next);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() throws StackOverflowError {
        return value + "->" + (next == null ? "|" : next);
    }


}
