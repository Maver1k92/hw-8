import java.util.Iterator;
public class MyArrayList<E> implements MyArray<E> {

    private E[] values;

    public MyArrayList(){

        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
      try {
          E[] temp = values;
          values =(E[]) new Object[temp.length+1];
          System.arraycopy(temp,0, values, 0, temp.length);
          values[values.length -1] = e;
          return true;
      }catch (ClassCastException ex){
          ex.printStackTrace();
      }
      return false;
    }

    @Override
    public void remove(int index) {
        try {
            E[] temp = values;
            values =(E[]) new Object[temp.length-1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElementsAfterIndex = temp.length - index -1;
            System.arraycopy(temp, index+1, values, index, amountElementsAfterIndex);
        }catch (ClassCastException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void clear() {
        E[] temp = values;
        values = (E[]) new Object[temp.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }
}
