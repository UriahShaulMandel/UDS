import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<T> extends Stack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};

    private Object[] elementData;
    private int size;


    public ArrayStack() {
        elementData = EMPTY_ELEMENTDATA;
    }

    public ArrayStack(ArrayStack<T> other) {
        this.size = other.size;
        this.elementData = other.elementData.clone();
    }

    public ArrayStack(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }


    @Override
    public void push(T t) {
        if (size == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        } else if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        elementData[size++] = t;

    }

    @Override
    public T pop() {
        final T ret = (T) elementData[--size];
        elementData[size] = null;
        return ret;
    }

    @Override
    public T top() {
        return (T) elementData[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        elementData = EMPTY_ELEMENTDATA;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = size - 1;

            @Override
            public boolean hasNext() {
                return i >= 0;
            }

            @Override
            public T next() {
                return (T) elementData[i--];
            }
        };
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof ArrayStack) {
            if (((ArrayStack) obj).size == size) {
                int i = 0;
                while (elementData[i].equals(((ArrayStack) obj).elementData[i])) {
                    if (++i == size)
                        return true;
                }
            }
        }
        return false;
    }
}