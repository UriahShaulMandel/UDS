import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class DataStructure<T> implements Collection<T> {
    @Override
    public void forEach(Consumer<? super T> action) {
        for (T t : this)
            action.accept(t);
    }

    @Deprecated
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("really bad practice for those data structures. use List instead");
    }


    @Deprecated
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("really bad practice for those data structures. use List instead");
    }

    @Deprecated
    @Override
    public boolean remove(Object c) {
        throw new UnsupportedOperationException("really bad practice for those data structures. use List instead");
    }

    @Deprecated
    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        throw new UnsupportedOperationException("really bad practice for those data structures. use List instead");
    }

    public boolean containsAll(Collection<?> c) {
        for (Object o : c)
            if (!contains(o))
                return false;
        return true;
    }


    public boolean addAll(Collection<? extends T> c) {
        for (T t : c)
            add(t);
        return true;
    }


    public <E> E[] toArray(E[] a) {
        if (a.length < size())
            a = (E[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size());
        Object[] result = a;

        int i = 0;
        for (T t : this)
            result[i++] = t;

        return a;
    }

    public Object[] toArray() {
        Object[] ts = new Object[size()];
        int i = 0;
        for (T t : this)
            ts[i++] = t;
        return ts;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (T t : this)
                if (t == null)
                    return true;
        } else {
            for (T t : this)
                if (o.equals(t))
                    return true;

        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }


    @Override
    public int hashCode() {
        return Objects.hash(toArray());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (T t : this) {
            stringBuilder.append(t);
            stringBuilder.append(",");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append("]");

        return stringBuilder.toString();
    }


}
