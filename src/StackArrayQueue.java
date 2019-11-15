import java.util.Iterator;

public class StackArrayQueue<T> extends Queue<T> {
    private ArrayStack<T> stI, stR;

    public StackArrayQueue() {
        stI = new ArrayStack<>();
        stR = new ArrayStack<>();
    }

    @Override
    public void insert(T t) {
        stI.push(t);
    }

    @Override
    public T remove() {
        if (stR.isEmpty()) {
            stR.addAll(stI);
            stI.clear();
        }
        return stR.pop();
    }

    @Override
    public T head() {
        if (stR.isEmpty()) {
            stR.addAll(stI);
            stI.clear();
        }
        return stR.top();
    }

    @Override
    public int size() {
        return stR.size() + stI.size();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("use nodeQueue instead!");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("use nodeQueue instead!");
    }

    @Override
    public void clear() {
        stI.clear();
        stR.clear();
    }
}