public interface Method<E> {
    void add(E e);
    E remove(int index);
    void clear();
    int size();
    E getElement(int index);
}
