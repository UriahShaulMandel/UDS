public class BinTree<T> {
    public T value;
    public BinTree<T> left, right;

    public BinTree(T value) {
        this.value = value;
    }

    public BinTree(BinTree<T> left, T value, BinTree<T> right) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    public BinTree(BinTree<T> left, T value) {
        this.value = value;
        this.left = left;
    }

    public BinTree(T value, BinTree<T> right) {
        this.value = value;
        this.right = right;
    }


    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinTree<T> left) {
        this.left = left;
    }

    public BinTree<T> getRight() {
        return right;
    }

    public void setRight(BinTree<T> right) {
        this.right = right;
    }

    public int size() throws StackOverflowError {
        return 1 + (hasLeft() ? left.size() : 0) + (hasRight() ? right.size() : 0);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) throws StackOverflowError {
        if (this == obj)
            return true;
        if (obj instanceof BinTree) {
            if (((BinTree) obj).value.equals(value))
                return ((!((BinTree) obj).hasLeft() || !hasLeft()) || ((BinTree) obj).left.equals(left)) && ((!((BinTree) obj).hasRight() || !hasRight()) || ((BinTree) obj).right.equals(right));

        }
        return false;
    }


    @Override
    public String toString() throws StackOverflowError {
        return toMultiLineString(new StringBuilder(), 0).toString();
    }

    public StringBuilder toMultiLineString(StringBuilder stringBuilder, int amntOfTabs) {
        for (int i = 0; i < amntOfTabs; ++i)
            stringBuilder.append("----");
        stringBuilder.append(value);
        stringBuilder.append(System.lineSeparator());


        if (hasLeft()) {
            for (int i = 0; i < amntOfTabs; ++i)
                stringBuilder.append("----");
            stringBuilder.append("left:");
            stringBuilder.append(System.lineSeparator());
            left.toMultiLineString(stringBuilder, amntOfTabs + 1);
        }
        if (hasRight()) {
            for (int i = 0; i < amntOfTabs; ++i)
                stringBuilder.append("----");
            stringBuilder.append("right:");
            stringBuilder.append(System.lineSeparator());
            right.toMultiLineString(stringBuilder, amntOfTabs + 1);
        }
        return stringBuilder;
    }

}
