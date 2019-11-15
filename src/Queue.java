public abstract class Queue<T> extends DataStructure<T> {

    public abstract void insert(T t);

    public abstract T remove();

    public abstract T head();

    @Override
    public boolean add(T t) {
        insert(t);
        return true;
    }

}
