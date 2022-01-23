
public class Stack<E> implements StackMethods<E> {
    //Проверка работоспособности кода
    public static void main(String[] args) {
        StackMethods<String> strings = new Stack<>();
        strings.push("Diablo");
        strings.push("Diablo 2");
        strings.push("Diablo 3");
        strings.push("Lineage 2");
        strings.push("WorldOfTanks");
        System.out.println(strings.size());
        System.out.println(strings.pop());
        System.out.println(strings.size());
        System.out.println(strings.pop());
        System.out.println(strings.peek());
        strings.remove(1);
        System.out.println(strings.size());
        System.out.println(strings.get(1));

    }





    //Создание Массива и конструктора
    private E[] values;
    public Stack(){
        values= (E[]) new Object[0];
    }


    //Метод для проверки того что в ммассиве после выполнения методов
    @Override
     public E get(int index) {
        return values[index];
    }

    @Override
    public boolean push(E e) {
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
        values = (E[]) new Object[time.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = null;
        }

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
            return values[values.length -1];
        }
    }

    @Override
    public E pop() {
        if(size() == 0){
            return null;
        }
        String result = (String) values[values.length-1];

        try {
            E[] time = values;
            values = (E[]) new Object[time.length-1];
            System.arraycopy(time, 0, values, 0, values.length);

        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
        return (E) result;
    }
}
