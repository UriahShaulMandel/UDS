public abstract class Stack<T> extends DataStructure<T> {

    public abstract void push(T t);

    public abstract T pop();

    public abstract T top();

    @Override
    public boolean add(T t) {
        push(t);
        return true;
    }
}
