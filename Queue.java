import java.util.Iterator;
import java.util.*;

public class Queue<E> implements QueueMethods<E> {

    private E[] values;

    public static void main(String[] args) {
        QueueMethods<String> stings = new Queue<>();
        stings.add("Iphone");
        stings.add("Ipad");
        stings.add("IPod");
        // System.out.println(stings.get(1));// проверить что в адд что то записываю
        //System.out.println(stings.size());// проверить что сайз рабочий
        //stings.clear();// вызов чистки
        // System.out.println(stings.peek());//работает ли пик
        //stings.remove(0); //работает ли ремув
        //System.out.println(stings.size());// проверка что зачищаю
        System.out.println(stings.poll());
        System.out.println(stings.size());



    }


    //конструктор
    public Queue() {
        values = (E[]) new Object[0];
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] time = values;
            values = (E[]) new Object[time.length + 1];
            System.arraycopy(time, 0, values, 0, time.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public void remove(int index) {
        try {
            E[] time = values;
            values = (E[]) new Object[time.length - 1];
            System.arraycopy(time, 0, values, 0, index);
            int amountElementAfterIndex = time.length - index - 1;
            System.arraycopy(time, index + 1, values, index, amountElementAfterIndex);
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
    }

 @Override
    public void clear() {
        E[] time = values;
        values = (E[]) new Object[0];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public E peek() {
        if (size() == 0) {
            return null;
        } else {
            return values[0];
        }
    }

    @Override
    public E poll() {
        if(size() == 0){
            return null;
        }
        try {
            E[] time = values;
            values = (E[]) new Object[time.length - 1];
            System.arraycopy(time, 0, values, 0, values.length);

        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
        return values[0];
    }
}



