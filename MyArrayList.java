import java.util.Arrays;
import  java.util.StringJoiner;

public class MyArrayList<T> {
    private Object[] devices;
    private int index;
    private final int pointer = 0;
    private final int INIT_SIZE = 16;
    // private final int CUT_RATE = 4;

    public MyArrayList(){
        int INIT_SIZE = 8;
        devices = new Object[INIT_SIZE];
    }

    public void add(T device){
        devices[index]= device;
        index++;
    }

    private void resizeIfNeed(){
        if(index == devices.length){
            int newSize = devices.length * 2;
            Object[] newDevices = new Object[newSize];
            System.arraycopy(devices, 0, newDevices, 0 , devices.length);
            devices = newDevices;
        }
    }

    public String remove(int index){
        if(index < 0 || index >= size()){
            System.out.println("Нельзя удалить элемент по индексу");
        }
        Object[] removeDevice = new Object[size() -1];
        for(int i = 0; i < index; i++){
            removeDevice[i] = devices[i];
        }
        for(int i = index + 1; i < size();i++){
            removeDevice[i - 1] = devices[i];
        }
        return Arrays.toString(removeDevice);
    }
    Object clear(){
        Object[]  clearDevice = new Object[devices.length];
        for(int i = 0; i < devices.length; i++){
            clearDevice[i] = null;
        }

        return Arrays.toString(clearDevice);
    }






    public T get(int i){
        return (T) devices[i];
    }

    public int size(){
        return index;
    }





    //TODO clear


    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (int i = 0; i < index; i++){
            result.add((CharSequence) devices[i]);
        }
        return "[" + result + "]";
    }
}
