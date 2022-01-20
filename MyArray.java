public interface MyArray<E> extends Iterable<E> {
    boolean add(E e);
    void remove(int index);
    E get(int index);
    int size();
    void clear();
}
